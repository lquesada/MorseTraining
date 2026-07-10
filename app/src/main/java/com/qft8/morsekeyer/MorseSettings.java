package com.qft8.morsekeyer;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Settings persistence via SharedPreferences.
 * Exact same defaults as index.html loadSettings().
 */
public class MorseSettings {

    private static final String PREFS_NAME = "morseKeyerSettings";

    public String mode = "iambic-a";
    public String toneType = "triangle";
    public int wpm = 15;
    public int vol = 40;
    public int tone = 600;
    public String polarity = "normal";
    public boolean strict = true;
    public boolean visual = false;
    public boolean showTable = true;
    public boolean showTableCodes = true;
    public boolean showPaddles = true;
    public int interletterSpacing = 100;
    public int interwordSpacing = 100;
    public boolean showNextWordIndicator = true;
    public String letterColor = "green";
    public int fontSize = 35;
    public String appTheme = "dark";
    public float bufferMs = 25.0f;
    public float envelopeMs = 0.75f;
    public float chunkMs = 4.0f;
    public int tableFontSizeDelta = 0;
    public int tableRatio = 50;
    public boolean keepAlive = true;
    public boolean whiteNoise = false;
    public float whiteNoiseVolume = 5.0f;
    public int whiteNoiseFrequency = 500;
    public boolean keepScreenOn = false;
    public String language = "system";
    public String keyboardType = "QWERTY";
    public boolean pickLangThemeOnShare = false;
    public int effectiveWpm = 15;
    public int extraWordSpacing = 0;
    public int wordSpacing = 100;

    public Map<String, String> decoderChoices = new HashMap<>();

    private String getStringSafe(SharedPreferences prefs, String key, String defValue) {
        try {
            return prefs.getString(key, defValue);
        } catch (ClassCastException e) {
            prefs.edit().remove(key).apply();
            return defValue;
        }
    }

    private int getIntSafe(SharedPreferences prefs, String key, int defValue) {
        try {
            return prefs.getInt(key, defValue);
        } catch (ClassCastException e) {
            prefs.edit().remove(key).apply();
            return defValue;
        }
    }

    private boolean getBooleanSafe(SharedPreferences prefs, String key, boolean defValue) {
        try {
            return prefs.getBoolean(key, defValue);
        } catch (ClassCastException e) {
            prefs.edit().remove(key).apply();
            return defValue;
        }
    }

    private float getFloatSafe(SharedPreferences prefs, String key, float defValue) {
        try {
            return prefs.getFloat(key, defValue);
        } catch (ClassCastException e) {
            prefs.edit().remove(key).apply();
            return defValue;
        }
    }

    public void load(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean needsSave = false;
        mode = getStringSafe(prefs, "mode", "iambic-a");
        toneType = getStringSafe(prefs, "toneType", "triangle");
        wpm = getIntSafe(prefs, "wpm", 15);
        vol = getIntSafe(prefs, "vol", 40);
        tone = getIntSafe(prefs, "tone", 600);
        polarity = getStringSafe(prefs, "polarity", "normal");
        strict = getBooleanSafe(prefs, "strict", true);
        visual = getBooleanSafe(prefs, "visual", false);
        showTable = getBooleanSafe(prefs, "showTable", true);
        showTableCodes = getBooleanSafe(prefs, "showTableCodes", true);
        showPaddles = getBooleanSafe(prefs, "showPaddles", true);
        interletterSpacing = getIntSafe(prefs, "interletterSpacing", 100);
        interwordSpacing = getIntSafe(prefs, "interwordSpacing", 100);
        showNextWordIndicator = getBooleanSafe(prefs, "showNextWordIndicator", true);
        letterColor = getStringSafe(prefs, "letterColor", "green");
        fontSize = getIntSafe(prefs, "fontSize", 35);
        if (fontSize < 13) {
            fontSize = 13;
            needsSave = true;
        }
        appTheme = getStringSafe(prefs, "appTheme", "dark");
        
        if ("system".equals(appTheme) || "white".equals(appTheme)) {
            appTheme = "dark";
            needsSave = true;
        }
        
        bufferMs = getFloatSafe(prefs, "bufferMs", 25.0f);
        envelopeMs = getFloatSafe(prefs, "envelopeMs", 0.75f);
        chunkMs = getFloatSafe(prefs, "chunkMs", 4.0f);
        tableFontSizeDelta = getIntSafe(prefs, "tableFontSizeDelta", 0);
        tableRatio = getIntSafe(prefs, "tableRatio", 50);
        keepAlive = getBooleanSafe(prefs, "keepAlive", true);
        whiteNoise = getBooleanSafe(prefs, "whiteNoise", false);
        whiteNoiseVolume = getFloatSafe(prefs, "whiteNoiseVolume", 5.0f);
        whiteNoiseFrequency = getIntSafe(prefs, "whiteNoiseFrequency", 500);
        keepScreenOn = getBooleanSafe(prefs, "keepScreenOn", false);
        language = getStringSafe(prefs, "language", "system");
        
        boolean kbNeedsSave = false;
        if (!prefs.contains("keyboardType")) {
            keyboardType = guessKeyboardType(language);
            needsSave = true;
        } else {
            keyboardType = getStringSafe(prefs, "keyboardType", "QWERTY");
        }
        
        pickLangThemeOnShare = getBooleanSafe(prefs, "pickLangThemeOnShare", false);
        
        if (!prefs.contains("effectiveWpm")) {
            effectiveWpm = Math.min(wpm, Math.max(3, (int) Math.round(100.0 * wpm / interletterSpacing)));
            needsSave = true;
        } else {
            effectiveWpm = getIntSafe(prefs, "effectiveWpm", wpm);
        }
        
        if (!prefs.contains("extraWordSpacing")) {
            extraWordSpacing = Math.min(2000, Math.max(0, (int) Math.round((84.0 * interwordSpacing / wpm) - (8400.0 / effectiveWpm))));
            needsSave = true;
        } else {
            extraWordSpacing = getIntSafe(prefs, "extraWordSpacing", 0);
        }
        wordSpacing = getIntSafe(prefs, "wordSpacing", 100);
        updateDerivedSpacingSettings();

        String choicesStr = getStringSafe(prefs, "decoderChoices", "{}");
        decoderChoices.clear();
        try {
            JSONObject obj = new JSONObject(choicesStr);
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()) {
                String k = keys.next();
                decoderChoices.put(k, obj.getString(k));
            }
        } catch (Exception e) {}
        
