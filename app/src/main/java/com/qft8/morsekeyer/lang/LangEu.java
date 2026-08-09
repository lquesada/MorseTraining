package com.qft8.morsekeyer.lang;

public class LangEu extends MorseLanguage {
    public LangEu() {
        set(SAVE, "Gorde");
        set(RESET_DEFAULTS, "Berrezarri balio lehenetsiak");
        set(CLOSE, "Itxi");
        
        set(SETTINGS_TITLE, "Ezarpenak");
        set(TONE, "Tonua");
        set(USER_INTERFACE, "Erabiltzailearen interfazea");
        set(ADVANCED, "Aurreratua (errendimendua)");
        set(DECODER_BEHAVIOR, "Dekodetzailearen portaera");

        set(KEY_MODE, "Manipulatzaile modua");
        set(WPM_SPEED, "Abiadura (WPM)");
        set(INVERSE_PADDLES, "Alderantzikatu palak");
        set(STRICT_TIMING, "Denbora zorrotza");
        
        set(FREQUENCY, "Maiztasuna");
        set(VOLUME, "Bolumena");
        set(ENVELOPE, "Igoera/jaitsiera denbora (envelopea)");
        set(NOCLICK, "Zerra-hortz seinalea klikak saihesteko");
        
        set(LANGUAGE, "Hizkuntza");
        set(KEYBOARD_TYPE, "Teklatu mota");
        set(SHOW_TABLE, "Erakutsi Morse taula");
        set(SHOW_TABLE_CODES, "Erakutsi puntu eta marrak Morse taulan");
        set(SHOW_VISUAL, "Erakutsi adierazle bisuala");
        set(SHOW_PADDLES, "Erakutsi palak pantailan");
        set(NEXT_WORD_INDICATOR, "Hurrengo hitzaren adierazlea");
        set(KEEP_SCREEN_ON, "Mantendu pantaila piztuta");
        set(APP_THEME, "Aplikazioaren gaia");
        set(TEXT_COLOR, "Testuaren kolorea");
        set(TEXT_FONT_SIZE, "Testuaren letra-tamaina");
        set(TABLE_FONT_SIZE, "Taularen letra-tamaina");
        set(TABLE_RATIO, "Taula/pantaila proportzioa");
        
        set(KEEP_ALIVE, "Mantendu audioa aktibo (latentzia murrizten du)");
        set(WHITE_NOISE, "Indartsuagoa (zarata zuria erreproduzitu)");
        set(AUDIO_BUFFER, "Audio bufferra (hardwarea)");
        set(PROCESSING_CHUNK, "Prozesatze zatia");
        set(PERFORMANCE_HINT, "Soinua mozten bada, handitu bufferra. Latentzia handia bada, murriztu.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Onartutako sarrerak: teklatua, ukipen-pantaila, sagua edo USB arraun-egokitzailea.\n\nSaguaren ezkerreko/eskuineko klik teklak edo USB-saguaren arraun egokitzaileak erabiltzeko, utzi saguaren erakuslea pantailako ezkerreko arraun botoiaren gainean; ezkerreko/eskuineko klikak arraun egokietara mapatuko dira.\n\nUSB-teklatu arraun egokitzaileentzat (adibidez, VBand), inolako konfiguraziorik gabe funtzionatzen du.\n\nDenboralizazio zehatzak letren arteko etenaldi zehatzak eskatzen ditu; zehatza ez denak azkarrago idazteko aukera ematen du.\n\nArazoak konpontzea: Soinuak klik egiten badu, saiatu Zerra-hortza erabiltzen edo aldatu inguratzailea. Latentzia altua bada, murriztu bufferra. Soinua totelka ari bada, handitu.\n\nTeklatuko teklak:\n  Ezkerra: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  Eskuina: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Gakoa");
        
        set(SYSTEM_SETTING, "Sistemaren ezarpena");
        set(DARK_THEME, "Gai iluna");
        set(LIGHT_THEME, "Gai argia");
        
        set(MODE_STRAIGHT, "Manipulatzaile bertikala");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Semi-automatikoa)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "LETRAK");
        set(CAT_NUMBERS, "ZENBAKIAK");
        set(CAT_SYMBOLS, "SINBOLOAK");
        set(CAT_SPECIAL_SYMBOLS, "SINBOLO BEREZIAK");
        set(CAT_SPECIAL, "LETRA BEREZIAK");
        set(CAT_PROSIGNS_COMMON, "PROZEDURA-SEINALE OHIKOAK");
        set(CAT_ABBREVIATIONS, "LABURDURA OHIKOAK");
        set(CAT_QCODES, "Q KODEAK");
        set(CAT_PROSIGNS_OTHER, "BESTE PROZEDURA-SEINALE BATZUK");

        set(COLOR_WHITE, "Zuria");
        set(COLOR_BLACK, "Beltza");
        set(COLOR_RED, "Gorria");
        set(COLOR_ORANGE, "Laranja");
        set(COLOR_YELLOW, "Horia");
        set(COLOR_GREEN, "Berdea");
        set(COLOR_CYAN, "Ziana");
        set(COLOR_BLUE, "Urdina");
        set(COLOR_PURPLE, "Morea");
        set(COLOR_PINK, "Arrosa");
        set(SUPPORT_WINDLEREYE, "Nire musika proiektua Windlereye entzunez lagundu nazazu");
        set(CANCEL, "Utzi");
        set(QUIT, "Irten");
        set(QUIT_GAME_PROMPT, "Ziur zaude joko honetatik irten nahi duzula?");

        set(SCORE, "Puntuazioa");
        set(HIGH_SCORE, "Puntuazio altua");
        set(YOUR_HIGH_SCORE_IS, "Zure puntuazio altuena");
        set(TIME, "Denbora");
                set(MATCH_COMPLETED, "Partida amaituta");
        set(TRY_AGAIN, "Saiatu berriro");
        set(WORDS, "Hitzak");
                set(QUIT_GAME, "Irten jokoa");
        set(MATCH_SETTINGS, "Joko-parametroak");
        set(SHARE_PREVIEW, "Partekatu aurrebista");
        set(GAMES, "Jokoak");
        set(SHARE, "Partekatu");
        set(SHARE_SUBJECT, "Nire Morse Training partitura partekatzen");
        set(SHARE_PROMO_TEXT, "Jokatu Morse Training doan https://morsetraining.com helbidean");
        set(THEME, "Gaia");

        set(MATCH_RESULTS, "Partiduen emaitzak");
                

        set(REPEAT, "ERREPIKATU");
        set(HINT, "ARGIBIDEA");

        set(START, "HASI");
        set(PICK_LANG_THEME_ON_SHARE, "Aukeratu hizkuntza eta gaia puntuazioak partekatzean");
        set(CONTINUE, "JARRAITU");
        set(RX, "Jaso");
        set(TX, "Igorri");

        set(KOCH_METHOD, "Koch metodoa");
        set(TARGET, "Helburua");
set(TARGET_MET, "Helburua lortuta");
        set(TARGET_NOT_MET, "Helburua ez da lortu");
            set(LEVEL, "Maila");
    
        set(LEARN, "Ikasi");
        set(PLAY, "Jolastu");
    
        set(LEVELS_COMPLETED, "Osatutako mailak");
        set(RESET_PROGRESS, "Berrezarri progresioa");
        set(RESET_PROGRESS_CONFIRM, "Ziur zaude progresioa berrezarri nahi duzula?");
        set(RESET, "Berrezarri");
            set(WPM, "WPM​");
        set(BACK, "Atzera");
        set(NEXT_LEVEL, "Hurrengo maila");

                set(EFFECTIVE_WPM_FARNSWORTH, "WPM eraginkorra (Farnsworth)");
                set(EXTRA_WORD_SPACING, "Tartea");
                set(EFFECTIVE_WPM_SHORT, "Eraginkorra");

                set(WORD_SPACING_ADD, "Hitz +");

        // Koch custom level
        set(CUSTOM_LEVEL, "Maila pertsonalizatua");
        set(SELECT_CHARACTERS_PROMPT, "Sakatu teklatua interesatzen zatzun karaktereak hautatzeko");
    }
}
