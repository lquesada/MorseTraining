package com.qft8.morsekeyer.lang;

import java.lang.reflect.Field;
import java.util.Map;

public class TestCheat {
    public static void main(String[] args) throws Exception {
        LanguageManager.getAvailableLanguages();
        
        Field languagesField = LanguageManager.class.getDeclaredField("LANGUAGES");
        languagesField.setAccessible(true);
        Map<String, MorseLanguage> languages = (Map<String, MorseLanguage>) languagesField.get(null);
        
        Field stringsField = MorseLanguage.class.getDeclaredField("strings");
        stringsField.setAccessible(true);
        
        MorseLanguage langEn = languages.get("en");
        Map<String, String> stringsEn = (Map<String, String>) stringsField.get(langEn);
        
        for (Map.Entry<String, MorseLanguage> entry : languages.entrySet()) {
            String langCode = entry.getKey();
            if ("en".equals(langCode) || "pcm".equals(langCode)) continue;
            
            MorseLanguage langInstance = entry.getValue();
            Map<String, String> strings = (Map<String, String>) stringsField.get(langInstance);
            
            for (Map.Entry<String, String> strEntry : strings.entrySet()) {
                String key = strEntry.getKey();
                String val = strEntry.getValue();
                String enVal = stringsEn.get(key);
                
                if (val != null && val.equals(enVal)) {
                    if (val.matches(".*\\d.*") || val.contains("Koch") || val.equals("Windlereye") || val.contains("100%")) continue;
                    if (key.equals("INFO_TITLE") || key.startsWith("MODE_") || key.equals("WPM") || key.equals("SPACING") || key.equals("AUDIO_BUFFER") || key.equals("CAT_QCODES")) continue;
                    if (key.equals("VOLUME") || key.equals("TARGET") || key.equals("RESET") || key.equals("START") || key.startsWith("COLOR_") || key.equals("BACK") || key.equals("NEXT_LEVEL") || key.equals("TRY_AGAIN") || key.equals("REPEAT") || key.equals("CONTINUE") || key.equals("KOCH_METHOD")) continue;
                    
                    System.out.println("Cheated: [" + langCode + "] key=" + key + " val=" + val);
                }
            }
        }
    }
}
