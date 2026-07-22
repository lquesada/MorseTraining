package com.qft8.morsekeyer;

import android.os.Handler;
import android.os.Looper;

public class MorseKeyer {

    public interface OutputCallback {
        void onText(String text);

        void onWordGapPending();

        void onWordGapConfirmed();
    }

    public interface VisualCallback {
        void onToneStart();

        void onToneStop();
    }

    private final MorseSettings settings;
    private final MorseState state;
    private final ToneEngine toneEngine;
    private final OutputCallback outputCallback;
    private VisualCallback visualCallback;

    Handler uiHandler;
    Handler timingHandler;
    Handler recognitionHandler;
    private Runnable timingRunnable;

    private boolean wasTransmitting = false;
    private boolean inputEnabled = true;
    
    public void setInputEnabled(boolean enabled) {
        this.inputEnabled = enabled;
        if (!enabled) {
            cancelAll();
        }
    }

    public MorseKeyer(MorseSettings settings, MorseState state,
            ToneEngine toneEngine, OutputCallback callback) {
        this.settings = settings;
        this.state = state;
        this.toneEngine = toneEngine;
        this.outputCallback = callback;
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.timingHandler = new Handler(Looper.getMainLooper()); // Use main thread for timing for now, or dedicated
                                                                  // thread
        this.recognitionHandler = new Handler(Looper.getMainLooper());
    }

    private java.util.List<double[]> sequenceElements;
    
    public void cancelAll() {
        clearTimingTimeouts();
        timingHandler.removeCallbacksAndMessages(null);
        state.isTransmitting = false;
        state.iambicScheduled = false;
        state.bugKeyActive = false;
        state.isSequencePlaying = false;
        sequenceElements = null;
        sequenceCharCallback = null;
        toneEngine.cancelElement();
        toneEngine.setToneActive(false);
        state.currentCode = "";
        state.isWordGapPending = false;
        notifyVisual(false);
    }

    public void release() {
        cancelAll();
    }

    public void setVisualCallback(VisualCallback callback) {
        this.visualCallback = callback;
    }

    // ============================================================
    // Timing calculations
    // ============================================================

    double[] getTransmissionTimings() {
        double ditLength = 1200.0 / settings.wpm;
        return new double[] {
                ditLength, // [0] dit
                ditLength * 3.0, // [1] dah
                ditLength, // [2] elementGap
                ditLength * 3.0, // [3] letterGap (strict)
                ditLength * 7.0 // [4] wordGap (strict)
        };
    }

    double[] getRecognitionTimings() {
        double ditLength = 1200.0 / settings.wpm;

        // At 100%, these factors are exactly 1.0, matching strict mode perfectly.
        double ilsFactor = settings.strict ? 1.0 : (settings.interletterSpacing / 100.0);
        double iwsFactor = settings.strict ? 1.0 : (settings.interwordSpacing / 100.0);

        double letterGap = Math.max(ditLength * 3.0 * ilsFactor, 1.2 * ditLength);

        // Ensure word gap is always at least 0.5 dits longer than letter gap
        double wordGap = Math.max(ditLength * 7.0 * iwsFactor, letterGap + 0.5 * ditLength);

        return new double[] {
                ditLength, // [0] dit
                ditLength * 3.0, // [1] dah
                ditLength, // [2] elementGap
                letterGap, // [3] letterGap
                wordGap // [4] wordGap
        };
    }

    // ============================================================
    // Output text
    // ============================================================

    private void outputText(String text) {
        if (outputCallback != null) {
            uiHandler.post(() -> outputCallback.onText(text));
        }
    }

    private void processMorseCode(String code) {
        if (code == null || code.isEmpty())
            return;

        String ch = null;
        if (settings.decoderChoices != null && settings.decoderChoices.containsKey(code)) {
            ch = settings.decoderChoices.get(code);
        }
        if (ch == null) {
            ch = MorseTable.REVERSE_MORSE.get(code);
        }

        if (ch != null) {
            outputText(ch);
            state.currentCode = "";
            state.isWordGapPending = false;
        } else {
            outputText("[?]");
            state.currentCode = "";
            state.isWordGapPending = false;
        }
    }

