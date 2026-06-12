package com.qft8.morsekeyer.lang;

public class LangMr extends MorseLanguage {
    public LangMr() {
        set(SAVE, "जतन करा");
        set(RESET_DEFAULTS, "डीफॉल्टवर रिसेट करा");
        set(CLOSE, "बंद करा");
        
        set(SETTINGS_TITLE, "सेटिंग्ज");
        set(TONE, "टोन");
        set(USER_INTERFACE, "युजर इंटरफेस");
        set(ADVANCED, "प्रगत (कामगिरी)");
        set(DECODER_BEHAVIOR, "डिकोडर वर्तन");

        set(KEY_MODE, "की मोड");
        set(WPM_SPEED, "वेग (WPM)");
        set(INVERSE_PADDLES, "पॅडल उलटे करा");
        set(STRICT_TIMING, "कठोर वेळ (Strict Timing)");
        set(INTERLETTER_SPACING, "अक्षरांमधील अंतर");
        set(INTERWORD_SPACING, "शब्दांमधील अंतर");
        
        set(FREQUENCY, "वारंवारता (Frequency)");
        set(VOLUME, "आवाज");
        set(ENVELOPE, "वाढण्याचा/कमी होण्याचा वेळ (Envelope)");
        set(NOCLICK, "क्लिक टाळण्यासाठी सॉटूथ सिग्नल");
        
        set(LANGUAGE, "भाषा");
        set(KEYBOARD_TYPE, "कीबोर्ड प्रकार");
        set(SHOW_TABLE, "मोर्स टेबल दाखवा");
        set(SHOW_TABLE_CODES, "मोर्स टेबलमध्ये डॉट्स आणि डॅश दाखवा");
        set(SHOW_VISUAL, "दृश्य निर्देशक दाखवा");
        set(SHOW_PADDLES, "स्क्रीन पॅडल दाखवा");
        set(NEXT_WORD_INDICATOR, "पुढील शब्द निर्देशक");
        set(KEEP_SCREEN_ON, "स्क्रीन चालू ठेवा");
        set(APP_THEME, "अॅप थीम");
        set(TEXT_COLOR, "मजकूराचा रंग");
        set(TEXT_FONT_SIZE, "मजकूर फॉन्ट आकार");
        set(TABLE_FONT_SIZE, "टेबल फॉन्ट आकार");
        set(TABLE_RATIO, "टेबल/स्क्रीन प्रमाण");
        
        set(KEEP_ALIVE, "ऑडिओ सक्रिय ठेवा (विलंब कमी होतो)");
        set(AUDIO_BUFFER, "ऑडिओ बफर (हार्डवेअर)");
        set(PROCESSING_CHUNK, "प्रोसेसिंग चंक");
        set(PERFORMANCE_HINT, "जर आवाज अडकला तर बफर किंवा चंक वाढवा. विलंब जास्त असल्यास कमी करा.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "समर्थित इनपुट: कीबोर्ड, टच स्क्रीन, माउस किंवा USB अडॅप्टर असलेला पॅडल।\n\n" +
                "माउस लेफ्ट/राइट-क्लिक कीइंग किंवा यूएसबी-टू-माऊस पॅडल अॅडॉप्टरसाठी, माऊस पॉइंटर स्क्रीनमधील लेफ्ट पॅडल बटणावर सोडा, लेफ्ट/राईट क्लिक योग्य पॅडल्सवर मॅप करेल.\n\n" +
                "USB कीबोर्ड अडॅप्टरसाठी (उदा. VBand) हे कोणत्याही सेटअपशिवाय थेट काम करते।\n\n" +
                "कठोर मोडमध्ये अक्षरांमधील योग्य वेळेची आवश्यकता असते; इतर मोडमध्ये जलद गतीने काम करता येते।\n\n" +
                "सामान्य समस्या: जर आवाजात जास्त क्लिक येत असतील तर 'सॉ-टूथ' पर्याय वापरून पहा। विलंब जास्त असल्यास बफर कमी करा।\n\n" +
                "कीबोर्ड बटणे:\n" +
                "  डावे: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  उजवे: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "की");
        
        set(SYSTEM_SETTING, "सिस्टम सेटिंग");
        set(DARK_THEME, "डार्क थीम");
        set(LIGHT_THEME, "लाइट थीम");
        
        set(MODE_STRAIGHT, "सरळ की (Vertical)");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "बग (अर्ध-स्वयंचलित)");
        set(MODE_COOTIE, "कूटी (Sideswiper)");
        
        set(CAT_LETTERS, "अक्षरे");
        set(CAT_NUMBERS, "संख्या");
        set(CAT_SYMBOLS, "चिन्हे");
        set(CAT_SPECIAL_SYMBOLS, "विशेष चिन्हे");
        set(CAT_SPECIAL, "विशेष अक्षरे");
        set(CAT_PROSIGNS_COMMON, "सामान्य प्रक्रिया चिन्हे");
        set(CAT_ABBREVIATIONS, "सामान्य संक्षेप");
        set(CAT_QCODES, "Q कोड");
        set(CAT_PROSIGNS_OTHER, "इतर प्रक्रिया चिन्हे");

        set(COLOR_WHITE, "पांढरा");
        set(COLOR_BLACK, "काळा");
        set(COLOR_RED, "लाल");
        set(COLOR_ORANGE, "नारंगी");
        set(COLOR_YELLOW, "पिवळा");
        set(COLOR_GREEN, "हिरवा");
        set(COLOR_CYAN, "स्यान");
        set(COLOR_BLUE, "निळा");
        set(COLOR_PURPLE, "जांभळा");
        set(COLOR_PINK, "गुलाबी");
        set(SUPPORT_WINDLEREYE, "माझा संगीत प्रकल्प Windlereye ऐकून मला पाठिंबा द्या");
        set(CANCEL, "रद्द करा");
        set(QUIT, "बाहेर पडा");
        set(QUIT_GAME_PROMPT, "तुम्हाला नक्की हा गेम सोडायचा आहे का?");

        set(SCORE, "गुण: ");
        set(HIGH_SCORE, "उच्च स्कोअर");
        set(YOUR_HIGH_SCORE_IS, "तुमचा उच्चांक आहे:");
        set(TIME, "वेळ: ");
                set(MATCH_COMPLETED, "सामना पूर्ण झाला");
        set(TRY_AGAIN, "पुन्हा प्रयत्न करा");
        set(WORDS, "शब्द");
                set(QUIT_GAME, "गेम सोडा");
        set(MATCH_SETTINGS, "गेम पॅरामीटर्स");
        set(SHARE_PREVIEW, "पूर्वावलोकन शेअर करा");
        set(SHARE, "शेअर करा");
        set(SHARE_SUBJECT, "माझा मोर्स कीर स्कोअर शेअर करत आहे");
        set(SHARE_PROMO_TEXT, "https://morsetraining.com वर मोर्स कीअर विनामूल्य खेळा");
        set(THEME, "थीम");

        set(MATCH_RESULTS, "सामना निकाल");
                

        set(REPEAT, "पुन्हा सांगा");

        set(START, "सुरू करा");
        set(PICK_LANG_THEME_ON_SHARE, "स्कोर शेअर करताना भाषा आणि थीम निवडा");
        set(GAMES, "खेळ");
        set(CONTINUE, "सुरू ठेवा");
        set(RX, "प्राप्त करणे");
        set(TX, "प्रसारित करणे");

        set(KOCH_METHOD, "कोच पद्धत");
        set(TARGET, "लक्ष्य");
        set(LISTEN, "ऐका");
        set(TARGET_MET, "लक्ष्य साध्य");
        set(TARGET_NOT_MET, "लक्ष्य साध्य नाही");
            set(LEVEL, "पातळी");
    
        set(LEARN, "शिका");
        set(PLAY, "खेळा");
    
        set(LEVELS_COMPLETED, "पूर्ण झालेल्या पातळ्या");
        set(RESET_PROGRESS, "प्रगती रीसेट करा");
        set(RESET_PROGRESS_CONFIRM, "तुम्हाला नक्की प्रगती रीसेट करायची आहे का?");
        set(RESET, "रीसेट करा");
            set(WPM, "WPM​");
        set(SPACING, "अंतर");
    }
}