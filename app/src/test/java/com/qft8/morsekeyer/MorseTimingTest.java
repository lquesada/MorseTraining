package com.qft8.morsekeyer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MorseTimingTest {

    private MorseSettings settings;
    private MorseState state;
    private ToneEngine toneEngine;
    private MorseKeyer keyer;

    @Before
    public void setUp() {
        settings = new MorseSettings();
        state = new MorseState();
        toneEngine = new ToneEngine();
        keyer = new MorseKeyer(settings, state, toneEngine, null);
    }

    @Test
    public void testStrictTiming_15WPM() {
        settings.wpm = 15;
        settings.strict = true;
        
        double dit = 1200.0 / 15; // 80.0 ms
        double[] timings = keyer.getRecognitionTimings();
        
        assertEquals("Dit should be 80ms", 80.0, timings[0], 0.001);
        assertEquals("Dah should be 240ms", 240.0, timings[1], 0.001);
        assertEquals("Letter gap should be 240ms (3 dits)", 240.0, timings[3], 0.001);
        assertEquals("Word gap should be 560ms (7 dits)", 560.0, timings[4], 0.001);
    }

    @Test
    public void test100PercentSpacingEqualsStrict_15WPM() {
        settings.wpm = 15;
        
        // Strict mode values
        settings.strict = true;
        double[] strictTimings = keyer.getRecognitionTimings();
        
        // Non-strict at 100% values
        settings.strict = false;
        settings.interletterSpacing = 100;
        settings.interwordSpacing = 100;
        double[] nonStrictTimings = keyer.getRecognitionTimings();
        
        assertArrayEquals("Strict and 100% timings should be identical", 
            strictTimings, nonStrictTimings, 0.001);
    }

    @Test
    public void testStrictTiming_20WPM() {
        settings.wpm = 20;
        settings.strict = true;
        
        double dit = 1200.0 / 20; // 60.0 ms
        double[] timings = keyer.getRecognitionTimings();
        
        assertEquals("Dit should be 60ms", 60.0, timings[0], 0.001);
        assertEquals("Letter gap should be 180ms", 180.0, timings[3], 0.001);
        assertEquals("Word gap should be 420ms", 420.0, timings[4], 0.001);
    }

    @Test
    public void testCustomSpacing_15WPM() {
        settings.wpm = 15; // dit = 80ms
        settings.strict = false;
        settings.interletterSpacing = 150; // 1.5 * 3 = 4.5 dits = 360ms
        settings.interwordSpacing = 150;   // 1.5 * 7 = 10.5 dits = 840ms
        
        double[] timings = keyer.getRecognitionTimings();
        
        assertEquals("Letter gap should be 360ms", 360.0, timings[3], 0.001);
        assertEquals("Word gap should be 840ms", 840.0, timings[4], 0.001);
    }

    @Test
    public void testSafetyFloors_VeryFast() {
        settings.wpm = 60; // dit = 20ms
        settings.strict = false;
        settings.interletterSpacing = 10;
        settings.interwordSpacing = 10;
        
        double[] timings = keyer.getRecognitionTimings();
        
        assertEquals("Letter gap should be 24ms (floor 1.2 * dit)", 24.0, timings[3], 0.001);
        assertEquals("Word gap should be 34ms (floor letter + 0.5 * dit)", 34.0, timings[4], 0.001);
    }
}
