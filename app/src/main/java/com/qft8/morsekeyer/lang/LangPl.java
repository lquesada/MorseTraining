package com.qft8.morsekeyer.lang;

public class LangPl extends MorseLanguage {
    public LangPl() {
        set(SAVE, "Zapisz");
        set(RESET_DEFAULTS, "Przywróć domyślne");
        set(CLOSE, "Zamknij");
        
        set(SETTINGS_TITLE, "Ustawienia");
        set(TONE, "Ton");
        set(USER_INTERFACE, "Interfejs użytkownika");
        set(ADVANCED, "Zaawansowane (wydajność)");
        set(DECODER_BEHAVIOR, "Zachowanie dekodera");

        set(KEY_MODE, "Tryb klucza");
        set(WPM_SPEED, "Prędkość (WPM)");
        set(INVERSE_PADDLES, "Odwróć łopatki");
        set(STRICT_TIMING, "Rygorystyczny timing");
        set(INTERLETTER_SPACING, "Odstęp między literami");
        set(INTERWORD_SPACING, "Odstęp między słowami");
        
        set(FREQUENCY, "Częstotliwość");
        set(VOLUME, "Głośność");
        set(ENVELOPE, "Czas narastania/opadania (obwiednia)");
        set(NOCLICK, "Sygnał piłokształtny (brak kliknięć)");
        
        set(LANGUAGE, "Język");
        set(KEYBOARD_TYPE, "Typ klawiatury");
        set(SHOW_TABLE, "Pokaż tabelę Morse'a");
        set(SHOW_TABLE_CODES, "Pokaż kropki i kreski w tabeli Morse'a");
        set(SHOW_VISUAL, "Pokaż wskaźnik wizualny");
        set(SHOW_PADDLES, "Pokaż łopatki na ekranie");
        set(NEXT_WORD_INDICATOR, "Wskaźnik następnego słowa");
        set(KEEP_SCREEN_ON, "Utrzymuj włączony ekran");
        set(APP_THEME, "Motyw aplikacji");
        set(TEXT_COLOR, "Kolor tekstu");
        set(TEXT_FONT_SIZE, "Rozmiar czcionki tekstu");
        set(TABLE_FONT_SIZE, "Rozmiar czcionki tabeli");
        set(TABLE_RATIO, "Proporcja tabela/tekst");
        
        set(KEEP_ALIVE, "Utrzymuj dźwięk (zmniejsza opóźnienie)");
        set(AUDIO_BUFFER, "Bufor audio (sprzętowy)");
        set(PROCESSING_CHUNK, "Fragment przetwarzania");
        set(PERFORMANCE_HINT, "Jeśli dźwięk przerywa, zwiększ bufor. Jeśli opóźnienie jest duże, zmniejsz go.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Obsługiwane wejścia: klawiatura, ekran dotykowy, mysz lub klucz przez USB.\n\n" +
                "W przypadku kluczowania lewym/prawym przyciskiem myszy lub adaptera łopatki z USB na mysz, pozostaw wskaźnik myszy nad lewym przyciskiem łopatki na ekranie, lewe/prawe kliknięcie zostanie zmapowane na odpowiednie łopatki.\n\n" +
                "Adaptery klawiatury USB (np. VBand) działają natychmiast bez konfiguracji.\n\n" +
                "Tryb rygorystyczny wymaga precyzyjnego timingu; tryb swobodny pozwala na szybsze kluczowanie.\n\n" +
                "Problemy: Jeśli dźwięk zbyt mocno klika, spróbuj sygnału piłokształtnego. Jeśli opóźnienie jest duże, zmniejsz bufor. Jeśli dźwięk przerywa, zwiększ go.\n\n" +
                "Klawisze:\n" +
                "  Lewo: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Prawo: ]  D  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Klucz");
        
        set(SYSTEM_SETTING, "Ustawienie systemowe");
        set(DARK_THEME, "Ciemny motyw");
        set(LIGHT_THEME, "Jasny motyw");
        
        set(MODE_STRAIGHT, "Klucz pionowy");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Półautomatyczny)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "LITERY");
        set(CAT_NUMBERS, "CYFRY");
        set(CAT_SYMBOLS, "SYMBOLE");
        set(CAT_SPECIAL_SYMBOLS, "SYMBOLE SPECJALNE");
        set(CAT_SPECIAL, "LITERY SPECJALNE");
        set(CAT_PROSIGNS_COMMON, "TYPOWE ZNAKI PROCEDURALNE");
        set(CAT_ABBREVIATIONS, "TYPOWE SKRÓTY");
        set(CAT_QCODES, "KODY Q");
        set(CAT_PROSIGNS_OTHER, "Inne sygnały");

        set(COLOR_WHITE, "Biały");
        set(COLOR_BLACK, "Czarny");
        set(COLOR_RED, "Czerwony");
        set(COLOR_ORANGE, "Pomarańczowy");
        set(COLOR_YELLOW, "Żółty");
        set(COLOR_GREEN, "Zielony");
        set(COLOR_CYAN, "Cyjan");
        set(COLOR_BLUE, "Niebieski");
        set(COLOR_PURPLE, "Purpurowy");
        set(COLOR_PINK, "Różowy");
        set(SUPPORT_WINDLEREYE, "Wesprzyj mnie, słuchając mojego projektu muzycznego Windlereye");
        set(CANCEL, "Anuluj");
        set(QUIT, "Wyjdź");
        set(QUIT_GAME_PROMPT, "Czy na pewno chcesz wyjść z tej gry?");

        set(SCORE, "Wynik: ");
        set(HIGH_SCORE, "Wysoki wynik");
        set(YOUR_HIGH_SCORE_IS, "Twój najwyższy wynik to:");
        set(TIME, "Czas: ");
                set(MATCH_COMPLETED, "Mecz zakończony");
        set(TRY_AGAIN, "Spróbuj ponownie");
        set(WORDS, "Słowa");
                set(QUIT_GAME, "Wyjdź");
        set(MATCH_SETTINGS, "Parametry gry");
        set(SHARE_PREVIEW, "Podgląd");
        set(GAMES, "Gry");
        set(SHARE, "Udostępnij");
        set(SHARE_SUBJECT, "Mój wynik Morse Training");
        set(SHARE_PROMO_TEXT, "Graj na https://morsetraining.com");
        set(THEME, "Motyw");

        set(MATCH_RESULTS, "Wyniki");
                
        set(TX_PRACTICE, "Transmisja (szkolenie)");
        set(TX_CONTEST, "Transmisja (atak punktowy)");
        set(INFINITE, "Ćwicz bez ograniczeń czasowych");
        set(THREE_MINUTES, "Pobij swój wynik w 3 minuty");

        set(RX_PRACTICE, "Odbierz (szkolenie)");
        set(RX_CONTEST, "Otrzymaj (atak punktowy)");
        set(REPEAT, "POWTÓRZ");

        set(START, "START");
        set(PICK_LANG_THEME_ON_SHARE, "Wybierz język i motyw podczas udostępniania wyników");
        set(CONTINUE, "KONTYNUOWAĆ");
        set(RX, "Odbierać");
        set(TX, "Przekazać");
}
}
