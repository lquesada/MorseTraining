package com.qft8.morsekeyer.lang;

public class LangUr extends MorseLanguage {
    public LangUr() {
        set(SAVE, "محفوظ کریں");
        set(RESET_DEFAULTS, "ڈیفالٹ پر ری سیٹ کریں");
        set(CLOSE, "بند کریں");
        
        set(SETTINGS_TITLE, "ترتیبات");
        set(TONE, "ٹون");
        set(USER_INTERFACE, "صارف انٹرفیس");
        set(ADVANCED, "جدید (کارکردگی)");
        set(DECODER_BEHAVIOR, "ڈیکوڈر کا رویہ");

        set(KEY_MODE, "کی موڈ");
        set(WPM_SPEED, "رفتار (WPM)");
        set(INVERSE_PADDLES, "پیڈل الٹ دیں");
        set(STRICT_TIMING, "سخت ٹائمنگ");
        
        set(FREQUENCY, "فریکوئنسی");
        set(VOLUME, "آواز");
        set(ENVELOPE, "چڑھاؤ/اتار کا وقت (Envelope)");
        set(NOCLICK, "کلکس سے بچنے کے لیے سا ٹوتھ سگنل");
        
        set(LANGUAGE, "زبان");
        set(KEYBOARD_TYPE, "کی بورڈ کی قسم");
        set(SHOW_TABLE, "مورس ٹیبل دکھائیں");
        set(SHOW_TABLE_CODES, "مورس ٹیبل میں ڈاٹس اور ڈیش دکھائیں");
        set(SHOW_VISUAL, "بصری اشارے دکھائیں");
        set(SHOW_PADDLES, "اسکرین پیڈل دکھائیں");
        set(NEXT_WORD_INDICATOR, "اگلے لفظ کا اشارہ");
        set(KEEP_SCREEN_ON, "اسکرین آن رکھیں");
        set(APP_THEME, "ایپ تھیم");
        set(TEXT_COLOR, "متن کا رنگ");
        set(TEXT_FONT_SIZE, "متن کے فونٹ کا سائز");
        set(TABLE_FONT_SIZE, "ٹیبل فونٹ سائز");
        set(TABLE_RATIO, "ٹیبل/اسکرین تناسب");
        
        set(KEEP_ALIVE, "آڈیو فعال رکھیں (تاخیر کم کرتا ہے)");
        set(WHITE_NOISE, "مضبوط (سفید شور چلائیں)");
        set(AUDIO_BUFFER, "آڈیو بفر (ہارڈ ویئر)");
        set(PROCESSING_CHUNK, "پروسیسنگ چنک");
        set(PERFORMANCE_HINT, "اگر آواز کٹتی ہے تو بفر یا چنک بڑھائیں۔ اگر تاخیر زیادہ ہے تو انہیں کم کریں۔");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "تائید شدہ ان پٹ: کی بورڈ، ٹچ اسکرین، ماؤس یا USB اڈاپٹر والا پیڈل۔\n\n" +
                "ماؤس لیفٹ/رائٹ کلک کیئنگ یا USB-ٹو-ماؤس پیڈل اڈاپٹر کے لیے، ماؤس پوائنٹر کو اسکرین میں بائیں پیڈل بٹن کے اوپر چھوڑ دیں، بایاں/دایاں کلک درست پیڈلز کا نقشہ بنائے گا۔\n\n" +
                "USB کی بورڈ اڈاپٹر (جیسے VBand) کے لیے یہ بغیر کسی سیٹ اپ کے کام کرتا ہے۔\n\n" +
                "سخت موڈ میں حروف کے درمیان درست ٹائمنگ کی ضرورت ہوتی ہے؛ غیر سخت موڈ تیز آپریشن کی اجازت دیتا ہے۔\n\n" +
                "عام مسائل: اگر آواز میں بہت زیادہ کلکس ہیں تو 'سا ٹوتھ' آپشن آزمائیں یا اینولپ تبدیل کریں۔ اگر تاخیر زیادہ ہے تو بفر کم کریں۔\n\n" +
                "کی بورڈ کیز:\n" +
                "  بایاں: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  دایاں: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "کلید");
        
        set(SYSTEM_SETTING, "سسٹم کی ترتیب");
        set(DARK_THEME, "ڈارک تھیم");
        set(LIGHT_THEME, "لائٹ تھیم");
        
        set(MODE_STRAIGHT, "سیدھی کلید");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "بگ (نیم خودکار)");
        set(MODE_COOTIE, "کوٹی (Sideswiper)");
        
