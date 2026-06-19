package com.qft8.morsekeyer.lang;

public class LangPcm extends MorseLanguage {
    public LangPcm() {
        set(SAVE, "Save");
        set(RESET_DEFAULTS, "Reset everything");
        set(CLOSE, "Close");
        
        set(SETTINGS_TITLE, "Settings");
        set(TONE, "Sound");
        set(USER_INTERFACE, "How e look");
        set(ADVANCED, "Oga settings (performance)");
        set(DECODER_BEHAVIOR, "How e dey read am");

        set(KEY_MODE, "Key mode");
        set(WPM_SPEED, "Speed (WPM)");
        set(INVERSE_PADDLES, "Turn paddles reverse");
        set(STRICT_TIMING, "Strict timing");
        set(INTERLETTER_SPACING, "Space between letters");
        set(INTERWORD_SPACING, "Space between words");
        
        set(FREQUENCY, "Frequency");
        set(VOLUME, "Volume");
        set(ENVELOPE, "Rise/Fall time (envelope)");
        set(NOCLICK, "Use sawtooth signal make e no click");
        
        set(LANGUAGE, "Language");
        set(KEYBOARD_TYPE, "Keyboard type");
        set(SHOW_TABLE, "Show Morse table");
        set(SHOW_TABLE_CODES, "Show dits and dahs for Morse table");
        set(SHOW_VISUAL, "Show light indicator");
        set(SHOW_PADDLES, "Show screen paddles");
        set(NEXT_WORD_INDICATOR, "Next word indicator");
        set(KEEP_SCREEN_ON, "Make screen no sleep");
        set(APP_THEME, "App theme");
        set(TEXT_COLOR, "Text color");
        set(TEXT_FONT_SIZE, "Text font size");
        set(TABLE_FONT_SIZE, "Table font size");
        set(TABLE_RATIO, "Table/Screen ratio");
        
        set(KEEP_ALIVE, "Keep audio active (make e fast)");
        set(WHITE_NOISE, "Stronger (play white noise)");
        set(AUDIO_BUFFER, "Audio buffer (hardware)");
        set(PROCESSING_CHUNK, "Processing chunk");
        set(PERFORMANCE_HINT, "If sound dey break, increase buffer. If e dey delay, reduce am.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Support for: keyboard, touch screen, mouse, or paddle with USB adapter.\n\n" +
                "For mouse left/right-click keying or USB-to-mouse paddle adapter, leave di mouse pointer over di left paddle button inside di screen, left/right click go map to di correct paddles.\n\n" +
                "For USB keyboard adapter (like VBand), e go work just like dat.\n\n" +
                "Strict mode need correct timing between letters; non-strict go let you key fast.\n\n" +
                "Common issues: If sound dey click too much, try 'Sawtooth' option or change envelope. If e dey delay, reduce buffer.\n\n" +
                "Keyboard keys:\n" +
                "  Left: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Right: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Key");
        
        set(SYSTEM_SETTING, "System setting");
        set(DARK_THEME, "Dark theme");
        set(LIGHT_THEME, "Light theme");
        
        set(MODE_STRAIGHT, "Straight key");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Semi-auto)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "LETTERS");
        set(CAT_NUMBERS, "NUMBERS");
        set(CAT_SYMBOLS, "SYMBOLS");
        set(CAT_SPECIAL_SYMBOLS, "SPECIAL SYMBOLS");
        set(CAT_SPECIAL, "SPECIAL LETTERS");
        set(CAT_PROSIGNS_COMMON, "COMMON SIGNALS");
        set(CAT_ABBREVIATIONS, "COMMON SHORT NAMES");
        set(CAT_QCODES, "Q CODES");
        set(CAT_PROSIGNS_OTHER, "OTHER SIGNALS");

        set(COLOR_WHITE, "White");
        set(COLOR_BLACK, "Black");
        set(COLOR_RED, "Red");
        set(COLOR_ORANGE, "Orange");
        set(COLOR_YELLOW, "Yellow");
        set(COLOR_GREEN, "Green");
        set(COLOR_CYAN, "Cyan");
        set(COLOR_BLUE, "Blue");
        set(COLOR_PURPLE, "Purple");
        set(COLOR_PINK, "Pink");
        set(SUPPORT_WINDLEREYE, "Support me make you listen to my music project Windlereye");
        set(CANCEL, "Cancel");
        set(QUIT, "Comot");
        set(QUIT_GAME_PROMPT, "You sure say you want comot from dis game?");

        set(SCORE, "Score");
        set(HIGH_SCORE, "High score");
        set(YOUR_HIGH_SCORE_IS, "Your highest score na");
        set(TIME, "Time");
                set(MATCH_COMPLETED, "Match don finish");
        set(TRY_AGAIN, "Try again");
        set(WORDS, "Words");
                set(QUIT_GAME, "Quit game");
        set(MATCH_SETTINGS, "Game parameters");
        set(SHARE_PREVIEW, "Share preview");
        set(SHARE, "Share");
        set(SHARE_SUBJECT, "Sharing my Morse Training score");
        set(SHARE_PROMO_TEXT, "Play Morse Training for free at https://morsetraining.com");
        set(THEME, "Theme");

        set(MATCH_RESULTS, "Match results");
                

        set(REPEAT, "REPEAT");

        set(START, "START");
        set(PICK_LANG_THEME_ON_SHARE, "Choose language and theme when you dey share scores");
        set(GAMES, "Games");
        set(CONTINUE, "CONTINUE");
        set(RX, "Risiv");
        set(TX, "Transmit");

        set(KOCH_METHOD, "Koch method");
        set(TARGET, "Target");
set(TARGET_MET, "Target reach");
        set(TARGET_NOT_MET, "Target no reach");
            set(LEVEL, "Level");
    
        set(LEARN, "Learn");
        set(PLAY, "Play");
    
        set(LEVELS_COMPLETED, "Level finish");
        set(RESET_PROGRESS, "Reset progress");
        set(RESET_PROGRESS_CONFIRM, "You sure say you won reset progress?");
        set(RESET, "Reset");
            set(WPM, "WPM");
        set(SPACING, "Space");
        set(BACK, "Go back");
        set(NEXT_LEVEL, "Next level");
    }
}