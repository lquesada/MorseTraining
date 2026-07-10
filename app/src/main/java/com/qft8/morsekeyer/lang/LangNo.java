package com.qft8.morsekeyer.lang;

public class LangNo extends MorseLanguage {
    public LangNo() {
        set(SAVE, "Lagre");
        set(RESET_DEFAULTS, "Tilbakestill til standard");
        set(CLOSE, "Lukk");
        
        set(SETTINGS_TITLE, "Innstillinger");
        set(TONE, "Tone");
        set(USER_INTERFACE, "Brukergrensesnitt");
        set(ADVANCED, "Avansert (ytelse)");
        set(DECODER_BEHAVIOR, "Dekoderoppførsel");

        set(KEY_MODE, "Nøkkelmodus");
        set(WPM_SPEED, "WPM-hastighet");
        set(INVERSE_PADDLES, "Omvendte padler");
        set(STRICT_TIMING, "Streng timing");
        
        set(FREQUENCY, "Frekvens");
        set(VOLUME, "Volum");
        set(ENVELOPE, "Stige-/falltid (envelope)");
        set(NOCLICK, "Bruk sagtonnsignal for å unngå klikk");
        
        set(LANGUAGE, "Språk");
        set(KEYBOARD_TYPE, "Tastaturtype");
        set(SHOW_TABLE, "Vis morsetabell");
        set(SHOW_TABLE_CODES, "Vis prikker og streker i morsetabell");
        set(SHOW_VISUAL, "Vis visuell indikator");
        set(SHOW_PADDLES, "Vis skjermpadler");
        set(NEXT_WORD_INDICATOR, "Neste ord-indikator");
        set(KEEP_SCREEN_ON, "Hold skjermen på mens appen er aktiv");
        set(APP_THEME, "App-tema");
        set(TEXT_COLOR, "Tekstfarge");
        set(TEXT_FONT_SIZE, "Tekststørrelse");
        set(TABLE_FONT_SIZE, "Tabellskriftstørrelse");
        set(TABLE_RATIO, "Forhold mellom tabell og tekstskjerm");
        
        set(COLOR_WHITE, "Hvit");
        set(COLOR_BLACK, "Svart");
        set(COLOR_RED, "Rød");
        set(COLOR_ORANGE, "Oransje");
        set(COLOR_YELLOW, "Gul");
        set(COLOR_GREEN, "Grønn");
        set(COLOR_CYAN, "Cyan");
        set(COLOR_BLUE, "Blå");
        set(COLOR_PURPLE, "Lilla");
        set(COLOR_PINK, "Rosa");
        
        set(KEEP_ALIVE, "Hold lyd i live (senker forsinkelse)");
        set(WHITE_NOISE, "Sterkere (spill hvit støy)");
        set(AUDIO_BUFFER, "Lydbuffer (maskinvare)");
        set(PROCESSING_CHUNK, "Behandlingschunk");
        set(PERFORMANCE_HINT, "Hvis lyden hakker, øk bufferen eller chunken. Hvis forsinkelsen er høy, senk dem.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Støttede innganger: tastatur, berøringsskjerm, mus, eller en padle med USB-adapter.\n\n" +
                "For tasting med venstre/høyre museklikk eller USB-til-mus padleadapter, la musepekeren hvile over venstre padle-knapp på skjermen, så vil venstre/høyreklikk tilordnes de riktige padlene.\n\n" +
                "For en USB-til-tastatur padleadapter fungerer det rett ut av boksen (f.eks. testet med VBand) - gi meg beskjed hvis det ikke gjør det.\n\n" +
                "Streng modus krever nøyaktig timing mellom bokstaver, ikke-streng modus tillater raskere manipulering.\n\n" +
                "Vanlige problemer: Hvis lyden klikker for mye på enheten din, prøv 'sagtonnsignal'-alternativet eller prøv å endre stige-/falltiden. Hvis forsinkelsen er for høy, prøv å redusere bufferen. Hvis lyden brytes opp, prøv å øke den.\n\n" +
                "Tastaturtaster:\n" +
                "  Venstre: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Høyre: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Nøkkel");
        
        set(SYSTEM_SETTING, "Systeminnstilling");
        set(DARK_THEME, "Mørkt tema");
        set(LIGHT_THEME, "Lyst tema");
        
        set(MODE_STRAIGHT, "Rett (Straight)");
        set(MODE_IAMBIC_A, "Jambisk A");
        set(MODE_IAMBIC_B, "Jambisk B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug");
        set(MODE_COOTIE, "Cootie");
        
        set(CAT_LETTERS, "BOKSTAVER");
        set(CAT_NUMBERS, "TALL");
        set(CAT_SYMBOLS, "SYMBOLER");
        set(CAT_SPECIAL_SYMBOLS, "SPESIELLE SYMBOLER");
        set(CAT_SPECIAL, "SPESIELLE BOKSTAVER");
        set(CAT_PROSIGNS_COMMON, "VANLIGE PROSEDYRESIGNALER");
        set(CAT_ABBREVIATIONS, "VANLIGE FORKORTELSER");
        set(CAT_QCODES, "Q-KODER");
        set(CAT_PROSIGNS_OTHER, "ANDRE PROSEDYRESIGNALER");
        set(SUPPORT_WINDLEREYE, "Støtt meg ved å lytte til musikkprosjektet mitt Windlereye");
        set(CANCEL, "Avbryt");
        set(QUIT, "Avslutt");
        set(QUIT_GAME_PROMPT, "Er du sikker på at du vil avslutte dette spillet?");
        set(WORDS, "Ord");
                set(QUIT_GAME, "Avslutt");
        set(MATCH_SETTINGS, "Spillparametere");
        set(SHARE_PREVIEW, "Forhåndsvisning");
        set(GAMES, "Spill");
        set(SHARE, "Del");
        set(SHARE_SUBJECT, "Deler min poengsum");
        set(SHARE_PROMO_TEXT, "Spill på https://morsetraining.com");
        set(THEME, "Tema");

        set(MATCH_RESULTS, "Resultater");
        set(TIME, "Tid");
        set(TRY_AGAIN, "Prøv igjen");
        set(SCORE, "Poengsum");
        set(MATCH_COMPLETED, "Kamp fullført");
        set(HIGH_SCORE, "Høy score");

                

        set(REPEAT, "GJENTA");

        set(START, "START");
        set(PICK_LANG_THEME_ON_SHARE, "Velg språk og tema når du deler poeng");
        set(CONTINUE, "FORTSETTE");
        set(RX, "Motta");
        set(TX, "Sende");

        set(KOCH_METHOD, "Koch-metoden");
        set(TARGET, "Mål");
set(TARGET_MET, "Mål nådd");
        set(TARGET_NOT_MET, "Mål ikke nådd");
            set(LEVEL, "Nivå");
    
        set(LEARN, "Lær");
        set(PLAY, "Spill");
    
        set(LEVELS_COMPLETED, "Fullførte nivåer");
        set(RESET_PROGRESS, "Nullstill fremdrift");
        set(RESET_PROGRESS_CONFIRM, "Er du sikker på at du vil nullstille fremdriften?");
        set(RESET, "Nullstill");
            set(WPM, "WPM​");
        set(BACK, "Tilbake");
        set(NEXT_LEVEL, "Neste nivå");

                set(EFFECTIVE_WPM_FARNSWORTH, "Effektiv WPM (Farnsworth)");
                set(EXTRA_WORD_SPACING, "Ordmellomrom");
                set(EFFECTIVE_WPM_SHORT, "Effektiv");

                set(WORD_SPACING_ADD, "Ord +");
    }
}