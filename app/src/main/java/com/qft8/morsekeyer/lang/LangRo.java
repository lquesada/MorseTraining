package com.qft8.morsekeyer.lang;

public class LangRo extends MorseLanguage {
    public LangRo() {
        set(SAVE, "Salvează");
        set(RESET_DEFAULTS, "Resetează la valorile implicite");
        set(CLOSE, "Închide");
        
        set(SETTINGS_TITLE, "Setări");
        set(TONE, "Ton");
        set(USER_INTERFACE, "Interfață utilizator");
        set(ADVANCED, "Avansat (performanță)");
        set(DECODER_BEHAVIOR, "Comportament decodificator");

        set(KEY_MODE, "Mod manipulator");
        set(WPM_SPEED, "Viteză (WPM)");
        set(INVERSE_PADDLES, "Inversează padelele");
        set(STRICT_TIMING, "Temporizare strictă");
        
        set(FREQUENCY, "Frecvență");
        set(VOLUME, "Volum");
        set(ENVELOPE, "Timp de creștere/scădere (anvelopă)");
        set(NOCLICK, "Semnal dinte de fierăstrău pentru a evita clicul");
        
        set(LANGUAGE, "Limbă");
        set(KEYBOARD_TYPE, "Tip tastatură");
        set(SHOW_TABLE, "Afișează tabelul Morse");
        set(SHOW_TABLE_CODES, "Afișează punctele și liniile în tabelul Morse");
        set(SHOW_VISUAL, "Afișează indicatorul vizual");
        set(SHOW_PADDLES, "Afișează padelele pe ecran");
        set(NEXT_WORD_INDICATOR, "Indicator cuvânt următor");
        set(KEEP_SCREEN_ON, "Menține ecranul aprins");
        set(APP_THEME, "Temă aplicație");
        set(TEXT_COLOR, "Culoare text");
        set(TEXT_FONT_SIZE, "Dimensiune font text");
        set(TABLE_FONT_SIZE, "Dimensiune font tabel");
        set(TABLE_RATIO, "Proporție tabel/ecran");
        
        set(KEEP_ALIVE, "Menține audio activ (reduce latența)");
        set(WHITE_NOISE, "Mai puternic (redă zgomot alb)");
        set(AUDIO_BUFFER, "Buffer audio (hardware)");
        set(PROCESSING_CHUNK, "Fragment de procesare");
        set(PERFORMANCE_HINT, "Dacă sunetul se întrerupe, mărește bufferul. Dacă latența e mare, redu-l.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Intrări suportate: tastatură, ecran tactil, mouse sau manipulator cu adaptor USB.\n\n" +
                "Pentru manipularea cu clic stânga/dreapta al mouse-ului sau cu un adaptor pentru padele USB la mouse, lăsați indicatorul mouse-ului deasupra butonului padelei din stânga de pe ecran, clicul stânga/dreapta se va mapa la padelele corecte.\n\n" +
                "Pentru adaptoare de tastatură USB (ex: VBand), funcționează direct fără setări.\n\n" +
                "Modul strict necesită timp precis între litere; modul non-strict permite manipulare mai rapidă.\n\n" +
                "Probleme comune: Dacă sunetul are prea multe clicuri, încearcă opțiunea 'Dinte de fierăstrău' sau modifică anvelopa. Dacă latența e mare, redu bufferul.\n\n" +
                "Taste tastatură:\n" +
                "  Stânga: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Dreapta: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Cheie");
        
        set(SYSTEM_SETTING, "Setare sistem");
        set(DARK_THEME, "Temă întunecată");
        set(LIGHT_THEME, "Temă luminoasă");
        
        set(MODE_STRAIGHT, "Cheie verticală");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Semi-automat)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "LITERE");
        set(CAT_NUMBERS, "CIFRE");
        set(CAT_SYMBOLS, "SIMBOLURI");
        set(CAT_SPECIAL_SYMBOLS, "SIMBOLURI SPECIALE");
        set(CAT_SPECIAL, "LITERE SPECIALE");
        set(CAT_PROSIGNS_COMMON, "SEMNALE DE PROCEDURĂ COMUNE");
        set(CAT_ABBREVIATIONS, "ABREVIERI COMUNE");
        set(CAT_QCODES, "CODURI Q");
        set(CAT_PROSIGNS_OTHER, "ALTE SEMNALE DE PROCEDURĂ");

        set(COLOR_WHITE, "Alb");
        set(COLOR_BLACK, "Negru");
        set(COLOR_RED, "Roșu");
        set(COLOR_ORANGE, "Portocaliu");
        set(COLOR_YELLOW, "Galben");
        set(COLOR_GREEN, "Verde");
        set(COLOR_CYAN, "Cian");
        set(COLOR_BLUE, "Albastru");
        set(COLOR_PURPLE, "Violet");
        set(COLOR_PINK, "Roz");
        set(SUPPORT_WINDLEREYE, "Susține-mă ascultând proiectul meu muzical Windlereye");
        set(CANCEL, "Anulează");
        set(QUIT, "Ieși");
        set(QUIT_GAME_PROMPT, "Ești sigur că vrei să părăsești acest joc?");

        set(SCORE, "Scor");
        set(HIGH_SCORE, "Scor mare");
        set(YOUR_HIGH_SCORE_IS, "Cel mai mare scor al tău este");
        set(TIME, "Timp");
                set(MATCH_COMPLETED, "Meci complet");
        set(TRY_AGAIN, "Încearcă din nou");
        set(WORDS, "Cuvinte");
                set(QUIT_GAME, "Ieși din joc");
        set(MATCH_SETTINGS, "Parametrii jocului");
        set(SHARE_PREVIEW, "Partajați previzualizarea");
        set(GAMES, "Jocuri");
        set(SHARE, "Distribuie");
        set(SHARE_SUBJECT, "Împărtășesc scorul meu Morse Training");
        set(SHARE_PROMO_TEXT, "Joacă Morse Training gratuit la https://morsetraining.com");
        set(THEME, "Temă");

        set(MATCH_RESULTS, "Rezultatele meciului");
                

        set(REPEAT, "REPETĂ");

        set(START, "START");
        set(PICK_LANG_THEME_ON_SHARE, "Alege limba și tema la partajarea scorurilor");
        set(CONTINUE, "CONTINUA");
        set(RX, "Primi");
        set(TX, "Transmite");

        set(KOCH_METHOD, "Metoda Koch");
        set(TARGET, "Țintă");
set(TARGET_MET, "Țintă atinsă");
        set(TARGET_NOT_MET, "Țintă neatinsă");
            set(LEVEL, "Nivel");
    
        set(LEARN, "Învață");
        set(PLAY, "Joacă");
    
        set(LEVELS_COMPLETED, "Niveluri completate");
        set(RESET_PROGRESS, "Resetează progresul");
        set(RESET_PROGRESS_CONFIRM, "Sigur vrei să resetezi progresul?");
        set(RESET, "Resetează");
            set(WPM, "WPM​");
        set(BACK, "Înapoi");
        set(NEXT_LEVEL, "Nivelul următor");

                set(EFFECTIVE_WPM_FARNSWORTH, "WPM efectiv (Farnsworth)");
                set(EXTRA_WORD_SPACING, "Spațiu suplimentar între cuvinte");
                set(EFFECTIVE_WPM_SHORT, "Efectiv");

                set(WORD_SPACING_ADD, "Cuvânt +");
    }
}