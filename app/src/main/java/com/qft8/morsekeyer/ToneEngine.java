package com.qft8.morsekeyer;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;

/**
 * Audio engine using AudioTrack.
 * Generates continuous tone matching the web app's OscillatorNode behavior.
 * Two waveforms:
 * - "triangle": standard triangle wave
 * - "sawtooth": sawtooth wave (used for "No-click" mode)
 *
 * Volume scaling matches web app:
 * - triangle: vol / 100
 * - sawtooth: vol / 250
 *
 * Uses exponential envelope for click-free start/stop.
 *
 * Element playback uses sample-accurate timing: the audio thread counts
 * samples to control tone/silence durations with ~22µs precision (at 44.1kHz),
 * eliminating the ~1-16ms jitter of Handler.postDelayed().
 *
 * Seamless element chaining: when the main thread queues a next element
 * during the silence phase, the audio thread transitions directly to the
 * next element's tone at the exact sample boundary — zero jitter between
 * consecutive elements.
 */
public class ToneEngine {

    private int sampleRate = 44100;

    private AudioTrack audioTrack;
    private Thread audioThread;
    private volatile boolean running = false;
    private volatile boolean toneActive = false;
    private volatile boolean keepAlive = true;
    private volatile boolean whiteNoise = false;
    private volatile float whiteNoiseVolume = 5.0f;
    private volatile int whiteNoiseFrequency = 500;
    private float noiseFilterState = 0.0f;
    private final java.util.Random random = new java.util.Random();

    private volatile String toneType = "triangle";
    private volatile int frequencyHz = 700;
    private volatile int volume = 40; // 0-100
    private volatile float bufferMs = 25.0f;
    private volatile float envelopeMs = 1.0f;
    private volatile float chunkMs = 4.0f;

    // Captured settings at the start of a tone for stability
    private String activeToneType = "triangle";
    private int activeFrequencyHz = 700;
    private int activeVolume = 40;

    private double phase = 0.0;
    private float currentGain = 0.0f;
    private float alpha = 0.0f;

    // Sample-accurate element playback state
    // elementPhase: 0 = idle, 1 = tone on, 2 = silence gap
    private volatile int elementPhase = 0;
    private int elementToneSamples = 0;
    private int elementSilenceSamples = 0;
    private int elementSampleCounter = 0;
    private volatile Runnable elementToneEndCallback;
    private volatile Runnable elementSilenceEndCallback;
    private Handler callbackHandler;

    // Queued next element — set by main thread during silence phase,
    // consumed by audio thread at the exact silence→tone boundary.
    private volatile boolean hasQueuedElement = false;
    private int queuedToneSamples = 0;
    private int queuedSilenceSamples = 0;
    private volatile Runnable queuedToneEndCallback;
    private volatile Runnable queuedSilenceEndCallback;
    private volatile Runnable queuedElementStartCallback;

