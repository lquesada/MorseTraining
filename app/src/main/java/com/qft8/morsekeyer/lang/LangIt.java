package com.qft8.morsekeyer.lang;

public class LangIt extends MorseLanguage {
    public LangIt() {
        set(SAVE, "Salva");
        set(RESET_DEFAULTS, "Ripristina predefiniti");
        set(CLOSE, "Chiudi");
        
        set(SETTINGS_TITLE, "Impostazioni");
        set(TONE, "Tono");
        set(USER_INTERFACE, "Interfaccia utente");
        set(ADVANCED, "Avanzate (prestazioni)");
        set(DECODER_BEHAVIOR, "Comportamento del decodificatore");

        set(KEY_MODE, "Modo manipolatore");
        set(WPM_SPEED, "Velocità (WPM)");
        set(INVERSE_PADDLES, "Inverti palette");
        set(STRICT_TIMING, "Timing rigoroso");
        set(INTERLETTER_SPACING, "Spaziatura tra lettere");
        set(INTERWORD_SPACING, "Spaziatura tra parole");
        
        set(FREQUENCY, "Frequenza");
        set(VOLUME, "Volume");
        set(ENVELOPE, "Tempo di salita/discesa (inviluppo)");
        set(NOCLICK, "Segnale a dente di sega per evitare clic");
        
        set(LANGUAGE, "Lingua");
        set(KEYBOARD_TYPE, "Tipo di tastiera");
        set(SHOW_TABLE, "Mostra tabella Morse");
        set(SHOW_TABLE_CODES, "Mostra punti e linee nella tabella Morse");
        set(SHOW_VISUAL, "Mostra indicatore visivo");
        set(SHOW_PADDLES, "Mostra palette a schermo");
        set(NEXT_WORD_INDICATOR, "Indicatore parola successiva");
        set(KEEP_SCREEN_ON, "Mantieni schermo acceso");
        set(APP_THEME, "Tema dell'app");
        set(TEXT_COLOR, "Colore del testo");
        set(TEXT_FONT_SIZE, "Dimensione carattere testo");
        set(TABLE_FONT_SIZE, "Dimensione carattere tabella");
        set(TABLE_RATIO, "Rapporto tabella/testo");
        
        set(KEEP_ALIVE, "Mantieni audio attivo (riduce latenza)");
        set(AUDIO_BUFFER, "Buffer audio (hardware)");
        set(PROCESSING_CHUNK, "Frammento di elaborazione");
        set(PERFORMANCE_HINT, "Se il suono si interrompe, aumenta il buffer o il frammento. Se la latenza è alta, riducili.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Ingressi supportati: tastiera, touch screen, mouse o manipolatore con adattatore USB.\n\n" +
                "Per la manipolazione con clic sinistro/destro del mouse o con un adattatore da USB a mouse paddle, lascia il puntatore del mouse sul pulsante del paddle sinistro sullo schermo, il clic sinistro/destro verrà mappato sui paddle corretti.\n\n" +
                "Per gli adattatori tastiera (es. VBand), funziona direttamente senza configurazione.\n\n" +
                "La modalità rigorosa richiede un timing preciso; quella non rigorosa permette una manipolazione più rapida.\n\n" +
                "Problemi comuni: Se il suono ha troppi clic, prova l'opzione 'Dente di sega' o modifica l'inviluppo. Se la latenza è alta, riduci il buffer. Se il suono si interrompe, aumentalo.\n\n" +
                "Tasti della tastiera:\n" +
                "  Sinistra: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Destra: ]  D  S  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Tasto");
        
        set(SYSTEM_SETTING, "Impostazione di sistema");
        set(DARK_THEME, "Tema scuro");
        set(LIGHT_THEME, "Tema chiaro");
        
        set(MODE_STRAIGHT, "Tasto verticale");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Semiautomatico)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "LETTERE");
        set(CAT_NUMBERS, "NUMERI");
        set(CAT_SYMBOLS, "SIMBOLI");
        set(CAT_SPECIAL_SYMBOLS, "SIMBOLI SPECIALI");
        set(CAT_SPECIAL, "LETTERE SPECIALI");
        set(CAT_PROSIGNS_COMMON, "SEGNALI DI PROCEDURA COMUNI");
        set(CAT_ABBREVIATIONS, "ABBREVIAZIONI COMUNI");
        set(CAT_QCODES, "CODICI Q");
        set(CAT_PROSIGNS_OTHER, "Altri Segnali");

        set(COLOR_WHITE, "Bianco");
        set(COLOR_BLACK, "Nero");
        set(COLOR_RED, "Rosso");
        set(COLOR_ORANGE, "Arancione");
        set(COLOR_YELLOW, "Giallo");
        set(COLOR_GREEN, "Verde");
        set(COLOR_CYAN, "Ciano");
        set(COLOR_BLUE, "Blu");
        set(COLOR_PURPLE, "Viola");
        set(COLOR_PINK, "Rosa");
        set(SUPPORT_WINDLEREYE, "Sostienimi ascoltando il mio progetto musicale Windlereye");
        set(CANCEL, "Annulla");
        set(QUIT, "Esci");
        set(QUIT_GAME_PROMPT, "Sei sicuro di voler uscire da questo gioco?");

        set(SCORE, "Punteggio: ");
        set(HIGH_SCORE, "Punteggio alto");
        set(YOUR_HIGH_SCORE_IS, "Il tuo punteggio più alto è:");
        set(TIME, "Tempo: ");
                set(MATCH_COMPLETED, "Partita completata");
        set(TRY_AGAIN, "Riprova");
        set(WORDS, "Parole");
                set(QUIT_GAME, "Esci");
        set(MATCH_SETTINGS, "Parametri di gioco");
        set(SHARE_PREVIEW, "Anteprima");
        set(GAMES, "Giochi");
        set(SHARE, "Condividi");
        set(SHARE_SUBJECT, "Il mio punteggio Morse Training");
        set(SHARE_PROMO_TEXT, "Gioca a Morse Training su https://morsetraining.com");
        set(THEME, "Tema");

        set(MATCH_RESULTS, "Risultati");
                
        set(INFINITE, "Esercitati senza limiti di tempo");
        set(THREE_MINUTES, "Batti il ​​tuo punteggio in 3 minuti");

        set(REPEAT, "RIPETI");

        set(START, "INIZIA");
        set(PICK_LANG_THEME_ON_SHARE, "Scegli lingua e tema quando condividi i punteggi");
        set(CONTINUE, "CONTINUARE");
        set(RX, "Ricevere");
        set(TX, "Trasmettere");
}
}
