package com.qft8.morsekeyer.lang;

public class LangUz extends MorseLanguage {
    public LangUz() {
        set(SAVE, "Saqlash");
        set(RESET_DEFAULTS, "Standartga qaytarish");
        set(CLOSE, "Yopish");
        
        set(SETTINGS_TITLE, "Sozlamalar");
        set(TONE, "Ohang");
        set(USER_INTERFACE, "Foydalanuvchi interfeysi");
        set(ADVANCED, "Kengaytirilgan (unumdorlik)");
        set(DECODER_BEHAVIOR, "Dekoder xatti-harakati");

        set(KEY_MODE, "Kalit rejimi");
        set(WPM_SPEED, "Tezlik (WPM)");
        set(INVERSE_PADDLES, "Pedallarni almashtirish");
        set(STRICT_TIMING, "Qat'iy vaqt");
        set(INTERLETTER_SPACING, "Harflar aro masofa");
        set(INTERWORD_SPACING, "So'zlar aro masofa");
        
        set(FREQUENCY, "Chastota");
        set(VOLUME, "Ovoz balandligi");
        set(ENVELOPE, "Ko'tarilish/pasayish vaqti");
        set(NOCLICK, "Chertishlarni oldini olish uchun arra tishli signal");
        
        set(LANGUAGE, "Til");
        set(KEYBOARD_TYPE, "Klaviatura turi");
        set(SHOW_TABLE, "Morze jadvalini ko'rsatish");
        set(SHOW_TABLE_CODES, "Morze jadvalida nuqtalar va chiziqlarni ko'rsatish");
        set(SHOW_VISUAL, "Vizual indikatorni ko'rsatish");
        set(SHOW_PADDLES, "Ekran pedallarini ko'rsatish");
        set(NEXT_WORD_INDICATOR, "Keyingi so'z indikatori");
        set(KEEP_SCREEN_ON, "Ekranni yoniq qoldirish");
        set(APP_THEME, "Ilova mavzusi");
        set(TEXT_COLOR, "Matn rangi");
        set(TEXT_FONT_SIZE, "Matn shrifti o'lchami");
        set(TABLE_FONT_SIZE, "Jadval shrifti o'lchami");
        set(TABLE_RATIO, "Jadval/ekran nisbati");
        
        set(KEEP_ALIVE, "Audioni faol saqlash (kechikishni kamaytiradi)");
        set(AUDIO_BUFFER, "Audio bufer (apparat)");
        set(PROCESSING_CHUNK, "Qayta ishlash bo'lagi");
        set(PERFORMANCE_HINT, "Agar ovoz uzilsa, buferni oshiring. Kechikish yuqori bo'lsa, kamaytiring.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Qo'llab-quvvatlanadigan kiritishlar: klaviatura, sensorli ekran, sichqoncha yoki USB eshkak adapteri.\n\nSichqonchani chap/o‘ng tugmani bosish orqali kalitlash yoki USB-sichqonchali eshkak eshish adapteri uchun sichqoncha ko‘rsatkichini ekrandagi chap eshkak tugmasi ustida qoldiring, chap/o‘ng tugmani bosish to‘g‘ri eshkaklarga ulanadi.\n\nUSB-klaviatura eshkak adapterlari uchun (masalan, VBand) u hech qanday sozlamalarsiz ishlaydi.\n\nQat'iy vaqt harflar orasidagi aniq tanaffuslarni talab qiladi; qat'iy bo'lmagan tezroq yozish imkonini beradi.\n\nMuammolarni hal qilish: Agar ovoz chertayotgan bo'lsa, Arra tishini sinab ko'ring yoki konvertni o'zgartiring. Agar kechikish yuqori bo'lsa, buferni kamaytiring. Agar ovoz duduqlansa, uni oshiring.\n\nKlaviatura tugmalari:\n  Chap: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  O'ng: ]  D  S  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Kalit");
        
        set(SYSTEM_SETTING, "Tizim sozlamasi");
        set(DARK_THEME, "Tungi mavzu");
        set(LIGHT_THEME, "Yorug' mavzu");
        
        set(MODE_STRAIGHT, "Vertikal kalit");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Yarim avtomatik)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "HARFLAR");
        set(CAT_NUMBERS, "SONLAR");
        set(CAT_SYMBOLS, "BELGILAR");
        set(CAT_SPECIAL_SYMBOLS, "MAXSUS BELGILAR");
        set(CAT_SPECIAL, "MAXSUS HARFLAR");
        set(CAT_PROSIGNS_COMMON, "ODATIY XIZMAT BELGILARI");
        set(CAT_ABBREVIATIONS, "ODATIY QISQARTMALAR");
        set(CAT_QCODES, "Q KODLAR");
        set(CAT_PROSIGNS_OTHER, "BOSHQA XIZMAT BELGILARI");

        set(COLOR_WHITE, "Oq");
        set(COLOR_BLACK, "Qora");
        set(COLOR_RED, "Qizil");
        set(COLOR_ORANGE, "To'q sariq");
        set(COLOR_YELLOW, "Sariq");
        set(COLOR_GREEN, "Yashil");
        set(COLOR_CYAN, "Havo rang");
        set(COLOR_BLUE, "Ko'k");
        set(COLOR_PURPLE, "Binafsha");
        set(COLOR_PINK, "Pushti");
        set(SUPPORT_WINDLEREYE, "Mening musiqa loyiham Windlereye ni tinglash orqali meni qo'llab-quvvatlang");
        set(CANCEL, "Bekor qilish");
        set(QUIT, "Chiqish");
        set(QUIT_GAME_PROMPT, "Ushbu o'yindan chiqmoqchimisiz?");

        set(SCORE, "Hisob: ");
        set(HIGH_SCORE, "Yuqori ball");
        set(YOUR_HIGH_SCORE_IS, "Sizning eng yuqori balingiz:");
        set(TIME, "Vaqt: ");
                set(MATCH_COMPLETED, "O'yin yakunlandi");
        set(TRY_AGAIN, "Qaytadan urinish");
        set(WORDS, "So'zlar");
                set(QUIT_GAME, "O'yindan chiqish");
        set(MATCH_SETTINGS, "O'yin parametrlari");
        set(SHARE_PREVIEW, "Ko‘rib chiqishni ulashish");
        set(SHARE, "Ulashish");
        set(SHARE_SUBJECT, "Morse Training ballimni baham ko'raman");
        set(SHARE_PROMO_TEXT, "Morse Trainingni https://morsetraining.com saytida bepul o'ynang");
        set(THEME, "Mavzu");

        set(MATCH_RESULTS, "O'yin natijalari");
                
        set(INFINITE, "Vaqt cheklovisiz mashq qiling");
        set(THREE_MINUTES, "Hisobingizni 3 daqiqada yengib chiqing");

        set(REPEAT, "TAKRORLASH");

        set(START, "BOSHLASH");
        set(PICK_LANG_THEME_ON_SHARE, "Ballarni ulashishda til va mavzuni tanlang");
        set(GAMES, "O'yinlar");
        set(CONTINUE, "DAVOM ETISH");
        set(RX, "Qabul qilish");
        set(TX, "Uzatish");
}
}