    private void clearTimingTimeouts() {
        recognitionHandler.removeCallbacksAndMessages(null);
    }

    private void setupLetterWordTimeouts() {
        clearTimingTimeouts();
        final double[] timings = getRecognitionTimings();

        recognitionHandler.postDelayed(() -> {
            if (!state.currentCode.isEmpty() && !state.isTransmitting) {
                processMorseCode(state.currentCode);
                recognitionHandler.postDelayed(() -> {
                    if (!state.isTransmitting && state.currentCode.isEmpty()) {
                        if (settings.showNextWordIndicator) {
                            state.isWordGapPending = true;
                            if (outputCallback != null) {
                                uiHandler.post(() -> outputCallback.onWordGapPending());
                            }
                        } else {
                            outputText(" ");
                        }
                    }
                }, (long) (timings[4] - timings[3]));
            }
        }, (long) timings[3]);
    }

    // ============================================================
    // Sequence playback (tapping on Morse table)
    // ============================================================

    private Runnable sequenceCompleteCallback;

    public void playMorse(String code) {
        if (code == null || code.isEmpty())
            return;
        // If paddles are already held, don't start
        if (state.ditCurrentlyPressed || state.dahCurrentlyPressed)
            return;

        cancelAll();
        state.isSequencePlaying = true;
        
        final double[] timings = getTransmissionTimings();
        sequenceElements = new java.util.ArrayList<>();
        for (int i = 0; i < code.length(); i++) {
            char element = code.charAt(i);
            double toneDuration = (element == '.') ? timings[0] : timings[1];
            double silenceDuration = (i == code.length() - 1) ? 0 : timings[2];
            sequenceElements.add(new double[]{toneDuration, silenceDuration});
        }
        state.sequenceIndex = 0;
        sequenceCompleteCallback = null;
        playNextSequenceElement();
    }

    private java.util.function.Consumer<Integer> sequenceCharCallback;

    public void playText(String text, Runnable onComplete) {
        playText(text, null, onComplete);
    }

    public void playText(String text, java.util.function.Consumer<Integer> onCharIndex, Runnable onComplete) {
        if (text == null || text.isEmpty()) {
            if (onComplete != null) onComplete.run();
            return;
        }
        if (state.ditCurrentlyPressed || state.dahCurrentlyPressed) {
            if (onComplete != null) onComplete.run();
            return;
        }
        
        cancelAll();
        state.isSequencePlaying = true;
        sequenceCompleteCallback = onComplete;
        sequenceCharCallback = onCharIndex;
        
        final double[] timings = getRecognitionTimings();
        sequenceElements = new java.util.ArrayList<>();
        
        String upperText = text.toUpperCase(java.util.Locale.US);
        
        // Convert to sequence of elements
        for (int i = 0; i < upperText.length(); i++) {
            String ch = upperText.substring(i, i+1);
            if (ch.equals(" ")) {
                if (!sequenceElements.isEmpty()) {
                    double[] last = sequenceElements.get(sequenceElements.size() - 1);
                    last[1] = timings[4]; // Replace letter gap with word gap
                }
                continue;
            }
            
            // Find code
            String code = "";
            for (MorseDictionary.Entry entry : MorseDictionary.ENTRIES) {
                if (entry.name.equals(ch)) {
                    code = entry.code;
                    break;
                }
            }
            if (code == null || code.isEmpty()) continue;
            
            for (int j = 0; j < code.length(); j++) {
                char element = code.charAt(j);
                double toneDuration = (element == '.') ? timings[0] : timings[1];
                double silenceDuration = timings[2];
                sequenceElements.add(new double[]{toneDuration, silenceDuration, (double) i});
            }
            
            // Replace last element gap with letter gap
            if (!sequenceElements.isEmpty()) {
                double[] last = sequenceElements.get(sequenceElements.size() - 1);
                last[1] = timings[3];
            }
        }
        
        // Remove silence from very last element
        if (!sequenceElements.isEmpty()) {
            sequenceElements.get(sequenceElements.size() - 1)[1] = 0;
        }

        state.sequenceIndex = 0;
        playNextSequenceElement();
    }