        set(CAT_LETTERS, "حروف");
        set(CAT_NUMBERS, "نمبر");
        set(CAT_SYMBOLS, "علامات");
        set(CAT_SPECIAL_SYMBOLS, "خصوصی علامات");
        set(CAT_SPECIAL, "خصوصی حروف");
        set(CAT_PROSIGNS_COMMON, "عام طریقہ کار کے اشارے");
        set(CAT_ABBREVIATIONS, "عام مخففات");
        set(CAT_QCODES, "Q کوڈز");
        set(CAT_PROSIGNS_OTHER, "دیگر طریقہ کار کے اشارے");

        set(COLOR_WHITE, "سفید");
        set(COLOR_BLACK, "کالا");
        set(COLOR_RED, "سرخ");
        set(COLOR_ORANGE, "نارنجی");
        set(COLOR_YELLOW, "پیلا");
        set(COLOR_GREEN, "سبز");
        set(COLOR_CYAN, "سایان");
        set(COLOR_BLUE, "نیلا");
        set(COLOR_PURPLE, "جامنی");
        set(COLOR_PINK, "گلابی");
        set(SUPPORT_WINDLEREYE, "میرے موسیقی پروجیکٹ Windlereye کو سن کر میری حمایت کریں");
        set(CANCEL, "منسوخ کریں");
        set(QUIT, "باہر نکلیں");
        set(QUIT_GAME_PROMPT, "کیا آپ واقعی اس گیم سے باہر نکلنا چاہتے ہیں؟");

        set(SCORE, "اسکور");
        set(HIGH_SCORE, "اعلی سکور");
        set(YOUR_HIGH_SCORE_IS, "آپ کا سب سے زیادہ اسکور ہے");
        set(TIME, "وقت");
                set(MATCH_COMPLETED, "میچ مکمل ہوگیا");
        set(TRY_AGAIN, "دوبارہ کوشش کریں");
        set(WORDS, "الفاظ");
                set(QUIT_GAME, "کھیل چھوڑ دو");
        set(MATCH_SETTINGS, "کھیل کے پیرامیٹرز");
        set(SHARE_PREVIEW, "پیش نظارہ شیئر کریں۔");
        set(SHARE, "شیئر کریں۔");
        set(SHARE_SUBJECT, "میرا مورس کیئر سکور شیئر کر رہا ہوں۔");
        set(SHARE_PROMO_TEXT, "Morse Training مفت میں https://morsetraining.com پر کھیلیں");
        set(THEME, "تھیم");

        set(MATCH_RESULTS, "میچ کے نتائج");
                

        set(REPEAT, "دہراؤ");

        set(START, "شروع کریں");
        set(PICK_LANG_THEME_ON_SHARE, "اسکور شیئر کرتے وقت زبان اور تھیم منتخب کریں");
        set(GAMES, "گیمز");
        set(CONTINUE, "جاری رکھیں");
        set(RX, "وصول کرنا");
        set(TX, "منتقل کرنا");

        set(KOCH_METHOD, "کوچ طریقہ");
        set(TARGET, "ہدف");
set(TARGET_MET, "ہدف حاصل ہو گیا");
        set(TARGET_NOT_MET, "ہدف حاصل نہیں ہوا");
            set(LEVEL, "سطح");
    
        set(LEARN, "سیکھیں");
        set(PLAY, "کھیلیں");
    
        set(LEVELS_COMPLETED, "مکمل شدہ سطحیں");
        set(RESET_PROGRESS, "پیشرفت ری سیٹ کریں");
        set(RESET_PROGRESS_CONFIRM, "کیا آپ پیشرفت ری سیٹ کرنا چاہتے ہیں؟");
        set(RESET, "ری سیٹ کریں");
            set(WPM, "WPM​");
        set(BACK, "واپس");
        set(NEXT_LEVEL, "اگلا درجہ");

                set(EFFECTIVE_WPM_FARNSWORTH, "موثر ڈبلیو پی ایم (فارنس ورتھ)");
                set(EXTRA_WORD_SPACING, "اضافی لفظی فاصلہ");
                set(EFFECTIVE_WPM_SHORT, "موثر");

                set(WORD_SPACING_ADD, "لفظ +");
    }
}