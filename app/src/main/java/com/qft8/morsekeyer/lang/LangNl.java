package com.qft8.morsekeyer.lang;

public class LangNl extends MorseLanguage {
    public LangNl() {
        set(SAVE, "Opslaan");
        set(RESET_DEFAULTS, "Standaardwaarden herstellen");
        set(CLOSE, "Sluiten");
        
        set(SETTINGS_TITLE, "Instellingen");
        set(TONE, "Toon");
        set(USER_INTERFACE, "Gebruikersinterface");
        set(ADVANCED, "Geavanceerd (prestaties)");
        set(DECODER_BEHAVIOR, "Decodergedrag");

        set(KEY_MODE, "Sleutelmodus");
        set(WPM_SPEED, "WPM-snelheid");
        set(INVERSE_PADDLES, "Omgekeerde paddles");
        set(STRICT_TIMING, "Strikte timing");
        set(INTERLETTER_SPACING, "Afstand tussen letters");
        set(INTERWORD_SPACING, "Afstand tussen woorden");
        
        set(FREQUENCY, "Frequentie");
        set(VOLUME, "Volume");
        set(ENVELOPE, "Stijg-/daaltijd (envelope)");
        set(NOCLICK, "Gebruik zaagtandsignaal om klikken te voorkomen");
        
        set(LANGUAGE, "Taal");
        set(KEYBOARD_TYPE, "Toetsenbordtype");
        set(SHOW_TABLE, "Toon Morsetabel");
        set(SHOW_TABLE_CODES, "Toon punten en strepen in morsetabel");
        set(SHOW_VISUAL, "Toon visuele indicator");
        set(SHOW_PADDLES, "Toon schermpaddles");
        set(NEXT_WORD_INDICATOR, "Volgend woord-indicator");
        set(KEEP_SCREEN_ON, "Scherm aanhouden zolang de app actief is");
        set(APP_THEME, "App-thema");
        set(TEXT_COLOR, "Tekstkleur");
        set(TEXT_FONT_SIZE, "Tekstgrootte");
        set(TABLE_FONT_SIZE, "Tabellettergrootte");
        set(TABLE_RATIO, "Verhouding tabel tot tekstscherm");
        
        set(COLOR_WHITE, "Wit");
        set(COLOR_BLACK, "Zwart");
        set(COLOR_RED, "Rood");
        set(COLOR_ORANGE, "Oranje");
        set(COLOR_YELLOW, "Geel");
        set(COLOR_GREEN, "Groen");
        set(COLOR_CYAN, "Cyaan");
        set(COLOR_BLUE, "Blauw");
        set(COLOR_PURPLE, "Paars");
        set(COLOR_PINK, "Roze");
        
        set(KEEP_ALIVE, "Houd audio actief (verlaagt latentie)");
        set(AUDIO_BUFFER, "Audiobuffer (hardware)");
        set(PROCESSING_CHUNK, "Verwerkingschunk");
        set(PERFORMANCE_HINT, "Als het geluid hapert, vergroot dan de buffer of chunk. Als de latentie hoog is, verklein ze dan.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Ondersteunde invoer: toetsenbord, touchscreen, muis of een paddle met USB-adapter.\n\n" +
                "Voor morsecode via de linker-/rechtermuisknop of een USB-naar-muis paddle-adapter, laat u de muisaanwijzer boven de linker paddle-knop op het scherm staan. Linker-/rechtermuisklikken worden dan aan de juiste paddles toegewezen.\n\n" +
                "Een USB-naar-toetsenbord paddle-adapter werkt direct (bijv. getest met VBand) - laat het me weten als dit niet het geval is.\n\n" +
                "Strikte modus vereist de juiste timing tussen letters, niet-strikte modus staat snellere manipulatie toe.\n\n" +
                "Veelvoorkomende problemen: Als het geluid te veel klikt op uw apparaat, probeer dan de optie 'Zaagtandsignaal' of pas de stijg-/daaltijd aan. Als de latentie te hoog is, probeer dan de buffer te verkleinen. Als het geluid hapert, probeer het dan te vergroten.\n\n" +
                "Toetsenbordtoetsen:\n" +
                "  Links: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Rechts: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Sleutel");
        
        set(SYSTEM_SETTING, "Systeeminstelling");
        set(DARK_THEME, "Donker thema");
        set(LIGHT_THEME, "Licht thema");
        
        set(MODE_STRAIGHT, "Recht (Straight)");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug");
        set(MODE_COOTIE, "Cootie");
        
        set(CAT_LETTERS, "LETTERS");
        set(CAT_NUMBERS, "CIJFERS");
        set(CAT_SYMBOLS, "SYMBOLEN");
        set(CAT_SPECIAL_SYMBOLS, "SPECIALE SYMBOLEN");
        set(CAT_SPECIAL, "SPECIALE LETTERS");
        set(CAT_PROSIGNS_COMMON, "VEELVOORKOMENDE PROCEDURESIGNALEN");
        set(CAT_ABBREVIATIONS, "VEELVOORKOMENDE AFKORTINGEN");
        set(CAT_QCODES, "Q-CODES");
        set(CAT_PROSIGNS_OTHER, "ANDRE PROCEDURESIGNALEN");
        set(SUPPORT_WINDLEREYE, "Steun me door naar mijn muziekproject Windlereye te luisteren");
        set(CANCEL, "Annuleren");
        set(QUIT, "Afsluiten");
        set(QUIT_GAME_PROMPT, "Weet je zeker dat je dit spel wilt afsluiten?");
        set(WORDS, "Woorden");
                set(QUIT_GAME, "Sluiten");
        set(MATCH_SETTINGS, "Spelparameters");
        set(SHARE_PREVIEW, "Voorbeeld");
        set(GAMES, "Spellen");
        set(SHARE, "Delen");
        set(SHARE_SUBJECT, "Mijn score");
        set(SHARE_PROMO_TEXT, "Speel op https://morsetraining.com");
        set(THEME, "Thema");

        set(MATCH_RESULTS, "Resultaten");
        set(TIME, "Tijd: ");
        set(TRY_AGAIN, "Probeer het opnieuw");
        set(SCORE, "Score: ");
        set(MATCH_COMPLETED, "Wedstrijd voltooid");
        set(HIGH_SCORE, "Hoge score");

                

        set(REPEAT, "HERHALEN");

        set(START, "START");
        set(PICK_LANG_THEME_ON_SHARE, "Kies taal en thema bij het delen van partituren");
        set(CONTINUE, "DOORGAAN");
        set(RX, "Ontvangen");
        set(TX, "Zenden");

        set(KOCH_METHOD, "Koch-methode");
        set(TARGET, "Doel");
        set(LISTEN, "Luister");
        set(TARGET_MET, "Doel bereikt");
        set(TARGET_NOT_MET, "Doel niet bereikt");
            set(LEVEL, "Niveau");
    
        set(LEARN, "Leren");
        set(PLAY, "Spelen");
    
        set(LEVELS_COMPLETED, "Voltooide niveaus");
        set(RESET_PROGRESS, "Voortgang resetten");
        set(RESET_PROGRESS_CONFIRM, "Weet u zeker dat u de voortgang wilt resetten?");
        set(RESET, "Resetten");
            set(WPM, "WPM​");
        set(SPACING, "Afstand");
    }
}