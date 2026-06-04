package com.qft8.morsekeyer.lang;

public class LangFa extends MorseLanguage {
    public LangFa() {
        set(SAVE, "ذخیره");
        set(RESET_DEFAULTS, "بازنشانی به پیش‌فرض");
        set(CLOSE, "بستن");
        
        set(SETTINGS_TITLE, "تنظیمات");
        set(TONE, "صدا");
        set(USER_INTERFACE, "رابط کاربری");
        set(ADVANCED, "پیشرفته (عملکرد)");
        set(DECODER_BEHAVIOR, "رفتار رمزگشا");

        set(KEY_MODE, "حالت کلید");
        set(WPM_SPEED, "سرعت (WPM)");
        set(INVERSE_PADDLES, "معکوس کردن پدال‌ها");
        set(STRICT_TIMING, "زمان‌بندی دقیق");
        set(INTERLETTER_SPACING, "فاصله بین حروف");
        set(INTERWORD_SPACING, "فاصله بین کلمات");
        
        set(FREQUENCY, "فرکانس");
        set(VOLUME, "میزان صدا");
        set(ENVELOPE, "زمان صعود/سقوط (پاکت صوتی)");
        set(NOCLICK, "استفاده از سیگنال دندان‌اره‌ای برای جلوگیری از صداهای کلیک");
        
        set(LANGUAGE, "زبان");
        set(KEYBOARD_TYPE, "نوع صفحه کلید");
        set(SHOW_TABLE, "نمایش جدول مورس");
        set(SHOW_TABLE_CODES, "نمایش نقطه‌ها و خط‌ها در جدول مورس");
        set(SHOW_VISUAL, "نمایش نشانگر بصری");
        set(SHOW_PADDLES, "نمایش پدال‌های روی صفحه");
        set(NEXT_WORD_INDICATOR, "نشانگر کلمه بعدی");
        set(KEEP_SCREEN_ON, "روشن نگه داشتن صفحه");
        set(APP_THEME, "تم برنامه");
        set(TEXT_COLOR, "رنگ متن");
        set(TEXT_FONT_SIZE, "اندازه قلم متن");
        set(TABLE_FONT_SIZE, "اندازه قلم جدول");
        set(TABLE_RATIO, "نسبت جدول/صفحه");
        
        set(KEEP_ALIVE, "فعال نگه داشتن صدا (کاهش تأخیر)");
        set(AUDIO_BUFFER, "بافر صدا (سخت‌افزار)");
        set(PROCESSING_CHUNK, "بخش پردازش");
        set(PERFORMANCE_HINT, "اگر صدا قطع و وصل می‌شود، بافر را افزایش دهید. اگر تأخیر زیاد است، آن را کاهش دهید.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "ورودی‌های پشتیبانی شده: صفحه‌کلید، صفحه لمسی، ماوس یا کلید با آداپتور USB.\n\n" +
                "برای کلیدزنی کلیک چپ/راست ماوس یا آداپتور پدال USB به ماوس، نشانگر ماوس را روی دکمه پدال چپ در صفحه رها کنید، کلیک چپ/راست به پدال‌های صحیح نقشه می‌شود.\n\n" +
                "برای آداپتورهای صفحه‌کلید USB (مانند VBand)، مستقیماً بدون تنظیمات کار می‌کند.\n\n" +
                "حالت دقیق به زمان‌بندی درست بین حروف نیاز دارد؛ حالت غیردقیق اجازه کلیدزنی سریع‌تر را می‌دهد.\n\n" +
                "مشکلات رایج: اگر صدا بیش از حد صدای کلیک دارد، گزینه 'دندان‌اره‌ای' را امتحان کنید یا پاکت صوتی را تغییر دهید. اگر تأخیر زیاد است، بافر را کم کنید.\n\n" +
                "کلیدهای صفحه‌کلید:\n" +
                "  چپ: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  راست: ]  D  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "کلید");
        
        set(SYSTEM_SETTING, "تنظیمات سیستم");
        set(DARK_THEME, "تم تیره");
        set(LIGHT_THEME, "تم روشن");
        
        set(MODE_STRAIGHT, "کلید عمودی (Straight key)");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "باگ (نیمه خودکار)");
        set(MODE_COOTIE, "کوتی (Sideswiper)");
        
        set(CAT_LETTERS, "حروف");
        set(CAT_NUMBERS, "اعداد");
        set(CAT_SYMBOLS, "علائم");
        set(CAT_SPECIAL_SYMBOLS, "علائم خاص");
        set(CAT_SPECIAL, "حروف خاص");
        set(CAT_PROSIGNS_COMMON, "علائم عملیاتی رایج");
        set(CAT_ABBREVIATIONS, "اختصارات رایج");
        set(CAT_QCODES, "کدهای Q");
        set(CAT_PROSIGNS_OTHER, "سایر علائم عملیاتی");

        set(COLOR_WHITE, "سفید");
        set(COLOR_BLACK, "مشکی");
        set(COLOR_RED, "قرمز");
        set(COLOR_ORANGE, "نارنجی");
        set(COLOR_YELLOW, "زرد");
        set(COLOR_GREEN, "سبز");
        set(COLOR_CYAN, "فیروزه‌ای");
        set(COLOR_BLUE, "آبی");
        set(COLOR_PURPLE, "بنفش");
        set(COLOR_PINK, "صورتی");
        set(SUPPORT_WINDLEREYE, "با گوش دادن به پروژه موسیقی من Windlereye از من حمایت کنید");
        set(CANCEL, "لغو");
        set(QUIT, "خروج");
        set(QUIT_GAME_PROMPT, "آیا مطمئن هستید که می‌خواهید از این بازی خارج شوید؟");

        set(SCORE, "امتیاز: ");
        set(HIGH_SCORE, "نمره بالا");
        set(YOUR_HIGH_SCORE_IS, "بالاترین امتیاز شما:");
        set(TIME, "زمان: ");
                set(MATCH_COMPLETED, "بازی تمام شد");
        set(TRY_AGAIN, "دوباره تلاش کنید");
        set(WORDS, "کلمات");
                set(QUIT_GAME, "ترک بازی");
        set(MATCH_SETTINGS, "پارامترهای بازی");
        set(SHARE_PREVIEW, "پیش نمایش را به اشتراک بگذارید");
        set(SHARE, "به اشتراک بگذارید");
        set(SHARE_SUBJECT, "امتیاز مورس کییر را به اشتراک می گذارم");
        set(SHARE_PROMO_TEXT, "Morse Training را به صورت رایگان در https://morsetraining.com بازی کنید");
        set(THEME, "موضوع");

        set(MATCH_RESULTS, "نتایج مسابقه");
                
        set(TX_PRACTICE, "انتقال (آموزش)");
        set(TX_CONTEST, "انتقال (حمله امتیازی)");
        set(INFINITE, "بدون محدودیت زمانی تمرین کنید");
        set(THREE_MINUTES, "ضرب و شتم امتیاز خود را در 3 دقیقه");

        set(RX_PRACTICE, "دریافت (آموزش)");
        set(RX_CONTEST, "دریافت (حمله امتیازی)");
        set(REPEAT, "تکرار");

        set(START, "شروع");
        set(PICK_LANG_THEME_ON_SHARE, "انتخاب زبان و تم هنگام اشتراک‌گذاری امتیازات");
        set(GAMES, "بازی‌ها");
        set(CONTINUE, "ادامه دهید");
        set(RX, "دریافت کنید");
        set(TX, "انتقال دهد");
}
}
