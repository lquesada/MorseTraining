package com.qft8.morsekeyer.lang;

public class LangAz extends MorseLanguage {
    public LangAz() {
        set(SAVE, "Yadda saxla");
        set(RESET_DEFAULTS, "İlkin vəziyyətə qaytar");
        set(CLOSE, "Bağla");
        
        set(SETTINGS_TITLE, "Ayarlar");
        set(TONE, "Ton");
        set(USER_INTERFACE, "İstifadəçi interfeysi");
        set(ADVANCED, "Təkmilləşmiş (performans)");
        set(DECODER_BEHAVIOR, "Dekoder davranışı");

        set(KEY_MODE, "Açar rejimi");
        set(WPM_SPEED, "Sürət (WPM)");
        set(INVERSE_PADDLES, "Paddles yerini dəyiş");
        set(STRICT_TIMING, "Dəqiq vaxt");
        set(INTERLETTER_SPACING, "Hərflər arası məsafə");
        set(INTERWORD_SPACING, "Sözlər arası məsafə");
        
        set(FREQUENCY, "Tezlik");
        set(VOLUME, "Səs səviyyəsi");
        set(ENVELOPE, "Yüksəlmə/enmə vaxtı");
        set(NOCLICK, "Klik səslərini önləmək üçün mişar dişi siqnalı");
        
        set(LANGUAGE, "Dil");
        set(KEYBOARD_TYPE, "Klaviatura növü");
        set(SHOW_TABLE, "Morze cədvəlini göstər");
        set(SHOW_TABLE_CODES, "Morze cədvəlində nöqtələri və xətləri göstər");
        set(SHOW_VISUAL, "Vizual indiqatoru göstər");
        set(SHOW_PADDLES, "Ekran paddles-ı göstər");
        set(NEXT_WORD_INDICATOR, "Növbəti söz indiqatoru");
        set(KEEP_SCREEN_ON, "Ekranı açıq saxla");
        set(APP_THEME, "Tətbiq mövzusu");
        set(TEXT_COLOR, "Mətn rəngi");
        set(TEXT_FONT_SIZE, "Mətn şrift ölçüsü");
        set(TABLE_FONT_SIZE, "Cədvəl şrift ölçüsü");
        set(TABLE_RATIO, "Cədvəl/ekran nisbəti");
        
        set(KEEP_ALIVE, "Audionu aktiv saxla (gecikməni azaldır)");
        set(AUDIO_BUFFER, "Audio bufer (apparat)");
        set(PROCESSING_CHUNK, "Emal hissəsi");
        set(PERFORMANCE_HINT, "Əgər səs kəsilirsə, buferi artırın. Gecikmə yüksəkdirsə, azaldın.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Dəstəklənən girişlər: klaviatura, sensor ekran, siçan və ya USB avar adapteri.\n\nSiçan sol/sağ klik düyməsi və ya USB-siçan avarlı adapteri üçün, siçan göstəricisini ekrandakı sol avar düyməsinin üzərində buraxın, sol/sağ klik düzgün avarlara uyğun olacaq.\n\nUSB-klaviatura avar adapterləri üçün (məsələn, VBand) heç bir əlavə quraşdırma olmadan işləyir.\n\nSərt vaxtlama hərflər arası dəqiq fasilələr tələb edir; sərt olmayan isə daha sürətli yazmağa imkan verir.\n\nProblemlərin həlli: Səs tıkqıltılıdırsa, Mişar dişi yoxlayın və ya zərfi dəyişdirin. Gecikmə yüksəkdirsə, buferi azaldın. Səs qırılırsa, onu artırın.\n\nKlaviatura düymələri:\n  Sol: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  Sağ: ]  D  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Açar");
        
        set(SYSTEM_SETTING, "Sistem ayarı");
        set(DARK_THEME, "Tünd mövzu");
        set(LIGHT_THEME, "Açıq mövzu");
        
        set(MODE_STRAIGHT, "Vertikal açar");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Yarım avtomatik)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "HƏRFLƏR");
        set(CAT_NUMBERS, "RƏQƏMLƏR");
        set(CAT_SYMBOLS, "SİMVOLLAR");
        set(CAT_SPECIAL_SYMBOLS, "XÜSUSİ SİMVOLLAR");
        set(CAT_SPECIAL, "XÜSUSİ HƏRFLƏR");
        set(CAT_PROSIGNS_COMMON, "ÜMUMİ PROSEDUR SİQNALLARI");
        set(CAT_ABBREVIATIONS, "ÜMUMİ QISALTMALAR");
        set(CAT_QCODES, "Q KODLARI");
        set(CAT_PROSIGNS_OTHER, "DİGƏR PROSEDUR SİQNALLARI");

        set(COLOR_WHITE, "Ağ");
        set(COLOR_BLACK, "Qara");
        set(COLOR_RED, "Qırmızı");
        set(COLOR_ORANGE, "Narıncı");
        set(COLOR_YELLOW, "Sarı");
        set(COLOR_GREEN, "Yaşıl");
        set(COLOR_CYAN, "Sian");
        set(COLOR_BLUE, "Mavi");
        set(COLOR_PURPLE, "Bənövşəyi");
        set(COLOR_PINK, "Çəhrayı");
        set(SUPPORT_WINDLEREYE, "Mənim musiqi layihəm Windlereye-i dinləyərək məni dəstəkləyin");
        set(CANCEL, "Ləğv et");
        set(QUIT, "Çıx");
        set(QUIT_GAME_PROMPT, "Bu oyundan çıxmaq istədiyinizə əminsiniz?");

        set(SCORE, "Xal: ");
        set(HIGH_SCORE, "Yüksək xal");
        set(YOUR_HIGH_SCORE_IS, "Ən yüksək balınız:");
        set(TIME, "Vaxt: ");
                set(MATCH_COMPLETED, "Oyun bitdi");
        set(TRY_AGAIN, "Yenidən cəhd et");
        set(WORDS, "Sözlər");
                set(QUIT_GAME, "Oyundan çıxın");
        set(MATCH_SETTINGS, "Oyun parametrləri");
        set(SHARE_PREVIEW, "Önizləməni paylaşın");
        set(SHARE, "Paylaşın");
        set(SHARE_SUBJECT, "Morse Training hesabımı paylaşıram");
        set(SHARE_PROMO_TEXT, "Morse Training-i https://morsetraining.com saytında pulsuz oynayın");
        set(THEME, "Mövzu");

        set(MATCH_RESULTS, "Matç nəticələri");
                
        set(TX_PRACTICE, "Ötürmə (Təlim)");
        set(TX_CONTEST, "Ötürmə (Hücum Hesabı)");
        set(INFINITE, "Vaxt məhdudiyyəti olmadan məşq edin");
        set(THREE_MINUTES, "Hesabınızı 3 dəqiqə ərzində məğlub edin");

        set(RX_PRACTICE, "Qəbul (Təlim)");
        set(RX_CONTEST, "Qəbul (Hücum Hesabı)");
        set(REPEAT, "TƏKRARLA");

        set(START, "BAŞLA");
        set(PICK_LANG_THEME_ON_SHARE, "Xalları paylaşarkən dil və mövzu seçin");
        set(GAMES, "Oyunlar");
        set(CONTINUE, "DAVAM EDİN");
        set(RX, "Qəbul et");
        set(TX, "Ötür");
}
}
