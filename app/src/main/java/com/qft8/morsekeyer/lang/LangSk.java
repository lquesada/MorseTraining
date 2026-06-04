package com.qft8.morsekeyer.lang;

public class LangSk extends MorseLanguage {
    public LangSk() {
        set(SAVE, "Uložiť");
        set(RESET_DEFAULTS, "Obnoviť predvolené");
        set(CLOSE, "Zavrieť");
        
        set(SETTINGS_TITLE, "Nastavenia");
        set(TONE, "Tón");
        set(USER_INTERFACE, "Používateľské rozhranie");
        set(ADVANCED, "Pokročilé (výkon)");
        set(DECODER_BEHAVIOR, "Správanie dekodéra");

        set(KEY_MODE, "Režim kľúča");
        set(WPM_SPEED, "Rýchlosť WPM");
        set(INVERSE_PADDLES, "Inverzné pádla");
        set(STRICT_TIMING, "Prísne načasovanie");
        set(INTERLETTER_SPACING, "Medzera medzi písmenami");
        set(INTERWORD_SPACING, "Medzera medzi slovami");
        
        set(FREQUENCY, "Frekvencia");
        set(VOLUME, "Hlasitosť");
        set(ENVELOPE, "Čas nábehu/dobehu (obálka)");
        set(NOCLICK, "Použiť pílovitý signál na zabránenie klikaniu");
        
        set(LANGUAGE, "Jazyk");
        set(KEYBOARD_TYPE, "Typ klávesnice");
        set(SHOW_TABLE, "Zobraziť Morseovu tabuľku");
        set(SHOW_TABLE_CODES, "Zobraziť bodky a čiarky v Morseovej tabuľke");
        set(SHOW_VISUAL, "Zobraziť vizuálny indikátor");
        set(SHOW_PADDLES, "Zobraziť pádla na obrazovke");
        set(NEXT_WORD_INDICATOR, "Indikátor ďalšieho slova");
        set(KEEP_SCREEN_ON, "Ponechať obrazovku zapnutú počas aktivity aplikácie");
        set(APP_THEME, "Motív aplikácie");
        set(TEXT_COLOR, "Farba textu");
        set(TEXT_FONT_SIZE, "Veľkosť písma textu");
        set(TABLE_FONT_SIZE, "Veľkosť písma tabuľky");
        set(TABLE_RATIO, "Pomer tabuľky k textovej obrazovke");
        
        set(COLOR_WHITE, "Biela");
        set(COLOR_BLACK, "Čierna");
        set(COLOR_RED, "Červená");
        set(COLOR_ORANGE, "Oranžová");
        set(COLOR_YELLOW, "Žltá");
        set(COLOR_GREEN, "Zelená");
        set(COLOR_CYAN, "Azúrová");
        set(COLOR_BLUE, "Modrá");
        set(COLOR_PURPLE, "Fialová");
        set(COLOR_PINK, "Ružová");
        
        set(KEEP_ALIVE, "Udržiavať zvuk aktívny (znižuje oneskorenie)");
        set(AUDIO_BUFFER, "Zvuková vyrovnávacia pamäť (hardvér)");
        set(PROCESSING_CHUNK, "Dávka spracovania");
        set(PERFORMANCE_HINT, "Ak zvuk vypadáva, zväčšite vyrovnávaciu pamäť alebo dávku. Ak je oneskorenie vysoké, zmenšite ich.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Podporované vstupy: klávesnica, dotyková obrazovka, myš alebo pádlo s USB adaptérom.\n\n" +
                "Pre zadávanie pomocou ľavého/pravého kliknutia myši alebo USB-myš pádlo adaptéra nechajte kurzor myši nad ľavým tlačidlom pádla na obrazovke a ľavé/pravé kliknutie bude priradené správnym pádlom.\n\n" +
                "Pre adaptér USB-klávesnica to funguje ihneď (napr. testované s VBand) - dajte mi vedieť, ak nie.\n\n" +
                "Prísny režim vyžaduje presné načasovanie medzi písmenami, neprísny režim umožňuje rýchlejšiu manipuláciu.\n\n" +
                "Bežné problémy: Ak je zvuk vo vašom zariadení príliš klikavý, skúste možnosť pílovitého signálu alebo skúste upraviť obálku. Ak je oneskorenie príliš vysoké, skúste zmenšiť vyrovnávaciu pamäť. Ak sa zvuk prerušuje, skúste ju zväčšiť.\n\n" +
                "Klávesy na klávesnici:\n" +
                "  Vľavo: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Vpravo: ]  D  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Kľúč");
        
        set(SYSTEM_SETTING, "Nastavenie systému");
        set(DARK_THEME, "Tmavý motív");
        set(LIGHT_THEME, "Svetlý motív");
        
        set(MODE_STRAIGHT, "Rovný (Straight)");
        set(MODE_IAMBIC_A, "Jambický A");
        set(MODE_IAMBIC_B, "Jambický B");
        set(MODE_ULTIMATIC, "Ultimatický (Ultimatic)");
        set(MODE_BUG, "Bug");
        set(MODE_COOTIE, "Cootie");
        
        set(CAT_LETTERS, "PÍSMENÁ");
        set(CAT_NUMBERS, "ČÍSLA");
        set(CAT_SYMBOLS, "SYMBOLY");
        set(CAT_SPECIAL_SYMBOLS, "ŠPECIÁLNE SYMBOLY");
        set(CAT_SPECIAL, "ŠPECIÁLNE PÍSMENÁ");
        set(CAT_PROSIGNS_COMMON, "BEŽNÉ PROCEDURÁLNE SIGNÁLY");
        set(CAT_ABBREVIATIONS, "BEŽNÉ SKRATKY");
        set(CAT_QCODES, "Q KÓDY");
        set(CAT_PROSIGNS_OTHER, "INÉ PROCEDURÁLNE SIGNÁLY");
        set(SUPPORT_WINDLEREYE, "Podporte ma počúvaním môjho hudobného projektu Windlereye");
        set(CANCEL, "Zrušiť");
        set(QUIT, "Ukončiť");
        set(QUIT_GAME_PROMPT, "Naozaj chcete ukončiť túto hru?");
        set(WORDS, "Slová");
                set(QUIT_GAME, "Ukončiť hru");
        set(MATCH_SETTINGS, "Parametre hry");
        set(SHARE_PREVIEW, "Zdieľať ukážku");
        set(GAMES, "Hry");
        set(SHARE, "zdieľať");
        set(SHARE_SUBJECT, "Zdieľam svoje skóre Morsea Keyera");
        set(SHARE_PROMO_TEXT, "Zahrajte si Morse Training zadarmo na https://morsetraining.com");
        set(THEME, "Téma");

        set(MATCH_RESULTS, "Výsledky zápasov");
        set(TIME, "čas: ");
        set(TRY_AGAIN, "Skúste to znova");
        set(SCORE, "skóre: ");
        set(MATCH_COMPLETED, "Zápas dokončený");
        set(HIGH_SCORE, "Vysoké skóre");

                
        set(INFINITE, "Cvičte bez časového obmedzenia");
        set(THREE_MINUTES, "Prekonajte svoje skóre za 3 minúty");

        set(REPEAT, "OPAKOVAŤ");

        set(START, "ŠTART");
        set(PICK_LANG_THEME_ON_SHARE, "Pri zdieľaní skóre vyberte jazyk a tému");
        set(CONTINUE, "POKRAČOVAŤ");
        set(RX, "Prijímať");
        set(TX, "Vysielať");
}
}
