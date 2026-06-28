package com.qft8.morsekeyer;

import android.os.Handler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * Tests for Morse spacing/timing behavior.
 *
 * The iambic path uses ToneEngine.playElement() with two callbacks:
 * - onToneEnd: fired at tone→silence transition (updates state, queues next element)
 * - onSilenceEnd: fired when silence ends with no queued next element (cleanup)
 *
 * These tests verify:
 * 1. playElement() is called with correct tone and silence durations.
 * 2. The toneEnd callback correctly determines the next element and queues it.
 * 3. The silenceEnd callback correctly cleans up state.
 * 4. Recognition timers fire correctly after silenceEnd.
 */
public class MorseSpacingTimingTest {

    private MorseSettings settings;
    private MorseState state;
    private ToneEngine toneEngine;
    private MorseKeyer keyer;
    private Handler mockRecognitionHandler;

    @Before
    public void setUp() {
        settings = new MorseSettings();
        state = new MorseState();
        toneEngine = mock(ToneEngine.class);
        keyer = new MorseKeyer(settings, state, toneEngine, null);

        mockRecognitionHandler = mock(Handler.class);
        keyer.recognitionHandler = mockRecognitionHandler;
    }

    /**
     * Performs a single dit via the iambic path and verifies:
     * 1. playElement() was called with the correct tone and silence durations.
     * 2. After toneEnd + silenceEnd callbacks, recognition timers have correct values.
     */
    private void performSingleDitAndVerifyTimings(
            double expectedToneDuration,
            double expectedSilenceDuration,
            long expectedLetterGap,
            long expectedWordGap) {

        // 1. Press dit paddle — triggers handleIambic → toneEngine.playElement()
        keyer.handlePaddlePress("left", true);

        // 2. Capture the playElement call
        ArgumentCaptor<Double> toneCaptor = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<Double> silenceCaptor = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<Runnable> toneEndCaptor = ArgumentCaptor.forClass(Runnable.class);
        ArgumentCaptor<Runnable> silenceEndCaptor = ArgumentCaptor.forClass(Runnable.class);
        verify(toneEngine).playElement(
                toneCaptor.capture(), silenceCaptor.capture(),
                toneEndCaptor.capture(), silenceEndCaptor.capture());

        assertEquals("Tone duration (ms)", expectedToneDuration, toneCaptor.getValue(), 0.001);
        assertEquals("Silence duration (ms)", expectedSilenceDuration, silenceCaptor.getValue(), 0.001);

        // 3. Release paddle before firing callbacks
        keyer.handlePaddlePress("left", false);

        // 4. Fire toneEnd callback (sets up recognition timers, but isTransmitting is still true)
        toneEndCaptor.getValue().run();

        // 5. Fire silenceEnd callback (sets isTransmitting = false)
        silenceEndCaptor.getValue().run();
        assertFalse("Should no longer be transmitting", state.isTransmitting);

        // 6. Verify Letter Gap timer was scheduled by toneEnd
        ArgumentCaptor<Runnable> letterGapCaptor = ArgumentCaptor.forClass(Runnable.class);
        verify(mockRecognitionHandler).postDelayed(letterGapCaptor.capture(), eq(expectedLetterGap));

        // 7. Fire Letter Gap timer (now isTransmitting is false, so it will process the code)
        letterGapCaptor.getValue().run();

        // 8. Verify Word Gap timer (scheduled for wordGap - letterGap)
        verify(mockRecognitionHandler).postDelayed(any(Runnable.class), eq(expectedWordGap - expectedLetterGap));
    }

    @Test
    public void testSpacing_100Percent() {
        settings.wpm = 15; // 1 dit = 80ms
        settings.strict = false;
        settings.interletterSpacing = 100;
        settings.interwordSpacing = 100;

        // Tone: 80ms dit, Silence: 80ms element gap
        // Letter: 3 dits = 240ms, Word: 7 dits = 560ms
        performSingleDitAndVerifyTimings(80.0, 80.0, 240L, 560L);
    }

    @Test
    public void testSpacing_200Percent() {
        settings.wpm = 15;
        settings.strict = false;
        settings.interletterSpacing = 200;
        settings.interwordSpacing = 200;

        performSingleDitAndVerifyTimings(80.0, 80.0, 480L, 1120L);
    }

    @Test
    public void testSpacing_500Percent() {
        settings.wpm = 15;
        settings.strict = false;
        settings.interletterSpacing = 500;
        settings.interwordSpacing = 500;

        performSingleDitAndVerifyTimings(80.0, 80.0, 1200L, 2800L);
    }


