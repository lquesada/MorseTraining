package com.qft8.morsekeyer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for MorseKeyer: paddle state management, polarity, mode switching.
 *
 * Note: Handler.postDelayed() returns 0 (default) in unit tests due to
 * unitTests.returnDefaultValues = true. This means the iambic scheduling
 * and letter/word timeouts won't fire asynchronously. We test the
 * synchronous state transitions instead.
 */
public class MorseKeyerTest {

    private MorseSettings settings;
    private MorseState state;
    private ToneEngine toneEngine;
    private List<String> outputLog;
    private MorseKeyer keyer;

    @Before
    public void setUp() {
        settings = new MorseSettings();
        state = new MorseState();
        toneEngine = new ToneEngine();
        outputLog = new ArrayList<>();
        keyer = new MorseKeyer(settings, state, toneEngine, new MorseKeyer.OutputCallback() {
            @Override
            public void onText(String text) {
                outputLog.add(text);
            }

            @Override
            public void onWordGapPending() {
            }

            @Override
            public void onWordGapConfirmed() {
            }
        });
    }

    // ================================================================
    // Paddle press — normal polarity, iambic-a mode
    // ================================================================

    @Test
    public void testLeftPressSetsDit_NormalPolarity() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        keyer.handlePaddlePress("left", true);
        assertTrue(state.ditCurrentlyPressed);
        assertFalse(state.dahCurrentlyPressed);
    }

    @Test
    public void testRightPressSetsDah_NormalPolarity() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        keyer.handlePaddlePress("right", true);
        assertFalse(state.ditCurrentlyPressed);
        assertTrue(state.dahCurrentlyPressed);
    }

    @Test
    public void testLeftReleaseClears_NormalPolarity() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        keyer.handlePaddlePress("left", true);
        assertTrue(state.ditCurrentlyPressed);
        keyer.handlePaddlePress("left", false);
        assertFalse(state.ditCurrentlyPressed);
    }

    @Test
    public void testRightReleaseClears_NormalPolarity() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        keyer.handlePaddlePress("right", true);
        assertTrue(state.dahCurrentlyPressed);
        keyer.handlePaddlePress("right", false);
        assertFalse(state.dahCurrentlyPressed);
    }

    // ================================================================
    // Paddle press — inverse polarity
    // ================================================================

    @Test
    public void testLeftPressSetsDah_InversePolarity() {
        settings.mode = "iambic-a";
        settings.polarity = "inverse";
        keyer.handlePaddlePress("left", true);
        assertFalse(state.ditCurrentlyPressed);
        assertTrue(state.dahCurrentlyPressed);
    }

    @Test
    public void testRightPressSetsDit_InversePolarity() {
        settings.mode = "iambic-a";
        settings.polarity = "inverse";
        keyer.handlePaddlePress("right", true);
        assertTrue(state.ditCurrentlyPressed);
        assertFalse(state.dahCurrentlyPressed);
    }

    @Test
    public void testLeftReleaseClears_InversePolarity() {
        settings.mode = "iambic-a";
        settings.polarity = "inverse";
        keyer.handlePaddlePress("left", true);
        assertTrue(state.dahCurrentlyPressed);
        keyer.handlePaddlePress("left", false);
        assertFalse(state.dahCurrentlyPressed);
    }

    @Test
    public void testRightReleaseClears_InversePolarity() {
        settings.mode = "iambic-a";
        settings.polarity = "inverse";
        keyer.handlePaddlePress("right", true);
        assertTrue(state.ditCurrentlyPressed);
        keyer.handlePaddlePress("right", false);
        assertFalse(state.ditCurrentlyPressed);
    }

    // ================================================================
    // Squeeze detection
    // ================================================================

    @Test
    public void testSqueezeDetected_BothPaddles() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        keyer.handlePaddlePress("left", true);
        keyer.handlePaddlePress("right", true);
        assertTrue(state.squeezeCurrentlyPressed);
    }

    @Test
    public void testSqueezeCleared_OnePaddleReleased() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        keyer.handlePaddlePress("left", true);
        keyer.handlePaddlePress("right", true);
        assertTrue(state.squeezeCurrentlyPressed);
        keyer.handlePaddlePress("left", false);
        assertFalse(state.squeezeCurrentlyPressed);
    }

    @Test
    public void testNoSqueeze_SinglePaddle() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        keyer.handlePaddlePress("left", true);
        assertFalse(state.squeezeCurrentlyPressed);
    }

    // ================================================================
    // Straight key mode — only left paddle activates
    // ================================================================

    @Test
    public void testStraightKey_LeftPressStartsTransmitting() {
        settings.mode = "straight";
        settings.polarity = "normal";
        keyer.handlePaddlePress("left", true);
        assertTrue("Left press in straight mode should start transmitting",
            state.isTransmitting);
    }

    @Test
    public void testStraightKey_RightPressDoesNotTransmit() {
        settings.mode = "straight";
        settings.polarity = "normal";
        keyer.handlePaddlePress("right", true);
        // In straight mode, handleStraightKey is called with isPressed && "left".equals(side)
        // right press → isPressed=true but side="right" → handleStraightKey(false) → no transmit
        assertFalse("Right press in straight mode should not start transmitting",
            state.isTransmitting);
    }

    @Test
    public void testStraightKey_LeftRelease_StopsTransmitting() {
        settings.mode = "straight";
        settings.polarity = "normal";
        keyer.handlePaddlePress("left", true);
        assertTrue(state.isTransmitting);
        keyer.handlePaddlePress("left", false);
        assertFalse(state.isTransmitting);
    }

    @Test
    public void testStraightKey_LeftRelease_AppendsElement() {
        settings.mode = "straight";
        settings.polarity = "normal";
        keyer.handlePaddlePress("left", true);
        keyer.handlePaddlePress("left", false);
        // currentCode should have an element appended (. or - depending on duration)
        assertFalse("Should have appended an element to currentCode",
            state.currentCode.isEmpty());
    }

    @Test
    public void testStraightKey_ToneEngineActivated() {
        settings.mode = "straight";
        settings.polarity = "normal";
        keyer.handlePaddlePress("left", true);
        assertTrue(toneEngine.isPlaying());
        keyer.handlePaddlePress("left", false);
        assertFalse(toneEngine.isPlaying());
    }

    // ================================================================
    // DuringElement flags
    // ================================================================

    @Test
    public void testDitPressedDuringElement_WhenTransmitting() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        // Simulate transmitting state
        state.isTransmitting = true;
        keyer.handlePaddlePress("left", true);
        assertTrue(state.ditPressedDuringElement);
    }

    @Test
    public void testDahPressedDuringElement_WhenTransmitting() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        state.isTransmitting = true;
        keyer.handlePaddlePress("right", true);
        assertTrue(state.dahPressedDuringElement);
    }

    @Test
    public void testDitNotPressedDuringElement_WhenIdle() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        state.isTransmitting = false;
        state.iambicScheduled = false;
        keyer.handlePaddlePress("left", true);
        assertFalse(state.ditPressedDuringElement);
    }

    @Test
    public void testDitPressedDuringElement_WhenIambicScheduled() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        state.iambicScheduled = true;
        keyer.handlePaddlePress("left", true);
        assertTrue(state.ditPressedDuringElement);
    }

    @Test
    public void testSqueezeDuringElement_WhenTransmitting() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        state.isTransmitting = true;
        keyer.handlePaddlePress("left", true);
        keyer.handlePaddlePress("right", true);
        assertTrue(state.squeezePressedDuringElement);
    }

    // ================================================================
    // Cancel all
    // ================================================================

    @Test
    public void testCancelAll_ClearsState() {
        settings.mode = "straight";
        settings.polarity = "normal";
        keyer.handlePaddlePress("left", true);
        assertTrue(state.isTransmitting);
        keyer.cancelAll();
        assertFalse(state.isTransmitting);
        assertFalse(state.iambicScheduled);
        assertFalse(toneEngine.isPlaying());
    }

    // ================================================================
    // Mode-specific behavior
    // ================================================================

    @Test
    public void testIambicA_IambicTriggeredOnPress() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        // When idle and paddle pressed, iambic should start transmitting
        keyer.handlePaddlePress("left", true);
        assertTrue("Iambic should start transmitting on press",
            state.isTransmitting);
    }

    @Test
    public void testIambicB_IambicTriggeredOnPress() {
        settings.mode = "iambic-b";
        settings.polarity = "normal";
        keyer.handlePaddlePress("right", true);
        assertTrue("Iambic B should start transmitting on press",
            state.isTransmitting);
    }

    // ================================================================
    // Multiple presses without release
    // ================================================================

    @Test
    public void testDoublePressNoEffect() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        keyer.handlePaddlePress("left", true);
        boolean first = state.ditCurrentlyPressed;
        keyer.handlePaddlePress("left", true);
        assertEquals(first, state.ditCurrentlyPressed);
    }

    @Test
    public void testDoubleReleaseNoEffect() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        keyer.handlePaddlePress("left", true);
        keyer.handlePaddlePress("left", false);
        assertFalse(state.ditCurrentlyPressed);
        keyer.handlePaddlePress("left", false);
        assertFalse(state.ditCurrentlyPressed);
    }

    // ================================================================
    // Output callback
    // ================================================================

    @Test
    public void testNullOutputCallbackDoesNotCrash() {
        MorseKeyer safeKeyer = new MorseKeyer(settings, state, toneEngine, null);
        settings.mode = "straight";
        safeKeyer.handlePaddlePress("left", true);
        safeKeyer.handlePaddlePress("left", false);
        // No crash = pass
    }

    // ================================================================
    // Visual callback
    // ================================================================

    @Test
    public void testVisualCallbackFiredOnTone() {
        final boolean[] started = {false};
        final boolean[] stopped = {false};
        keyer.setVisualCallback(new MorseKeyer.VisualCallback() {
            @Override public void onToneStart() { started[0] = true; }
            @Override public void onToneStop() { stopped[0] = true; }
        });
        settings.mode = "straight";
        settings.visual = true;
        keyer.handlePaddlePress("left", true);
        assertTrue("Visual callback should fire on tone start", started[0]);
        keyer.handlePaddlePress("left", false);
        assertTrue("Visual callback should fire on tone stop", stopped[0]);
    }

    @Test
    public void testVisualCallbackNotFiredWhenVisualOff() {
        final boolean[] started = {false};
        keyer.setVisualCallback(new MorseKeyer.VisualCallback() {
            @Override public void onToneStart() { started[0] = true; }
            @Override public void onToneStop() {}
        });
        settings.mode = "straight";
        settings.visual = false;
        keyer.handlePaddlePress("left", true);
        assertFalse("Visual callback should NOT fire when visual is off", started[0]);
    }
}
