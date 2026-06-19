package com.qft8.morsekeyer.lang;

public class LangDa extends MorseLanguage {
    public LangDa() {
        set(SAVE, "Gem");
        set(RESET_DEFAULTS, "Nulstil til standard");
        set(CLOSE, "Luk");
        
        set(SETTINGS_TITLE, "Indstillinger");
        set(TONE, "Tone");
        set(USER_INTERFACE, "Brugergrænseflade");
        set(ADVANCED, "Avanceret (ydeevne)");
        set(DECODER_BEHAVIOR, "Dekoderadfærd");

        set(KEY_MODE, "Nøgletilstand");
        set(WPM_SPEED, "WPM-hastighed");
        set(INVERSE_PADDLES, "Omvendte padler");
        set(STRICT_TIMING, "Streng timing");
        set(INTERLETTER_SPACING, "Mellemrum mellem bogstaver");
        set(INTERWORD_SPACING, "Mellemrum mellem ord");
        
        set(FREQUENCY, "Frekvens");
        set(VOLUME, "Lydstyrke");
        set(ENVELOPE, "Stige-/faldetid (konvolut)");
        set(NOCLICK, "Brug savtaksignal for at undgå klik");
        
        set(LANGUAGE, "Sprog");
        set(KEYBOARD_TYPE, "Tastaturtype");
        set(SHOW_TABLE, "Vis morsetabel");
        set(SHOW_TABLE_CODES, "Vis prikker og streger i morsetabel");
        set(SHOW_VISUAL, "Vis visuel indikator");
        set(SHOW_PADDLES, "Vis skærmpadler");
        set(NEXT_WORD_INDICATOR, "Næste ord-indikator");
        set(KEEP_SCREEN_ON, "Hold skærmen tændt, mens appen er aktiv");
        set(APP_THEME, "App-tema");
        set(TEXT_COLOR, "Tekstfarve");
        set(TEXT_FONT_SIZE, "Tekstskriftstørrelse");
        set(TABLE_FONT_SIZE, "Tabelskriftstørrelse");
        set(TABLE_RATIO, "Forholdet mellem tabel og tekstskærm");
        
        set(COLOR_WHITE, "Hvid");
        set(COLOR_BLACK, "Sort");
        set(COLOR_RED, "Rød");
        set(COLOR_ORANGE, "Orange");
        set(COLOR_YELLOW, "Gul");
        set(COLOR_GREEN, "Grøn");
        set(COLOR_CYAN, "Cyan");
        set(COLOR_BLUE, "Blå");
        set(COLOR_PURPLE, "Lilla");
        set(COLOR_PINK, "Lyserød");
        
        set(KEEP_ALIVE, "Hold lyden i live (sænker forsinkelsen)");
        set(WHITE_NOISE, "Stærkere (afspil hvid støj)");
        set(AUDIO_BUFFER, "Lydbuffer (hardware)");
        set(PROCESSING_CHUNK, "Behandlingschunk");
        set(PERFORMANCE_HINT, "Hvis lyden afbrydes, skal du øge bufferen eller chunken. Hvis forsinkelsen er høj, skal du mindske dem.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Understøttede input: tastatur, berøringsskærm, mus eller en padle med USB-adapter.\n\n" +
                "For venstre/højreklik-tastning med mus eller USB-til-mus-padleadapter skal du lade musemarkøren svæve over venstre padle-knap på skærmen, og venstre/højreklik vil blive knyttet til de korrekte padler.\n\n" +
                "For en USB-til-tastatur-padleadapter virker det ud af boksen (f.eks. testet med VBand) - lad mig vide, hvis det ikke gør.\n\n" +
                "Streng tilstand kræver korrekt timing mellem bogstaver, ikke-streng tilstand tillader hurtigere manipulation.\n\n" +
                "Almindelige problemer: Hvis lyden er for klikkende på din enhed, kan du prøve 'Brug savtaksignal for at undgå klik'-indstillingen eller prøve at ændre stige-/faldetiden. Hvis forsinkelsen er for høj, kan du prøve at mindske bufferen. Hvis lyden hakker, kan du prøve at øge den.\n\n" +
                "Tastaturtaster:\n" +
                "  Venstre: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Højre: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Nøgle");
        
        set(SYSTEM_SETTING, "Systemindstilling");
        set(DARK_THEME, "Mørkt tema");
        set(LIGHT_THEME, "Lyst tema");
        
        set(MODE_STRAIGHT, "Lige (Straight)");
        set(MODE_IAMBIC_A, "Jambisk A");
        set(MODE_IAMBIC_B, "Jambisk B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug");
        set(MODE_COOTIE, "Cootie");
        
        set(CAT_LETTERS, "BOGSTAVER");
        set(CAT_NUMBERS, "TAL");
        set(CAT_SYMBOLS, "SYMBOLER");
        set(CAT_SPECIAL_SYMBOLS, "SPECIELLE SYMBOLER");
        set(CAT_SPECIAL, "SPECIELLE BOGSTAVER");
        set(CAT_PROSIGNS_COMMON, "ALMINDELIGE PROCEDURESIGNALER");
        set(CAT_ABBREVIATIONS, "ALMINDELIGE FORKORTELSER");
        set(CAT_QCODES, "Q-KODER");
        set(CAT_PROSIGNS_OTHER, "ANDRE PROCEDURESIGNALER");
        set(SUPPORT_WINDLEREYE, "Støt mig ved at lytte til mit musikprojekt Windlereye");
        set(CANCEL, "Annuller");
        set(QUIT, "Afslut");
        set(QUIT_GAME_PROMPT, "Er du sikker på, at du vil afslutte dette spil?");
        set(WORDS, "Ord");
                set(QUIT_GAME, "Afslut");
        set(MATCH_SETTINGS, "Spilparametre");
        set(SHARE_PREVIEW, "Forhåndsvisning");
        set(GAMES, "Spil");
        set(SHARE, "Del");
        set(SHARE_SUBJECT, "Deler min score");
        set(SHARE_PROMO_TEXT, "Spil på https://morsetraining.com");
        set(THEME, "Tema");

        set(MATCH_RESULTS, "Resultater");
        set(TIME, "Tid");
        set(TRY_AGAIN, "Prøv igen");
        set(SCORE, "Score");
        set(MATCH_COMPLETED, "Match fuldført");
        set(HIGH_SCORE, "Høj score");

                

        set(REPEAT, "GENTAG");

        set(START, "START");
        set(PICK_LANG_THEME_ON_SHARE, "Vælg sprog og tema, når du deler resultater");
        set(CONTINUE, "FORTSÆTTE");
        set(RX, "Modtage");
        set(TX, "Sende");

        set(KOCH_METHOD, "Koch-metoden");
        set(TARGET, "Mål");
set(TARGET_MET, "Mål nået");
        set(TARGET_NOT_MET, "Mål ikke nået");
            set(LEVEL, "Niveau");
    
        set(LEARN, "Lær");
        set(PLAY, "Spil");
    
        set(LEVELS_COMPLETED, "Gennemførte niveauer");
        set(RESET_PROGRESS, "Nulstil fremskridt");
        set(RESET_PROGRESS_CONFIRM, "Er du sikker på, at du vil nulstille fremskridtet?");
        set(RESET, "Nulstil");
            set(WPM, "WPM​");
        set(SPACING, "Mellemrum");
        set(BACK, "Tilbage");
        set(NEXT_LEVEL, "Næste niveau");
    }
}