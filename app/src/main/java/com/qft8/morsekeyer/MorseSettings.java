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
    public int interwordSpacing = 75;
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
    public boolean keepScreenOn = false;
    public String language = "system";
    public String keyboardType = "QWERTY";
    public boolean pickLangThemeOnShare = false;

    public Map<String, String> decoderChoices = new HashMap<>();

    public void load(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        mode = prefs.getString("mode", "iambic-a");
        toneType = prefs.getString("toneType", "triangle");
        wpm = prefs.getInt("wpm", 15);
        vol = prefs.getInt("vol", 40);
        tone = prefs.getInt("tone", 600);
        polarity = prefs.getString("polarity", "normal");
        strict = prefs.getBoolean("strict", true);
        visual = prefs.getBoolean("visual", false);
        showTable = prefs.getBoolean("showTable", true);
        showTableCodes = prefs.getBoolean("showTableCodes", true);
        showPaddles = prefs.getBoolean("showPaddles", true);
        interletterSpacing = prefs.getInt("interletterSpacing", 100);
        interwordSpacing = prefs.getInt("interwordSpacing", 75);
        showNextWordIndicator = prefs.getBoolean("showNextWordIndicator", true);
        letterColor = prefs.getString("letterColor", "green");
        fontSize = prefs.getInt("fontSize", 35);
        appTheme = prefs.getString("appTheme", "dark");
        
        boolean needsSave = false;
        if ("system".equals(appTheme) || "white".equals(appTheme)) {
            appTheme = "dark";
            needsSave = true;
        }
        
        bufferMs = prefs.getFloat("bufferMs", 25.0f);
        envelopeMs = prefs.getFloat("envelopeMs", 0.75f);
        chunkMs = prefs.getFloat("chunkMs", 4.0f);
        tableFontSizeDelta = prefs.getInt("tableFontSizeDelta", 0);
        tableRatio = prefs.getInt("tableRatio", 50);
        keepAlive = prefs.getBoolean("keepAlive", true);
        keepScreenOn = prefs.getBoolean("keepScreenOn", false);
        language = prefs.getString("language", "system");
        
        boolean kbNeedsSave = false;
        if (!prefs.contains("keyboardType")) {
            keyboardType = guessKeyboardType(language);
            needsSave = true;
        } else {
            keyboardType = prefs.getString("keyboardType", "QWERTY");
        }
        
        pickLangThemeOnShare = prefs.getBoolean("pickLangThemeOnShare", false);

        String choicesStr = prefs.getString("decoderChoices", "{}");
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
            .putBoolean("keepScreenOn", keepScreenOn)
            .putString("language", language)
            .putString("keyboardType", keyboardType)
            .putBoolean("pickLangThemeOnShare", pickLangThemeOnShare);

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
        interwordSpacing = 75;
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
        keepScreenOn = false;
        language = "system";
        keyboardType = guessKeyboardType(language);
        pickLangThemeOnShare = false;
        decoderChoices.clear();
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
