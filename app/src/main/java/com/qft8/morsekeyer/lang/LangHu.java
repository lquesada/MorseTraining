package com.qft8.morsekeyer.lang;

public class LangHu extends MorseLanguage {
    public LangHu() {
        set(SAVE, "Mentés");
        set(RESET_DEFAULTS, "Alaphelyzet");
        set(CLOSE, "Bezárás");
        
        set(SETTINGS_TITLE, "Beállítások");
        set(TONE, "Hangszín");
        set(USER_INTERFACE, "Felhasználói felület");
        set(ADVANCED, "Haladó (teljesítmény)");
        set(DECODER_BEHAVIOR, "Dekóder viselkedése");

        set(KEY_MODE, "Billentyűzési mód");
        set(WPM_SPEED, "Sebesség (WPM)");
        set(INVERSE_PADDLES, "Fordított paddle-ök");
        set(STRICT_TIMING, "Szigorú időzítés");
        set(INTERLETTER_SPACING, "Betűköz");
        set(INTERWORD_SPACING, "Szóköz");
        
        set(FREQUENCY, "Frekvencia");
        set(VOLUME, "Hangerő");
        set(ENVELOPE, "Felfutási/lefutási idő (envelope)");
        set(NOCLICK, "Fűrészfog jel a kattogás elkerülésére");
        
        set(LANGUAGE, "Nyelv");
        set(KEYBOARD_TYPE, "Billentyűzet típusa");
        set(SHOW_TABLE, "Morszé-táblázat megjelenítése");
        set(SHOW_TABLE_CODES, "Pontok és vonalak megjelenítése a Morse-táblázatban");
        set(SHOW_VISUAL, "Vizuális visszajelzés");
        set(SHOW_PADDLES, "Képernyő-paddle-ök");
        set(NEXT_WORD_INDICATOR, "Következő szó jelző");
        set(KEEP_SCREEN_ON, "Képernyő ébrentartása");
        set(APP_THEME, "Téma");
        set(TEXT_COLOR, "Szöveg színe");
        set(TEXT_FONT_SIZE, "Szöveg betűmérete");
        set(TABLE_FONT_SIZE, "Táblázat betűmérete");
        set(TABLE_RATIO, "Táblázat/szöveg arány");
        
        set(KEEP_ALIVE, "Audio ébrentartása (kisebb késleltetés)");
        set(AUDIO_BUFFER, "Audio puffer (hardver)");
        set(PROCESSING_CHUNK, "Feldolgozási egység");
        set(PERFORMANCE_HINT, "Ha akadozik a hang, növelje a puffert. Ha nagy a késleltetés, csökkentse.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Támogatott bemenetek: billentyűzet, érintőképernyő, egér vagy USB-s manipulátor.\n\n" +
                "Az egér bal/jobb gombos billentyűzéséhez vagy az USB-egér evező adapterhez hagyja az egérmutatót a képernyőn lévő bal evezőgomb felett, a bal/jobb kattintás a megfelelő evezőkre lesz leképezve.\n\n" +
                "USB-s billentyűzet-adapterek (pl. VBand) beállítás nélkül működnek.\n\n" +
                "A szigorú mód pontos időzítést igényel; a nem szigorú mód gyorsabb kezelést tesz lehetővé.\n\n" +
                "Gyakori problémák: Ha túl darabos a hang, próbálja a fűrészfog jelet vagy állítsa az envelope-ot. Ha nagy a késleltetés, csökkentse a puffert.\n\n" +
                "Billentyűk:\n" +
                "  Bal: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Jobb: ]  D  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Billentyű");
        
        set(SYSTEM_SETTING, "Rendszerbeállítás");
        set(DARK_THEME, "Sötét téma");
        set(LIGHT_THEME, "Világos téma");
        
        set(MODE_STRAIGHT, "Függőleges billentyű");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Félautomata)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "BETŰK");
        set(CAT_NUMBERS, "SZÁMOK");
        set(CAT_SYMBOLS, "SZIMBÓLUMOK");
        set(CAT_SPECIAL_SYMBOLS, "SPECIÁLIS SZIMBÓLUMOK");
        set(CAT_SPECIAL, "SPECIÁLIS BETŰK");
        set(CAT_PROSIGNS_COMMON, "GYAKORI FORGALMI JELZÉSEK");
        set(CAT_ABBREVIATIONS, "GYAKORI RÖVIDÍTÉSEK");
        set(CAT_QCODES, "Q-KÓDOK");
        set(CAT_PROSIGNS_OTHER, "Egyéb jelek");

        set(COLOR_WHITE, "Fehér");
        set(COLOR_BLACK, "Fekete");
        set(COLOR_RED, "Piros");
        set(COLOR_ORANGE, "Narancssárga");
        set(COLOR_YELLOW, "Sárga");
        set(COLOR_GREEN, "Zöld");
        set(COLOR_CYAN, "Cián");
        set(COLOR_BLUE, "Kék");
        set(COLOR_PURPLE, "Lila");
        set(COLOR_PINK, "Rózsaszín");
        set(SUPPORT_WINDLEREYE, "Támogass azzal, hogy meghallgatod a Windlereye zenei projektemet");
        set(CANCEL, "Mégse");
        set(QUIT, "Kilépés");
        set(QUIT_GAME_PROMPT, "Biztosan ki akarsz lépni ebből a játékból?");

        set(SCORE, "Pontszám: ");
        set(HIGH_SCORE, "Magas pontszám");
        set(YOUR_HIGH_SCORE_IS, "A legmagasabb pontszámod:");
        set(TIME, "Idő: ");
                set(MATCH_COMPLETED, "Meccs befejezve");
        set(TRY_AGAIN, "Újra");
        set(WORDS, "Szavak");
                set(QUIT_GAME, "Kilépés a játékból");
        set(MATCH_SETTINGS, "A játék paraméterei");
        set(SHARE_PREVIEW, "Előnézet megosztása");
        set(GAMES, "Játékok");
        set(SHARE, "Részesedés");
        set(SHARE_SUBJECT, "Megosztom Morse Training pontszámomat");
        set(SHARE_PROMO_TEXT, "Játssz a Morse Trainingrel ingyen a https://morsetraining.com oldalon");
        set(THEME, "Téma");

        set(MATCH_RESULTS, "Mérkőzések eredményei");
                
        set(INFINITE, "Gyakorolj időkorlát nélkül");
        set(THREE_MINUTES, "Verje meg pontszámát 3 perc alatt");

        set(REPEAT, "ISMÉTLÉS");

        set(START, "INDÍTÁS");
        set(PICK_LANG_THEME_ON_SHARE, "Nyelv és téma kiválasztása pontszámok megosztásakor");
        set(CONTINUE, "FOLYTATÁS");
        set(RX, "Fogni");
        set(TX, "Adni");
}
}
