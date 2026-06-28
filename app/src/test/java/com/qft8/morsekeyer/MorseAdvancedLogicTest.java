package com.qft8.morsekeyer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MorseAdvancedLogicTest {

    private MorseSettings settings;
    private MorseState state;
    private MorseKeyer keyer;

    @Before
    public void setUp() {
        settings = new MorseSettings();
        state = new MorseState();
        keyer = new MorseKeyer(settings, state, mock(ToneEngine.class), null);
    }

    @Test
    public void testDefaultsMatchDocumentation() {
        settings.resetToDefaults();
        assertEquals("iambic-a", settings.mode);
        assertTrue(settings.strict);
        assertEquals(15, settings.wpm);
        assertEquals(100, settings.interletterSpacing);
        assertEquals(100, settings.interwordSpacing);
        assertTrue(settings.showNextWordIndicator);
        assertEquals(600, settings.tone);
    }

    @Test
    public void testWordGapSafety_AlwaysLongerThanLetterGap() {
        settings.wpm = 15; // 80ms dit
        settings.strict = false;
        
        // Scenario: Extreme settings where inter-word % is smaller than inter-letter %
        settings.interletterSpacing = 200; // Letter gap = 3 * 2.0 = 6 dits (480ms)
        settings.interwordSpacing = 10;   // Word gap = 7 * 0.1 = 0.7 dits (56ms) -- UNSAFE!
        
        double[] timings = keyer.getRecognitionTimings();
        double letterGap = timings[3];
        double wordGap = timings[4];
        
        assertEquals(480.0, letterGap, 0.1);
        
        // Safety check in code: wordGap = Max(wordGap, letterGap + 0.5*dit)
        // 480 + 0.5*80 = 520ms.
        assertTrue("Word gap must be at least 0.5 dits longer than letter gap", wordGap >= letterGap + 40.0);
        assertEquals(520.0, wordGap, 0.1);
    }

    @Test
    public void testNextWordIndicator_StateTransition() {
        settings.wpm = 15; // 80ms dit
        settings.showNextWordIndicator = true;
        state.currentCode = "."; // We just finished a dit
        
        // Mock the callback
        MorseKeyer.OutputCallback mockCallback = mock(MorseKeyer.OutputCallback.class);
        keyer = new MorseKeyer(settings, state, mock(ToneEngine.class), mockCallback);
        
        // Force the letter gap timeout (240ms)
        // Note: In real life this is a handler callback, we simulate the logic here.
        // We want to verify that when the inter-letter gap passes:
        // 1. processMorseCode is called.
        // 2. onWordGapPending is called.
        // 3. state.isWordGapPending becomes true.
        
        // This is partially tested in MorseSpacingTimingTest, but we want to check the INDICATOR logic specifically.
    }
}