    private void onElementToneStart(double[] element) {
        notifyVisual(true);
        if (sequenceCharCallback != null && element != null && element.length > 2) {
            final int charIdx = (int) element[2];
            uiHandler.post(() -> {
                if (sequenceCharCallback != null) {
                    sequenceCharCallback.accept(charIdx);
                }
            });
        }
    }

    private void playNextSequenceElement() {
        if (!state.isSequencePlaying || sequenceElements == null || state.sequenceIndex >= sequenceElements.size()) {
            state.isSequencePlaying = false;
            sequenceCharCallback = null;
            return;
        }

        double[] element = sequenceElements.get(state.sequenceIndex);
        state.sequenceIndex++;

        onElementToneStart(element);
        toneEngine.playElement(element[0], element[1],
                this::onSequenceToneEnd, this::onSequenceSilenceEnd);
    }

    private void onSequenceToneEnd() {
        notifyVisual(false);
        if (state.isSequencePlaying && sequenceElements != null && state.sequenceIndex < sequenceElements.size()) {
            double[] nextElement = sequenceElements.get(state.sequenceIndex);
            state.sequenceIndex++;

            toneEngine.queueNextElement(nextElement[0], nextElement[1],
                    () -> onElementToneStart(nextElement),
                    this::onSequenceToneEnd,
                    this::onSequenceSilenceEnd);
        }
    }

    private void onSequenceSilenceEnd() {
        if (sequenceElements == null || state.sequenceIndex >= sequenceElements.size()) {
            state.isSequencePlaying = false;
            sequenceCharCallback = null;
            if (sequenceCompleteCallback != null) {
                uiHandler.post(sequenceCompleteCallback);
                sequenceCompleteCallback = null;
            }
        }
    }

    // ============================================================
    // Key handling
    // ============================================================

    public void handleStraightKey(boolean isPressed) {
        if (!inputEnabled) return;
        if (isPressed) {
            clearTimingTimeouts();
            if (!state.isTransmitting) {
                state.isTransmitting = true;
                toneEngine.setToneActive(true);
                notifyVisual(true);
                state.lastElementTime = android.os.SystemClock.elapsedRealtime();
            }
        } else {
            if (state.isTransmitting) {
                state.isTransmitting = false;
                toneEngine.setToneActive(false);
                notifyVisual(false);

                long now = android.os.SystemClock.elapsedRealtime();
                final double[] timings = getRecognitionTimings();

                long duration = now - (long) state.lastElementTime;
                String element = duration < (timings[0] + timings[1]) / 2 ? "." : "-";
                state.currentCode += element;
                state.lastElementTime = now;
                setupLetterWordTimeouts();
            }
        }
    }

    // Iambic keyer
    // ============================================================

    /**
     * Determine the next element to send based on current paddle state and memory.
     * Returns "." for dit, "-" for dah, or null if nothing to send.
     */
    private String determineNextElement() {
        boolean ditHeld = state.ditCurrentlyPressed;
        boolean dahHeld = state.dahCurrentlyPressed;
        boolean squeezeHeld = ditHeld && dahHeld;

        boolean squeezeActive = squeezeHeld || ("iambic-b".equals(settings.mode) && state.squeezePressedDuringElement);

        boolean ditMemory = state.ditPressedDuringElement;
        boolean dahMemory = state.dahPressedDuringElement;

        // 1. Priority: Squeeze / Alternation
        if (squeezeActive ||
           (".".equals(state.lastElement) && ditHeld && dahMemory) ||
           ("-".equals(state.lastElement) && dahHeld && ditMemory)) {
            return ".".equals(state.lastElement) ? "-" : ".";
        }
        // 2. Priority: Current Press (if only one held)
        else if (ditHeld) {
            return ".";
        } else if (dahHeld) {
            return "-";
        }
        // 3. Priority: Memory (Taps while nothing held)
        else if (ditMemory) {
            return ".";
        } else if (dahMemory) {
            return "-";
        }

        return null;
    }

