package com.qft8.morsekeyer.lang;

public class LangSw extends MorseLanguage {
    public LangSw() {
        set(SAVE, "Hifadhi");
        set(RESET_DEFAULTS, "Rejesha msingi");
        set(CLOSE, "Funga");
        
        set(SETTINGS_TITLE, "Mipangilio");
        set(TONE, "Sauti");
        set(USER_INTERFACE, "Muonekano");
        set(ADVANCED, "Hali ya juu (utendaji)");
        set(DECODER_BEHAVIOR, "Tabia ya dikoda");

        set(KEY_MODE, "Njia ya ufunguo");
        set(WPM_SPEED, "Kasi (WPM)");
        set(INVERSE_PADDLES, "Geuza pedali");
        set(STRICT_TIMING, "Muda madhubuti");
        set(INTERLETTER_SPACING, "Nafasi kati ya herufi");
        set(INTERWORD_SPACING, "Nafasi kati ya maneno");
        
        set(FREQUENCY, "Masafa");
        set(VOLUME, "Sauti");
        set(ENVELOPE, "Muda wa kupanda/kushuka (bahasha)");
        set(NOCLICK, "Tumia mawimbi ya msumeno ili kuepuka kelele");
        
        set(LANGUAGE, "Lugha");
        set(KEYBOARD_TYPE, "Aina ya kibodi");
        set(SHOW_TABLE, "Onyesha jedwali la Morse");
        set(SHOW_TABLE_CODES, "Onyesha nukta na mistari katika jedwali la Morse");
        set(SHOW_VISUAL, "Onyesha kiashiria cha picha");
        set(SHOW_PADDLES, "Onyesha pedali kwenye skrini");
        set(NEXT_WORD_INDICATOR, "Kiashiria cha neno linalofuata");
        set(KEEP_SCREEN_ON, "Weka skrini iwe imewaka");
        set(APP_THEME, "Mandhari ya programu");
        set(TEXT_COLOR, "Rangi ya maandishi");
        set(TEXT_FONT_SIZE, "Ukubwa wa font ya maandishi");
        set(TABLE_FONT_SIZE, "Ukubwa wa font ya jedwali");
        set(TABLE_RATIO, "Uwiano wa jedwali/skrini");
        
        set(KEEP_ALIVE, "Weka sauti iwe hai (hupunguza kuchelewa)");
        set(AUDIO_BUFFER, "Hifadhi ya sauti (vifaa)");
        set(PROCESSING_CHUNK, "Kipande cha usindikaji");
        set(PERFORMANCE_HINT, "Sauti ikikatika, ongeza hifadhi. Sauti ikichelewa sana, ipunguze.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Ingizo zinazotumika: kibodi, skrini ya kugusa, panya au pedali yenye adapta ya USB.\n\n" +
                "Kwa kubofya kipanya kushoto/kulia au adapta ya kasia ya USB-hadi-panya, acha kielekezi cha kipanya juu ya kitufe cha kasia cha kushoto kwenye skrini, kubofya kushoto/kulia kutasawiri kwenye kasia sahihi.\n\n" +
                "Kuhusu adapta za kibodi za USB (kama VBand) inafanya kazi moja kwa moja bila mipangilio.\n\n" +
                "Njia madhubuti inahitaji muda sahihi kati ya herufi; njia isiyo madhubuti inaruhusu ufunguaji wa kasi zaidi.\n\n" +
                "Matatizo ya kawaida: Sauti ikiwa na kelele sana, jaribu chaguo la 'Msumeno' au ubadilishe bahasha. Sauti ikichelewa sana, punguza hifadhi.\n\n" +
                "Vifungo vya kibodi:\n" +
                "  Kushoto: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Kulia: ]  D  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Ufunguo");
        
        set(SYSTEM_SETTING, "Mpangilio wa mfumo");
        set(DARK_THEME, "Mandhari meusi");
        set(LIGHT_THEME, "Mandhari meupe");
        
        set(MODE_STRAIGHT, "Ufunguo wa wima");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Nusu-otomatiki)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "HERUFI");
        set(CAT_NUMBERS, "NAMBARI");
        set(CAT_SYMBOLS, "ALAMA");
        set(CAT_SPECIAL_SYMBOLS, "ALAMA MAALUM");
        set(CAT_SPECIAL, "HERUFI MAALUM");
        set(CAT_PROSIGNS_COMMON, "ISHARA ZA KAWAIDA ZA UTARATIBU");
        set(CAT_ABBREVIATIONS, "VIFUPISHO VYA KAWAIDA");
        set(CAT_QCODES, "MISIMBO YA Q");
        set(CAT_PROSIGNS_OTHER, "ISHARA NYINGINE ZA UTARATIBU");

        set(COLOR_WHITE, "Nyeupe");
        set(COLOR_BLACK, "Nyeusi");
        set(COLOR_RED, "Nyekundu");
        set(COLOR_ORANGE, "Chungwa");
        set(COLOR_YELLOW, "Njano");
        set(COLOR_GREEN, "Kijani");
        set(COLOR_CYAN, "Bluu Bahari");
        set(COLOR_BLUE, "Bluu");
        set(COLOR_PURPLE, "Zambarau");
        set(COLOR_PINK, "Waridi");
        set(SUPPORT_WINDLEREYE, "Niunge mkono kwa kusikiliza mradi wangu wa muziki Windlereye");
        set(CANCEL, "Ghairi");
        set(QUIT, "Toka");
        set(QUIT_GAME_PROMPT, "Una uhakika unataka kutoka kwenye mchezo huu?");

        set(SCORE, "Alama: ");
        set(HIGH_SCORE, "Alama ya juu");
        set(YOUR_HIGH_SCORE_IS, "Alama yako ya juu ni:");
        set(TIME, "Muda: ");
                set(MATCH_COMPLETED, "Mechi imekamilika");
        set(TRY_AGAIN, "Jaribu tena");
        set(WORDS, "Maneno");
                set(QUIT_GAME, "Acha Mchezo");
        set(MATCH_SETTINGS, "Vigezo vya mchezo");
        set(SHARE_PREVIEW, "Shiriki onyesho la kukagua");
        set(SHARE, "Shiriki");
        set(SHARE_SUBJECT, "Ninashiriki alama yangu ya Morse Training");
        set(SHARE_PROMO_TEXT, "Cheza Morse Training bila malipo kwenye https://morsetraining.com");
        set(THEME, "Mandhari");

        set(MATCH_RESULTS, "Matokeo ya mechi");
                
        set(TX_PRACTICE, "Sambaza (Mafunzo)");
        set(TX_CONTEST, "Sambaza (Shambulio la Alama)");
        set(INFINITE, "Fanya mazoezi bila kikomo cha muda");
        set(THREE_MINUTES, "Shinda alama zako katika dakika 3");

        set(RX_PRACTICE, "Pokea (Mafunzo)");
        set(RX_CONTEST, "Pokea (Shambulio la Alama)");
        set(REPEAT, "RUDIA");

        set(START, "ANZA");
        set(PICK_LANG_THEME_ON_SHARE, "Chagua lugha na mandhari unaposhiriki alama");
        set(GAMES, "Michezo");
        set(CONTINUE, "ENDELEA");
        set(RX, "Pokea");
        set(TX, "Sambaza");
}
}
