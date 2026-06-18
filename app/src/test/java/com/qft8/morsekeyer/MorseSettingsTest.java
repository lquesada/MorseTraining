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

    @Test
    public void testDefaultFontSize() {
        MorseSettings settings = new MorseSettings();
        assertEquals(35, settings.fontSize);
    }

    @Test
    public void testFontSizeRecoveryOnLoad() {
        android.content.Context mockContext = org.mockito.Mockito.mock(android.content.Context.class);
        android.content.SharedPreferences mockPrefs = org.mockito.Mockito.mock(android.content.SharedPreferences.class);
        android.content.SharedPreferences.Editor mockEditor = org.mockito.Mockito.mock(android.content.SharedPreferences.Editor.class);

        org.mockito.Mockito.when(mockContext.getSharedPreferences(org.mockito.Mockito.anyString(), org.mockito.Mockito.anyInt()))
                .thenReturn(mockPrefs);

        // Stub SharedPreferences to return the default value (second arg) by default
        org.mockito.Mockito.when(mockPrefs.getString(org.mockito.Mockito.any(), org.mockito.Mockito.any()))
                .thenAnswer(invocation -> invocation.getArgument(1));
        org.mockito.Mockito.when(mockPrefs.getInt(org.mockito.Mockito.any(), org.mockito.Mockito.anyInt()))
                .thenAnswer(invocation -> invocation.getArgument(1));
        org.mockito.Mockito.when(mockPrefs.getBoolean(org.mockito.Mockito.any(), org.mockito.Mockito.anyBoolean()))
                .thenAnswer(invocation -> invocation.getArgument(1));
        org.mockito.Mockito.when(mockPrefs.getFloat(org.mockito.Mockito.any(), org.mockito.Mockito.anyFloat()))
                .thenAnswer(invocation -> invocation.getArgument(1));

        // Specifically return 10 for fontSize
        org.mockito.Mockito.when(mockPrefs.getInt(org.mockito.Mockito.eq("fontSize"), org.mockito.Mockito.anyInt()))
                .thenReturn(10);

        // Stub Editor to return itself for chaining
        org.mockito.Mockito.when(mockPrefs.edit()).thenReturn(mockEditor);
        org.mockito.Mockito.when(mockEditor.putString(org.mockito.Mockito.any(), org.mockito.Mockito.any())).thenReturn(mockEditor);
        org.mockito.Mockito.when(mockEditor.putInt(org.mockito.Mockito.any(), org.mockito.Mockito.anyInt())).thenReturn(mockEditor);
        org.mockito.Mockito.when(mockEditor.putBoolean(org.mockito.Mockito.any(), org.mockito.Mockito.anyBoolean())).thenReturn(mockEditor);
        org.mockito.Mockito.when(mockEditor.putFloat(org.mockito.Mockito.any(), org.mockito.Mockito.anyFloat())).thenReturn(mockEditor);

        MorseSettings settings = new MorseSettings();
        settings.load(mockContext);

        assertEquals(13, settings.fontSize); // Should recover to 13
        org.mockito.Mockito.verify(mockEditor).putInt("fontSize", 13); // Should save the corrected value
    }
}