    /**
     * Prepare state for sending an element (memory reset, squeeze update).
     */
    private void prepareElementState(String elementToSend) {
        state.lastElement = elementToSend;

        // Reset memory — must match reference exactly per mode
        if ("iambic-a".equals(settings.mode)) {
            state.ditPressedDuringElement = false;
            state.dahPressedDuringElement = false;
        } else {
            if (".".equals(state.lastElement)) {
                state.ditPressedDuringElement = false;
            } else {
                state.ditPressedDuringElement = state.ditCurrentlyPressed;
            }
            if ("-".equals(state.lastElement)) {
                state.dahPressedDuringElement = false;
            } else {
                state.dahPressedDuringElement = state.dahCurrentlyPressed;
            }
        }

        // Squeeze memory for the NEXT element
        state.squeezePressedDuringElement = state.squeezeCurrentlyPressed;
    }

    private void updateQueuedElement() {
        String nextElement = determineNextElement();
        if (nextElement != null) {
            final double[] timings = getTransmissionTimings();
            double toneDuration = ".".equals(nextElement) ? timings[0] : timings[1];
            double silenceDuration = timings[2];

            toneEngine.queueNextElement(toneDuration, silenceDuration,
                    () -> onQueuedElementStart(nextElement),
                    this::onElementToneEnd,
                    this::onElementSilenceEnd);
        } else {
            toneEngine.cancelQueuedElement();
        }
    }

    private void onQueuedElementStart(String element) {
        clearTimingTimeouts();
        notifyVisual(true);
        prepareElementState(element);
    }

    /**
     * Common toneEnd callback — fired at the exact tone→silence sample boundary.
     * Updates state and determines whether to queue the next element.
     */
    private void onElementToneEnd() {
        notifyVisual(false);
        state.currentCode += state.lastElement;
        state.lastElementTime = android.os.SystemClock.elapsedRealtime();

        // Start recognition timer from tone end
        setupLetterWordTimeouts();

        // Initialize the queued element for the gap phase
        updateQueuedElement();
    }

    /**
     * Common silenceEnd callback — fired when silence ends with no queued element.
     * The element sequence has ended; clean up state and re-evaluate paddles
     * in case they were pressed during the silence phase.
     */
    private void onElementSilenceEnd() {
        state.isTransmitting = false;
        state.iambicScheduled = false;
        handleIambic();
    }

    /**
     * Start the iambic keyer — called from paddle press (first element).
     */
    private void handleIambic() {
        if (state.isTransmitting || state.iambicScheduled)
            return;

        final double[] timings = getTransmissionTimings();
        String elementToSend = determineNextElement();

        if (elementToSend == null) {
            return;
        }

        clearTimingTimeouts();
        state.isTransmitting = true;
        prepareElementState(elementToSend);

        final double toneDuration = ".".equals(elementToSend) ? timings[0] : timings[1];
        final double silenceDuration = timings[2];

        notifyVisual(true);
        state.iambicScheduled = true;
        toneEngine.playElement(toneDuration, silenceDuration,
                this::onElementToneEnd, this::onElementSilenceEnd);
    }

    // Ultimatic keyer
    // ============================================================

    private String determineNextUltimaticElement() {
        boolean ditHeld = state.ditCurrentlyPressed;
        boolean dahHeld = state.dahCurrentlyPressed;
        boolean squeezeHeld = ditHeld && dahHeld;
        
        if (squeezeHeld) {
            return state.ultimaticLastPaddle;
        } else if (ditHeld) {
            return ".";
        } else if (dahHeld) {
            return "-";
        } else if (state.ditPressedDuringElement && state.dahPressedDuringElement) {
            return state.ultimaticLastPaddle;
        } else if (state.ditPressedDuringElement) {
            return ".";
        } else if (state.dahPressedDuringElement) {
            return "-";
        }
        return null;
    }

