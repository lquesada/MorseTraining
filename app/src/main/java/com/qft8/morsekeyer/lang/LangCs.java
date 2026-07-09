package com.qft8.morsekeyer.lang;

public class LangCs extends MorseLanguage {
    public LangCs() {
        set(SAVE, "Uložit");
        set(RESET_DEFAULTS, "Obnovit výchozí");
        set(CLOSE, "Zavřít");
        
        set(SETTINGS_TITLE, "Nastavení");
        set(TONE, "Tón");
        set(USER_INTERFACE, "Uživatelské rozhraní");
        set(ADVANCED, "Pokročilé (výkon)");
        set(DECODER_BEHAVIOR, "Chování dekodéru");

        set(KEY_MODE, "Režim klíče");
        set(WPM_SPEED, "Rychlost (WPM)");
        set(INVERSE_PADDLES, "Inverzní pádla");
        set(STRICT_TIMING, "Přesné časování");
        
        set(FREQUENCY, "Frekvence");
        set(VOLUME, "Hlasitost");
        set(ENVELOPE, "Náběh/doběh (obálka)");
        set(NOCLICK, "Pila signál pro zamezení klikání");
        
        set(LANGUAGE, "Jazyk");
        set(KEYBOARD_TYPE, "Typ klávesnice");
        set(SHOW_TABLE, "Zobrazit Morseovu tabulku");
        set(SHOW_TABLE_CODES, "Zobrazit tečky a čárky v Morseově tabulce");
        set(SHOW_VISUAL, "Zobrazit vizuální indikátor");
        set(SHOW_PADDLES, "Zobrazit pádla na obrazovce");
        set(NEXT_WORD_INDICATOR, "Indikátor dalšího slova");
        set(KEEP_SCREEN_ON, "Ponechat zapnutou obrazovku");
        set(APP_THEME, "Téma aplikace");
        set(TEXT_COLOR, "Barva textu");
        set(TEXT_FONT_SIZE, "Velikost písma textu");
        set(TABLE_FONT_SIZE, "Velikost písma tabulky");
        set(TABLE_RATIO, "Poměr tabulka/obrazovka");
        
        set(KEEP_ALIVE, "Udržovat audio aktivní (snižuje latenci)");
        set(WHITE_NOISE, "Silnější (přehrát bílý šum)");
        set(AUDIO_BUFFER, "Vyrovnávací paměť zvuku (hardware)");
        set(PROCESSING_CHUNK, "Zpracovávaný blok");
        set(PERFORMANCE_HINT, "Pokud zvuk koktá, zvyšte buffer. Pokud je latence vysoká, snižte jej.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Podporované vstupy: klávesnice, dotyková obrazovka, myš nebo USB adaptér pro pádla.\n\nPro klíčování levým/pravým tlačítkem myši nebo adaptér pádla z USB na myš nechte ukazatel myši nad levým tlačítkem pádla na obrazovce, levé/pravé kliknutí se namapuje na správná pádla.\n\nPro USB adaptéry pádel na klávesnici (např. VBand) to funguje ihned po připojení.\n\nPřísné časování vyžaduje přesné mezery mezi písmeny; nepřísné umožňuje rychlejší klíčování.\n\nŘešení problémů: Pokud zvuk cvaká, zkuste Pilový zub nebo změňte obálku. Pokud je zpoždění vysoké, zmenšete vyrovnávací paměť. Pokud se zvuk zasekává, zvyšte ji.\n\nKlávesy na klávesnici:\n  Levá: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  Pravá: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Klíč");
        
        set(SYSTEM_SETTING, "Nastavení systému");
        set(DARK_THEME, "Tmavé téma");
        set(LIGHT_THEME, "Světlé téma");
        
        set(MODE_STRAIGHT, "Vertikální klíč");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Poloautomat)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "PÍSMENA");
        set(CAT_NUMBERS, "ČÍSLA");
        set(CAT_SYMBOLS, "SYMBOLY");
        set(CAT_SPECIAL_SYMBOLS, "ZVLÁŠTNÍ SYMBOLY");
        set(CAT_SPECIAL, "ZVLÁŠTNÍ PÍSMENA");
        set(CAT_PROSIGNS_COMMON, "BĚŽNÉ PROCEDURÁLNÍ SIGNÁLY");
        set(CAT_ABBREVIATIONS, "BĚŽNÉ ZKRATKY");
        set(CAT_QCODES, "Q KÓDY");
        set(CAT_PROSIGNS_OTHER, "OSTATNÍ PROCEDURÁLNÍ SIGNÁLY");

        set(COLOR_WHITE, "Bílá");
        set(COLOR_BLACK, "Černá");
        set(COLOR_RED, "Červená");
        set(COLOR_ORANGE, "Oranžová");
        set(COLOR_YELLOW, "Žlutá");
        set(COLOR_GREEN, "Zelená");
        set(COLOR_CYAN, "Azurová");
        set(COLOR_BLUE, "Modrá");
        set(COLOR_PURPLE, "Fialová");
        set(COLOR_PINK, "Růžová");
        set(SUPPORT_WINDLEREYE, "Podpořte mě poslechem mého hudebního projektu Windlereye");
        set(CANCEL, "Zrušit");
        set(QUIT, "Ukončit");
        set(QUIT_GAME_PROMPT, "Opravdu chcete opustit tuto hru?");

        set(SCORE, "Skóre");
        set(HIGH_SCORE, "Vysoké skóre");
        set(YOUR_HIGH_SCORE_IS, "Vaše nejvyšší skóre je");
        set(TIME, "Čas");
                set(MATCH_COMPLETED, "Zápas dokončen");
        set(TRY_AGAIN, "Zkusit znovu");
        set(WORDS, "Slova");
                set(QUIT_GAME, "Ukončit hru");
        set(MATCH_SETTINGS, "Parametry hry");
        set(SHARE_PREVIEW, "Sdílet náhled");
        set(GAMES, "Hry");
        set(SHARE, "Podíl");
        set(SHARE_SUBJECT, "Sdílím své skóre Morse Traininga");
        set(SHARE_PROMO_TEXT, "Zahrajte si Morse Training zdarma na https://morsetraining.com");
        set(THEME, "Téma");

        set(MATCH_RESULTS, "Výsledky zápasů");
                

        set(REPEAT, "OPAKOVAT");

        set(START, "ZAČÍT");
        set(PICK_LANG_THEME_ON_SHARE, "Vyberte jazyk a motiv při sdílení skóre");
        set(CONTINUE, "POKRAČOVAT");
        set(RX, "Přijímat");
        set(TX, "Vysílat");

        set(KOCH_METHOD, "Kochova metoda");
        set(TARGET, "Cíl");
set(TARGET_MET, "Cíl splněn");
        set(TARGET_NOT_MET, "Cíl nesplněn");
            set(LEVEL, "Úroveň");
    
        set(LEARN, "Učit se");
        set(PLAY, "Hrát");
    
        set(LEVELS_COMPLETED, "Dokončené úrovně");
        set(RESET_PROGRESS, "Resetovat postup");
        set(RESET_PROGRESS_CONFIRM, "Opravdu chcete resetovat postup?");
        set(RESET, "Resetovat");
            set(WPM, "WPM​");
        set(BACK, "Zpět");
        set(NEXT_LEVEL, "Další úroveň");

                set(EFFECTIVE_WPM_FARNSWORTH, "Efektivní WPM (Farnsworth)");
                set(EXTRA_WORD_SPACING, "Extra mezera mezi slovy");
                set(EFFECTIVE_WPM_SHORT, "Efektivní");

                set(WORD_SPACING_ADD, "Slovo +");
    }
}