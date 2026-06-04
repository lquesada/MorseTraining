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
                "  اليسار: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  اليمين: ]  D  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

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

        set(SCORE, "النتيجة: ");
        set(HIGH_SCORE, "درجة عالية");
        set(YOUR_HIGH_SCORE_IS, "أعلى نتيجة لك هي:");
        set(TIME, "الوقت: ");
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
                
        set(INFINITE, "ممارسة مع عدم وجود حد زمني");
        set(THREE_MINUTES, "تغلب على درجاتك في 3 دقائق");

        set(REPEAT, "تكرار");

        set(START, "بدء");
        set(PICK_LANG_THEME_ON_SHARE, "اختيار اللغة والمظهر عند مشاركة النتائج");
        set(GAMES, "ألعاب");
        set(CONTINUE, "يكمل");
        set(RX, "يستلم");
        set(TX, "نقل");
}
}
