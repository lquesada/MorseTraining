package com.qft8.morsekeyer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;

/**
 * Regression tests for iambic keyer timing.
 *
 * These reproduce the reported bug: "press dit, squeeze, get an extra dit
 * and an extra dah". Each test targets a specific root cause that was fixed
 * to align MorseKeyer with the reference MorsePractice implementation.
 *
 * Note: Handler.postDelayed() is a no-op in unit tests (returnDefaultValues).
 * We test the synchronous state transitions that determine what element
 * the keyer will send next.
 */
public class MorseIambicTimingTest {

    private MorseSettings settings;
    private MorseState state;
    private ToneEngine toneEngine;
    private MorseKeyer keyer;

    @Before
    public void setUp() {
        settings = new MorseSettings();
        state = new MorseState();
        toneEngine = mock(ToneEngine.class);
        keyer = new MorseKeyer(settings, state, toneEngine, null);
    }

    // ================================================================
    // Bug 1: handlePaddlePress must NOT set both memory flags
    // ================================================================

    @Test
    public void testDitPressDuringTransmit_OnlySetsditMemory() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        // Simulate: keyer is currently transmitting a dah
        state.isTransmitting = true;
        state.lastElement = "-";

        // Press dit paddle while transmitting
        keyer.handlePaddlePress("left", true);