        if (needsSave) {
            save(ctx);
        }
    }

    public void save(Context ctx) {
        updateDerivedSpacingSettings();
        SharedPreferences prefs = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit()
            .putString("mode", mode)
            .putString("toneType", toneType)
            .putInt("wpm", wpm)
            .putInt("vol", vol)
            .putInt("tone", tone)
            .putString("polarity", polarity)
            .putBoolean("strict", strict)
            .putBoolean("visual", visual)
            .putBoolean("showTable", showTable)
            .putBoolean("showTableCodes", showTableCodes)
            .putBoolean("showPaddles", showPaddles)
            .putInt("interletterSpacing", interletterSpacing)
            .putInt("interwordSpacing", interwordSpacing)
            .putBoolean("showNextWordIndicator", showNextWordIndicator)
            .putString("letterColor", letterColor)
            .putInt("fontSize", fontSize)
            .putString("appTheme", appTheme)
            .putFloat("bufferMs", bufferMs)
            .putFloat("envelopeMs", envelopeMs)
            .putFloat("chunkMs", chunkMs)
            .putInt("tableFontSizeDelta", tableFontSizeDelta)
            .putInt("tableRatio", tableRatio)
            .putBoolean("keepAlive", keepAlive)
            .putBoolean("whiteNoise", whiteNoise)
            .putFloat("whiteNoiseVolume", whiteNoiseVolume)
            .putInt("whiteNoiseFrequency", whiteNoiseFrequency)
            .putBoolean("keepScreenOn", keepScreenOn)
            .putString("language", language)
            .putString("keyboardType", keyboardType)
            .putBoolean("pickLangThemeOnShare", pickLangThemeOnShare)
            .putInt("effectiveWpm", effectiveWpm)
            .putInt("extraWordSpacing", extraWordSpacing)
            .putInt("wordSpacing", wordSpacing);

        String choicesStr = "{}";
        try {
            JSONObject obj = new JSONObject();
            for (Map.Entry<String, String> entry : decoderChoices.entrySet()) {
                obj.put(entry.getKey(), entry.getValue());
            }
            choicesStr = obj.toString();
        } catch (Exception e) {}
        
        editor.putString("decoderChoices", choicesStr)
            .apply();
    }

    public void resetToDefaults() {
        mode = "iambic-a";
        toneType = "triangle";
        wpm = 15;
        vol = 40;
        tone = 600;
        polarity = "normal";
        strict = true;
        visual = false;
        showTable = true;
        showTableCodes = true;
        showPaddles = true;
        interletterSpacing = 100;
        interwordSpacing = 100;
        showNextWordIndicator = true;
        letterColor = "green";
        fontSize = 35;
        appTheme = "dark";
        bufferMs = 25.0f;
        envelopeMs = 0.75f;
        chunkMs = 4.0f;
        tableFontSizeDelta = 0;
        tableRatio = 50;
        keepAlive = true;
        whiteNoise = false;
        whiteNoiseVolume = 5.0f;
        whiteNoiseFrequency = 500;
        keepScreenOn = false;
        language = "system";
        keyboardType = guessKeyboardType(language);
        pickLangThemeOnShare = false;
        effectiveWpm = 15;
        extraWordSpacing = 0;
        wordSpacing = 100;
        decoderChoices.clear();
    }

    public void updateDerivedSpacingSettings() {
        if (strict) {
            interletterSpacing = 100;
            interwordSpacing = 100;
            return;
        }
        if (effectiveWpm > 60) {
            effectiveWpm = 60;
        }
        if (effectiveWpm < 3) {
            effectiveWpm = 3;
        }
        if (wordSpacing > 250) {
            wordSpacing = 250;
        }
        if (wordSpacing < 25) {
            wordSpacing = 25;
        }

        int eff = effectiveWpm;
        int maxEff = (int) Math.floor(wpm * 2.0);
        if (maxEff < 3) {
            maxEff = 3;
        }
        if (eff > maxEff) {
            eff = maxEff;
        }

        interletterSpacing = (int) Math.round(100.0 * wpm / eff);
        interwordSpacing = (int) Math.round((wpm * wordSpacing) / (double) eff);
    }

    private String guessKeyboardType(String langSetting) {
        String langCode = langSetting;
        if ("system".equals(langSetting) || langSetting == null) {
            langCode = java.util.Locale.getDefault().getLanguage();
        }
        if (langCode != null) {
            langCode = langCode.toLowerCase();
            if (langCode.equals("de") || langCode.equals("cs") || langCode.equals("sk") ||
                langCode.equals("hu") || langCode.equals("ro") || langCode.equals("hr") ||
                langCode.equals("sr") || langCode.equals("sl") || langCode.equals("bs")) {
                return "QWERTZ";
            } else if (langCode.equals("fr") || langCode.equals("wa")) {
                return "AZERTY";
            }
        }
        return "QWERTY";
    }
}
