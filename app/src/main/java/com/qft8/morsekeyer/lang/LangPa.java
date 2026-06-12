package com.qft8.morsekeyer.lang;

public class LangPa extends MorseLanguage {
    public LangPa() {
        set(SAVE, "ਸੰਭਾਲੋ");
        set(RESET_DEFAULTS, "ਡਿਫੌਲਟ ਤੇ ਰੀਸੈਟ ਕਰੋ");
        set(CLOSE, "ਬੰਦ ਕਰੋ");
        
        set(SETTINGS_TITLE, "ਸੈਟਿੰਗਾਂ");
        set(TONE, "ਟੋਨ");
        set(USER_INTERFACE, "ਯੂਜ਼ਰ ਇੰਟਰਫੇਸ");
        set(ADVANCED, "ਐਡਵਾਂਸਡ (ਪ੍ਰਦਰਸ਼ਨ)");
        set(DECODER_BEHAVIOR, "ਡਿਕੋਡਰ ਵਿਵਹਾਰ");

        set(KEY_MODE, "ਕੀ ਮੋਡ");
        set(WPM_SPEED, "ਰਫਤਾਰ (WPM)");
        set(INVERSE_PADDLES, "ਪੈਡਲ ਉਲਟਾ ਕਰੋ");
        set(STRICT_TIMING, "ਸਖਤ ਟਾਈਮਿੰਗ");
        set(INTERLETTER_SPACING, "ਅੱਖਰਾਂ ਵਿਚਕਾਰ ਵਿੱਥ");
        set(INTERWORD_SPACING, "ਸ਼ਬਦਾਂ ਵਿਚਕਾਰ ਵਿੱਥ");
        
        set(FREQUENCY, "ਫ੍ਰੀਕੁਐਂਸੀ");
        set(VOLUME, "ਆਵਾਜ਼");
        set(ENVELOPE, "ਰਾਇਜ਼/ਫਾਲ ਟਾਈਮ");
        set(NOCLICK, "ਕਲਿੱਕ ਤੋਂ ਬਚਣ ਲਈ ਸਾਟੂਥ ਸਿਗਨਲ");
        
        set(LANGUAGE, "ਭਾਸ਼ਾ");
        set(KEYBOARD_TYPE, "ਕੀਬੋਰਡ ਦੀ ਕਿਸਮ");
        set(SHOW_TABLE, "ਮੋਰਸ ਟੇਬਲ ਦਿਖਾਓ");
        set(SHOW_TABLE_CODES, "ਮੋਰਸ ਟੇਬਲ ਵਿੱਚ ਬਿੰਦੀਆਂ ਅਤੇ ਡੈਸ਼ ਦਿਖਾਓ");
        set(SHOW_VISUAL, "ਵਿਜ਼ੂਅਲ ਇੰਡੀਕੇਟਰ ਦਿਖਾਓ");
        set(SHOW_PADDLES, "ਸਕ੍ਰੀਨ ਪੈਡਲ ਦਿਖਾਓ");
        set(NEXT_WORD_INDICATOR, "ਅਗਲਾ ਸ਼ਬਦ ਸੂਚਕ");
        set(KEEP_SCREEN_ON, "ਸਕ੍ਰੀਨ ਚਾਲੂ ਰੱਖੋ");
        set(APP_THEME, "ਐਪ ਥੀਮ");
        set(TEXT_COLOR, "ਲਿਖਾਈ ਦਾ ਰੰਗ");
        set(TEXT_FONT_SIZE, "ਲਿਖਾਈ ਦਾ ਸਾਈਜ਼");
        set(TABLE_FONT_SIZE, "ਟੇਬਲ ਲਿਖਾਈ ਦਾ ਸਾਈਜ਼");
        set(TABLE_RATIO, "ਟੇਬਲ/ਸਕ੍ਰੀਨ ਅਨੁਪਾਤ");
        
        set(KEEP_ALIVE, "ਆਡੀਓ ਚਾਲੂ ਰੱਖੋ");
        set(AUDIO_BUFFER, "ਆਡੀਓ ਬਫਰ");
        set(PROCESSING_CHUNK, "ਪ੍ਰੋਸੈਸਿੰਗ ਚੰਕ");
        set(PERFORMANCE_HINT, "ਜੇ ਆਵਾਜ਼ ਕੱਟਦੀ ਹੈ ਤਾਂ ਬਫਰ ਵਧਾਓ। ਜੇ ਦੇਰੀ ਹੈ ਤਾਂ ਘਟਾਓ।");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "ਸਮਰਥਿਤ ਇਨਪੁਟਸ: ਕੀਬੋਰਡ, ਟੱਚ ਸਕਰੀਨ, ਮਾਊਸ ਜਾਂ USB ਪੈਡਲ ਅਡਾਪਟਰ।\n\nਮਾਊਸ ਖੱਬੇ/ਸੱਜੇ-ਕਲਿੱਕ ਕੀਇੰਗ ਜਾਂ USB-ਟੂ-ਮਾਊਸ ਪੈਡਲ ਅਡਾਪਟਰ ਲਈ, ਮਾਊਸ ਪੁਆਇੰਟਰ ਨੂੰ ਸਕ੍ਰੀਨ ਵਿੱਚ ਖੱਬੇ ਪੈਡਲ ਬਟਨ ਉੱਤੇ ਛੱਡੋ, ਖੱਬਾ/ਸੱਜਾ ਕਲਿੱਕ ਸਹੀ ਪੈਡਲਾਂ ਨਾਲ ਮੈਪ ਹੋ ਜਾਵੇਗਾ।\n\nUSB-ਟੂ-ਕੀਬੋਰਡ ਪੈਡਲ ਅਡਾਪਟਰਾਂ ਲਈ (ਜਿਵੇਂ ਕਿ VBand) ਇਹ ਬਿਨਾਂ ਕਿਸੇ ਸੈਟਅਪ ਦੇ ਕੰਮ ਕਰਦਾ ਹੈ।\n\nਸਖਤ ਸਮੇਂ ਲਈ ਅੱਖਰਾਂ ਦੇ ਵਿਚਕਾਰ ਸਹੀ ਵਿਰਾਮ ਦੀ ਲੋੜ ਹੁੰਦੀ ਹੈ; ਗੈਰ-ਸਖਤ ਤੇਜ਼ ਕੀਇੰਗ ਦੀ ਆਗਿਆ ਦਿੰਦਾ ਹੈ।\n\nਸਮੱਸਿਆ ਨਿਪਟਾਰਾ: ਜੇਕਰ ਆਵਾਜ਼ ਕਲਿੱਕ ਕਰਦੀ ਹੈ, ਤਾਂ ਸਾਟੂਥ ਦੀ ਕੋਸ਼ਿਸ਼ ਕਰੋ ਜਾਂ ਲਿਫਾਫੇ ਨੂੰ ਬਦਲੋ। ਜੇਕਰ ਲੇਟੈਂਸੀ ਜ਼ਿਆਦਾ ਹੈ, ਤਾਂ ਬਫਰ ਨੂੰ ਘਟਾਓ। ਜੇਕਰ ਆਵਾਜ਼ ਅਟਕਦੀ ਹੈ, ਤਾਂ ਇਸਨੂੰ ਵਧਾਓ।\n\nਕੀਬੋਰਡ ਕੁੰਜੀਆਂ:\n  ਖੱਬਾ: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  ਸੱਜਾ: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "ਕੀ");
        
        set(SYSTEM_SETTING, "ਸਿਸਟਮ ਸੈਟਿੰਗ");
        set(DARK_THEME, "ਡਾਰਕ ਥੀਮ");
        set(LIGHT_THEME, "ਲਾਈਟ ਥੀਮ");
        
        set(MODE_STRAIGHT, "ਸਿੱਧੀ ਕੀ");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "ਬੱਗ (ਅਰਧ-ਸਵੈਚਾਲਿਤ)");
        set(MODE_COOTIE, "ਕੂਟੀ (Sideswiper)");
        
