package com.qft8.morsekeyer.lang;

public class LangAm extends MorseLanguage {
    public LangAm() {
        set(SAVE, "አስቀምጥ");
        set(RESET_DEFAULTS, "ወደ መጀመሪያው መልስ");
        set(CLOSE, "ዝጋ");
        
        set(SETTINGS_TITLE, "ቅንብሮች");
        set(TONE, "ድምጽ");
        set(USER_INTERFACE, "መልክ");
        set(ADVANCED, "የላቀ (አፈጻጸም)");
        set(DECODER_BEHAVIOR, "የዲኮደር ባህሪ");

        set(KEY_MODE, "የመጫኛ አይነት");
        set(WPM_SPEED, "ፍጥነት (WPM)");
        set(INVERSE_PADDLES, "ቀኝና ግራ ቀይር");
        set(STRICT_TIMING, "ትክክለኛ ሰዓት");
        set(INTERLETTER_SPACING, "በፊደላት መካከል ያለው ክፍተት");
        set(INTERWORD_SPACING, "በቃላት መካከል ያለው ክፍተት");
        
        set(FREQUENCY, "ድግግሞሽ (Frequency)");
        set(VOLUME, "ድምጽ መጠን");
        set(ENVELOPE, "መነሻ/መድረሻ ጊዜ (Envelope)");
        set(NOCLICK, "ጠቅታን ለማስወገድ የሶቱዝ ሞገድ ተጠቀም");
        
        set(LANGUAGE, "ቋንቋ");
        set(KEYBOARD_TYPE, "የቁልፍ ሰሌዳ አይነት");
        set(SHOW_TABLE, "የሞርስ ሰንጠረዥ አሳይ");
        set(SHOW_TABLE_CODES, "በሞርስ ሰንጠረዥ ውስጥ ነጥቦችን እና ሰረዞችን አሳይ");
        set(SHOW_VISUAL, "የምስል ምልክት አሳይ");
        set(SHOW_PADDLES, "የስክሪን መጫኛዎችን አሳይ");
        set(NEXT_WORD_INDICATOR, "የሚቀጥለው ቃል ጠቋሚ");
        set(KEEP_SCREEN_ON, "ስክሪኑ እንዳይጠፋ አድርግ");
        set(APP_THEME, "መተግበሪያ ገጽታ");
        set(TEXT_COLOR, "የጽሑፍ ቀለም");
        set(TEXT_FONT_SIZE, "የጽሑፍ መጠን");
        set(TABLE_FONT_SIZE, "የሰንጠረዥ ጽሑፍ መጠን");
        set(TABLE_RATIO, "የሰንጠረዥ/ስክሪን መጠን");
        
        set(KEEP_ALIVE, "ድምጽ ዝግጁ አድርግ (መዘግየትን ይቀንሳል)");
        set(AUDIO_BUFFER, "የድምጽ ማጠራቀሚያ (hardware)");
        set(PROCESSING_CHUNK, "የሂደት መጠን");
        set(PERFORMANCE_HINT, "ድምጹ የሚቆራረጥ ከሆነ ማጠራቀሚያውን ይጨምሩ። መዘግየት ካለ ይቀንሱ።");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "የሚደገፉ ግብዓቶች፡ ኪቦርድ፣ ንክኪ ስክሪን፣ ማውስ ወይም የUSB መጫኛ።\n\n" +
                "ለአይጥ ግራ/ቀኝ ጠቅታ ቁልፍ ወይም ዩኤስቢ-ወደ-አይጥ መቅዘፊያ አስማሚ፣ የአይጥ ጠቋሚውን በስክሪኑ ውስጥ ባለው የግራ መቅዘፊያ ቁልፍ ላይ ይተዉት፣ ግራ/ቀኝ ጠቅታ ወደ ትክክለኛው መቅዘፊያ ካርታ ይሆናል።\n\n" +
                "ለUSB ኪቦርድ (ለምሳሌ VBand) ያለ ምንም ቅንብር ወዲያውኑ ይሰራል።\n\n" +
                "ትክክለኛ ሞድ በፊደላት መካከል ጥብቅ ሰዓት ይፈልጋል፤ ተራ ሞድ ፈጣን ስራ ይፈቅዳል።\n\n" +
                "የተለመዱ ችግሮች፡ ድምጹ በጣም ጠቅታ ካለው 'Sawtooth' ይሞክሩ። መዘግየት ካለ Buffer ይቀንሱ።\n\n" +
                "የኪቦርድ ቁልፎች፡\n" +
                "  ግራ፡ [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  ቀኝ፡ ]  D  S  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "ቁልፍ");
        
        set(SYSTEM_SETTING, "የስርዓቱ ቅንብር");
        set(DARK_THEME, "ጥቁር ገጽታ");
        set(LIGHT_THEME, "ነጭ ገጽታ");
        
        set(MODE_STRAIGHT, "ቀጥተኛ ቁልፍ");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (ግማሽ-አውቶማቲክ)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "ፊደላት");
        set(CAT_NUMBERS, "ቁጥሮች");
        set(CAT_SYMBOLS, "ምልክቶች");
        set(CAT_SPECIAL_SYMBOLS, "ልዩ ምልክቶች");
        set(CAT_SPECIAL, "ልዩ ፊደላት");
        set(CAT_PROSIGNS_COMMON, "የተለመዱ የአሰራር ምልክቶች");
        set(CAT_ABBREVIATIONS, "የተለመዱ አህጽሮተ ቃላት");
        set(CAT_QCODES, "Q ኮዶች");
        set(CAT_PROSIGNS_OTHER, "ሌሎች የአሰራር ምልክቶች");

