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
}
