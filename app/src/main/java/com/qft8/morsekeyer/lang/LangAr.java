package com.qft8.morsekeyer.lang;

public class LangAr extends MorseLanguage {
    public LangAr() {
        set(SAVE, "حفظ");
        set(RESET_DEFAULTS, "إعادة التعيين للافتراضي");
        set(CLOSE, "إغلاق");
        
        set(SETTINGS_TITLE, "الإعدادات");
        set(TONE, "النغمة");
        set(USER_INTERFACE, "واجهة المستخدم");
        set(ADVANCED, "متقدم (الأداء)");
        set(DECODER_BEHAVIOR, "سلوك فك التشفير");

        set(KEY_MODE, "وضع المفتاح");
        set(WPM_SPEED, "السرعة (كلمة في الدقيقة)");
        set(INVERSE_PADDLES, "عكس المجاذيف");
        set(STRICT_TIMING, "توقيت صارم");
        set(INTERLETTER_SPACING, "تباعد الأحرف");
        set(INTERWORD_SPACING, "تباعد الكلمات");
        
        set(FREQUENCY, "التردد");
        set(VOLUME, "مستوى الصوت");
        set(ENVELOPE, "وقت الصعود/الهبوط (الغلاف)");
        set(NOCLICK, "إشارة سن المنشار لتجنب النقرات");
        
        set(LANGUAGE, "اللغة");
        set(KEYBOARD_TYPE, "نوع لوحة المفاتيح");
        set(SHOW_TABLE, "عرض جدول مورس");
        set(SHOW_TABLE_CODES, "عرض النقاط والشرطات في جدول مورس");
        set(SHOW_VISUAL, "عرض المؤشر المرئي");
        set(SHOW_PADDLES, "عرض المجاذيف على الشاشة");
        set(NEXT_WORD_INDICATOR, "مؤشر الكلمة التالية");
        set(KEEP_SCREEN_ON, "إبقاء الشاشة قيد التشغيل");
        set(APP_THEME, "سمة التطبيق");
        set(TEXT_COLOR, "لون النص");
        set(TEXT_FONT_SIZE, "حجم خط النص");
        set(TABLE_FONT_SIZE, "حجم خط الجدول");
        set(TABLE_RATIO, "نسبة الجدول/الشاشة");
        
        set(KEEP_ALIVE, "إبقاء الصوت نشطاً (يقلل التأخير)");
        set(AUDIO_BUFFER, "مخزن الصوت (الأجهزة)");
        set(PROCESSING_CHUNK, "قطعة المعالجة");
        set(PERFORMANCE_HINT, "إذا انقطع الصوت، فقم بزيادة المخزن أو القطعة. إذا كان التأخير عالياً، فقم بتقليلهما.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "المدخلات المدعومة: لوحة المفاتيح، شاشة اللمس، الماوس أو مفتاح بمحول USB.\n\n" +
                "لمفتاح النقر بزر الماوس الأيسر/الأيمن أو محول USB إلى ماوس، اترك مؤشر الماوس فوق زر المضرب الأيسر في الشاشة، وسيتم تعيين النقر الأيسر/الأيمن على المضارب الصحيحة.\n\n" +
                "لمحولات لوحة المفاتيح (مثل VBand) فهي تعمل مباشرة دون إعداد.\n\n" +
                "يتطلب الوضع الصارم توقيتاً دقيقاً بين الأحرف؛ يسمح الوضع غير الصارم بالتلاعب الأسرع.\n\n" +
                "مشاكل شائعة: إذا كان الصوت متقطعاً جداً، جرب خيار 'سن المنشار' أو عدل الغلاف. إذا كان التأخير عالياً، قلل المخزن.\n\n" +
                "مفاتيح لوحة المفاتيح:\n" +
                "  اليسار: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  اليمين: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "مفتاح");
        
        set(SYSTEM_SETTING, "إعداد النظام");
        set(DARK_THEME, "سمة داكنة");
        set(LIGHT_THEME, "سمة فاتحة");
        
        set(MODE_STRAIGHT, "مفتاح رأسي");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (نصف آلي)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "الأحرف");
        set(CAT_NUMBERS, "الأرقام");
        set(CAT_SYMBOLS, "الرموز");
        set(CAT_SPECIAL_SYMBOLS, "رموز خاصة");
        set(CAT_SPECIAL, "أحرف خاصة");
        set(CAT_PROSIGNS_COMMON, "إشارات الإجراءات الشائعة");
        set(CAT_ABBREVIATIONS, "الاختصارات الشائعة");
        set(CAT_QCODES, "رموز Q");
        set(CAT_PROSIGNS_OTHER, "إشارات إجراءات أخرى");

        set(COLOR_WHITE, "أبيض");
        set(COLOR_BLACK, "أسود");
        set(COLOR_RED, "أحمر");
        set(COLOR_ORANGE, "برتقالي");
        set(COLOR_YELLOW, "أصفر");
        set(COLOR_GREEN, "أخضر");
        set(COLOR_CYAN, "سماوي");
        set(COLOR_BLUE, "أزرق");
        set(COLOR_PURPLE, "أرجواني");
        set(COLOR_PINK, "وردي");
        set(SUPPORT_WINDLEREYE, "ادعمني بالاستماع إلى مشروعي الموسيقي Windlereye");
        set(CANCEL, "إلغاء");
        set(QUIT, "خروج");
        set(QUIT_GAME_PROMPT, "هل أنت متأكد أنك تريد الخروج من هذه اللعبة؟");

        set(SCORE, "النتيجة");
        set(HIGH_SCORE, "درجة عالية");
        set(YOUR_HIGH_SCORE_IS, "أعلى نتيجة لك هي");
        set(TIME, "الوقت");
                set(MATCH_COMPLETED, "اكتملت المباراة");
        set(TRY_AGAIN, "حاول مرة أخرى");
        set(WORDS, "كلمات");
                set(QUIT_GAME, "خروج");
        set(MATCH_SETTINGS, "معلمات اللعبة");
        set(SHARE_PREVIEW, "معاينة");
        set(SHARE, "مشاركة");
        set(SHARE_SUBJECT, "مشاركة نتيجتي");
        set(SHARE_PROMO_TEXT, "العب مجانا على https://morsetraining.com");
        set(THEME, "مظهر");

        set(MATCH_RESULTS, "نتائج");
                

        set(REPEAT, "تكرار");

        set(START, "بدء");
        set(PICK_LANG_THEME_ON_SHARE, "اختيار اللغة والمظهر عند مشاركة النتائج");
        set(GAMES, "ألعاب");
        set(CONTINUE, "يكمل");
        set(RX, "يستلم");
        set(TX, "نقل");

        set(KOCH_METHOD, "طريقة كوخ");
        set(TARGET, "الهدف");
set(TARGET_MET, "تم تحقيق الهدف");
        set(TARGET_NOT_MET, "لم يتم تحقيق الهدف");
            set(LEVEL, "مستوى");
    
        set(LEARN, "تعلم");
        set(PLAY, "العب");
    
        set(LEVELS_COMPLETED, "المستويات المنجزة");
        set(RESET_PROGRESS, "إعادة ضبط التقدم");
        set(RESET_PROGRESS_CONFIRM, "هل أنت متأكد أنك تريد إعادة ضبط التقدم؟");
        set(RESET, "إعادة ضبط");
            set(WPM, "كلمة/د");
        set(SPACING, "التباعد");
        set(BACK, "رجوع");
        set(NEXT_LEVEL, "المستوى التالي");
    }
}