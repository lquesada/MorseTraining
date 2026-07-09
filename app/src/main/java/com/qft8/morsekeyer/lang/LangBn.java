package com.qft8.morsekeyer.lang;

public class LangBn extends MorseLanguage {
    public LangBn() {
        set(SAVE, "সংরক্ষণ করুন");
        set(RESET_DEFAULTS, "ডিফল্ট রিসেট করুন");
        set(CLOSE, "বন্ধ করুন");
        
        set(SETTINGS_TITLE, "সেটিংস");
        set(TONE, "টোন");
        set(USER_INTERFACE, "ইউজার ইন্টারফেস");
        set(ADVANCED, "উন্নত (পারফরম্যান্স)");
        set(DECODER_BEHAVIOR, "ডিকোডার আচরণ");

        set(KEY_MODE, "কী মোড");
        set(WPM_SPEED, "গতি (WPM)");
        set(INVERSE_PADDLES, "প্যাডেল উল্টান");
        set(STRICT_TIMING, "কঠোর টাইমিং");
        
        set(FREQUENCY, "ফ্রিকোয়েন্সি");
        set(VOLUME, "ভলিউম");
        set(ENVELOPE, "রাইজ/ফল টাইম (এনভেলপ)");
        set(NOCLICK, "ক্লিক এড়াতে সটুথ সিগন্যাল");
        
        set(LANGUAGE, "ভাষা");
        set(KEYBOARD_TYPE, "কীবোর্ডের ধরন");
        set(SHOW_TABLE, "মোর্স টেবিল দেখান");
        set(SHOW_TABLE_CODES, "মোর্স টেবিলে ডটস এবং ড্যাশ দেখান");
        set(SHOW_VISUAL, "ভিজ্যুয়াল ইন্ডিকেটর দেখান");
        set(SHOW_PADDLES, "স্ক্রিন প্যাডেল দেখান");
        set(NEXT_WORD_INDICATOR, "পরবর্তী শব্দ নির্দেশক");
        set(KEEP_SCREEN_ON, "স্ক্রিন চালু রাখুন");
        set(APP_THEME, "অ্যাপ থিম");
        set(TEXT_COLOR, "টেক্সট কালার");
        set(TEXT_FONT_SIZE, "টেক্সট ফন্ট সাইজ");
        set(TABLE_FONT_SIZE, "টেবিল ফন্ট সাইজ");
        set(TABLE_RATIO, "টেবিল/স্ক্রিন অনুপাত");
        
        set(KEEP_ALIVE, "অডিও সক্রিয় রাখুন (ল্যাটেন্সি কমায়)");
        set(WHITE_NOISE, "আরও শক্তিশালী (সাদা নয়েজ চালান)");
        set(AUDIO_BUFFER, "অডিও বাফার (হার্ডওয়্যার)");
        set(PROCESSING_CHUNK, "প্রসেসিং চাঙ্ক");
        set(PERFORMANCE_HINT, "শব্দ কেটে গেলে বাফার বা চাঙ্ক বাড়ান। ল্যাটেন্সি বেশি হলে কমান।");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "সমর্থিত ইনপুট: কীবোর্ড, টাচ স্ক্রিন, মাউস বা USB অ্যাডাপ্টার সহ প্যাডেল।\n\n" +
                "মাউস লেফট/রাইট-ক্লিক কিয়িং বা ইউএসবি-টু-মাউস প্যাডেল অ্যাডাপ্টারের জন্য, স্ক্রিনে বাম প্যাডেল বোতামের উপরে মাউস পয়েন্টারটি ছেড়ে দিন, বাম/ডান ক্লিক সঠিক প্যাডেলে ম্যাপ হবে।\n\n" +
                "USB কীবোর্ড অ্যাডাপ্টারের (যেমন VBand) জন্য এটি সরাসরি কাজ করে।\n\n" +
                "কঠোর মোডে অক্ষরের মাঝে সঠিক টাইমিং প্রয়োজন; সাধারণ মোডে দ্রুত কিয়িং সম্ভব।\n\n" +
                "সাধারণ সমস্যা: শব্দে বেশি ক্লিক হলে 'সটুথ' অপশন ব্যবহার করুন বা এনভেলপ পরিবর্তন করুন। ল্যাটেন্সি বেশি হলে বাফার কমান।\n\n" +
                "কীবোর্ড কী:\n" +
                "  বাম: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  ডান: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "কী");
        
        set(SYSTEM_SETTING, "সিস্টেম সেটিংস");
        set(DARK_THEME, "ডার্ক থিম");
        set(LIGHT_THEME, "লাইট থিম");
        
        set(MODE_STRAIGHT, "স্ট্রেইট কী");
        set(MODE_IAMBIC_A, "আয়াম্বিক A");
        set(MODE_IAMBIC_B, "আয়াম্বিক B");
        set(MODE_ULTIMATIC, "আল্টিমেটিক");
        set(MODE_BUG, "বাগ (আধা-স্বয়ংক্রিয়)");
        set(MODE_COOTIE, "কুটি (Sideswiper)");
        
        set(CAT_LETTERS, "অক্ষর");
        set(CAT_NUMBERS, "সংখ্যা");
        set(CAT_SYMBOLS, "চিহ্ন");
        set(CAT_SPECIAL_SYMBOLS, "বিশেষ চিহ্ন");
        set(CAT_SPECIAL, "বিশেষ অক্ষর");
        set(CAT_PROSIGNS_COMMON, "সাধারণ প্রসাইন");
        set(CAT_ABBREVIATIONS, "সাধারণ সংক্ষিপ্ত রূপ");
        set(CAT_QCODES, "Q কোড");
        set(CAT_PROSIGNS_OTHER, "অন্যান্য প্রসাইন");

        set(COLOR_WHITE, "সাদা");
        set(COLOR_BLACK, "কালো");
        set(COLOR_RED, "লাল");
        set(COLOR_ORANGE, "কমলা");
        set(COLOR_YELLOW, "হলুদ");
        set(COLOR_GREEN, "সবুজ");
        set(COLOR_CYAN, "সায়ান");
        set(COLOR_BLUE, "নীল");
        set(COLOR_PURPLE, "বেগুনি");
        set(COLOR_PINK, "গোলাপী");
        set(SUPPORT_WINDLEREYE, "আমার সঙ্গীত প্রকল্প Windlereye শুনে আমাকে সমর্থন করুন");
        set(CANCEL, "বাতিল");
        set(QUIT, "প্রস্থান");
        set(QUIT_GAME_PROMPT, "আপনি কি নিশ্চিত যে আপনি এই গেমটি থেকে প্রস্থান করতে চান?");

        set(SCORE, "স্কোর");
        set(HIGH_SCORE, "উচ্চ স্কোর");
        set(YOUR_HIGH_SCORE_IS, "আপনার সর্বোচ্চ স্কোর");
        set(TIME, "সময়");
                set(MATCH_COMPLETED, "ম্যাচ সম্পন্ন");
        set(TRY_AGAIN, "আবার চেষ্টা করুন");
        set(WORDS, "শব্দ");
                set(QUIT_GAME, "খেলা ছেড়ে দিন");
        set(MATCH_SETTINGS, "খেলার পরামিতি");
        set(SHARE_PREVIEW, "শেয়ার পূর্বরূপ");
        set(SHARE, "শেয়ার করুন");
        set(SHARE_SUBJECT, "আমার মোর্স কিয়ার স্কোর ভাগ করা");
        set(SHARE_PROMO_TEXT, "https://morsetraining.com এ বিনামূল্যে Morse Training খেলুন");
        set(THEME, "থিম");

        set(MATCH_RESULTS, "ম্যাচের ফলাফল");
                

        set(REPEAT, "পুনরাবৃত্তি");

        set(START, "শুরু করুন");
        set(PICK_LANG_THEME_ON_SHARE, "স্কোর শেয়ার করার সময় ভাষা এবং থيم বেছে নিন");
        set(GAMES, "গেমস");
        set(CONTINUE, "চালিয়ে যান");
        set(RX, "গ্রহণ করা");
        set(TX, "সম্প্রচার করা");

        set(KOCH_METHOD, "কোচ পদ্ধতি");
        set(TARGET, "লক্ষ্য");
set(TARGET_MET, "লক্ষ্য পূরণ হয়েছে");
        set(TARGET_NOT_MET, "লক্ষ্য পূরণ হয়নি");
            set(LEVEL, "স্তর");
    
        set(LEARN, "শিখুন");
        set(PLAY, "খেলুন");
    
        set(LEVELS_COMPLETED, "সম্পন্ন স্তর");
        set(RESET_PROGRESS, "অগ্রগতি রিসেট করুন");
        set(RESET_PROGRESS_CONFIRM, "আপনি কি অগ্রগতি রিসেট করতে চান?");
        set(RESET, "রিসেট করুন");
            set(WPM, "WPM​");
        set(BACK, "ফিরে যান");
        set(NEXT_LEVEL, "পরবর্তী স্তর");

                set(EFFECTIVE_WPM_FARNSWORTH, "কার্যকর ডব্লিউপিএম (ফার্নসওয়ার্থ)");
                set(EXTRA_WORD_SPACING, "অতিরিক্ত শব্দ ব্যবধান");
                set(EFFECTIVE_WPM_SHORT, "কার্যকর");

                set(WORD_SPACING_ADD, "শব্দ +");
    }
}