    /**
     * Initialize the audio engine and start the background audio thread.
     */
    public void init() {
        if (running)
            return;

        // Use USAGE_GAME and CONTENT_TYPE_MUSIC for the fastest "Fast Mixer" path on
        // Android
        AudioAttributes attrs = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setFlags(AudioAttributes.FLAG_LOW_LATENCY)
                .build();

        this.sampleRate = AudioTrack.getNativeOutputSampleRate(AudioAttributes.USAGE_GAME);
        if (this.sampleRate == 0)
            this.sampleRate = 44100;

        try {
            int bufferSize = AudioTrack.getMinBufferSize(
                    sampleRate,
                    AudioFormat.CHANNEL_OUT_MONO,
                    AudioFormat.ENCODING_PCM_FLOAT);

            if (bufferSize <= 0) {
                return; // Device does not support this format
            }

            audioTrack = new AudioTrack.Builder()
                    .setAudioAttributes(attrs)
                    .setAudioFormat(new AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_FLOAT)
                            .setSampleRate(sampleRate)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                            .build())
                    .setBufferSizeInBytes(bufferSize)
                    .setTransferMode(AudioTrack.MODE_STREAM)
                    .setPerformanceMode(AudioTrack.PERFORMANCE_MODE_LOW_LATENCY)
                    .build();

            // Ensure we use the smallest possible active buffer within the track
            applyBufferSettings();

            // Ensure full stream volume
            audioTrack.setVolume(1.0f);

            callbackHandler = new Handler(Looper.getMainLooper());

            running = true;
            audioTrack.play();

            audioThread = new Thread(this::audioLoop, "ToneEngine");
            audioThread.setPriority(Thread.MAX_PRIORITY);
            audioThread.start();
        } catch (Exception e) {
            e.printStackTrace();
            running = false;
        }
    }

    /**
     * Set the tone active state (Push model — straight key only).
     */
    public void setToneActive(boolean active) {
        if (active && !toneActive) {
            // Capture settings at the moment the tone starts
            activeToneType = toneType;
            activeFrequencyHz = frequencyHz;
            activeVolume = volume;
            // Only reset phase if we were effectively silent to avoid clicks on rapid
            // re-triggers
            if (currentGain < 0.01f) {
                phase = "sawtooth".equals(activeToneType) ? 0.0 : 0.25;
            }
        }
        this.toneActive = active;
    }

    /**
     * Compute the envelope compensation in samples.
     * The exponential envelope makes tones sound shorter than their sample count
     * because rise/fall time "steals" from the perceived tone duration.
     * We extend the tone by envelopeMs total (half on each side) so the
     * perceptual midpoint of the rise aligns with the nominal tone start,
     * and the midpoint of the fall aligns with the nominal tone end.
     */
    private int envelopeCompensationSamples() {
        return (int) Math.round(envelopeMs * sampleRate / 1000.0);
    }

    /**
     * Play a single Morse element with sample-accurate timing.
     * The tone plays for the adjusted duration (compensated for envelope),
     * followed by a correspondingly shortened silence.
     *
     * Callbacks:
     * - onToneEnd: fired when tone→silence transition occurs (posted to main
     * thread).
     * Use this to determine and queue the next element via queueNextElement().
     * - onSilenceEnd: fired when silence ends and NO queued element was found
     * (posted to main thread). Use this to clean up state when the sequence ends.
     *
     * If a queued element exists when silence ends, it starts immediately
     * (zero-jitter chaining) and onSilenceEnd is NOT called.
     */
    public void playElement(double toneDurationMs, double silenceDurationMs,
            Runnable onToneEnd, Runnable onSilenceEnd) {
        // Capture settings snapshot
        activeToneType = toneType;
        activeFrequencyHz = frequencyHz;
        activeVolume = volume;
        // Reset phase if effectively silent to avoid clicks
        if (currentGain < 0.01f) {
            phase = "sawtooth".equals(activeToneType) ? 0.0 : 0.25;
        }

        // Convert ms to sample counts, then apply envelope compensation
        int baseToneSamples = (int) Math.round(toneDurationMs * sampleRate / 1000.0);
        int baseSilenceSamples = (int) Math.round(silenceDurationMs * sampleRate / 1000.0);
        int compensation = envelopeCompensationSamples();

        this.elementToneSamples = baseToneSamples + compensation;
        this.elementSilenceSamples = Math.max(0, baseSilenceSamples - compensation);
        this.elementToneEndCallback = onToneEnd;
        this.elementSilenceEndCallback = onSilenceEnd;
        this.elementSampleCounter = 0;
        this.hasQueuedElement = false;
        // Set elementPhase last — volatile write acts as release barrier
        this.elementPhase = 1;
    }

    /**
     * Queue the next element for seamless chaining.
     * Must be called from the onToneEnd callback (during the silence phase).
     * The audio thread will start this element at the exact sample boundary
     * when the current silence ends — zero jitter between elements.
     *
     * If silence has already ended by the time this is called (race condition),
     * the element starts immediately via playElement() fallback.
     */
    public void queueNextElement(double toneDurationMs, double silenceDurationMs,
            Runnable onElementStart, Runnable onToneEnd, Runnable onSilenceEnd) {
        // If we are idle, fall back to direct play
        if (elementPhase == 0) {
            if (onElementStart != null && callbackHandler != null) {
                callbackHandler.post(onElementStart);
            }
            playElement(toneDurationMs, silenceDurationMs, onToneEnd, onSilenceEnd);
            return;
        }

        int baseToneSamples = (int) Math.round(toneDurationMs * sampleRate / 1000.0);
        int baseSilenceSamples = (int) Math.round(silenceDurationMs * sampleRate / 1000.0);
        int compensation = envelopeCompensationSamples();

        this.queuedToneSamples = baseToneSamples + compensation;
        this.queuedSilenceSamples = Math.max(0, baseSilenceSamples - compensation);
        this.queuedToneEndCallback = onToneEnd;
        this.queuedSilenceEndCallback = onSilenceEnd;
        this.queuedElementStartCallback = onElementStart;
        // Set hasQueuedElement last — volatile write acts as release barrier
        this.hasQueuedElement = true;
    }

    public void cancelQueuedElement() {
        this.hasQueuedElement = false;
        this.queuedToneEndCallback = null;
        this.queuedSilenceEndCallback = null;
        this.queuedElementStartCallback = null;
    }

    /**
     * Cancel any in-flight or queued element.
     * Called from cancelAll() to immediately stop element playback.
     */
    public void cancelElement() {
        this.elementPhase = 0;
        this.hasQueuedElement = false;
        this.elementToneEndCallback = null;
        this.elementSilenceEndCallback = null;
        cancelQueuedElement();
    }

    /**
     * Main audio loop — continuously generates samples.
     * Envelope follows exponential curve.
     *
     * Element state machine:
     * Phase 1 (tone): count samples, transition to phase 2, fire toneEnd callback
     * Phase 2 (silence): count samples, then either:
     * - If queued element: swap in and go to phase 1 (seamless chain)
     * - If no queue: go to phase 0, fire silenceEnd callback
     * Phase 0 (idle): fall through to toneActive (straight key) or silence
     */
    private void audioLoop() {
        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_AUDIO);
        // Pre-allocate a large buffer to avoid GC pressure (max 100ms at 44.1kHz)
        float[] buffer = new float[sampleRate / 10];

        while (running) {
            int currentChunkSize = (int) (sampleRate * chunkMs / 1000.0);
            if (currentChunkSize < 1)
                currentChunkSize = 1;
            if (currentChunkSize > buffer.length)
                currentChunkSize = buffer.length;

            float alphaLocal = alpha;
            int localElementPhase = elementPhase;
            for (int i = 0; i < currentChunkSize; i++) {
                float targetGain;

                if (localElementPhase > 0) {
                    // Sample-accurate element mode (iambic keyer)
                    if (localElementPhase == 1) {
                        // Tone-on phase
                        int volDivider = "sawtooth".equals(activeToneType) ? 250 : 100;
                        targetGain = (float) activeVolume / volDivider;
                        elementSampleCounter++;
                        if (elementSampleCounter >= elementToneSamples) {
                            localElementPhase = 2;
                            elementPhase = 2;
                            elementSampleCounter = 0;
                            // Fire tone-end callback on main thread
                            Runnable cb = elementToneEndCallback;
                            elementToneEndCallback = null;
                            if (cb != null && callbackHandler != null) {
                                callbackHandler.post(cb);
                            }
                        }
                    } else {
                        // Silence phase
                        targetGain = 0.0f;
                        elementSampleCounter++;
                        if (elementSampleCounter >= elementSilenceSamples) {
                            if (hasQueuedElement) {
                                // Seamless chain: swap queued element into active
                                hasQueuedElement = false;
                                elementToneSamples = queuedToneSamples;
                                elementSilenceSamples = queuedSilenceSamples;
                                elementToneEndCallback = queuedToneEndCallback;
                                elementSilenceEndCallback = queuedSilenceEndCallback;
                                Runnable startCb = queuedElementStartCallback;
                                queuedToneEndCallback = null;
                                queuedSilenceEndCallback = null;
                                queuedElementStartCallback = null;
                                localElementPhase = 1;
                                elementPhase = 1;
                                elementSampleCounter = 0;
                                if (startCb != null && callbackHandler != null) {
                                    callbackHandler.post(startCb);
                                }
                            } else {
                                // No next element — sequence ends
                                localElementPhase = 0;
                                elementPhase = 0;
                                Runnable cb = elementSilenceEndCallback;
                                elementSilenceEndCallback = null;
                                if (cb != null && callbackHandler != null) {
                                    callbackHandler.post(cb);
                                }
                            }
                        }
                    }
                } else if (toneActive) {
                    // Straight key mode (unchanged)
                    int volDivider = "sawtooth".equals(activeToneType) ? 250 : 100;
                    targetGain = (float) activeVolume / volDivider;
                } else {
                    targetGain = 0.0f; // Absolute silence
                }

                // Exponential envelope
                currentGain += alphaLocal * (targetGain - currentGain);

                // Generate waveform sample
                float sample;
                double p = phase - Math.floor(phase + 0.5);
                if ("sawtooth".equals(activeToneType)) {
                    sample = (float) (2.0 * p);
                } else {
                    // triangle
                    sample = (float) (2.0 * Math.abs(2.0 * p) - 1.0);
                }

                float sampleValue = sample * currentGain;
                if (keepAlive && currentGain < 0.00001f) {
                    // Keep the audio hardware/mixer awake with white noise.
                    float rawNoise = (random.nextFloat() * 2.0f - 1.0f);
                    float noiseValue;
                    
                    if (whiteNoise) {
                        float omega_dt = (float) (2.0 * Math.PI * whiteNoiseFrequency / sampleRate);
                        float filterAlpha = omega_dt / (omega_dt + 1.0f);
                        noiseFilterState += filterAlpha * (rawNoise - noiseFilterState);
                        
                        float noiseLevel = (float) activeVolume / 100.0f * (whiteNoiseVolume / 100.0f);
                        noiseValue = noiseFilterState * noiseLevel;
                    } else {
                        noiseValue = rawNoise * 0.00001f;
                    }
                    sampleValue += noiseValue;
                }
                buffer[i] = sampleValue;

                // Advance phase
                phase += (double) activeFrequencyHz / sampleRate;
                if (phase >= 1.0)
                    phase -= 1.0;
            }

            if (audioTrack != null && running) {
                int written = audioTrack.write(buffer, 0, currentChunkSize, AudioTrack.WRITE_BLOCKING);
                if (written < 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {}
                }
            }
        }
    }

    public void setToneType(String type) {
        this.toneType = type;
    }

    public void setFrequency(int hz) {
        this.frequencyHz = hz;
    }

    public void setVolume(int vol) {
        this.volume = vol;
    }

    public void setBufferMs(float ms) {
        this.bufferMs = ms;
        applyBufferSettings();
    }

    public void setEnvelopeMs(float ms) {
        this.envelopeMs = ms;
        this.alpha = (float) (1.0 - Math.exp(-1.0 / (ms * sampleRate / 1000.0)));
    }

    public void setChunkMs(float ms) {
        this.chunkMs = ms;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public void setWhiteNoise(boolean whiteNoise) {
        this.whiteNoise = whiteNoise;
    }

    public void setWhiteNoiseVolume(float volume) {
        this.whiteNoiseVolume = volume;
    }

    public void setWhiteNoiseFrequency(int hz) {
        this.whiteNoiseFrequency = hz;
    }

    private void applyBufferSettings() {
        if (audioTrack != null && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            int frames = (int) (bufferMs * sampleRate / 1000.0);
            int min = 1; // At least 1 frame
            int max = audioTrack.getBufferCapacityInFrames();
            audioTrack.setBufferSizeInFrames(Math.max(min, Math.min(frames, max)));
        }
    }

    public boolean isPlaying() {
        return toneActive || currentGain > 0.0001f;
    }

    public void release() {
        running = false;
        toneActive = false;
        elementPhase = 0;
        hasQueuedElement = false;
        elementToneEndCallback = null;
        elementSilenceEndCallback = null;
        cancelQueuedElement();
        if (audioThread != null) {
            try {
                audioThread.join(1000);
            } catch (InterruptedException e) {
                // Ignore
            }
            audioThread = null;
        }
        if (audioTrack != null) {
            try {
                audioTrack.stop();
            } catch (IllegalStateException e) {
                // Ignore
            }
            audioTrack.release();
            audioTrack = null;
        }
    }
}
