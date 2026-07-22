package com.qft8.morsekeyer.lang;

public class LangCa extends MorseLanguage {
    public LangCa() {
        set(SAVE, "Desa");
        set(RESET_DEFAULTS, "Restaura valors per defecte");
        set(CLOSE, "Tanca");

        set(SETTINGS_TITLE, "Configuració");
        set(TONE, "To");
        set(USER_INTERFACE, "Interfície d'usuari");
        set(ADVANCED, "Avançat (rendiment)");
        set(DECODER_BEHAVIOR, "Comportament del decodificador");

        set(KEY_MODE, "Mode del manipulador");
        set(WPM_SPEED, "Velocitat (WPM)");
        set(INVERSE_PADDLES, "Inverteix les pales");
        set(STRICT_TIMING, "Temporització estricta");

        set(FREQUENCY, "Freqüència");
        set(VOLUME, "Volum");
        set(ENVELOPE, "Temps de pujada/baixada (envolvent)");
        set(NOCLICK, "Senyal dent de serra per evitar clics");

        set(LANGUAGE, "Idioma");
        set(KEYBOARD_TYPE, "Tipus de teclat");
        set(SHOW_TABLE, "Mostra la taula Morse");
        set(SHOW_TABLE_CODES, "Mostra punts i ratlles a la taula Morse");
        set(SHOW_VISUAL, "Mostra l'indicador visual");
        set(SHOW_PADDLES, "Mostra les pales en pantalla");
        set(NEXT_WORD_INDICATOR, "Indicador de paraula següent");
        set(KEEP_SCREEN_ON, "Mantén la pantalla encesa");
        set(APP_THEME, "Tema de l'app");
        set(TEXT_COLOR, "Color del text");
        set(TEXT_FONT_SIZE, "Mida de la font del text");
        set(TABLE_FONT_SIZE, "Mida de la font de la taula");
        set(TABLE_RATIO, "Proporció taula/pantalla");

        set(KEEP_ALIVE, "Mantén l'àudio actiu (redueix la latència)");
        set(WHITE_NOISE, "Més fort (reprodueix soroll blanc)");
        set(AUDIO_BUFFER, "Búfer d'àudio (hardware)");
        set(PROCESSING_CHUNK, "Fragment de processament");
        set(PERFORMANCE_HINT, "Si el so s'entretalla, augmenta el búfer. Si la latència és alta, redueix-lo.");

        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Entrades compatibles: teclat, pantalla tàctil, ratolí o adaptador de pales USB.\n\nPer a la tecla de clic esquerre/dret del ratolí o l'adaptador de pales USB a ratolí, deixeu el punter del ratolí sobre el botó de la pala esquerra a la pantalla, el clic esquerre/dret s'assignarà a les pales correctes.\n\nPer als adaptadors de pales d'USB a teclat (per exemple, VBand) funciona directament sense configuració.\n\nLa temporització estricta requereix pauses precises entre lletres; la no estricta permet una manipulació més ràpida.\n\nSolució de problemes: Si el so fa clics, proveu Dent de serra o canvieu l'envolvent. Si la latència és alta, reduïu el búfer. Si el so s'entretalla, augmenteu-lo.\n\nTecles del teclat:\n  Esquerra: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  Dreta: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Clau");

        set(SYSTEM_SETTING, "Configuració del sistema");
        set(DARK_THEME, "Tema fosc");
        set(LIGHT_THEME, "Tema clar");

        set(MODE_STRAIGHT, "Clau vertical");
        set(MODE_IAMBIC_A, "Iàmbic A");
        set(MODE_IAMBIC_B, "Iàmbic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Semiautomàtic)");
        set(MODE_COOTIE, "Cootie / Sideswiper");

        set(CAT_LETTERS, "LLETRES");
        set(CAT_NUMBERS, "NÚMEROS");
        set(CAT_SYMBOLS, "SÍMBOLS");
        set(CAT_SPECIAL_SYMBOLS, "SÍMBOLS ESPECIALS");
        set(CAT_SPECIAL, "LLETRES ESPECIALS");
        set(CAT_PROSIGNS_COMMON, "SENYALS DE PROCEDIMENT COMUNS");
        set(CAT_ABBREVIATIONS, "ABREVIATURES COMUNES");
        set(CAT_QCODES, "CODIS Q");
        set(CAT_PROSIGNS_OTHER, "ALTRES SENYALS DE PROCEDIMENT");

        set(COLOR_WHITE, "Blanc");
        set(COLOR_BLACK, "Negre");
        set(COLOR_RED, "Vermell");
        set(COLOR_ORANGE, "Taronja");
        set(COLOR_YELLOW, "Groc");
        set(COLOR_GREEN, "Verd");
        set(COLOR_CYAN, "Cian");
        set(COLOR_BLUE, "Blau");
        set(COLOR_PURPLE, "Lila");
        set(COLOR_PINK, "Rosa");
        set(SUPPORT_WINDLEREYE, "Dóna'm suport escoltant el meu projecte musical Windlereye");
        set(CANCEL, "Cancel·lar");
        set(QUIT, "Sortir");
        set(QUIT_GAME_PROMPT, "Estàs segur que vols sortir d'aquest joc?");

        set(SCORE, "Puntuació");
        set(HIGH_SCORE, "Puntuació alta");
        set(YOUR_HIGH_SCORE_IS, "La teva puntuació més alta és");
        set(TIME, "Temps");
                set(MATCH_COMPLETED, "Partida completada");
        set(TRY_AGAIN, "Torna-ho a provar");
        set(WORDS, "Paraules");
                set(QUIT_GAME, "Surt del joc");
        set(MATCH_SETTINGS, "Paràmetres del joc");
        set(SHARE_PREVIEW, "Comparteix la vista prèvia");
        set(GAMES, "Jocs");
        set(SHARE, "Comparteix");
        set(SHARE_SUBJECT, "Compartint la meva partitura de Morse Training");
        set(SHARE_PROMO_TEXT, "Juga a Morse Training gratuïtament a https://morsetraining.com");
        set(THEME, "Tema");

        set(MATCH_RESULTS, "Resultats del partit");
                

        set(REPEAT, "REPETEIX");
        set(HINT, "PISTA");

        set(START, "INICIA");
        set(PICK_LANG_THEME_ON_SHARE, "Tria idioma i tema en compartir puntuacions");
        set(CONTINUE, "CONTINUA");
        set(RX, "Rebre");
        set(TX, "Transmetre");

        set(KOCH_METHOD, "Mètode Koch");
        set(TARGET, "Objectiu");
set(TARGET_MET, "Objectiu assolit");
        set(TARGET_NOT_MET, "Objectiu no assolit");
            set(LEVEL, "Nivell");
    
        set(LEARN, "Aprèn");
        set(PLAY, "Juga");
    
        set(LEVELS_COMPLETED, "Nivells completats");
        set(RESET_PROGRESS, "Restableix el progrés");
        set(RESET_PROGRESS_CONFIRM, "Estàs segur que vols restablir el progrés?");
        set(RESET, "Restableix");
            set(WPM, "WPM​");
        set(BACK, "Enrere");
        set(NEXT_LEVEL, "Següent nivell");

                set(EFFECTIVE_WPM_FARNSWORTH, "WPM efectiu (Farnsworth)");
                set(EXTRA_WORD_SPACING, "Espaiat");
                set(EFFECTIVE_WPM_SHORT, "Efectiu");

                set(WORD_SPACING_ADD, "Paraula +");
    }
}
