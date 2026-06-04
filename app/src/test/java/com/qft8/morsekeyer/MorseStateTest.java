package com.qft8.morsekeyer;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for MorseState: verifies all initial state values match the JS
 * morseState and paddleState objects.
 */
public class MorseStateTest {

    @Test
    public void testInitialMorseState() {
        MorseState state = new MorseState();
        assertEquals("", state.currentCode);
        assertEquals(0.0, state.lastElementTime, 0.001);
        assertFalse(state.isTransmitting);
        assertEquals("", state.lastElement);
        assertEquals(0.0, state.elementStartTime, 0.001);
        assertFalse(state.iambicScheduled);
    }

    @Test
    public void testInitialPaddleState() {
        MorseState state = new MorseState();
        assertFalse(state.ditCurrentlyPressed);
        assertFalse(state.dahCurrentlyPressed);
        assertFalse(state.ditPressedDuringElement);
        assertFalse(state.dahPressedDuringElement);
        assertFalse(state.squeezeCurrentlyPressed);
        assertFalse(state.squeezePressedDuringElement);
    }

    @Test
    public void testFieldsMutableForDit() {
        MorseState state = new MorseState();
        state.ditCurrentlyPressed = true;
        state.ditPressedDuringElement = true;
        assertTrue(state.ditCurrentlyPressed);
        assertTrue(state.ditPressedDuringElement);
    }

    @Test
    public void testFieldsMutableForDah() {
        MorseState state = new MorseState();
        state.dahCurrentlyPressed = true;
        state.dahPressedDuringElement = true;
        assertTrue(state.dahCurrentlyPressed);
        assertTrue(state.dahPressedDuringElement);
    }

    @Test
    public void testFieldsMutableForSqueeze() {
        MorseState state = new MorseState();
        state.squeezeCurrentlyPressed = true;
        state.squeezePressedDuringElement = true;
        assertTrue(state.squeezeCurrentlyPressed);
        assertTrue(state.squeezePressedDuringElement);
    }

    @Test
    public void testFieldsMutableForTransmission() {
        MorseState state = new MorseState();
        state.isTransmitting = true;
        state.iambicScheduled = true;
        state.currentCode = ".-";
        state.lastElement = ".";
        state.lastElementTime = 12345.0;
        state.elementStartTime = 12340.0;

        assertTrue(state.isTransmitting);
        assertTrue(state.iambicScheduled);
        assertEquals(".-", state.currentCode);
        assertEquals(".", state.lastElement);
        assertEquals(12345.0, state.lastElementTime, 0.001);
        assertEquals(12340.0, state.elementStartTime, 0.001);
    }
}
