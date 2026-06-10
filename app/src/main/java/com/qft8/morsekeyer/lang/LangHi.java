package com.qft8.morsekeyer.lang;

public class LangHi extends MorseLanguage {
    public LangHi() {
        set(SAVE, "सहेजें");
        set(RESET_DEFAULTS, "डिफ़ॉल्ट पर रीसेट करें");
        set(CLOSE, "बंद करें");
        
        set(SETTINGS_TITLE, "सेटिंग्स");
        set(TONE, "टोन");
        set(USER_INTERFACE, "यूज़र इंटरफ़ेस");
        set(ADVANCED, "उन्नत (प्रदर्शन)");
        set(DECODER_BEHAVIOR, "डिकोडर व्यवहार");

        set(KEY_MODE, "की मोड");
        set(WPM_SPEED, "गति (WPM)");
        set(INVERSE_PADDLES, "पैडल को उल्टा करें");
        set(STRICT_TIMING, "सख्त समय (Strict Timing)");
        set(INTERLETTER_SPACING, "अक्षरों के बीच रिक्ति");
        set(INTERWORD_SPACING, "शब्दों के बीच रिक्ति");
        
        set(FREQUENCY, "आवृत्ति");
        set(VOLUME, "वॉल्यूम");
        set(ENVELOPE, "उदय/पतन का समय (Envelope)");
        set(NOCLICK, "क्लिक से बचने के लिए सॉटूथ सिग्नल");
        
        set(LANGUAGE, "भाषा");
        set(KEYBOARD_TYPE, "कीबोर्ड का प्रकार");
        set(SHOW_TABLE, "मोर्स तालिका दिखाएं");
        set(SHOW_TABLE_CODES, "मोर्स तालिका में डॉट्स और डैश दिखाएं");
        set(SHOW_VISUAL, "दृश्य संकेतक दिखाएं");
        set(SHOW_PADDLES, "स्क्रीन पैडल दिखाएं");
        set(NEXT_WORD_INDICATOR, "अगला शब्द संकेतक");
        set(KEEP_SCREEN_ON, "स्क्रीन चालू रखें");
        set(APP_THEME, "ऐप थीम");
        set(TEXT_COLOR, "टेक्स्ट का रंग");
        set(TEXT_FONT_SIZE, "टेक्स्ट फ़ॉन्ट आकार");
        set(TABLE_FONT_SIZE, "तालिका फ़ॉन्ट आकार");
        set(TABLE_RATIO, "तालिका/स्क्रीन अनुपात");
        
        set(KEEP_ALIVE, "ऑडियो सक्रिय रखें (विलंबता कम करता है)");
        set(AUDIO_BUFFER, "ऑडियो बफ़र (हार्डवेयर)");
        set(PROCESSING_CHUNK, "प्रोसेसिंग चंक");
        set(PERFORMANCE_HINT, "यदि ध्वनि रुकती है, तो बफ़र या चंक बढ़ाएँ। यदि विलंबता अधिक है, तो उन्हें कम करें।");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "समर्थित इनपुट: कीबोर्ड, टच स्क्रीन, माउस या USB एडॉप्टर वाला पैडल।\n\n" +
                "माउस लेफ्ट/राइट-क्लिक कीइंग या यूएसबी-टू-माउस पैडल एडेप्टर के लिए, माउस पॉइंटर को स्क्रीन में लेफ्ट पैडल बटन के ऊपर छोड़ दें, लेफ्ट/राइट क्लिक सही पैडल पर मैप हो जाएगा।\n\n" +
                "USB कीबोर्ड एडॉप्टर (जैसे VBand) के लिए यह बिना किसी सेटअप के काम करता है।\n\n" +
                "सख्त मोड के लिए अक्षरों के बीच उचित समय की आवश्यकता होती है; गैर-सख्त मोड तेज़ संचालन की अनुमति देता है।\n\n" +
                "सामान्य समस्याएँ: यदि ध्वनि बहुत अधिक क्लिक करने वाली है, तो 'सॉ-टूथ' विकल्प आज़माएँ या एनवेलप बदलें। यदि विलंबता बहुत अधिक है, तो बफ़र कम करें।\n\n" +
                "कीबोर्ड कुंजियाँ:\n" +
                "  बायां: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  दायां: ]  D  S  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "कुंजी");
        
        set(SYSTEM_SETTING, "सिस्टम सेटिंग");
        set(DARK_THEME, "डार्क थीम");
        set(LIGHT_THEME, "लाइट थीम");
        
        set(MODE_STRAIGHT, "सीधी कुंजी");
        set(MODE_IAMBIC_A, "आयम्बिक A");
        set(MODE_IAMBIC_B, "आयम्बिक B");
        set(MODE_ULTIMATIC, "अल्टीमेटिक");
        set(MODE_BUG, "बग (अर्ध-स्वचालित)");
        set(MODE_COOTIE, "कूटी (Sideswiper)");
        
        set(CAT_LETTERS, "अक्षर");
        set(CAT_NUMBERS, "संख्याएँ");
        set(CAT_SYMBOLS, "प्रतीक");
        set(CAT_SPECIAL_SYMBOLS, "विशेष प्रतीक");
        set(CAT_SPECIAL, "विशेष अक्षर");
        set(CAT_PROSIGNS_COMMON, "सामान्य प्रक्रिया संकेत");
        set(CAT_ABBREVIATIONS, "सामान्य संक्षिप्त रूप");
        set(CAT_QCODES, "Q कोड");
        set(CAT_PROSIGNS_OTHER, "अन्य प्रक्रिया संकेत");

        set(COLOR_WHITE, "सफेद");
        set(COLOR_BLACK, "काला");
        set(COLOR_RED, "लाल");
        set(COLOR_ORANGE, "नारंगी");
        set(COLOR_YELLOW, "पीला");
        set(COLOR_GREEN, "हरा");
        set(COLOR_CYAN, "स्यान");
        set(COLOR_BLUE, "नीला");
        set(COLOR_PURPLE, "बैंगनी");
        set(COLOR_PINK, "गुलाबी");
        set(SUPPORT_WINDLEREYE, "मेरे संगीत प्रोजेक्ट Windlereye को सुनकर मेरा समर्थन करें");
        set(CANCEL, "रद्द करें");
        set(QUIT, "बाहर निकलें");
        set(QUIT_GAME_PROMPT, "क्या आप वाकई इस गेम से बाहर निकलना चाहते हैं?");

        set(SCORE, "स्कोर: ");
        set(HIGH_SCORE, "उच्च अंक");
        set(YOUR_HIGH_SCORE_IS, "आपका उच्चतम स्कोर है:");
        set(TIME, "समय: ");
                set(MATCH_COMPLETED, "मैच पूरा हुआ");
        set(TRY_AGAIN, "फिर से प्रयास करें");
        set(WORDS, "शब्द");
                set(QUIT_GAME, "छोड़ें");
        set(MATCH_SETTINGS, "खेल पैरामीटर");
        set(SHARE_PREVIEW, "पूर्वावलोकन");
        set(SHARE, "साझा करें");
        set(SHARE_SUBJECT, "मेरा स्कोर साझा कर रहा हूँ");
        set(SHARE_PROMO_TEXT, "https://morsetraining.com पर खेलें");
        set(THEME, "विषय");

        set(MATCH_RESULTS, "परिणाम");
                
        set(INFINITE, "बिना किसी समय सीमा के अभ्यास करें");
        set(THREE_MINUTES, "3 मिनट में अपना स्कोर हराएँ");

        set(REPEAT, "दोहराएं");

        set(START, "शुरू करें");
        set(PICK_LANG_THEME_ON_SHARE, "स्कोर साझा करते समय भाषा और थीम चुनें");
        set(GAMES, "खेल");
        set(CONTINUE, "जारी रखना");
        set(RX, "प्राप्त करना");
        set(TX, "प्रसारित करना");
}
}
