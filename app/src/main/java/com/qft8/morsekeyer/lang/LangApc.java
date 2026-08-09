package com.qft8.morsekeyer.lang;

public class LangApc extends MorseLanguage {
    public LangApc() {
        set(SAVE, "حفظ");
        set(RESET_DEFAULTS, "رجع للأصلي");
        set(CLOSE, "إغلاق");
        
        set(SETTINGS_TITLE, "الإعدادات");
        set(TONE, "النغمة");
        set(USER_INTERFACE, "واجهة المستخدم");
        set(ADVANCED, "متقدم (الأداء)");
        set(DECODER_BEHAVIOR, "سلوك فك التشفير");

        set(KEY_MODE, "نوع المفتاح");
        set(WPM_SPEED, "السرعة (WPM)");
        set(INVERSE_PADDLES, "اعكس المجاذيف");
        set(STRICT_TIMING, "توقيت دقيق");
        
        set(FREQUENCY, "التردد");
        set(VOLUME, "الصوت");
        set(ENVELOPE, "وقت الطلوع والنزول (Envelope)");
        set(NOCLICK, "إشارة سن المنشار لتجنب النقرات");
        
        set(LANGUAGE, "اللغة");
        set(KEYBOARD_TYPE, "نوع لوحة المفاتيح");
        set(SHOW_TABLE, "عرض جدول مورس");
        set(SHOW_TABLE_CODES, "عرض النقاط والشرطات في جدول مورس");
        set(SHOW_VISUAL, "عرض المؤشر المرئي");
        set(SHOW_PADDLES, "عرض المجاذيف على الشاشة");
        set(NEXT_WORD_INDICATOR, "مؤشر الكلمة الجاية");
        set(KEEP_SCREEN_ON, "خلي الشاشة منورة");
        set(APP_THEME, "شكل البرنامج");
        set(TEXT_COLOR, "لون النص");
        set(TEXT_FONT_SIZE, "حجم خط النص");
        set(TABLE_FONT_SIZE, "حجم خط الجدول");
        set(TABLE_RATIO, "نسبة الجدول للشاشة");
        
        set(KEEP_ALIVE, "خلي الصوت شغال (بيقلل التأخير)");
        set(WHITE_NOISE, "أقوى (شغّل ضجيج أبيض)");
        set(AUDIO_BUFFER, "مخزن الصوت");
        set(PROCESSING_CHUNK, "حجم المعالجة");
        set(PERFORMANCE_HINT, "لو الصوت بيقطع زود المخزن. لو فيه تأخير قللهم.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "المدخلات المدعومة: لوحة المفاتيح، شاشة اللمس، الماوس أو محول USB للمضرب.\n\nلمفتاح النقر بزر الماوس الأيسر / الأيمن أو محول USB إلى ماوس ، اترك مؤشر الماوس فوق زر المضرب الأيسر في الشاشة ، وسيتم تعيين النقر الأيسر / الأيمن على المضارب الصحيحة.\n\nبالنسبة لمهايئات USB إلى لوحة المفاتيح (مثل VBand) ، فإنها تعمل دون أي إعداد.\n\nيتطلب التوقيت الدقيق توقفًا مؤقتًا دقيقًا بين الأحرف؛ يتيح التوقيت غير الدقيق إرسالًا أسرع.\n\nاستكشاف الأخطاء وإصلاحها: إذا كان الصوت ينقر، فجرب موجة سن المنشار أو غيّر الغلاف. إذا كان وقت الاستجابة عاليًا، فقم بتقليل المخزن المؤقت. إذا كان الصوت يتقطع، فقم بزيادته.\n\nمفاتيح لوحة المفاتيح:\n  يسار: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  يمين: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "مفتاح");
        
        set(SYSTEM_SETTING, "حسب النظام");
        set(DARK_THEME, "شكل غامق");
        set(LIGHT_THEME, "شكل فاتح");
        
        set(MODE_STRAIGHT, "مفتاح عادي");
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
        set(CAT_PROSIGNS_COMMON, "إشارات الإجراءات الشائعة");
        set(CAT_ABBREVIATIONS, "الاختصارات الشائعة");
        set(CAT_QCODES, "رموز Q");
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
        set(COLOR_PINK, "زهري");
        set(SUPPORT_WINDLEREYE, "ادعمني بالاستماع إلى مشروعي الموسيقي Windlereye");
        set(CANCEL, "إلغاء");
        set(QUIT, "خروج");
        set(QUIT_GAME_PROMPT, "متأكد بدك تطلع من هاللعبه؟");

        set(SCORE, "النتيجة");
        set(HIGH_SCORE, "درجة عالية");
        set(YOUR_HIGH_SCORE_IS, "أعلى سكور إلك هو");
        set(TIME, "الوقت");
                set(MATCH_COMPLETED, "خلصت اللعبة");
        set(TRY_AGAIN, "جرب كمان مرة");
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
        set(HINT, "تلميح");

        set(START, "بدء");
        set(PICK_LANG_THEME_ON_SHARE, "اختار لغة وثيم لما تشارك السكور");
        set(GAMES, "ألعاب");
        set(CONTINUE, "يكمل");
        set(RX, "استلم");
        set(TX, "أرسل");

        set(KOCH_METHOD, "طريقة كوخ");
        set(TARGET, "الهدف");
set(TARGET_MET, "تم تحقيق الهدف");
        set(TARGET_NOT_MET, "لم يتم تحقيق الهدف");
            set(LEVEL, "مستوى");
    
        set(LEARN, "تعلم");
        set(PLAY, "العب");
    
        set(LEVELS_COMPLETED, "المستويات المكتملة");
        set(RESET_PROGRESS, "إعادة ضبط التقدم");
        set(RESET_PROGRESS_CONFIRM, "هل أنت متأكد من إعادة الضبط؟");
        set(RESET, "إعادة ضبط");
            set(WPM, "WPM");
        set(BACK, "رجوع");
        set(NEXT_LEVEL, "المستوى التالي");

                set(EFFECTIVE_WPM_FARNSWORTH, "السرعة الفعلية (فارنسورث)");
                set(EXTRA_WORD_SPACING, "مسافة");
                set(EFFECTIVE_WPM_SHORT, "الفعلية");

                set(WORD_SPACING_ADD, "كلمة +");

        // Koch custom level
        set(CUSTOM_LEVEL, "Nivel personalizado");
        set(SELECT_CHARACTERS_PROMPT, "Pulsa el teclado para seleccionar los caracteres que te interesan");
    }
}