    private void prepareUltimaticElementState(String elementToSend) {
        state.lastElement = elementToSend;
        state.ditPressedDuringElement = false;
        state.dahPressedDuringElement = false;
        state.squeezePressedDuringElement = state.squeezeCurrentlyPressed;
    }

    private void updateQueuedUltimaticElement() {
        String nextElement = determineNextUltimaticElement();
        if (nextElement != null) {
            final double[] timings = getTransmissionTimings();
            double toneDuration = ".".equals(nextElement) ? timings[0] : timings[1];
            double silenceDuration = timings[2];

            toneEngine.queueNextElement(toneDuration, silenceDuration,
                    () -> onQueuedUltimaticElementStart(nextElement),
                    this::onUltimaticElementToneEnd,
                    this::onUltimaticElementSilenceEnd);
        } else {
            toneEngine.cancelQueuedElement();
        }
    }

    private void onQueuedUltimaticElementStart(String element) {
        clearTimingTimeouts();
        notifyVisual(true);
        prepareUltimaticElementState(element);
    }

    private void onUltimaticElementToneEnd() {
        notifyVisual(false);
        state.currentCode += state.lastElement;
        state.lastElementTime = android.os.SystemClock.elapsedRealtime();
        setupLetterWordTimeouts();
        updateQueuedUltimaticElement();
    }

    private void onUltimaticElementSilenceEnd() {
        state.isTransmitting = false;
        state.iambicScheduled = false;
        handleUltimatic();
    }

    private void handleUltimatic() {
        if (state.isTransmitting || state.iambicScheduled)
            return;

        final double[] timings = getTransmissionTimings();
        String elementToSend = determineNextUltimaticElement();

        if (elementToSend == null) {
            return;
        }

        clearTimingTimeouts();
        state.isTransmitting = true;
        prepareUltimaticElementState(elementToSend);

        final double toneDuration = ".".equals(elementToSend) ? timings[0] : timings[1];
        final double silenceDuration = timings[2];

        notifyVisual(true);
        state.iambicScheduled = true;
        toneEngine.playElement(toneDuration, silenceDuration,
                this::onUltimaticElementToneEnd, this::onUltimaticElementSilenceEnd);
    }

    // Bug (semi-automatic) keyer
    // ============================================================
    // Left paddle (dit-side): automatic timed dits (like single-paddle iambic)
    // Right paddle (key-side): continuous tone while held (like straight key)

    /**
     * Start a timed dit element for Bug mode.
     * Called when dit paddle is pressed and nothing is transmitting.
     */
    private void handleBugDitPress() {
        if (state.isTransmitting || state.iambicScheduled)
            return;
        if (state.bugKeyActive)
            return; // Key side owns the tone right now

        final double[] timings = getTransmissionTimings();
        double toneDuration = timings[0]; // dit length
        double silenceDuration = timings[2]; // element gap

        clearTimingTimeouts();
        state.isTransmitting = true;
        state.iambicScheduled = true;
        state.lastElement = ".";

        notifyVisual(true);
        toneEngine.playElement(toneDuration, silenceDuration,
                this::onBugDitToneEnd, this::onBugDitSilenceEnd);
    }

    /**
     * Called when a Bug dit's tone phase ends (silence gap begins).
     */
    private void onBugDitToneEnd() {
        notifyVisual(false);
        state.currentCode += ".";
        state.lastElementTime = android.os.SystemClock.elapsedRealtime();
        setupLetterWordTimeouts();

        // If key side is now held, transition to continuous tone
        if (state.dahCurrentlyPressed) {
            // Don't queue another dit — let silence end naturally,
            // then onBugDitSilenceEnd will start the key tone
            toneEngine.cancelQueuedElement();
        } else {
            updateQueuedBugElement();
        }
    }

    /**
     * Called when a Bug dit's silence gap ends with no queued element.
     */
    private void onBugDitSilenceEnd() {
        state.isTransmitting = false;
        state.iambicScheduled = false;

        // If key side is held, start continuous tone
        if (state.dahCurrentlyPressed) {
            bugStartKeyTone();
            return;
        }

        // If dit side is still held, start another dit
        if (state.ditCurrentlyPressed) {
            handleBugDitPress();
        }
    }

