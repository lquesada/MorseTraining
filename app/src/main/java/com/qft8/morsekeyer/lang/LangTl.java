package com.qft8.morsekeyer.lang;

public class LangTl extends MorseLanguage {
    public LangTl() {
        set(SAVE, "I-save");
        set(RESET_DEFAULTS, "I-reset sa default");
        set(CLOSE, "Isara");
        
        set(SETTINGS_TITLE, "Mga Setting");
        set(TONE, "Tono");
        set(USER_INTERFACE, "Interface ng User");
        set(ADVANCED, "Mas mataas (pagganap)");
        set(DECODER_BEHAVIOR, "Gawi ng Decoder");

        set(KEY_MODE, "Mode ng Key");
        set(WPM_SPEED, "Bilis (WPM)");
        set(INVERSE_PADDLES, "I-baligtad ang mga paddle");
        set(STRICT_TIMING, "Mahigpit na timing");
        set(INTERLETTER_SPACING, "Patlang sa pagitan ng mga titik");
        set(INTERWORD_SPACING, "Patlang sa pagitan ng mga salita");
        
        set(FREQUENCY, "Dalas");
        set(VOLUME, "Lakas ng tunog");
        set(ENVELOPE, "Oras ng pag-angat/pagbaba (sobre)");
        set(NOCLICK, "Gamitin ang sawtooth signal para maiwasan ang mga click");
        
        set(LANGUAGE, "Wika");
        set(KEYBOARD_TYPE, "Uri ng keyboard");
        set(SHOW_TABLE, "Ipakita ang talahanayan ng Morse");
        set(SHOW_TABLE_CODES, "Ipakita ang mga dits at dahs sa talahanayan ng Morse");
        set(SHOW_VISUAL, "Ipakita ang visual indicator");
        set(SHOW_PADDLES, "Ipakita ang mga paddle sa screen");
        set(NEXT_WORD_INDICATOR, "Indicator ng susunod na salita");
        set(KEEP_SCREEN_ON, "Panatilihing bukas ang screen");
        set(APP_THEME, "Tema ng app");
        set(TEXT_COLOR, "Kulay ng text");
        set(TEXT_FONT_SIZE, "Laki ng font ng text");
        set(TABLE_FONT_SIZE, "Laki ng font ng talahanayan");
        set(TABLE_RATIO, "Ratio ng talahanayan/screen");
        
        set(KEEP_ALIVE, "Panatilihing aktibo ang audio (binabawasan ang latency)");
        set(AUDIO_BUFFER, "Audio buffer (hardware)");
        set(PROCESSING_CHUNK, "Bahagi ng pagproseso");
        set(PERFORMANCE_HINT, "Kung napuputol ang tunog, dagdagan ang buffer. Kung mataas ang latency, bawasan ito.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Mga suportadong input: keyboard, touch screen, mouse, o paddle na may USB adapter.\n\n" +
                "Para sa pag-key ng pag-click sa kaliwa/kanan ng mouse o adaptor ng USB-to-mouse paddle, iwanan ang pointer ng mouse sa ibabaw ng button na kaliwang paddle sa screen, ang pag-click sa kaliwa/kanan ay imamapa sa mga tamang paddle.\n\n" +
                "Para sa mga USB keyboard adapter (hal. VBand), gagana ito agad nang walang setup.\n\n" +
                "Ang mahigpit na mode ay nangangailangan ng tamang timing sa pagitan ng mga titik; ang hindi mahigpit na mode ay nagbibigay-daan sa mas mabilis na pag-key.\n\n" +
                "Mga karaniwang isyu: Kung masyadong ma-click ang tunog, subukan ang 'Sawtooth' option o baguhin ang envelope. Kung mataas ang latency, bawasan ang buffer.\n\n" +
                "Mga key sa keyboard:\n" +
                "  Kaliwa: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Kanan: ]  D  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Susi");
        
        set(SYSTEM_SETTING, "Setting ng system");
        set(DARK_THEME, "Madilim na tema");
        set(LIGHT_THEME, "Maliwanag na tema");
        
        set(MODE_STRAIGHT, "Straight key");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Semi-auto)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "MGA TITIK");
        set(CAT_NUMBERS, "MGA NUMERO");
        set(CAT_SYMBOLS, "MGA SIMBOLO");
        set(CAT_SPECIAL_SYMBOLS, "MGA ESPESYAL NA SIMBOLO");
        set(CAT_SPECIAL, "MGA ESPESYAL NA TITIK");
        set(CAT_PROSIGNS_COMMON, "MGA KARANIWANG PROCEDURAL SIGNAL");
        set(CAT_ABBREVIATIONS, "MGA KARANIWANG ABREBYASYON");
        set(CAT_QCODES, "MGA Q CODE");
        set(CAT_PROSIGNS_OTHER, "IBA PANG MGA PROCEDURAL SIGNAL");

        set(COLOR_WHITE, "Puti");
        set(COLOR_BLACK, "Itim");
        set(COLOR_RED, "Pula");
        set(COLOR_ORANGE, "Kahel");
        set(COLOR_YELLOW, "Dilaw");
        set(COLOR_GREEN, "Berde");
        set(COLOR_CYAN, "Cyan");
        set(COLOR_BLUE, "Asul");
        set(COLOR_PURPLE, "Lila");
        set(COLOR_PINK, "Rosas");
        set(SUPPORT_WINDLEREYE, "Suportahan ako sa pamamagitan ng pakikinig sa aking music project na Windlereye");
        set(CANCEL, "Kanselahin");
        set(QUIT, "Umalis");
        set(QUIT_GAME_PROMPT, "Sigurado ka bang gusto mong umalis sa larong ito?");

        set(SCORE, "Iskor: ");
        set(HIGH_SCORE, "Mataas na marka");
        set(YOUR_HIGH_SCORE_IS, "Ang pinakamataas mong iskor ay:");
        set(TIME, "Oras: ");
                set(MATCH_COMPLETED, "Tapos na ang laban");
        set(TRY_AGAIN, "Subukan muli");
        set(WORDS, "Mga salita");
                set(QUIT_GAME, "Itigil ang Laro");
        set(MATCH_SETTINGS, "Mga parameter ng laro");
        set(SHARE_PREVIEW, "Ibahagi ang preview");
        set(SHARE, "Ibahagi");
        set(SHARE_SUBJECT, "Ibinabahagi ang aking marka ng Morse Training");
        set(SHARE_PROMO_TEXT, "Maglaro ng Morse Training nang libre sa https://morsetraining.com");
        set(THEME, "Tema");

        set(MATCH_RESULTS, "Mga resulta ng tugma");
                
        set(TX_PRACTICE, "Ipadala (Pagsasanay)");
        set(TX_CONTEST, "Ipadala (Score Attack)");
        set(INFINITE, "Magsanay nang walang limitasyon sa oras");
        set(THREE_MINUTES, "Talunin ang iyong iskor sa loob ng 3 minuto");

        set(RX_PRACTICE, "Tumanggap (Pagsasanay)");
        set(RX_CONTEST, "Tumanggap (Pag-atake ng Kalidad)");
        set(REPEAT, "ULITIN");

        set(START, "SIMULAN");
        set(PICK_LANG_THEME_ON_SHARE, "Pumili ng wika at tema kapag nagbabahagi ng mga marka");
        set(GAMES, "Mga Laro");
        set(CONTINUE, "MAGPATULOY");
        set(RX, "Tumanggap");
        set(TX, "Ipadala");
}
}