        set(CAT_LETTERS, "ਅੱਖਰ");
        set(CAT_NUMBERS, "ਨੰਬਰ");
        set(CAT_SYMBOLS, "ਚਿੰਨ੍ਹ");
        set(CAT_SPECIAL_SYMBOLS, "ਖਾਸ ਚਿੰਨ੍ਹ");
        set(CAT_SPECIAL, "ਖਾਸ ਅੱਖਰ");
        set(CAT_PROSIGNS_COMMON, "ਆਮ ਪ੍ਰਕਿਰਿਆ ਸੰਕੇਤ");
        set(CAT_ABBREVIATIONS, "ਆਮ ਛੋਟੇ ਨਾਮ");
        set(CAT_QCODES, "Q ਕੋਡ");
        set(CAT_PROSIGNS_OTHER, "ਦੂਜੇ ਪ੍ਰਕਿਰਿਆ ਸੰਕੇਤ");

        set(COLOR_WHITE, "ਚਿੱਟਾ");
        set(COLOR_BLACK, "ਕਾਲਾ");
        set(COLOR_RED, "ਲਾਲ");
        set(COLOR_ORANGE, "ਸੰਤਰੀ");
        set(COLOR_YELLOW, "ਪੀਲਾ");
        set(COLOR_GREEN, "ਹਰਾ");
        set(COLOR_CYAN, "ਸਾਈਨ");
        set(COLOR_BLUE, "ਨੀਲਾ");
        set(COLOR_PURPLE, "ਜਾਮਨੀ");
        set(COLOR_PINK, "ਗੁਲਾਬੀ");
        set(SUPPORT_WINDLEREYE, "ਮੇਰੇ ਸੰਗੀਤ ਪ੍ਰੋਜੈਕਟ Windlereye ਨੂੰ ਸੁਣ ਕੇ ਮੇਰਾ ਸਮਰਥਨ ਕਰੋ");
        set(CANCEL, "ਰੱਦ ਕਰੋ");
        set(QUIT, "ਬਾਹਰ ਜਾਓ");
        set(QUIT_GAME_PROMPT, "ਕੀ ਤੁਸੀਂ ਯਕੀਨੀ ਤੌਰ 'ਤੇ ਇਸ ਗੇਮ ਤੋਂ ਬਾਹਰ ਜਾਣਾ ਚਾਹੁੰਦੇ ਹੋ?");

