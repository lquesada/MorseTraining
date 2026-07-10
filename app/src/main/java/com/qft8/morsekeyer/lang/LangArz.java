package com.qft8.morsekeyer.lang;

public class LangArz extends MorseLanguage {
    public LangArz() {
        set(SAVE, "حفظ");
        set(RESET_DEFAULTS, "رجع للأصلي");
        set(CLOSE, "قفل");
        
        set(SETTINGS_TITLE, "الإعدادات");
        set(TONE, "النغمة");
        set(USER_INTERFACE, "شكل البرنامج");
        set(ADVANCED, "متقدم (الأداء)");
        set(DECODER_BEHAVIOR, "طريقة القراية");

        set(KEY_MODE, "نوع المفتاح");
        set(WPM_SPEED, "السرعة (WPM)");
        set(INVERSE_PADDLES, "اعكس المجاذيف");
        set(STRICT_TIMING, "توقيت مظبوط بالملي");
        
        set(FREQUENCY, "التردد");
        set(VOLUME, "العلو");
        set(ENVELOPE, "وقت الطلوع والنزول (Envelope)");
        set(NOCLICK, "إشارة سن المنشار عشان ميبقاش فيه تكة");
        
        set(LANGUAGE, "اللغة");
        set(KEYBOARD_TYPE, "نوع لوحة المفاتيح");
        set(SHOW_TABLE, "ورينا جدول مورس");
        set(SHOW_TABLE_CODES, "ورينا النقط والشرط في جدول مورس");
        set(SHOW_VISUAL, "ورينا المؤشر المنور");
        set(SHOW_PADDLES, "ورينا المجاذيف ع الشاشة");
        set(NEXT_WORD_INDICATOR, "مؤشر الكلمة الجاية");
        set(KEEP_SCREEN_ON, "خلي الشاشة منورة");
        set(APP_THEME, "شكل التطبيق");
        set(TEXT_COLOR, "لون الكلام");
        set(TEXT_FONT_SIZE, "حجم خط الكلام");
        set(TABLE_FONT_SIZE, "حجم خط الجدول");
        set(TABLE_RATIO, "نسبة الجدول للشاشة");
        
        set(KEEP_ALIVE, "خلي الصوت شغال (بيقلل التأخير)");
        set(WHITE_NOISE, "أقوى (شغّل ضوضاء بيضاء)");
        set(AUDIO_BUFFER, "مخزن الصوت (Buffer)");
        set(PROCESSING_CHUNK, "حجم المعالجة");
        set(PERFORMANCE_HINT, "لو الصوت بيقطع زود المخزن. لو فيه تأخير قللهم.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "بيشتغل بـ: الكيبورد، الشاشة، الماوس، أو مفتاح مورس بـ USB.\n\n" +
                "لمفتاح النقر بزر الماوس الأيسر/الأيمن أو محول USB إلى ماوس، اترك مؤشر الماوس فوق زر المضرب الأيسر في الشاشة، وسيتم تعيين النقر الأيسر/الأيمن على المضارب الصحيحة.\n\n" +
                "لو معاك وصلة كيبورد (زي VBand) بتشتغل علطول من غير تظبيط.\n\n" +
                "الوضع المظبوط بيحتاج توقيت دقيق بين الحروف؛ الوضع العادي بيخليك تدوس أسرع.\n\n" +
                "مشاكل معروفة: لو الصوت فيه تكة عالية، جرب خيار 'سن المنشار'. لو فيه تأخير قلل الـ Buffer.\n\n" +
                "زراير الكيبورد:\n" +
                "  شمال: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  يمين: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "مفتاح");
        
        set(SYSTEM_SETTING, "حسب النظام");
        set(DARK_THEME, "شكل غامق");
        set(LIGHT_THEME, "شكل فاتح");
        
        set(MODE_STRAIGHT, "مفتاح عادي (رأسي)");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "باج (نص أوتوماتيك)");
        set(MODE_COOTIE, "كوتي (Sideswiper)");
        
        set(CAT_LETTERS, "الحروف");
        set(CAT_NUMBERS, "الأرقام");
        set(CAT_SYMBOLS, "الرموز");
        set(CAT_SPECIAL_SYMBOLS, "رموز مخصوصة");
        set(CAT_SPECIAL, "حروف مخصوصة");
        set(CAT_PROSIGNS_COMMON, "إشارات الإجراءات المعروفة");
        set(CAT_ABBREVIATIONS, "الاختصارات المعروفة");
        set(CAT_QCODES, "رموز الـ Q");
        set(CAT_PROSIGNS_OTHER, "إشارات إجراءات تانية");

        set(COLOR_WHITE, "أبيض");
        set(COLOR_BLACK, "أسود");
        set(COLOR_RED, "أحمر");
        set(COLOR_ORANGE, "برتقالي");
        set(COLOR_YELLOW, "أصفر");
        set(COLOR_GREEN, "أخضر");
        set(COLOR_CYAN, "سماوي");
        set(COLOR_BLUE, "أزرق");
        set(COLOR_PURPLE, "بنفسجي");
        set(COLOR_PINK, "بمبي");
        set(SUPPORT_WINDLEREYE, "ادعمني بالاستماع إلى مشروعي الموسيقي Windlereye");
        set(CANCEL, "إلغاء");
        set(QUIT, "خروج");
        set(QUIT_GAME_PROMPT, "انت متأكد إنك عايز تخرج من اللعبة دي؟");

        set(SCORE, "النتيجة");
        set(HIGH_SCORE, "درجة عالية");
        set(YOUR_HIGH_SCORE_IS, "أعلى سكور ليك هو");
        set(TIME, "الوقت");
                set(MATCH_COMPLETED, "الماتش خلص");
        set(TRY_AGAIN, "حاول تاني");
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
        set(PICK_LANG_THEME_ON_SHARE, "اختار لغة وثيم لما تشارك السكور");
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
        set(RESET_PROGRESS_CONFIRM, "هل أنت متأكد من إعادة الضبط؟");
        set(RESET, "إعادة ضبط");
            set(WPM, "WPM");
        set(BACK, "رجوع");
        set(NEXT_LEVEL, "المستوى اللي بعده");

                set(EFFECTIVE_WPM_FARNSWORTH, "السرعة الفعلية (فارنسورث)");
                set(EXTRA_WORD_SPACING, "مسافة بين الكلمات");
                set(EFFECTIVE_WPM_SHORT, "الفعلية");

                set(WORD_SPACING_ADD, "كلمة +");
    }
}