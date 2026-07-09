package com.qft8.morsekeyer.lang;

public class LangMl extends MorseLanguage {
    public LangMl() {
        set(SAVE, "സേവ് ചെയ്യുക");
        set(RESET_DEFAULTS, "ഡിഫോൾട്ടിലേക്ക് മാറ്റുക");
        set(CLOSE, "അടയ്ക്കുക");
        
        set(SETTINGS_TITLE, "ക്രമീകരണങ്ങൾ");
        set(TONE, "ടോൺ");
        set(USER_INTERFACE, "യൂസർ ഇന്റർഫേസ്");
        set(ADVANCED, "അഡ്വാൻസ്ഡ് (പ്രകടനം)");
        set(DECODER_BEHAVIOR, "ഡീകോഡർ രീതി");

        set(KEY_MODE, "കീ മോഡ്");
        set(WPM_SPEED, "വേഗത (WPM)");
        set(INVERSE_PADDLES, "പാഡിലുകൾ മാറ്റുക");
        set(STRICT_TIMING, "കൃത്യമായ ടൈമിംഗ്");
        
        set(FREQUENCY, "ഫ്രീക്വൻസി");
        set(VOLUME, "ശബ്ദം");
        set(ENVELOPE, "എൻവലപ്പ് സമയം");
        set(NOCLICK, "ക്ലിക്ക് ഒഴിവാക്കാൻ സോടൂത്ത് സിഗ്നൽ");
        
        set(LANGUAGE, "ഭാഷ");
        set(KEYBOARD_TYPE, "കീബോർഡ് തരം");
        set(SHOW_TABLE, "മോഴ്സ് ടേബിൾ കാണിക്കുക");
        set(SHOW_TABLE_CODES, "മോഴ്സ് ടേബിളിൽ ഡോട്ടുകളും ഡാഷുകളും കാണിക്കുക");
        set(SHOW_VISUAL, "വിഷ്വൽ ഇൻഡിക്കേറ്റർ കാണിക്കുക");
        set(SHOW_PADDLES, "സ്ക്രീൻ പാഡിലുകൾ കാണിക്കുക");
        set(NEXT_WORD_INDICATOR, "അടുത്ത വാക്ക് സൂചകം");
        set(KEEP_SCREEN_ON, "സ്ക്രീൻ ഓൺ ആക്കി വെക്കുക");
        set(APP_THEME, "ആപ്പ് തീം");
        set(TEXT_COLOR, "അക്ഷരത്തിന്റെ നിറം");
        set(TEXT_FONT_SIZE, "അക്ഷരത്തിന്റെ വലിപ്പം");
        set(TABLE_FONT_SIZE, "ടേബിളിലെ അക്ഷര വലിപ്പം");
        set(TABLE_RATIO, "ടേബിൾ/സ്ക്രീൻ അനുപാതം");
        
        set(KEEP_ALIVE, "ഓഡിയോ സജീവമാക്കുക");
        set(WHITE_NOISE, "ശക്തമായ (വൈറ്റ് നോയ്സ് പ്ലേ ചെയ്യുക)");
        set(AUDIO_BUFFER, "ഓഡിയോ ബഫർ");
        set(PROCESSING_CHUNK, "പ്രോസസ്സിംഗ് ചങ്ക്");
        set(PERFORMANCE_HINT, "ശബ്ദം മുറിയുന്നുണ്ടെങ്കിൽ ബഫർ കൂട്ടുക. താമസം ഉണ്ടെങ്കിൽ കുറയ്ക്കുക.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "പിന്തുണയ്‌ക്കുന്ന ഇൻപുട്ടുകൾ: കീബോർഡ്, ടച്ച് സ്‌ക്രീൻ, മൗസ് അല്ലെങ്കിൽ USB പാഡിൽ അഡാപ്റ്റർ.\n\nമൗസ് ലെഫ്റ്റ്/റൈറ്റ്-ക്ലിക്ക് കീയിംഗ് അല്ലെങ്കിൽ യുഎസ്ബി-ടു-മൗസ് പാഡിൽ അഡാപ്റ്ററിന്, സ്ക്രീനിലെ ഇടത് പാഡിൽ ബട്ടണിന് മുകളിൽ മൗസ് പോയിൻ്റർ വയ്ക്കുക, ഇടത്/വലത് ക്ലിക്ക് ശരിയായ പാഡിലുകളിലേക്ക് മാപ്പ് ചെയ്യും.\n\nUSB-ടു-കീബോർഡ് പാഡിൽ അഡാപ്റ്ററുകൾക്ക് (ഉദാഹരണത്തിന് VBand) ഇത് നേരിട്ട് പ്രവർത്തിക്കും.\n\nകർശനമായ സമയത്തിന് അക്ഷരങ്ങൾക്കിടയിൽ കൃത്യമായ ഇടവേളകൾ ആവശ്യമാണ്; കർശനമല്ലാത്തവ വേഗത്തിൽ കീയിംഗ് ചെയ്യാൻ അനുവദിക്കുന്നു.\n\nട്രബിൾഷൂട്ടിംഗ്: ശബ്ദം ക്ലിക്ക് ചെയ്യുകയാണെങ്കിൽ, സോട്ടൂത്ത് ശ്രമിക്കുക അല്ലെങ്കിൽ എൻവലപ്പ് മാറ്റുക. ലേറ്റൻസി കൂടുതലാണെങ്കിൽ, ബഫർ കുറയ്ക്കുക. ശബ്ദം ഇടറുകയാണെങ്കിൽ, അത് കൂട്ടുക.\n\nകീബോർഡ് കീകൾ:\n  ഇടത്: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  വലത്: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "കീ");
        
        set(SYSTEM_SETTING, "സിസ്റ്റം ക്രമീകരണം");
        set(DARK_THEME, "ഡാർക്ക് തീം");
        set(LIGHT_THEME, "ലൈറ്റ് തീം");
        
        set(MODE_STRAIGHT, "സ്ട്രൈറ്റ് കീ");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "ബഗ് (സെമി-ഓട്ടോ)");
        set(MODE_COOTIE, "കൂട്ടി (Sideswiper)");
        
