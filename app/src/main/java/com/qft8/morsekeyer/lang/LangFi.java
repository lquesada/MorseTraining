package com.qft8.morsekeyer.lang;

public class LangFi extends MorseLanguage {
    public LangFi() {
        set(SAVE, "Tallenna");
        set(RESET_DEFAULTS, "Palauta oletukset");
        set(CLOSE, "Sulje");
        
        set(SETTINGS_TITLE, "Asetukset");
        set(TONE, "Ääni");
        set(USER_INTERFACE, "Käyttöliittymä");
        set(ADVANCED, "Lisäasetukset (suorituskyky)");
        set(DECODER_BEHAVIOR, "Dekooderin toiminta");

        set(KEY_MODE, "Avaimen tila");
        set(WPM_SPEED, "Nopeus (WPM)");
        set(INVERSE_PADDLES, "Käänteiset lavat");
        set(STRICT_TIMING, "Tarkka ajoitus");
        
        set(FREQUENCY, "Taajuus");
        set(VOLUME, "Äänenvoimakkuus");
        set(ENVELOPE, "Nousu-/laskuaika (envelope)");
        set(NOCLICK, "Sahalaitasignaali (estää napsahdukset)");
        
        set(LANGUAGE, "Kieli");
        set(KEYBOARD_TYPE, "Näppäimistön tyyppi");
        set(SHOW_TABLE, "Näytä Morse-taulukko");
        set(SHOW_TABLE_CODES, "Näytä pisteet ja viivat Morse-taulukossa");
        set(SHOW_VISUAL, "Näytä visuaalinen ilmaisin");
        set(SHOW_PADDLES, "Näytä näytön lavat");
        set(NEXT_WORD_INDICATOR, "Seuraavan sanan ilmaisin");
        set(KEEP_SCREEN_ON, "Pidä näyttö päällä");
        set(APP_THEME, "Sovelluksen teema");
        set(TEXT_COLOR, "Tekstin väri");
        set(TEXT_FONT_SIZE, "Tekstin fonttikoko");
        set(TABLE_FONT_SIZE, "Taulukon fonttikoko");
        set(TABLE_RATIO, "Taulukon suhde näyttöön");
        
        set(KEEP_ALIVE, "Pidä ääni aktiivisena (pienentää viivettä)");
        set(WHITE_NOISE, "Voimakkaampi (toista valkoista kohinaa)");
        set(AUDIO_BUFFER, "Äänipuskuri (laitteisto)");
        set(PROCESSING_CHUNK, "Käsittelypala");
        set(PERFORMANCE_HINT, "Jos ääni pätkii, suurenna puskuria. Jos viive on suuri, pienennä sitä.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Tuetut syötteet: näppäimistö, kosketusnäyttö, hiiri tai sähkötysavain USB-sovittimella.\n\n" +
                "Hiiren vasen/oikea-napsautus tai USB-hiiri-mela -sovitin: jätä hiiren osoitin näytön vasemman melan painikkeen päälle, vasen/oikea napsautus kohdistuu oikeisiin meloihin.\n\n" +
                "USB-näppäimistösovittimet (esim. VBand) toimivat suoraan ilman asetuksia.\n\n" +
                "Tarkka ajoitus vaatii oikeat välit kirjainten välillä; vapaa tila sallii nopeamman käytön.\n\n" +
                "Yleisiä ongelmia: Jos ääni napsuu liikaa, kokeile sahalaitasignaalia tai säädä envelopea. Jos viive on suuri, pienennä puskuria.\n\n" +
                "Näppäimistön näppäimet:\n" +
                "  Vasen: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Oikea: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Avain");
        
        set(SYSTEM_SETTING, "Järjestelmän asetus");
        set(DARK_THEME, "Tumma teema");
        set(LIGHT_THEME, "Vaalea teema");
        
        set(MODE_STRAIGHT, "Pystyahdistin");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Puoliautomaattinen)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "KIRJAIMET");
        set(CAT_NUMBERS, "NUMEROT");
        set(CAT_SYMBOLS, "SYMBOLIT");
        set(CAT_SPECIAL_SYMBOLS, "ERIKOISSYMBOLIT");
        set(CAT_SPECIAL, "ERIKOISKIRJAIMET");
        set(CAT_PROSIGNS_COMMON, "YLEISET MERKINANNONT");
        set(CAT_ABBREVIATIONS, "YLEISET LYHENTEET");
        set(CAT_QCODES, "Q-KOODIT");
        set(CAT_PROSIGNS_OTHER, "Muut merkit");

        set(COLOR_WHITE, "Valkoinen");
        set(COLOR_BLACK, "Musta");
        set(COLOR_RED, "Punainen");
        set(COLOR_ORANGE, "Oranssi");
        set(COLOR_YELLOW, "Keltainen");
        set(COLOR_GREEN, "Vihreä");
        set(COLOR_CYAN, "Syaani");
        set(COLOR_BLUE, "Sininen");
        set(COLOR_PURPLE, "Purppura");
        set(COLOR_PINK, "Vaaleanpunainen");
        set(SUPPORT_WINDLEREYE, "Tue minua kuuntelemalla musiikkiprojektiani Windlereye");
        set(CANCEL, "Peruuta");
        set(QUIT, "Lopeta");
        set(QUIT_GAME_PROMPT, "Haluatko varmasti lopettaa tämän pelin?");

        set(SCORE, "Pisteet");
        set(HIGH_SCORE, "Korkea pistemäärä");
        set(YOUR_HIGH_SCORE_IS, "Ennätyspisteesi on");
        set(TIME, "Aika");
                set(MATCH_COMPLETED, "Ottelu päättynyt");
        set(TRY_AGAIN, "Yritä uudelleen");
        set(WORDS, "Sanat");
                set(QUIT_GAME, "Lopeta peli");
        set(MATCH_SETTINGS, "Pelin parametrit");
        set(SHARE_PREVIEW, "Jaa esikatselu");
        set(GAMES, "Pelit");
        set(SHARE, "Jakaa");
        set(SHARE_SUBJECT, "Jaa Morse Training -pisteet");
        set(SHARE_PROMO_TEXT, "Pelaa Morse Trainingia ilmaiseksi osoitteessa https://morsetraining.com");
        set(THEME, "Teema");

        set(MATCH_RESULTS, "Ottelun tulokset");
                

        set(REPEAT, "TOISTA");
        set(HINT, "VIHJE");

        set(START, "ALOITA");
        set(PICK_LANG_THEME_ON_SHARE, "Valitse kieli ja teema tuloksia jaettaessa");
        set(CONTINUE, "JATKAA");
        set(RX, "Vastaanottaa");
        set(TX, "Lähettää");

        set(KOCH_METHOD, "Koch-menetelmä");
        set(TARGET, "Tavoite");
set(TARGET_MET, "Tavoite saavutettu");
        set(TARGET_NOT_MET, "Tavoite ei saavutettu");
            set(LEVEL, "Taso");
    
        set(LEARN, "Opi");
        set(PLAY, "Pelaa");
    
        set(LEVELS_COMPLETED, "Suoritetut tasot");
        set(RESET_PROGRESS, "Nollaa edistyminen");
        set(RESET_PROGRESS_CONFIRM, "Haluatko varmasti nollata edistymisen?");
        set(RESET, "Nollaa");
            set(WPM, "WPM​");
        set(BACK, "Takaisin");
        set(NEXT_LEVEL, "Seuraava taso");

                set(EFFECTIVE_WPM_FARNSWORTH, "Tehollinen WPM (Farnsworth)");
                set(EXTRA_WORD_SPACING, "Väli");
                set(EFFECTIVE_WPM_SHORT, "Tehollinen");

                set(WORD_SPACING_ADD, "Sana +");

        // Koch custom level
        set(CUSTOM_LEVEL, "Mukautettu taso");
        set(SELECT_CHARACTERS_PROMPT, "Napauta näppäimistöä valitaksesi kiinnostavat merkit");
    }
}