        // Only dit memory should be set, NOT dah
        assertTrue("Dit memory should be set", state.ditPressedDuringElement);
        assertFalse("Dah memory must NOT be set by a dit press", state.dahPressedDuringElement);
    }

    @Test
    public void testDahPressDuringTransmit_OnlySetsDahMemory() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        // Simulate: keyer is currently transmitting a dit
        state.isTransmitting = true;
        state.lastElement = ".";

        // Press dah paddle while transmitting
        keyer.handlePaddlePress("right", true);

        // Only dah memory should be set, NOT dit
        assertTrue("Dah memory should be set", state.dahPressedDuringElement);
        assertFalse("Dit memory must NOT be set by a dah press", state.ditPressedDuringElement);
    }

    @Test
    public void testSqueezeDuringTransmit_SetsBothMemoryAndSqueeze() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        // Simulate: keyer is transmitting
        state.isTransmitting = true;
        state.lastElement = ".";

        // Squeeze: press both paddles
        keyer.handlePaddlePress("left", true);
        keyer.handlePaddlePress("right", true);

        // Both individual memories set via their respective press handlers
        assertTrue("Dit memory should be set", state.ditPressedDuringElement);
        assertTrue("Dah memory should be set", state.dahPressedDuringElement);
        // Squeeze memory should be set
        assertTrue("Squeeze memory should be set", state.squeezePressedDuringElement);
    }

    @Test
    public void testSinglePaddleDuringTransmit_NoSqueezeMemory() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        state.isTransmitting = true;
        state.lastElement = ".";

        // Only press dit (no squeeze)
        keyer.handlePaddlePress("left", true);

        assertFalse("Squeeze memory must NOT be set for single paddle",
            state.squeezePressedDuringElement);
    }

    // ================================================================
    // Bug 2: handleIambic must not be called while transmitting
    // ================================================================

    @Test
    public void testPaddlePressDuringTransmit_DoesNotRestart() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        // Start transmitting by pressing dit
        keyer.handlePaddlePress("left", true);
        assertTrue("Should be transmitting after dit press", state.isTransmitting);

        String lastElement = state.lastElement;

        // Now press dah while still transmitting
        // This must NOT call handleIambic and change lastElement
        keyer.handlePaddlePress("right", true);

        // lastElement should not change — no new element should start
        assertEquals("lastElement must not change during transmission",
            lastElement, state.lastElement);
    }

    @Test
    public void testPaddlePressDuringScheduled_DoesNotRestart() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        // Simulate: in the element gap (iambicScheduled=true)
        state.iambicScheduled = true;

        // Press a paddle — handleIambic has an early return for iambicScheduled
        keyer.handlePaddlePress("left", true);

        // Should not start transmitting during the scheduled gap
        // (handleIambic returns immediately when iambicScheduled)
        assertFalse("Should not start transmitting during element gap",
            state.isTransmitting);
    }

    // ================================================================
    // Bug 3: Memory reset must match reference per mode
    // ================================================================

    @Test
    public void testIambicA_MemoryResetClearsBothFlags() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        // Set up fake memory (as if both paddles were tapped during element)
        state.ditPressedDuringElement = true;
        state.dahPressedDuringElement = true;
        state.ditCurrentlyPressed = true;

        // Press dit to trigger handleIambic
        keyer.handlePaddlePress("left", true);

        // After handleIambic sends an element in Iambic-A, BOTH flags must be clear
        assertFalse("Dit memory must be cleared in Iambic-A after element",
            state.ditPressedDuringElement);
        assertFalse("Dah memory must be cleared in Iambic-A after element",
            state.dahPressedDuringElement);
    }

    @Test
    public void testIambicB_MemoryResetKeepsDahCurrentlyPressed() {
        settings.mode = "iambic-b";
        settings.polarity = "normal";

        // Simulate: dah is held, sending a dit
        state.ditCurrentlyPressed = true;
        state.dahCurrentlyPressed = true;

        // Press dit to trigger handleIambic — will send dit (first element)
        keyer.handlePaddlePress("left", true);

        // After sending dit:
        // - ditPressedDuringElement should be cleared (element just sent)
        assertFalse("Dit memory must be cleared after sending dit in Iambic-B",
            state.ditPressedDuringElement);
        // - dahPressedDuringElement should reflect dahCurrentlyPressed (dah is held)
        assertTrue("Dah memory must reflect dahCurrentlyPressed in Iambic-B",
            state.dahPressedDuringElement);
    }

    @Test
    public void testIambicB_MemoryResetKeepsDitCurrentlyPressed() {
        settings.mode = "iambic-b";
        settings.polarity = "normal";

        // Simulate: dit is held, dah is held, last element was dit → sends dah
        state.ditCurrentlyPressed = true;
        state.dahCurrentlyPressed = true;
        state.lastElement = ".";

        keyer.handlePaddlePress("right", true);

        // After sending dah:
        // - dahPressedDuringElement should be cleared
        assertFalse("Dah memory must be cleared after sending dah in Iambic-B",
            state.dahPressedDuringElement);
        // - ditPressedDuringElement should reflect ditCurrentlyPressed
        assertTrue("Dit memory must reflect ditCurrentlyPressed in Iambic-B",
            state.ditPressedDuringElement);
    }

    // ================================================================
    // Full scenario: dit → squeeze → verify no extra elements
    // ================================================================

    @Test
    public void testDitThenSqueeze_IambicA_NoExtraMemory() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        // 1. Press dit (starts transmitting dit)
        keyer.handlePaddlePress("left", true);
        assertTrue(state.isTransmitting);
        assertEquals(".", state.lastElement);

        // 2. Squeeze: press dah while dit is transmitting
        keyer.handlePaddlePress("right", true);

        // Dah memory should be set (will cause alternation to dah)
        assertTrue("Dah memory should be set from squeeze",
            state.dahPressedDuringElement);

        // 3. Release both paddles while still transmitting
        keyer.handlePaddlePress("left", false);
        keyer.handlePaddlePress("right", false);

        // In Iambic-A with both released:
        // squeeze is no longer active, and after the memory-based dah plays,
        // both flags will be cleared → no more elements should queue.
        assertFalse("Dit should not be pressed", state.ditCurrentlyPressed);
        assertFalse("Dah should not be pressed", state.dahCurrentlyPressed);
        assertFalse("Squeeze should not be active", state.squeezeCurrentlyPressed);
    }

    @Test
    public void testSingleDitPress_IambicA_NoDahMemory() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        // Press and release dit only
        keyer.handlePaddlePress("left", true);
        keyer.handlePaddlePress("left", false);

        // After the element plays, only dit was ever involved
        // Dah memory must never have been set
        assertFalse("Dah memory must not be set for single dit",
            state.dahPressedDuringElement);
    }

    @Test
    public void testSingleDahPress_IambicA_NoDitMemory() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        // Press and release dah only
        keyer.handlePaddlePress("right", true);
        keyer.handlePaddlePress("right", false);

        // Dit memory must never have been set
        assertFalse("Dit memory must not be set for single dah",
            state.ditPressedDuringElement);
    }

    @Test
    public void testIambicB_GapPhaseSqueeze_ReevaluatesQueuedElement() {
        settings.mode = "iambic-b";
        settings.polarity = "normal";

        // 1. Press dit, starts transmitting dit
        keyer.handlePaddlePress("left", true);
        
        // Capture toneEnd and verify playElement was called
        ArgumentCaptor<Runnable> toneEndCaptor = ArgumentCaptor.forClass(Runnable.class);
        verify(toneEngine).playElement(anyDouble(), anyDouble(), toneEndCaptor.capture(), any(Runnable.class));
        
        // 2. Release dit before tone ends
        keyer.handlePaddlePress("left", false);

        // 3. Fire toneEnd callback (enters silence gap)
        toneEndCaptor.getValue().run();
        
        // At this point, no paddles are pressed, no memory is set.
        // The keyer should queue NOTHING and call cancelQueuedElement.
        verify(toneEngine, atLeastOnce()).cancelQueuedElement();
        
        // 4. During the silence gap, press the dah paddle
        // This should trigger updateQueuedElement() and queue a dah
        keyer.handlePaddlePress("right", true);

        // verify queueNextElement was called with dah duration
        verify(toneEngine).queueNextElement(
                eq(240.0), anyDouble(), // wpm=15 -> 80ms dit -> 240ms dah
                any(Runnable.class), any(Runnable.class), any(Runnable.class));
    }
}
