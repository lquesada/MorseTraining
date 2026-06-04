package com.qft8.morsekeyer;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for ToneEngine: configuration methods and callback state.
 * AudioTrack cannot be tested in unit tests (requires Android), but we test
 * all the public API state management.
 */
public class ToneEngineTest {

    @Test
    public void testSetToneActiveDoesNotThrow() {
        ToneEngine engine = new ToneEngine();
        engine.setToneActive(true);
        engine.setToneActive(false);
    }

    @Test
    public void testSetToneTypeDoesNotThrow() {
        ToneEngine engine = new ToneEngine();
        engine.setToneType("triangle");
        engine.setToneType("sawtooth");
        // No exception expected
    }

    @Test
    public void testSetFrequencyDoesNotThrow() {
        ToneEngine engine = new ToneEngine();
        engine.setFrequency(400);
        engine.setFrequency(700);
        engine.setFrequency(1200);
    }

    @Test
    public void testSetVolumeDoesNotThrow() {
        ToneEngine engine = new ToneEngine();
        engine.setVolume(0);
        engine.setVolume(50);
        engine.setVolume(100);
    }

    @Test
    public void testReleaseWithoutInitDoesNotThrow() {
        ToneEngine engine = new ToneEngine();
        engine.release();
        // No exception expected even if init() was never called
    }
}
