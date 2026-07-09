package com.qft8.morsekeyer.lang;

public class LangDe extends MorseLanguage {
    public LangDe() {
        set(SAVE, "Speichern");
        set(RESET_DEFAULTS, "Auf Standard zurücksetzen");
        set(CLOSE, "Schließen");
        
        set(SETTINGS_TITLE, "Einstellungen");
        set(TONE, "Ton");
        set(USER_INTERFACE, "Benutzeroberfläche");
        set(ADVANCED, "Erweitert (Leistung)");
        set(DECODER_BEHAVIOR, "Decoder-Verhalten");

        set(KEY_MODE, "Modus");
        set(WPM_SPEED, "Geschwindigkeit (WPM)");
        set(INVERSE_PADDLES, "Paddles vertauschen");
        set(STRICT_TIMING, "Striktes Timing");
        
        set(FREQUENCY, "Frequenz");
        set(VOLUME, "Lautstärke");
        set(ENVELOPE, "Anstiegs-/Abfallzeit (Envelope)");
        set(NOCLICK, "Sägezahn-Signal (vermeidet Klicken)");
        
        set(LANGUAGE, "Sprache");
        set(KEYBOARD_TYPE, "Tastaturtyp");
        set(SHOW_TABLE, "Morse-Tabelle anzeigen");
        set(SHOW_TABLE_CODES, "Punkte und Striche in der Morse-Tabelle anzeigen");
        set(SHOW_VISUAL, "Visuelle Anzeige anzeigen");
        set(SHOW_PADDLES, "Bildschirm-Paddles anzeigen");
        set(NEXT_WORD_INDICATOR, "Nächste-Wort-Anzeige");
        set(KEEP_SCREEN_ON, "Bildschirm anlassen");
        set(APP_THEME, "App-Design");
        set(TEXT_COLOR, "Textfarbe");
        set(TEXT_FONT_SIZE, "Textschriftgröße");
        set(TABLE_FONT_SIZE, "Tabellenschriftgröße");
        set(TABLE_RATIO, "Verhältnis Tabelle/Text");
        
        set(KEEP_ALIVE, "Audio aktiv halten (verringert Latenz)");
        set(WHITE_NOISE, "Stärker (weißes Rauschen abspielen)");
        set(AUDIO_BUFFER, "Audio-Puffer (Hardware)");
        set(PROCESSING_CHUNK, "Verarbeitungs-Chunk");
        set(PERFORMANCE_HINT, "Wenn der Ton hakt, Puffer oder Chunk erhöhen. Bei hoher Latenz verringern.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Unterstützte Eingaben: Tastatur, Touchscreen, Maus oder Paddles mit USB-Adapter.\n\n" +
                "Für die Tastung per linkem/rechtem Mausklick oder über einen USB-zu-Maus-Paddle-Adapter belassen Sie den Mauszeiger über der linken Paddle-Schaltfläche auf dem Bildschirm; der linke/rechte Klick wird den richtigen Paddles zugeordnet.\n\n" +
                "USB-Tastatur-Adapter (z.B. VBand) funktionieren ohne weitere Konfiguration.\n\n" +
                "Der strikte Modus erfordert korrektes Timing; der nicht-strikte Modus erlaubt schnellere Eingabe.\n\n" +
                "Häufige Probleme: Wenn es zu stark klickt, Sägezahn-Option wählen oder Envelope anpassen. Bei hoher Latenz Puffer verringern. Wenn der Ton aussetzt, Puffer erhöhen.\n\n" +
                "Tastaturbelegung:\n" +
                "  Links: [  A  ,  1  0  \u2190  L-Strg  L-Umschalt  L-Alt  Num.  F1\n" +
                "  Rechts: ]  D  S  .  3  9  \u2192  R-Strg  R-Umschalt  R-Alt  NumEnter  F2");

        set(KEY, "Taste");
        
        set(SYSTEM_SETTING, "Systemeinstellung");
        set(DARK_THEME, "Dunkles Design");
        set(LIGHT_THEME, "Helles Design");
        
        set(MODE_STRAIGHT, "Hubtaste");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Halbautomatisch)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "BUCHSTABEN");
        set(CAT_NUMBERS, "ZAHLEN");
        set(CAT_SYMBOLS, "SYMBOLE");
        set(CAT_SPECIAL_SYMBOLS, "SPEZIALSYMBOLE");
        set(CAT_SPECIAL, "SONDERZEICHEN");
        set(CAT_PROSIGNS_COMMON, "GÄNGIGE VERKEHRSZEICHEN");
        set(CAT_ABBREVIATIONS, "GÄNGIGE ABKÜRZUNGEN");
        set(CAT_QCODES, "Q-CODES");
        set(CAT_PROSIGNS_OTHER, "Sonstige Prosigns");

        set(COLOR_WHITE, "Weiß");
        set(COLOR_BLACK, "Schwarz");
        set(COLOR_RED, "Rot");
        set(COLOR_ORANGE, "Orange");
        set(COLOR_YELLOW, "Gelb");
        set(COLOR_GREEN, "Grün");
        set(COLOR_CYAN, "Cyan");
        set(COLOR_BLUE, "Blau");
        set(COLOR_PURPLE, "Lila");
        set(COLOR_PINK, "Rosa");
        set(SUPPORT_WINDLEREYE, "Unterstütze mich, indem du dir mein Musikprojekt Windlereye anhörst");
        set(CANCEL, "Abbrechen");
        set(QUIT, "Beenden");
        set(QUIT_GAME_PROMPT, "Möchtest du dieses Spiel wirklich beenden?");

        set(SCORE, "Punktzahl");
        set(HIGH_SCORE, "Hohe Punktzahl");
        set(YOUR_HIGH_SCORE_IS, "Dein Highscore ist");
        set(TIME, "Zeit");
                set(MATCH_COMPLETED, "Spiel beendet");
        set(TRY_AGAIN, "Erneut versuchen");
        set(WORDS, "Wörter");
                set(QUIT_GAME, "Beenden");
        set(MATCH_SETTINGS, "Spielparameter");
        set(SHARE_PREVIEW, "Vorschau");
        set(GAMES, "Spiele");
        set(SHARE, "Teilen");
        set(SHARE_SUBJECT, "Meine Morse Training-Punktzahl");
        set(SHARE_PROMO_TEXT, "Spiele Morse Training auf https://morsetraining.com");
        set(THEME, "Thema");

        set(MATCH_RESULTS, "Ergebnisse");
                

        set(REPEAT, "WIEDERHOLEN");

        set(START, "START");
        set(PICK_LANG_THEME_ON_SHARE, "Sprache und Design beim Teilen von Punktzahlen auswählen");
        set(CONTINUE, "WEITERMACHEN");
        set(RX, "Empfangen");
        set(TX, "Senden");

        set(KOCH_METHOD, "Koch-Methode");
        set(TARGET, "Ziel");
set(TARGET_MET, "Ziel erreicht");
        set(TARGET_NOT_MET, "Ziel nicht erreicht");
            set(LEVEL, "Level");
    
        set(LEARN, "Lernen");
        set(PLAY, "Spielen");
    
        set(LEVELS_COMPLETED, "Abgeschlossene Level");
        set(RESET_PROGRESS, "Fortschritt zurücksetzen");
        set(RESET_PROGRESS_CONFIRM, "Bist du sicher, dass du den Fortschritt zurücksetzen möchtest?");
        set(RESET, "Zurücksetzen");
            set(WPM, "WPM​");
        set(BACK, "Zurück");
        set(NEXT_LEVEL, "Nächste Stufe");

                set(EFFECTIVE_WPM_FARNSWORTH, "Effektive WPM (Farnsworth)");
                set(EXTRA_WORD_SPACING, "Zusätzlicher Wortabstand");
                set(EFFECTIVE_WPM_SHORT, "Effektiv");

                set(WORD_SPACING_ADD, "Wort +");
    }
}