        set(SCORE, "ਸਕੋਰ: ");
        set(HIGH_SCORE, "ਉੱਚ ਸਕੋਰ");
        set(YOUR_HIGH_SCORE_IS, "ਤੁਹਾਡਾ ਸਭ ਤੋਂ ਵੱਧ ਸਕੋਰ ਹੈ:");
        set(TIME, "ਸਮਾਂ: ");
                set(MATCH_COMPLETED, "ਮੈਚ ਪੂਰਾ ਹੋਇਆ");
        set(TRY_AGAIN, "ਦੁਬਾਰਾ ਕੋਸ਼ਿਸ਼ ਕਰੋ");
        set(WORDS, "ਸ਼ਬਦ");
                set(QUIT_GAME, "ਖੇਡ ਛੱਡੋ");
        set(MATCH_SETTINGS, "ਖੇਡ ਪੈਰਾਮੀਟਰ");
        set(SHARE_PREVIEW, "ਪੂਰਵ-ਝਲਕ ਸਾਂਝਾ ਕਰੋ");
        set(SHARE, "ਸ਼ੇਅਰ ਕਰੋ");
        set(SHARE_SUBJECT, "ਮੇਰਾ ਮੋਰਸ ਕੀਅਰ ਸਕੋਰ ਸਾਂਝਾ ਕਰਨਾ");
        set(SHARE_PROMO_TEXT, "ਮੋਰਸ ਕੀਅਰ ਨੂੰ https://morsetraining.com 'ਤੇ ਮੁਫ਼ਤ ਵਿੱਚ ਚਲਾਓ");
        set(THEME, "ਥੀਮ");

        set(MATCH_RESULTS, "ਮੈਚ ਨਤੀਜੇ");
                

        set(REPEAT, "ਦੁਹਰਾਓ");

        set(START, "ਸ਼ੁਰੂ ਕਰੋ");
        set(PICK_LANG_THEME_ON_SHARE, "ਸਕੋਰ ਸਾਂਝੇ ਕਰਨ ਵੇਲੇ ਭਾਸ਼ਾ ਅਤੇ ਥੀਮ ਚੁਣੋ");
        set(GAMES, "ਖੇਡਾਂ");
        set(CONTINUE, "ਜਾਰੀ ਰੱਖੋ");
        set(RX, "ਪ੍ਰਾਪਤ ਕਰਨਾ");
        set(TX, "ਸੰਚਾਰ ਕਰਨਾ");

        set(KOCH_METHOD, "ਕੋਚ ਵਿਧੀ");
        set(TARGET, "ਟੀਚਾ");
        set(LISTEN, "ਸੁਣੋ");
        set(TARGET_MET, "ਟੀਚਾ ਪੂਰਾ ਹੋਇਆ");
        set(TARGET_NOT_MET, "ਟੀਚਾ ਪੂਰਾ ਨਹੀਂ ਹੋਇਆ");
            set(LEVEL, "ਪੱਧਰ");
    
        set(LEARN, "ਸਿੱਖੋ");
        set(PLAY, "ਖੇਡੋ");
    
        set(LEVELS_COMPLETED, "ਪੂਰੇ ਕੀਤੇ ਪੱਧਰ");
        set(RESET_PROGRESS, "ਤਰੱਕੀ ਰੀਸੈਟ ਕਰੋ");
        set(RESET_PROGRESS_CONFIRM, "ਕੀ ਤੁਸੀਂ ਤਰੱਕੀ ਰੀਸੈਟ ਕਰਨਾ ਚਾਹੁੰਦੇ ਹੋ?");
        set(RESET, "ਰੀਸੈਟ ਕਰੋ");
            set(WPM, "WPM​");
        set(SPACING, "ਵਿੱਥ");
    }
}