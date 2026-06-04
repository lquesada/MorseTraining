package com.qft8.morsekeyer;

import com.qft8.morsekeyer.lang.LanguageManager;
import com.qft8.morsekeyer.lang.MorseLanguage;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LanguageTest {

    @Test
    public void testAllLanguagesHaveAllKeys() throws Exception {
        // Get all keys from MorseLanguage
        Set<String> allKeys = new HashSet<>();
        for (Field field : MorseLanguage.class.getFields()) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && field.getType() == String.class) {
                allKeys.add((String) field.get(null));
            }
        }

        // Get LANGUAGES map from LanguageManager
        Field languagesField = LanguageManager.class.getDeclaredField("LANGUAGES");
        languagesField.setAccessible(true);
        Map<String, MorseLanguage> languages = (Map<String, MorseLanguage>) languagesField.get(null);
        
        // Field to access internal strings map in MorseLanguage
        Field stringsField = MorseLanguage.class.getDeclaredField("strings");
        stringsField.setAccessible(true);

        List<String> errors = new ArrayList<>();

        for (Map.Entry<String, MorseLanguage> entry : languages.entrySet()) {
            String langCode = entry.getKey();
            MorseLanguage lang = entry.getValue();
            Map<String, String> langStrings = (Map<String, String>) stringsField.get(lang);

            // Check missing keys
            for (String key : allKeys) {
                if (!langStrings.containsKey(key)) {
                    errors.add("Language [" + langCode + "] is missing key: " + key);
                }
            }

            // Check extra keys
            for (String key : langStrings.keySet()) {
                if (!allKeys.contains(key)) {
                    errors.add("Language [" + langCode + "] has extra key: " + key);
                }
            }
        }

        if (!errors.isEmpty()) {
            StringBuilder sb = new StringBuilder("Localization errors found:\n");
            for (String error : errors) {
                sb.append("- ").append(error).append("\n");
            }
            assertTrue(sb.toString(), errors.isEmpty());
        }
    }
}
