package com.qft8.morsekeyer.lang;

public class LangBho extends MorseLanguage {
    public LangBho() {
        set(SAVE, "सहेजीं");
        set(RESET_DEFAULTS, "डिफ़ॉल्ट पर सेट करीं");
        set(CLOSE, "बंद करीं");
        
        set(SETTINGS_TITLE, "सेटिंग्स");
        set(TONE, "आवाज़");
        set(USER_INTERFACE, "दिखावट");
        set(ADVANCED, "एडवांस (परफॉर्मेंस)");
        set(DECODER_BEHAVIOR, "डिकोडर के तरीका");

        set(KEY_MODE, "की मोड");
        set(WPM_SPEED, "रफ़्तार (WPM)");
        set(INVERSE_PADDLES, "पैडल उल्टा करीं");
        set(STRICT_TIMING, "कड़क टाइमिंग");
        set(INTERLETTER_SPACING, "अक्षरन के बीच के जगह");
        set(INTERWORD_SPACING, "शब्दन के बीच के जगह");
        
        set(FREQUENCY, "फ्रीक्वेंसी");
        set(VOLUME, "आवाज़");
        set(ENVELOPE, "उठाव/गिरावट के समय");
        set(NOCLICK, "क्लिक से बचे खातिर सॉटूथ सिग्नल");
        
        set(LANGUAGE, "भाषा");
        set(KEYBOARD_TYPE, "कीबोर्ड के प्रकार");
        set(SHOW_TABLE, "मोर्ट टेबल देखाईं");
        set(SHOW_TABLE_CODES, "मोर्स तालिका में डॉट्स आ डैश देखाईं");
        set(SHOW_VISUAL, "निशान देखाईं");
        set(SHOW_PADDLES, "स्क्रीन पैडल देखाईं");
        set(NEXT_WORD_INDICATOR, "अगला शब्द के निशान");
        set(KEEP_SCREEN_ON, "स्क्रीन चालू राखीं");
        set(APP_THEME, "ऐप थीम");
        set(TEXT_COLOR, "लिखाई के रंग");
        set(TEXT_FONT_SIZE, "लिखाई के साइज़");
        set(TABLE_FONT_SIZE, "टेबल लिखाई के साइज़");
        set(TABLE_RATIO, "टेबल/स्क्रीन के हिसाब");
        
        set(KEEP_ALIVE, "आवाज़ चालू राखीं");
        set(AUDIO_BUFFER, "ऑडियो बफ़र");
        set(PROCESSING_CHUNK, "प्रोसेसिंग चंक");
        set(PERFORMANCE_HINT, "अगर आवाज़ कटी, त बफ़र बढ़ाईं। अगर देरी होखे, त कम करीं।");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "सपोर्टेड इनपुट: कीबोर्ड, टच स्क्रीन, माउस भा यूएसबी पैडल एडाप्टर।\n\nमाउस लेफ्ट/राइट-क्लिक कीइंग भा यूएसबी-टू-माउस पैडल एडाप्टर खातिर, माउस पॉइंटर के स्क्रीन में लेफ्ट पैडल बटन के ऊपर छोड़ीं, लेफ्ट/राइट क्लिक सही पैडल प मैप हो जाई।\n\nयूएसबी-टू-कीबोर्ड पैडल एडाप्टर (जइसे VBand) खातिर ई बिना कवनो सेट-अप के काम करेला।\n\nसख्त टाइमिंग खातिर अक्षर के बीच सटीक ठहराव के जरूरत होला; गैर-सख्त तेजी से कीइंग के अनुमति देला।\n\nसमस्या निवारण: अगर आवाज क्लिक करत बा, त सॉटूथ के प्रयास करीं भा लिफाफा बदलीं। अगर लेटेंसी ज्यादा बा, त बफर कम करीं। अगर आवाज अटकत बा, त एकरा के बढ़ाईं।\n\nकीबोर्ड कीज:\n  बायां: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  दायां: ]  D  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

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
        set(CAT_NUMBERS, "नंबर");
        set(CAT_SYMBOLS, "निशान");
        set(CAT_SPECIAL_SYMBOLS, "खास निशान");
        set(CAT_SPECIAL, "खास अक्षर");
        set(CAT_PROSIGNS_COMMON, "साधारण निशान");
        set(CAT_ABBREVIATIONS, "साधारण छोटा नाम");
        set(CAT_QCODES, "Q कोड");
        set(CAT_PROSIGNS_OTHER, "दोसर निशान");

        set(COLOR_WHITE, "सफेद");
        set(COLOR_BLACK, "करिया");
        set(COLOR_RED, "लाल");
        set(COLOR_ORANGE, "नारंगी");
        set(COLOR_YELLOW, "पीयर");
        set(COLOR_GREEN, "हरियर");
        set(COLOR_CYAN, "आसमानी");
        set(COLOR_BLUE, "नीला");
        set(COLOR_PURPLE, "बैंगनी");
        set(COLOR_PINK, "गुलाबी");
        set(SUPPORT_WINDLEREYE, "हमरा संगीत प्रोजेक्ट Windlereye के सुन के हमार समर्थन करीं");
        set(CANCEL, "रद्द करीं");
        set(QUIT, "बाहर निकलीं");
        set(QUIT_GAME_PROMPT, "का रउआ सचमुच एह खेल से बाहर निकलल चाहत बानी?");

        set(SCORE, "स्कोर: ");
        set(HIGH_SCORE, "उच्च अंक");
        set(YOUR_HIGH_SCORE_IS, "राउर सबसे ढेर स्कोर बा:");
        set(TIME, "समय: ");
                set(MATCH_COMPLETED, "मैच पूरा भइल");
        set(TRY_AGAIN, "फेर से कोशिश करीं");
        set(WORDS, "शब्द");
                set(QUIT_GAME, "गेम से बाहर निकलें");
        set(MATCH_SETTINGS, "खेल पैरामीटर");
        set(SHARE_PREVIEW, "पूर्वावलोकन साझा करें");
        set(SHARE, "शेयर करना");
        set(SHARE_SUBJECT, "मेरा मोर्स कीयर स्कोर साझा कर रहा हूँ");
        set(SHARE_PROMO_TEXT, "https://morsetraining.com पर निःशुल्क मोर्स कीयर खेलें");
        set(THEME, "विषय");

        set(MATCH_RESULTS, "मैच के नतीजे");
                
        set(TX_PRACTICE, "संचरण (प्रशिक्षण) के बा .");
        set(TX_CONTEST, "संचारित (स्कोर हमला) के बा।");
        set(INFINITE, "बिना कवनो समय सीमा के अभ्यास करीं");
        set(THREE_MINUTES, "3 मिनट में आपन स्कोर हरा दीं");

        set(RX_PRACTICE, "प्राप्त (प्रशिक्षण) के बा .");
        set(RX_CONTEST, "प्राप्त (स्कोर हमला) के बा।");
        set(REPEAT, "दोहराईं");

        set(START, "शुरू करीं");
        set(PICK_LANG_THEME_ON_SHARE, "स्कोर साझा करत समय भाषा आ थीम चुनीं");
        set(GAMES, "खेल");
        set(CONTINUE, "जारी रखना");
        set(RX, "Receive");
        set(TX, "Transmit");
}
}
