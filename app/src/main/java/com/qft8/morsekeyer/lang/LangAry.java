package com.qft8.morsekeyer.lang;

public class LangAry extends MorseLanguage {
    public LangAry() {
        set(SAVE, "حفظ");
        set(RESET_DEFAULTS, "رجع للأصل");
        set(CLOSE, "شد");
        
        set(SETTINGS_TITLE, "الإعدادات");
        set(TONE, "النغمة");
        set(USER_INTERFACE, "واجهة المستخدم");
        set(ADVANCED, "متقدم (الأداء)");
        set(DECODER_BEHAVIOR, "طريقة القراية");

        set(KEY_MODE, "نوع الساروت");
        set(WPM_SPEED, "السرعة (WPM)");
        set(INVERSE_PADDLES, "اقلب المجاذيف");
        set(STRICT_TIMING, "توقيت مضبوط");
        set(INTERLETTER_SPACING, "المسافة بين الحروف");
        set(INTERWORD_SPACING, "المسافة بين الكلمات");
        
        set(FREQUENCY, "التردد");
        set(VOLUME, "الصوت");
        set(ENVELOPE, "وقت الطلوع والنزول");
        set(NOCLICK, "إشارة سن المنشار باش ميكونش الصداع");
        
        set(LANGUAGE, "اللغة");
        set(KEYBOARD_TYPE, "نوع لوحة المفاتيح");
        set(SHOW_TABLE, "وريني جدول مورس");
        set(SHOW_TABLE_CODES, "وريلي النقاط والشراطي في جدول مورس");
        set(SHOW_VISUAL, "وريني المؤشر الضوئي");
        set(SHOW_PADDLES, "وريني المجاذيف ف الشاشة");
        set(NEXT_WORD_INDICATOR, "مؤشر الكلمة الجاية");
        set(KEEP_SCREEN_ON, "خلي الشاشة شاعلة");
        set(APP_THEME, "ستيل التطبيق");
        set(TEXT_COLOR, "لون الكتبه");
        set(TEXT_FONT_SIZE, "كبر الكتبه");
        set(TABLE_FONT_SIZE, "كبر الكتبه د الجدول");
        set(TABLE_RATIO, "نسبة الجدول ف الشاشة");
        
        set(KEEP_ALIVE, "خلي الصوت خدام (كاينقص التعطال)");
        set(AUDIO_BUFFER, "مخزن الصوت");
        set(PROCESSING_CHUNK, "حجم المعالجة");
        set(PERFORMANCE_HINT, "إلا كان الصوت كيتقطع، زيد ف الـ Buffer. إلا كان التعطال، نقصهم.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "المدخلات المدعومة: لوحة المفاتيح، شاشة اللمس، الماوس أو محول USB للمضرب.\n\nلمفتاح النقر بزر الماوس الأيسر/الأيمن أو محول USB إلى ماوس، اترك مؤشر الماوس فوق زر المضرب الأيسر في الشاشة، وسيتم تعيين النقر الأيسر/الأيمن على المضارب الصحيحة.\n\nبالنسبة لمهايئات USB إلى لوحة المفاتيح (مثل VBand) ، فإنها تعمل دون أي إعداد.\n\nيتطلب التوقيت الدقيق توقفًا مؤقتًا دقيقًا بين الأحرف؛ يتيح التوقيت غير الدقيق إرسالًا أسرع.\n\nاستكشاف الأخطاء وإصلاحها: إذا كان الصوت ينقر، فجرب موجة سن المنشار أو غيّر الغلاف. إذا كان وقت الاستجابة عاليًا، فقم بتقليل المخزن المؤقت. إذا كان الصوت يتقطع، فقم بزيادته.\n\nمفاتيح لوحة المفاتيح:\n  يسار: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  يمين: ]  D  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "ساروت");
        
        set(SYSTEM_SETTING, "على حساب السيستيم");
        set(DARK_THEME, "ستيل مضلم");
        set(LIGHT_THEME, "ستيل مضاوي");
        
        set(MODE_STRAIGHT, "ساروت عادي");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "باج (نص أوتوماتيك)");
        set(MODE_COOTIE, "كوتي (Sideswiper)");
        
        set(CAT_LETTERS, "الحروف");
        set(CAT_NUMBERS, "الأرقام");
        set(CAT_SYMBOLS, "الرموز");
        set(CAT_SPECIAL_SYMBOLS, "رموز خاصة");
        set(CAT_SPECIAL, "حروف خاصة");
        set(CAT_PROSIGNS_COMMON, "إشارات الخدمة المعروفة");
        set(CAT_ABBREVIATIONS, "الاختصارات المعروفة");
        set(CAT_QCODES, "رموز Q");
        set(CAT_PROSIGNS_OTHER, "إشارات خدمة أخرى");

        set(COLOR_WHITE, "بيض");
        set(COLOR_BLACK, "كحل");
        set(COLOR_RED, "حمر");
        set(COLOR_ORANGE, "ليموني");
        set(COLOR_YELLOW, "صفر");
        set(COLOR_GREEN, "خضر");
        set(COLOR_CYAN, "سماوي");
        set(COLOR_BLUE, "زرق");
        set(COLOR_PURPLE, "موف");
        set(COLOR_PINK, "غوز");
        set(SUPPORT_WINDLEREYE, "ادعمني بالاستماع إلى مشروعي الموسيقي Windlereye");
        set(CANCEL, "إلغاء");
        set(QUIT, "خروج");
        set(QUIT_GAME_PROMPT, "واش متأكد بغيتي تخرج من هاد اللعبة؟");

        set(SCORE, "النتيجة: ");
        set(HIGH_SCORE, "درجة عالية");
        set(YOUR_HIGH_SCORE_IS, "أعلى سكور ديالك هو:");
        set(TIME, "الوقت: ");
                set(MATCH_COMPLETED, "سالات المباراة");
        set(TRY_AGAIN, "عاود جرب");
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
        set(PICK_LANG_THEME_ON_SHARE, "عزل لغة وثيم فاش تبارطاجي السكور");
        set(GAMES, "ألعاب");
        set(CONTINUE, "يكمل");
        set(RX, "يستلم");
        set(TX, "نقل");
}
}
