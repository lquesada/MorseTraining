package com.qft8.morsekeyer.lang;

public class LangEn extends MorseLanguage {
        public LangEn() {
                // --- BUTTONS ---
                set(SAVE, "Save"); // Action to persist settings
                set(RESET_DEFAULTS, "Reset to defaults"); // Action to restore original settings
                set(CLOSE, "Close"); // Used in Info dialog

                // --- SETTINGS SECTIONS ---
                set(SETTINGS_TITLE, "Settings");
                set(TONE, "Tone");
                set(USER_INTERFACE, "User Interface");
                set(ADVANCED, "Advanced (performance)");
                set(DECODER_BEHAVIOR, "Decoder behavior");

                // --- KEY MODE ---
                set(KEY_MODE, "Keyer mode");
                set(WPM_SPEED, "WPM speed");
                set(INVERSE_PADDLES, "Inverse paddles");
                set(STRICT_TIMING, "Strict timing");

                // --- AUDIO ---
                set(FREQUENCY, "Frequency");
                set(VOLUME, "Volume");
                set(ENVELOPE, "Rise/Fall time (envelope)");
                set(NOCLICK, "Use sawtooth signal to avoid clicks");

                // --- UI SETTINGS ---
                set(LANGUAGE, "Language");
                set(KEYBOARD_TYPE, "Keyboard type");
                set(SHOW_TABLE, "Show Morse table");
                set(SHOW_TABLE_CODES, "Show dits and dahs in morse table");
                set(SHOW_VISUAL, "Show visual indicator");
                set(SHOW_PADDLES, "Show screen paddles");
                set(NEXT_WORD_INDICATOR, "Next word indicator");
                set(KEEP_SCREEN_ON, "Keep screen on while app is active");
                set(APP_THEME, "App theme");
                set(TEXT_COLOR, "Text color");
                set(TEXT_FONT_SIZE, "Text font size");
                set(TABLE_FONT_SIZE, "Table font size");
                set(TABLE_RATIO, "Ratio of table to text screen");

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

                // --- ADVANCED ---
                set(KEEP_ALIVE, "Keep audio alive (lowers latency)");
                set(WHITE_NOISE, "Stronger (play white noise)");
                set(AUDIO_BUFFER, "Audio buffer (hardware)");
                set(PROCESSING_CHUNK, "Processing chunk");
                set(PERFORMANCE_HINT, "If sound cuts, increase buffer or chunk. If latency is high, decrease them.");

                // --- INFO DIALOG ---
                set(INFO_TITLE, "Morse Training");
                set(INFO_TEXT, "Supported inputs: keyboard, touch screen, mouse, or a paddle with USB adapter.\n\n" +
                                "For mouse left/right-click keying or USB-to-mouse paddle adapter, leave the mouse pointer over the left paddle button in the screen, left/right click will map to the correct paddles.\n\n"
                                +
                                "For an USB-to-keyboard paddle adapter it works out of the box (e.g. tested with VBand) - let me know if it doesn't.\n\n"
                                +
                                "Strict mode requires the proper timing between letters, non-strict mode allows faster manipulation.\n\n"
                                +
                                "Common issues: If the sound is too clickety in your device, try the 'No-click' option or try modifying the envelope. If latency is too high, try decreasing the buffer. If the sound breaks, try increasing it.\n\n"
                                +
                                "Keyboard keys:\n" +
                                "  Left: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                                "  Right: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

                // --- DYNAMIC UI ---
                set(KEY, "Key"); // Label on the paddle for non-iambic modes

                // --- OPTIONS ---
                set(SYSTEM_SETTING, "System setting");
                set(DARK_THEME, "Dark theme");
                set(LIGHT_THEME, "Light theme");

                set(MODE_STRAIGHT, "Straight");
                set(MODE_IAMBIC_A, "Iambic A");
                set(MODE_IAMBIC_B, "Iambic B");
                set(MODE_ULTIMATIC, "Ultimatic");
                set(MODE_BUG, "Bug");
                set(MODE_COOTIE, "Cootie");

                // --- CATEGORIES ---
                set(CAT_LETTERS, "LETTERS");
                set(CAT_NUMBERS, "NUMBERS");
                set(CAT_SYMBOLS, "SYMBOLS");
                set(CAT_SPECIAL_SYMBOLS, "SPECIAL SYMBOLS");
                set(CAT_SPECIAL, "SPECIAL LETTERS");
                set(CAT_PROSIGNS_COMMON, "COMMON PROCEDURAL SIGNALS");
                set(CAT_ABBREVIATIONS, "COMMON ABBREVIATIONS");
                set(CAT_QCODES, "Q CODES");
                set(CAT_PROSIGNS_OTHER, "OTHER PROCEDURAL SIGNALS");
                set(SUPPORT_WINDLEREYE, "Support me by listening to my music project Windlereye");
                set(CANCEL, "Cancel");
                set(QUIT, "Quit");
                set(QUIT_GAME_PROMPT, "Are you sure you want to quit this game?");

                set(SCORE, "Score");
                set(HIGH_SCORE, "High Score");
                set(YOUR_HIGH_SCORE_IS, "Your high score is");
                set(TIME, "Time");
                set(MATCH_COMPLETED, "Match Complete");
                set(TRY_AGAIN, "Try again");

                // --- MATCH SUMMARY SCREEN ---
                // Shown on the full-screen results pane after a game ends (timer expires or
                // player quits)
                set(WORDS, "Words"); // Number of words/callsigns the player completed
                // Date when the high score was achieved
                set(QUIT_GAME, "Quit game"); // Button to exit the game and return to main screen
                set(MATCH_SETTINGS, "Match settings"); // Section header for keyer configuration used during the match
                set(MATCH_RESULTS, "Match results"); // Section header for match results
                // Section header for high score
                // High score label

                // --- SHARE ---
                // Share dialog allows the player to share their match results as an image
                set(SHARE_PREVIEW, "Share preview");
                set(GAMES, "Games"); // Title of the share dialog
                set(SHARE, "Share"); // Button label to trigger the system share sheet
                set(SHARE_SUBJECT, "Sharing my Morse Training score"); // Email subject line when sharing
                set(SHARE_PROMO_TEXT, "Play Morse Training for free at https://morsetraining.com"); // Text message
                                                                                                    // included with the
                                                                                                    // shared image
                set(THEME, "Theme"); // Label for the theme selector (Dark/Light) in the share dialog

                set(TX, "Transmit");
                set(RX, "Receive");

                set(LEARN, "Learn"); // Header for the learn section in the game menu
                set(PLAY, "Play"); // Button to start the game
                set(REPEAT, "REPEAT");
        set(HINT, "HINT");

                set(START, "START");
                set(CONTINUE, "Continue");
                set(PICK_LANG_THEME_ON_SHARE, "Choose language and theme when sharing scores");
        

        set(KOCH_METHOD, "Koch method");
        set(TARGET, "Target");
set(TARGET_MET, "TARGET MET");
        set(TARGET_NOT_MET, "TARGET NOT MET");
            set(LEVEL, "Level");
            set(LEVELS_COMPLETED, "Levels completed");
    
    

    
        set(KOCH_METHOD, "Koch method");
        set(TARGET, "Target");
set(TARGET_MET, "TARGET MET");
        set(TARGET_NOT_MET, "TARGET NOT MET");
        set(RESET_PROGRESS, "Reset progress");
        set(RESET_PROGRESS_CONFIRM, "Are you sure you want to reset progress?");
        set(RESET, "Reset");
        set(WPM, "WPM");
        set(BACK, "Back");
        set(NEXT_LEVEL, "Next Level");

                set(EFFECTIVE_WPM_FARNSWORTH, "Effective WPM (Farnsworth)");
                set(EXTRA_WORD_SPACING, "Spacing");
                set(EFFECTIVE_WPM_SHORT, "Effective");

                set(WORD_SPACING_ADD, "Word +");
    }
}