    @Test
    public void testSpacing_50Percent() {
        settings.wpm = 15;
        settings.strict = false;
        settings.interletterSpacing = 50;
        settings.interwordSpacing = 50;

        performSingleDitAndVerifyTimings(80.0, 80.0, 120L, 280L);
    }

    @Test
    public void testSpacing_StrictAlways100() {
        settings.wpm = 15;
        settings.strict = true;
        settings.interletterSpacing = 500;
        settings.interwordSpacing = 500;

        performSingleDitAndVerifyTimings(80.0, 80.0, 240L, 560L);
    }

    @Test
    public void testPlayElement_DahDuration() {
        settings.wpm = 15; // 1 dit = 80ms
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        keyer.handlePaddlePress("right", true);

        ArgumentCaptor<Double> toneCaptor = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<Double> silenceCaptor = ArgumentCaptor.forClass(Double.class);
        verify(toneEngine).playElement(
                toneCaptor.capture(), silenceCaptor.capture(),
                any(Runnable.class), any(Runnable.class));

        assertEquals("Dah tone duration should be 3 dits (240ms)", 240.0, toneCaptor.getValue(), 0.001);
        assertEquals("Element gap should be 1 dit (80ms)", 80.0, silenceCaptor.getValue(), 0.001);
    }

    /**
     * Test that when the toneEnd callback fires and a paddle is still held,
     * the next element is queued via queueNextElement for seamless chaining.
     */
    @Test
    public void testToneEndCallback_QueuesNextElement() {
        settings.wpm = 15;
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        keyer.handlePaddlePress("left", true);

        ArgumentCaptor<Runnable> toneEndCaptor = ArgumentCaptor.forClass(Runnable.class);
        verify(toneEngine).playElement(
                anyDouble(), anyDouble(),
                toneEndCaptor.capture(), any(Runnable.class));

        // Keep dit held, fire toneEnd callback
        toneEndCaptor.getValue().run();

        // Since dit is still held, next element should be queued
        verify(toneEngine).queueNextElement(
                eq(80.0), eq(80.0),
                any(Runnable.class), any(Runnable.class), any(Runnable.class));
    }

    /**
     * Test that when paddles are released before toneEnd, no element is queued
     * and silenceEnd correctly cleans up.
     */
    @Test
    public void testToneEndCallback_NoQueue_WhenPaddleReleased() {
        settings.wpm = 15;
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        keyer.handlePaddlePress("left", true);

        ArgumentCaptor<Runnable> toneEndCaptor = ArgumentCaptor.forClass(Runnable.class);
        ArgumentCaptor<Runnable> silenceEndCaptor = ArgumentCaptor.forClass(Runnable.class);
        verify(toneEngine).playElement(
                anyDouble(), anyDouble(),
                toneEndCaptor.capture(), silenceEndCaptor.capture());

        keyer.handlePaddlePress("left", false);

        // Fire toneEnd — no paddle held, no memory → nothing queued
        toneEndCaptor.getValue().run();
        verify(toneEngine, never()).queueNextElement(
                anyDouble(), anyDouble(),
                any(Runnable.class), any(Runnable.class), any(Runnable.class));

        // Fire silenceEnd — cleanup
        silenceEndCaptor.getValue().run();
        assertFalse(state.isTransmitting);
        assertFalse(state.iambicScheduled);
    }

    /**
     * Test that silenceEnd correctly transitions state when no next element.
     */
    @Test
    public void testSilenceEnd_ClearsTransmitState() {
        settings.wpm = 15;
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        keyer.handlePaddlePress("left", true);

        ArgumentCaptor<Runnable> silenceEndCaptor = ArgumentCaptor.forClass(Runnable.class);
        verify(toneEngine).playElement(
                anyDouble(), anyDouble(),
                any(Runnable.class), silenceEndCaptor.capture());

        assertTrue("Should be transmitting", state.isTransmitting);
        assertTrue("Should be iambicScheduled", state.iambicScheduled);

        // Release the paddle so handleIambic() (called from silenceEnd) doesn't start a new element
        keyer.handlePaddlePress("left", false);
        silenceEndCaptor.getValue().run();

        assertFalse("isTransmitting should be false after silenceEnd", state.isTransmitting);
        assertFalse("iambicScheduled should be false after silenceEnd", state.iambicScheduled);
    }
}
