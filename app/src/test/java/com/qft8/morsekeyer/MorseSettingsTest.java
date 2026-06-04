package com.qft8.morsekeyer;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for MorseSettings: verifies all default values match the web app's
 * loadSettings() defaults exactly.
 */
public class MorseSettingsTest {

    @Test
    public void testDefaultMode() {
        MorseSettings settings = new MorseSettings();
        assertEquals("iambic-a", settings.mode);
    }

    @Test
    public void testDefaultToneType() {
        MorseSettings settings = new MorseSettings();
        assertEquals("triangle", settings.toneType);
    }

    @Test
    public void testDefaultWpm() {
        MorseSettings settings = new MorseSettings();
        assertEquals(15, settings.wpm);
    }

    @Test
    public void testDefaultVol() {
        MorseSettings settings = new MorseSettings();
        assertEquals(40, settings.vol);
    }

    @Test
    public void testDefaultTone() {
        MorseSettings settings = new MorseSettings();
        assertEquals(600, settings.tone);
    }

    @Test
    public void testDefaultPolarity() {
        MorseSettings settings = new MorseSettings();
        assertEquals("normal", settings.polarity);
    }

    @Test
    public void testDefaultStrict() {
        MorseSettings settings = new MorseSettings();
        assertTrue(settings.strict);
    }

    @Test
    public void testDefaultVisual() {
        MorseSettings settings = new MorseSettings();
        assertFalse(settings.visual);
    }

    @Test
    public void testDefaultShowTable() {
        MorseSettings settings = new MorseSettings();
        assertTrue(settings.showTable);
    }

    @Test
    public void testDefaultShowPaddles() {
        MorseSettings settings = new MorseSettings();
        assertTrue(settings.showPaddles);
    }

    @Test
    public void testDefaultBufferMs() {
        MorseSettings settings = new MorseSettings();
        assertEquals(25.0f, settings.bufferMs, 0.001f);
    }

    @Test
    public void testDefaultTableFontSizeDelta() {
        MorseSettings settings = new MorseSettings();
        assertEquals(0, settings.tableFontSizeDelta);
    }

    @Test
    public void testDefaultTableRatio() {
        MorseSettings settings = new MorseSettings();
        assertEquals(50, settings.tableRatio);
    }

    @Test
    public void testFieldsAreMutable() {
        MorseSettings settings = new MorseSettings();
        settings.mode = "straight";
        settings.toneType = "sawtooth";
        settings.wpm = 30;
        settings.vol = 80;
        settings.tone = 1000;
        settings.polarity = "inverse";
        settings.strict = true;
        settings.visual = true;
        settings.showTable = false;
        settings.showPaddles = false;
        settings.letterColor = "blue";
        settings.fontSize = 40;
        settings.appTheme = "white";

        assertEquals("straight", settings.mode);
        assertEquals("sawtooth", settings.toneType);
        assertEquals(30, settings.wpm);
        assertEquals(80, settings.vol);
        assertEquals(1000, settings.tone);
        assertEquals("inverse", settings.polarity);
        assertTrue(settings.strict);
        assertTrue(settings.visual);
        assertFalse(settings.showTable);
        assertFalse(settings.showPaddles);
        assertEquals("blue", settings.letterColor);
        assertEquals(40, settings.fontSize);
        assertEquals("white", settings.appTheme);
    }
}