    /**
     * Queue the next dit element during a Bug dit's silence phase.
     * Only queues if dit is held and key is NOT held.
     */
    private void updateQueuedBugElement() {
        if (state.ditCurrentlyPressed && !state.dahCurrentlyPressed) {
            final double[] timings = getTransmissionTimings();
            double toneDuration = timings[0];
            double silenceDuration = timings[2];

            toneEngine.queueNextElement(toneDuration, silenceDuration,
                    () -> onQueuedBugDitStart(),
                    this::onBugDitToneEnd,
                    this::onBugDitSilenceEnd);
        } else {
            toneEngine.cancelQueuedElement();
        }
    }

    private void onQueuedBugDitStart() {
        clearTimingTimeouts();
        notifyVisual(true);
        state.lastElement = ".";
    }

    /**
     * Start continuous tone for Bug key side (straight-key behavior).
     */
    private void bugStartKeyTone() {
        clearTimingTimeouts();
        state.isTransmitting = true;
        state.bugKeyActive = true;
        toneEngine.setToneActive(true);
        notifyVisual(true);
        state.lastElementTime = android.os.SystemClock.elapsedRealtime();
    }

    /**
     * Stop continuous tone for Bug key side and do character recognition.
     */
    private void bugStopKeyTone() {
        state.bugKeyActive = false;
        state.isTransmitting = false;
        state.iambicScheduled = false;
        toneEngine.setToneActive(false);
        notifyVisual(false);

        // Character recognition: classify duration as dit or dah
        long now = android.os.SystemClock.elapsedRealtime();
        final double[] timings = getRecognitionTimings();
        long duration = now - (long) state.lastElementTime;
        String element = duration < (timings[0] + timings[1]) / 2 ? "." : "-";
        state.currentCode += element;
        state.lastElementTime = now;
        setupLetterWordTimeouts();
    }

    /**
     * Handle Bug key-side state changes (press/release of dah paddle).
     */
    private void handleBugKeyStateChange(boolean dahJustPressed, boolean dahJustReleased) {
        if (dahJustPressed) {
            if (state.bugKeyActive) return; // already active

            if (state.isTransmitting || state.iambicScheduled) {
                // Dit element is in progress — cancel queued next dit
                // so when the current dit+gap finishes, we transition to key
                toneEngine.cancelQueuedElement();
            } else {
                // Nothing transmitting, start key tone immediately
                bugStartKeyTone();
            }
        } else if (dahJustReleased) {
            if (!state.bugKeyActive) return; // key wasn't active

            bugStopKeyTone();

            // If dit is still held, schedule dits after a gap
            if (state.ditCurrentlyPressed) {
                final double[] timings = getTransmissionTimings();
                long gapMs = (long) timings[2]; // dit-length gap
                state.isTransmitting = true; // block re-entry during gap
                timingHandler.postDelayed(() -> {
                    state.isTransmitting = false;
                    if (state.ditCurrentlyPressed && !state.dahCurrentlyPressed) {
                        handleBugDitPress();
                    }
                }, gapMs);
            }
        }
    }

    // Cootie (sideswiper) keyer
    // ============================================================
    // Two paddles, both act as straight keys. Tone is on if either
    // or both paddles are pressed (OR logic). Functionally identical
    // to a straight key with two physical inputs.

    /**
     * Handle Cootie key state change. Called on any paddle press/release.
     * Tone is active when either paddle is held.
     */
    private void handleCootieKey() {
        boolean anyPressed = state.ditCurrentlyPressed || state.dahCurrentlyPressed;
        if (anyPressed) {
            clearTimingTimeouts();
            if (!state.isTransmitting) {
                state.isTransmitting = true;
                toneEngine.setToneActive(true);
                notifyVisual(true);
                state.lastElementTime = android.os.SystemClock.elapsedRealtime();
            }
        } else {
            if (state.isTransmitting) {
                state.isTransmitting = false;
                toneEngine.setToneActive(false);
                notifyVisual(false);

                long now = android.os.SystemClock.elapsedRealtime();
                final double[] timings = getRecognitionTimings();

                long duration = now - (long) state.lastElementTime;
                String element = duration < (timings[0] + timings[1]) / 2 ? "." : "-";
                state.currentCode += element;
                state.lastElementTime = now;
                setupLetterWordTimeouts();
            }
        }
    }

