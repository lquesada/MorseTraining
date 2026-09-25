package com.qft8.morsekeyer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;

/**
 * Unit tests for Ultimatic, Bug, and Cootie modes.
 * Verifies the specific logic and state transitions for these modes.
 */
public class MorseAllModesTest {

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

    @Test
    public void testUltimatic_LastPaddleWins_DitThenDah() {
        settings.mode = "ultimatic";
        settings.polarity = "normal";

        keyer.handlePaddlePress("left", true);
        assertTrue("Should be transmitting after first press", state.isTransmitting);
        
        keyer.handlePaddlePress("right", true);
        assertEquals("Dah should be the last paddle pressed", "-", state.ultimaticLastPaddle);
        
        // Should have called playElement once and queueNextElement
        verify(toneEngine, times(1)).playElement(anyDouble(), anyDouble(), any(), any());
        verify(toneEngine, atLeastOnce()).queueNextElement(eq(240.0), anyDouble(), any(), any(), any());
    }

    @Test
    public void testIambicA_Squeeze_Alternates() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";

        keyer.handlePaddlePress("left", true);
        assertTrue("Should be transmitting after first press", state.isTransmitting);

        keyer.handlePaddlePress("right", true);
        assertTrue("Squeeze should be detected", state.squeezeCurrentlyPressed);

        // Should have called playElement once
        ArgumentCaptor<Runnable> toneEndCaptor = ArgumentCaptor.forClass(Runnable.class);
        verify(toneEngine, times(1)).playElement(anyDouble(), anyDouble(), toneEndCaptor.capture(), any());
        
        toneEndCaptor.getValue().run();

        // Should have queued a dah
        verify(toneEngine, atLeastOnce()).queueNextElement(eq(240.0), anyDouble(), any(), any(), any());
    }

    @Test
    public void testBug_LeftPaddle_StartsDits() {
        settings.mode = "bug";
        settings.polarity = "normal";

        keyer.handlePaddlePress("left", true);
        assertTrue(state.isTransmitting);
        verify(toneEngine, times(1)).playElement(eq(80.0), anyDouble(), any(), any());
    }

    @Test
    public void testBug_RightPaddle_StartsContinuousTone() {
        settings.mode = "bug";
        settings.polarity = "normal";

        keyer.handlePaddlePress("right", true);
        assertTrue(state.bugKeyActive);
        verify(toneEngine, times(1)).setToneActive(true);
    }

    @Test
    public void testBug_DitToKeyTransition() {
        settings.mode = "bug";
        settings.polarity = "normal";

        keyer.handlePaddlePress("left", true);
        keyer.handlePaddlePress("right", true);
        
        verify(toneEngine, atLeastOnce()).cancelQueuedElement();
        
        ArgumentCaptor<Runnable> silenceEndCaptor = ArgumentCaptor.forClass(Runnable.class);
        verify(toneEngine).playElement(anyDouble(), anyDouble(), any(), silenceEndCaptor.capture());
        silenceEndCaptor.getValue().run();
        
        assertTrue(state.bugKeyActive);
        verify(toneEngine, atLeastOnce()).setToneActive(true);
    }

    @Test
    public void testCootie_AnyPaddleStartsTone() {
        settings.mode = "cootie";
        
        keyer.handlePaddlePress("left", true);
        assertTrue(state.isTransmitting);
        verify(toneEngine, atLeastOnce()).setToneActive(true);
        
        keyer.handlePaddlePress("left", false);
        assertFalse(state.isTransmitting);
        verify(toneEngine, atLeastOnce()).setToneActive(false);
    }

    @Test
    public void testCootie_SqueezeKeepsTone() {
        settings.mode = "cootie";

        keyer.handlePaddlePress("left", true);
        keyer.handlePaddlePress("right", true);
        assertTrue(state.isTransmitting);
        
        keyer.handlePaddlePress("left", false);
        assertTrue(state.isTransmitting);
        
        keyer.handlePaddlePress("right", false);
        assertFalse(state.isTransmitting);
    }

    @Test
    public void testOneFingerGatedOnlyToIambicAAndB() {
        String[] allModes = {"straight", "iambic-a", "iambic-b", "iambic-a-one-finger", "iambic-b-one-finger", "ultimatic", "bug", "cootie"};
        MorseSettings settings = new MorseSettings();
        for (String mode : allModes) {
            settings.mode = mode;
            if ("iambic-a-one-finger".equals(mode) || "iambic-b-one-finger".equals(mode)) {
                assertTrue("One-finger should be active in " + mode, settings.isOneFinger());
                assertTrue("Mode should be recognized as iambic in " + mode, settings.isIambic());
            } else {
                assertFalse("One-finger must NOT be active in " + mode, settings.isOneFinger());
            }
        }
    }

    @Test
    public void testIambicOneFingerModesKeyerLogic() {
        MorseSettings settings = new MorseSettings();
        settings.mode = "iambic-a-one-finger";
        assertTrue(settings.isIambic());
        assertTrue(settings.isIambicA());
        assertFalse(settings.isIambicB());
        assertTrue(settings.isOneFinger());

        settings.mode = "iambic-b-one-finger";
        assertTrue(settings.isIambic());
        assertFalse(settings.isIambicA());
        assertTrue(settings.isIambicB());
        assertTrue(settings.isOneFinger());
    }
}
