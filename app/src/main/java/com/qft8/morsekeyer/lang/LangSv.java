package com.qft8.morsekeyer.lang;

public class LangSv extends MorseLanguage {
    public LangSv() {
        set(SAVE, "Spara");
        set(RESET_DEFAULTS, "Återställ standard");
        set(CLOSE, "Stäng");
        
        set(SETTINGS_TITLE, "Inställningar");
        set(TONE, "Ton");
        set(USER_INTERFACE, "Användargränssnitt");
        set(ADVANCED, "Avancerat (prestanda)");
        set(DECODER_BEHAVIOR, "Dekoderbeteende");

        set(KEY_MODE, "Nyckelläge");
        set(WPM_SPEED, "Hastighet (WPM)");
        set(INVERSE_PADDLES, "Inverterade paddlar");
        set(STRICT_TIMING, "Strikt timing");
        set(INTERLETTER_SPACING, "Bokstavsavstånd");
        set(INTERWORD_SPACING, "Ordavstånd");
        
        set(FREQUENCY, "Frekvens");
        set(VOLUME, "Volym");
        set(ENVELOPE, "Stig/falltid (envelope)");
        set(NOCLICK, "Sagtandssignal (undviker klick)");
        
        set(LANGUAGE, "Språk");
        set(KEYBOARD_TYPE, "Tangentbordstyp");
        set(SHOW_TABLE, "Visa morse-tabell");
        set(SHOW_TABLE_CODES, "Visa punkter och streck i morse-tabellen");
        set(SHOW_VISUAL, "Visa visuell indikator");
        set(SHOW_PADDLES, "Visa skärmpaddlar");
        set(NEXT_WORD_INDICATOR, "Indikator för nästa ord");
        set(KEEP_SCREEN_ON, "Håll skärmen vaken");
        set(APP_THEME, "App-tema");
        set(TEXT_COLOR, "Textfärg");
        set(TEXT_FONT_SIZE, "Textstorlek");
        set(TABLE_FONT_SIZE, "Tabellstorlek");
        set(TABLE_RATIO, "Förhållande tabell/text");
        
        set(KEEP_ALIVE, "Håll ljudet aktivt (minskar latens)");
        set(AUDIO_BUFFER, "Ljudbuffer (hårdvara)");
        set(PROCESSING_CHUNK, "Bearbetningsenhet");
        set(PERFORMANCE_HINT, "Om ljudet hackar, öka buffert eller enhet. Vid hög latens, minska dem.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Ingångar som stöds: tangentbord, pekskärm, mus eller manipulatör med USB-adapter.\n\n" +
                "För nyckling med vänster/högerklick på musen eller USB-till-mus-paddeladapter, lämna muspekaren över den vänstra paddelknappen på skärmen, vänster/högerklick kommer att mappas till rätt paddlar.\n\n" +
                "USB-tangentbordsadaptrar (t.ex. VBand) fungerar direkt utan inställningar.\n\n" +
                "Strikt läge kräver korrekt timing; icke-strikt läge tillåter snabbare manipulering.\n\n" +
                "Vanliga problem: Om ljudet klickar för mycket, prova sagtandssignalen eller justera envelopen. Vid hög latens, minska bufferten.\n\n" +
                "Tangentbordsknappar:\n" +
                "  Vänster: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Höger: ]  D  S  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Nyckel");
        
        set(SYSTEM_SETTING, "Systeminställning");
        set(DARK_THEME, "Mörkt tema");
        set(LIGHT_THEME, "Ljust tema");
        
        set(MODE_STRAIGHT, "Rak nyckel");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Halvautomatisk)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "BOKSTÄVER");
        set(CAT_NUMBERS, "SIFFROR");
        set(CAT_SYMBOLS, "SYMBOLER");
        set(CAT_SPECIAL_SYMBOLS, "SPECIALSYMBOLER");
        set(CAT_SPECIAL, "SPECIALBOKSTÄVER");
        set(CAT_PROSIGNS_COMMON, "VANLIGA PROCEDURTECKEN");
        set(CAT_ABBREVIATIONS, "VANLIGA FÖRKORTNINGAR");
        set(CAT_QCODES, "Q-KODER");
        set(CAT_PROSIGNS_OTHER, "Övriga tecken");

        set(COLOR_WHITE, "Vit");
        set(COLOR_BLACK, "Svart");
        set(COLOR_RED, "Röd");
        set(COLOR_ORANGE, "Orange");
        set(COLOR_YELLOW, "Gul");
        set(COLOR_GREEN, "Grön");
        set(COLOR_CYAN, "Cyan");
        set(COLOR_BLUE, "Blå");
        set(COLOR_PURPLE, "Lila");
        set(COLOR_PINK, "Rosa");
        set(SUPPORT_WINDLEREYE, "Stöd mig genom att lyssna på mitt musikprojekt Windlereye");
        set(CANCEL, "Avbryt");
        set(QUIT, "Avsluta");
        set(QUIT_GAME_PROMPT, "Är du säker på att du vill avsluta det här spelet?");

        set(SCORE, "Poäng: ");
        set(HIGH_SCORE, "Hög poäng");
        set(YOUR_HIGH_SCORE_IS, "Ditt högsta poäng är:");
        set(TIME, "Tid: ");
                set(MATCH_COMPLETED, "Matchen är klar");
        set(TRY_AGAIN, "Försök igen");
        set(WORDS, "Ord");
                set(QUIT_GAME, "Avsluta");
        set(MATCH_SETTINGS, "Spelparametrar");
        set(SHARE_PREVIEW, "Förhandsgranska");
        set(GAMES, "Spel");
        set(SHARE, "Dela");
        set(SHARE_SUBJECT, "Delar min poäng");
        set(SHARE_PROMO_TEXT, "Spela på https://morsetraining.com");
        set(THEME, "Tema");

        set(MATCH_RESULTS, "Resultat");
                
        set(INFINITE, "Öva utan tidsbegränsning");
        set(THREE_MINUTES, "Slå din poäng på 3 minuter");

        set(REPEAT, "UPPREPA");

        set(START, "STARTA");
        set(PICK_LANG_THEME_ON_SHARE, "Välj språk och tema när du delar poäng");
        set(CONTINUE, "FORTSÄTTA");
        set(RX, "Motta");
        set(TX, "Sända");
}
}