    private void notifyVisual(boolean transmitting) {
        if (visualCallback != null && settings.visual) {
            if (transmitting)
                visualCallback.onToneStart();
            else
                visualCallback.onToneStop();
        }
    }

    public void handlePaddlePress(String side, boolean isPressed) {
        if (!inputEnabled) return;
        if (isPressed && state.isSequencePlaying) {
            cancelAll();
        }
        if (isPressed) {
            if ("left".equals(side)) {
                if ("normal".equals(settings.polarity)) {
                    state.ditCurrentlyPressed = true;
                    state.ultimaticLastPaddle = ".";
                    if (state.isTransmitting || state.iambicScheduled)
                        state.ditPressedDuringElement = true;
                } else {
                    state.dahCurrentlyPressed = true;
                    state.ultimaticLastPaddle = "-";
                    if (state.isTransmitting || state.iambicScheduled)
                        state.dahPressedDuringElement = true;
                }
            } else {
                if ("normal".equals(settings.polarity)) {
                    state.dahCurrentlyPressed = true;
                    state.ultimaticLastPaddle = "-";
                    if (state.isTransmitting || state.iambicScheduled)
                        state.dahPressedDuringElement = true;
                } else {
                    state.ditCurrentlyPressed = true;
                    state.ultimaticLastPaddle = ".";
                    if (state.isTransmitting || state.iambicScheduled)
                        state.ditPressedDuringElement = true;
                }
            }
        } else {
            if ("left".equals(side)) {
                if ("normal".equals(settings.polarity))
                    state.ditCurrentlyPressed = false;
                else
                    state.dahCurrentlyPressed = false;
            } else {
                if ("normal".equals(settings.polarity))
                    state.dahCurrentlyPressed = false;
                else
                    state.ditCurrentlyPressed = false;
            }
        }

        state.squeezeCurrentlyPressed = state.ditCurrentlyPressed && state.dahCurrentlyPressed;
        if (state.squeezeCurrentlyPressed && (state.isTransmitting || state.iambicScheduled)) {
            state.squeezePressedDuringElement = true;
        }

        if ("straight".equals(settings.mode)) {
            if ("left".equals(side)) {
                handleStraightKey(isPressed);
            }
        } else if ("ultimatic".equals(settings.mode)) {
            if (state.isTransmitting || state.iambicScheduled) {
                updateQueuedUltimaticElement();
            } else if (isPressed) {
                handleUltimatic();
            }
        } else if ("bug".equals(settings.mode)) {
            // Bug mode: dit-side uses timed elements, key-side uses straight key
            boolean ditSideChanged = ("left".equals(side) && "normal".equals(settings.polarity))
                    || ("right".equals(side) && "inverse".equals(settings.polarity));
            boolean keySideChanged = !ditSideChanged;

            if (keySideChanged) {
                handleBugKeyStateChange(isPressed, !isPressed);
            }
            if (ditSideChanged && isPressed) {
                if (!state.bugKeyActive && !state.isTransmitting && !state.iambicScheduled) {
                    handleBugDitPress();
                }
            }
            // If dit side changed during a dit element, update queued element
            if (ditSideChanged && (state.isTransmitting || state.iambicScheduled) && !state.bugKeyActive) {
                updateQueuedBugElement();
            }
        } else if ("cootie".equals(settings.mode)) {
            // Cootie: both paddles act as one straight key (OR logic)
            handleCootieKey();
        } else {
            if (state.isTransmitting || state.iambicScheduled) {
                // We are transmitting (tone or silence). Re-evaluate what should be queued next!
                updateQueuedElement();
            } else if (isPressed) {
                handleIambic();
            }
        }
    }
}