        set(CAT_LETTERS, "അക്ഷരങ്ങൾ");
        set(CAT_NUMBERS, "അക്കങ്ങൾ");
        set(CAT_SYMBOLS, "ചിഹ്നങ്ങൾ");
        set(CAT_SPECIAL_SYMBOLS, "പ്രത്യേക ചിഹ്നങ്ങൾ");
        set(CAT_SPECIAL, "പ്രത്യേക അക്ഷരങ്ങൾ");
        set(CAT_PROSIGNS_COMMON, "സാധാരണ നടപടിക്രമ ചിഹ്നങ്ങൾ");
        set(CAT_ABBREVIATIONS, "സാധാരണ ചുരുക്കരൂപങ്ങൾ");
        set(CAT_QCODES, "Q കോഡുകൾ");
        set(CAT_PROSIGNS_OTHER, "മറ്റ് നടപടിക്രമ ചിഹ്നങ്ങൾ");

        set(COLOR_WHITE, "വെള്ള");
        set(COLOR_BLACK, "കറുപ്പ്");
        set(COLOR_RED, "ചുവപ്പ്");
        set(COLOR_ORANGE, "ഓറഞ്ച്");
        set(COLOR_YELLOW, "മഞ്ഞ");
        set(COLOR_GREEN, "പച്ച");
        set(COLOR_CYAN, "സയൻ");
        set(COLOR_BLUE, "നീല");
        set(COLOR_PURPLE, "പർപ്പിൾ");
        set(COLOR_PINK, "പിങ്ക്");
        set(SUPPORT_WINDLEREYE, "എന്റെ സംഗീത പ്രോജക്റ്റ് Windlereye കേട്ട് എന്നെ പിന്തുണയ്ക്കുക");
        set(CANCEL, "റദ്ദാക്കുക");
        set(QUIT, "പുറത്തുകടക്കുക");
        set(QUIT_GAME_PROMPT, "ഈ ഗെയിമിൽ നിന്ന് പുറത്തുകടക്കണമെന്ന് നിങ്ങൾക്ക് ഉറപ്പാണോ?");

