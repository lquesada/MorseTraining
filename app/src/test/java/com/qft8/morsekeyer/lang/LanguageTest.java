package com.qft8.morsekeyer.lang;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LanguageTest {

    @Test
    public void testLanguageSynchronization() throws Exception {
        // 1. Get all valid keys from MorseLanguage
        Set<String> validKeys = new HashSet<>();
        for (Field field : MorseLanguage.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers()) && field.getType() == String.class) {
                validKeys.add((String) field.get(null));
            }
        }
        
        // 2. Get all language instances from LanguageManager
        Field languagesField = LanguageManager.class.getDeclaredField("LANGUAGES");
        languagesField.setAccessible(true);
        Map<String, MorseLanguage> languages = (Map<String, MorseLanguage>) languagesField.get(null);
        
        Field stringsField = MorseLanguage.class.getDeclaredField("strings");
        stringsField.setAccessible(true);
        
        boolean hasError = false;
        StringBuilder errorMsg = new StringBuilder();
        
        for (Map.Entry<String, MorseLanguage> entry : languages.entrySet()) {
            String langCode = entry.getKey();
            MorseLanguage langInstance = entry.getValue();
            
            Map<String, String> strings = (Map<String, String>) stringsField.get(langInstance);
            
            Set<String> langKeys = new HashSet<>(strings.keySet());
            
            // Check for missing keys
            Set<String> missing = new HashSet<>(validKeys);
            missing.removeAll(langKeys);
            if (!missing.isEmpty()) {
                hasError = true;
                errorMsg.append("Language [").append(langCode).append("] (").append(langInstance.getClass().getSimpleName())
                        .append(") is missing keys: ").append(missing).append("\n");
            }
            
            // Check for extra keys
            Set<String> extra = new HashSet<>(langKeys);
            extra.removeAll(validKeys);
            if (!extra.isEmpty()) {
                hasError = true;
                errorMsg.append("Language [").append(langCode).append("] (").append(langInstance.getClass().getSimpleName())
                        .append(") has extra keys that shouldn't exist: ").append(extra).append("\n");
            }
        }
        
        if (hasError) {
            fail("Language synchronization errors found:\n" + errorMsg.toString());
        }
    }

    @Test
    public void testWindlereyeSupportLink() throws Exception {
        // Ensure static initialization
        LanguageManager.getAvailableLanguages();
        
        Field languagesField = LanguageManager.class.getDeclaredField("LANGUAGES");
        languagesField.setAccessible(true);
        Map<String, MorseLanguage> languages = (Map<String, MorseLanguage>) languagesField.get(null);
        
        Field stringsField = MorseLanguage.class.getDeclaredField("strings");
        stringsField.setAccessible(true);
        
        boolean hasError = false;
        StringBuilder errorMsg = new StringBuilder();
        
        for (Map.Entry<String, MorseLanguage> entry : languages.entrySet()) {
            String langCode = entry.getKey();
            MorseLanguage langInstance = entry.getValue();
            
            Map<String, String> strings = (Map<String, String>) stringsField.get(langInstance);
            
            String windlereyeStr = strings.get(MorseLanguage.SUPPORT_WINDLEREYE);
            if (windlereyeStr != null && !windlereyeStr.contains("Windlereye")) {
                hasError = true;
                errorMsg.append("Language [").append(langCode).append("] does not contain 'Windlereye' in SUPPORT_WINDLEREYE string: ").append(windlereyeStr).append("\n");
            } else if (windlereyeStr == null) {
                hasError = true;
                errorMsg.append("Language [").append(langCode).append("] is missing SUPPORT_WINDLEREYE string entirely.\n");
            }
        }
        
        if (hasError) {
            fail("Windlereye string errors found:\n" + errorMsg.toString());
        }
    }

    @Test
    public void testNoCheatingWithEnglishTranslations() throws Exception {
        LanguageManager.getAvailableLanguages();
        
        Field languagesField = LanguageManager.class.getDeclaredField("LANGUAGES");
        languagesField.setAccessible(true);
        Map<String, MorseLanguage> languages = (Map<String, MorseLanguage>) languagesField.get(null);
        
        Field stringsField = MorseLanguage.class.getDeclaredField("strings");
        stringsField.setAccessible(true);
        
        MorseLanguage langEn = languages.get("en");
        Map<String, String> stringsEn = (Map<String, String>) stringsField.get(langEn);
        
        boolean hasError = false;
        StringBuilder errorMsg = new StringBuilder();
        
        for (Map.Entry<String, MorseLanguage> entry : languages.entrySet()) {
            String langCode = entry.getKey();
            if ("en".equals(langCode) || "pcm".equals(langCode)) {
                continue;
            }
            
            MorseLanguage langInstance = entry.getValue();
            Map<String, String> strings = (Map<String, String>) stringsField.get(langInstance);
            
            for (Map.Entry<String, String> strEntry : strings.entrySet()) {
                String key = strEntry.getKey();
                String val = strEntry.getValue();
                String enVal = stringsEn.get(key);
                
                if (val != null && val.equals(enVal)) {
                    if (val.matches(".*\\d.*") || val.contains("Koch") || val.equals("Windlereye") || val.contains("100%")) {
                        continue;
                    }
                    if (key.equals("INFO_TITLE") || key.startsWith("MODE_") || key.equals("WPM") || key.equals("SPACING") || key.equals("AUDIO_BUFFER") || key.equals("CAT_QCODES")) {
                        continue;
                    }
                    if (key.equals("VOLUME") || key.equals("TARGET") || key.equals("RESET") || key.equals("START") || key.startsWith("COLOR_") || key.equals("BACK") || key.equals("NEXT_LEVEL") || key.equals("TRY_AGAIN") || key.equals("REPEAT") || key.equals("CONTINUE") || key.equals("KOCH_METHOD") || key.equals("LEVEL") || key.equals("SCORE")) {
                        continue;
                    }
                    hasError = true;
                    errorMsg.append("Language [").append(langCode).append("] cheated on key ").append(key).append(" with value: ").append(val).append("\n");
                }
            }
        }
        
        if (hasError) {
            fail("Cheating detected - identical to English strings found:\n" + errorMsg.toString());
        }
    }
}