        set(COLOR_WHITE, "ነጭ");
        set(COLOR_BLACK, "ጥቁር");
        set(COLOR_RED, "ቀይ");
        set(COLOR_ORANGE, "ብርቱካን");
        set(COLOR_YELLOW, "ቢጫ");
        set(COLOR_GREEN, "አረንጓዴ");
        set(COLOR_CYAN, "ውሃ ሰማያዊ");
        set(COLOR_BLUE, "ሰማያዊ");
        set(COLOR_PURPLE, "ወይን ጠጅ");
        set(COLOR_PINK, "ሮዝ");
        set(SUPPORT_WINDLEREYE, "የሙዚቃ ፕሮጀክቴን Windlereye በማዳመጥ ይደግፉኝ");
        set(CANCEL, "ሰርዝ");
        set(QUIT, "ውጣ");
        set(QUIT_GAME_PROMPT, "በእርግጥ ከዚህ ጨዋታ መውጣት ይፈልጋሉ?");

        set(SCORE, "ነጥብ: ");
        set(HIGH_SCORE, "ከፍተኛ ነጥብ");
        set(YOUR_HIGH_SCORE_IS, "የእርስዎ ከፍተኛ ነጥብ:");
        set(TIME, "ጊዜ: ");
                set(MATCH_COMPLETED, "ግጥሚያው ተጠናቋል");
        set(TRY_AGAIN, "እንደገና ሞክር");
        set(WORDS, "ቃላት");
                set(QUIT_GAME, "ጨዋታውን አቋርጥ");
        set(MATCH_SETTINGS, "የጨዋታ መለኪያዎች");
        set(SHARE_PREVIEW, "ቅድመ እይታን አጋራ");
        set(SHARE, "አጋራ");
        set(SHARE_SUBJECT, "የሞርስ ኬየር ነጥቤን በማጋራት ላይ");
        set(SHARE_PROMO_TEXT, "ሞርስ ኪየርን በ https://morsetraining.com ላይ በነጻ ይጫወቱ");
        set(THEME, "ጭብጥ");

        set(MATCH_RESULTS, "የግጥሚያ ውጤቶች");
                
        set(INFINITE, "ያለ የጊዜ ገደብ ይለማመዱ");
        set(THREE_MINUTES, "ነጥብዎን በ 3 ደቂቃዎች ውስጥ ያሸንፉ");

        set(REPEAT, "ድገም");

        set(START, "ጀምር");
        set(PICK_LANG_THEME_ON_SHARE, "ውጤቶችን ሲያጋሩ ቋንቋ እና ገጽታ ይምረጡ");
        set(GAMES, "ጨዋታዎች");
        set(CONTINUE, "ቀጥል");
        set(RX, "ተቀበል");
        set(TX, "አስተላልፍ");
}
}