        set(SCORE, "സ്കോർ");
        set(HIGH_SCORE, "ഉയർന്ന സ്കോർ");
        set(YOUR_HIGH_SCORE_IS, "നിങ്ങളുടെ ഉയർന്ന സ്കോർ");
        set(TIME, "സമയം");
                set(MATCH_COMPLETED, "മത്സരം പൂർത്തിയായി");
        set(TRY_AGAIN, "വീണ്ടും ശ്രമിക്കുക");
        set(WORDS, "വാക്കുകൾ");
                set(QUIT_GAME, "ഗെയിം ഉപേക്ഷിക്കുക");
        set(MATCH_SETTINGS, "ഗെയിം പാരാമീറ്ററുകൾ");
        set(SHARE_PREVIEW, "പ്രിവ്യൂ പങ്കിടുക");
        set(SHARE, "പങ്കിടുക");
        set(SHARE_SUBJECT, "എൻ്റെ മോഴ്സ് കീയർ സ്കോർ പങ്കിടുന്നു");
        set(SHARE_PROMO_TEXT, "https://morsetraining.com എന്നതിൽ മോഴ്സ് കീയർ സൗജന്യമായി പ്ലേ ചെയ്യുക");
        set(THEME, "തീം");

        set(MATCH_RESULTS, "മത്സര ഫലങ്ങൾ");
                

        set(REPEAT, "ആവർത്തിക്കുക");

        set(START, "തുടങ്ങുക");
        set(PICK_LANG_THEME_ON_SHARE, "സ്കോറുകൾ പങ്കിടുമ്പോൾ ഭാഷയും തീമും തിരഞ്ഞെടുക്കുക");
        set(GAMES, "ഗെയിമുകൾ");
        set(CONTINUE, "തുടരുക");
        set(RX, "സ്വീകരിക്കുക");
        set(TX, "പ്രക്ഷേപണം ചെയ്യുക");

        set(KOCH_METHOD, "കോച്ച് രീതി");
        set(TARGET, "ലക്ഷ്യം");
set(TARGET_MET, "ലക്ഷ്യം നേടി");
        set(TARGET_NOT_MET, "ലക്ഷ്യം നേടിയില്ല");
            set(LEVEL, "നില");
    
        set(LEARN, "പഠിക്കുക");
        set(PLAY, "കളിക്കുക");
    
        set(LEVELS_COMPLETED, "പൂർത്തിയാക്കിയ നിലകൾ");
        set(RESET_PROGRESS, "പുരോഗതി പുനഃസജ്ജമാക്കുക");
        set(RESET_PROGRESS_CONFIRM, "പുരോഗതി പുനഃസജ്ജമാക്കണമെന്ന് ഉറപ്പാണോ?");
        set(RESET, "പുനഃസജ്ജമാക്കുക");
            set(WPM, "WPM​");
        set(BACK, "പിന്നിലേക്ക്");
        set(NEXT_LEVEL, "അടുത്ത ഘട്ടം");

                set(EFFECTIVE_WPM_FARNSWORTH, "ഫലപ്രദമായ ഡബ്ല്യുപിഎം (ഫാൺസ്വർത്ത്)");
                set(EXTRA_WORD_SPACING, "അധിക വാക്ക് അകലം");
                set(EFFECTIVE_WPM_SHORT, "ഫലപ്രദമായ");

                set(WORD_SPACING_ADD, "വാക്ക് +");
    }
}