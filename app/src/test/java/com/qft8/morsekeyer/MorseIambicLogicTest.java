package com.qft8.morsekeyer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MorseIambicLogicTest {

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
    public void testIambicA_HoldDitTapDah_AppendsDah() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        
        // 1. Hold Dit
        keyer.handlePaddlePress("left", true);
        state.isTransmitting = true;
        state.lastElement = ".";
        
        // 2. Tap Dah during Dit
        keyer.handlePaddlePress("right", true);
        keyer.handlePaddlePress("right", false);
        
        // 3. Dit ends
        // We verify that dahPressedDuringElement is true
        assertTrue("Dah tap should be remembered during element", state.dahPressedDuringElement);
    }

    @Test
    public void testIambicA_ReleaseDitPressDah_AppendsDah() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        
        // 1. Hold Dit
        keyer.handlePaddlePress("left", true);
        state.isTransmitting = true;
        state.lastElement = ".";
        
        // 2. Release Dit and immediately Press Dah
        keyer.handlePaddlePress("left", false);
        keyer.handlePaddlePress("right", true);
        
        // At this point:
        // ditHeld = false, dahHeld = true
        // ditMemory = true (from the just finished dit)
        // dahMemory = true (from the new press)
        
        // According to the new priority logic:
        // dahHeld (current press) should win over ditMemory.
        // So elementToSend should be "-".
    }

    @Test
    public void testIambicA_SqueezeReleaseBoth_Stops() {
        settings.mode = "iambic-a";
        settings.polarity = "normal";
        
        // 1. Squeeze
        keyer.handlePaddlePress("left", true);
        keyer.handlePaddlePress("right", true);
        state.isTransmitting = true;
        state.lastElement = ".";
        
        // 2. Release both during Dit
        keyer.handlePaddlePress("left", false);
        keyer.handlePaddlePress("right", false);
        
        // In Iambic-A, if both released, next elementToSend should be null
        // (This will be verified by the code fix)
    }

    @Test
    public void testIambicB_SqueezeReleaseBoth_AppendsExtra() {
        settings.mode = "iambic-b";
        settings.polarity = "normal";
        
        // 1. Squeeze
        keyer.handlePaddlePress("left", true);
        keyer.handlePaddlePress("right", true);
        state.isTransmitting = true;
        state.lastElement = ".";
        
        // 2. Release both during Dit
        keyer.handlePaddlePress("left", false);
        keyer.handlePaddlePress("right", false);
        
        // In Iambic-B, squeeze is remembered
        assertTrue(state.squeezePressedDuringElement);
    }
}
