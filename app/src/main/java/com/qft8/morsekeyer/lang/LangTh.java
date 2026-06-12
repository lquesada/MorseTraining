package com.qft8.morsekeyer.lang;

public class LangTh extends MorseLanguage {
    public LangTh() {
        set(SAVE, "บันทึก");
        set(RESET_DEFAULTS, "รีเซ็ตเป็นค่าเริ่มต้น");
        set(CLOSE, "ปิด");
        
        set(SETTINGS_TITLE, "การตั้งค่า");
        set(TONE, "โทนเสียง");
        set(USER_INTERFACE, "ส่วนติดต่อผู้ใช้");
        set(ADVANCED, "ขั้นสูง (ประสิทธิภาพ)");
        set(DECODER_BEHAVIOR, "พฤติกรรมการถอดรหัส");

        set(KEY_MODE, "โหมดคันเคาะ");
        set(WPM_SPEED, "ความเร็ว (WPM)");
        set(INVERSE_PADDLES, "สลับด้านคันเคาะ");
        set(STRICT_TIMING, "จังหวะเข้มงวด");
        set(INTERLETTER_SPACING, "ระยะห่างระหว่างตัวอักษร");
        set(INTERWORD_SPACING, "ระยะห่างระหว่างคำ");
        
        set(FREQUENCY, "ความถี่");
        set(VOLUME, "ระดับเสียง");
        set(ENVELOPE, "เวลาขึ้น/ลง (Envelope)");
        set(NOCLICK, "ใช้สัญญาณฟันเลื่อยเพื่อหลีกเลี่ยงเสียงคลิก");
        
        set(LANGUAGE, "ภาษา");
        set(KEYBOARD_TYPE, "ประเภทคีย์บอร์ด");
        set(SHOW_TABLE, "แสดงตารางมอร์ส");
        set(SHOW_TABLE_CODES, "แสดงจุดและขีดในตารางมอร์ส");
        set(SHOW_VISUAL, "แสดงตัวบ่งชี้ภาพ");
        set(SHOW_PADDLES, "แสดงคันเคาะบนหน้าจอ");
        set(NEXT_WORD_INDICATOR, "ตัวบ่งชี้คำถัดไป");
        set(KEEP_SCREEN_ON, "เปิดหน้าจอค้างไว้");
        set(APP_THEME, "ธีมแอป");
        set(TEXT_COLOR, "สีข้อความ");
        set(TEXT_FONT_SIZE, "ขนาดฟอนต์ข้อความ");
        set(TABLE_FONT_SIZE, "ขนาดฟอนต์ตาราง");
        set(TABLE_RATIO, "สัดส่วนตาราง/หน้าจอ");
        
        set(KEEP_ALIVE, "เปิดเสียงค้างไว้ (ลดความล่าช้า)");
        set(AUDIO_BUFFER, "บัฟเฟอร์เสียง (ฮาร์ดแวร์)");
        set(PROCESSING_CHUNK, "หน่วยการประมวลผล");
        set(PERFORMANCE_HINT, "ถ้าเสียงกระตุก ให้เพิ่มบัฟเฟอร์ ถ้าความล่าช้าสูง ให้ลดลง");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "อินพุตที่รองรับ: คีย์บอร์ด, หน้าจอสัมผัส, เมาส์ หรือคันเคาะมอร์สพร้อมอะแดปเตอร์ USB\n\n" +
                "สำหรับการป้อนข้อมูลด้วยการคลิกซ้าย/ขวาของเมาส์ หรืออะแดปเตอร์แป้นพิมพ์ USB เป็นเมาส์ ให้ปล่อยตัวชี้เมาส์ไว้เหนือปุ่มแป้นพิมพ์ซ้ายบนหน้าจอ การคลิกซ้าย/ขวาจะจับคู่กับแป้นพิมพ์ที่ถูกต้อง\n\n" +
                "สำหรับอะแดปเตอร์คีย์บอร์ด USB (เช่น VBand) จะทำงานได้ทันทีโดยไม่ต้องตั้งค่า\n\n" +
                "โหมดเข้มงวดต้องใช้จังหวะที่แม่นยำระหว่างตัวอักษร โหมดไม่เข้มงวดช่วยให้เคาะได้เร็วขึ้น\n\n" +
                "ปัญหาที่พบบ่อย: ถ้าเสียงมีคลิกมากเกินไป ให้ลองใช้ตัวเลือก 'ฟันเลื่อย' หรือเปลี่ยน envelope ถ้าความล่าช้าสูง ให้ลดบัฟเฟอร์\n\n" +
                "ปุ่มคีย์บอร์ด:\n" +
                "  ซ้าย: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  ขวา: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "คีย์");
        
        set(SYSTEM_SETTING, "ตั้งค่าตามระบบ");
        set(DARK_THEME, "ธีมมืด");
        set(LIGHT_THEME, "ธีมสว่าง");
        
        set(MODE_STRAIGHT, "คันเคาะแนวตั้ง");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (กึ่งอัตโนมัติ)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "ตัวอักษร");
        set(CAT_NUMBERS, "ตัวเลข");
        set(CAT_SYMBOLS, "สัญลักษณ์");
        set(CAT_SPECIAL_SYMBOLS, "สัญลักษณ์พิเศษ");
        set(CAT_SPECIAL, "ตัวอักษรพิเศษ");
        set(CAT_PROSIGNS_COMMON, "สัญญาณขั้นตอนทั่วไป");
        set(CAT_ABBREVIATIONS, "คำย่อทั่วไป");
        set(CAT_QCODES, "รหัส Q");
        set(CAT_PROSIGNS_OTHER, "สัญญาณขั้นตอนอื่นๆ");

        set(COLOR_WHITE, "ขาว");
        set(COLOR_BLACK, "ดำ");
        set(COLOR_RED, "แดง");
        set(COLOR_ORANGE, "ส้ม");
        set(COLOR_YELLOW, "เหลือง");
        set(COLOR_GREEN, "เขียว");
        set(COLOR_CYAN, "ฟ้าอมเขียว");
        set(COLOR_BLUE, "น้ำเงิน");
        set(COLOR_PURPLE, "ม่วง");
        set(COLOR_PINK, "ชมพู");
        set(SUPPORT_WINDLEREYE, "สนับสนุนฉันด้วยการฟังโปรเจกต์ดนตรีของฉัน Windlereye");
        set(CANCEL, "ยกเลิก");
        set(QUIT, "ออก");
        set(QUIT_GAME_PROMPT, "คุณแน่ใจหรือไม่ว่าต้องการออกจากเกมนี้?");

        set(SCORE, "คะแนน: ");
        set(HIGH_SCORE, "คะแนนสูง");
        set(YOUR_HIGH_SCORE_IS, "คะแนนสูงสุดของคุณคือ:");
        set(TIME, "เวลา: ");
                set(MATCH_COMPLETED, "การแข่งขันจบลงแล้ว");
        set(TRY_AGAIN, "ลองอีกครั้ง");
        set(WORDS, "คำ");
                set(QUIT_GAME, "ออกจากเกม");
        set(MATCH_SETTINGS, "พารามิเตอร์ของเกม");
        set(SHARE_PREVIEW, "แชร์ตัวอย่าง");
        set(SHARE, "แบ่งปัน");
        set(SHARE_SUBJECT, "แบ่งปันคะแนน Morse Training ของฉัน");
        set(SHARE_PROMO_TEXT, "เล่น Morse Training ฟรีที่ https://morsetraining.com");
        set(THEME, "ธีม");

        set(MATCH_RESULTS, "ผลการแข่งขัน");
                

        set(REPEAT, "ทำซ้ำ");

        set(START, "เริ่ม");
        set(PICK_LANG_THEME_ON_SHARE, "เลือกภาษาและธีมเมื่อแชร์คะแนน");
        set(GAMES, "เกม");
        set(CONTINUE, "ดำเนินการต่อ");
        set(RX, "รับ");
        set(TX, "ส่ง");

        set(KOCH_METHOD, "วิธีคอค");
        set(TARGET, "เป้าหมาย");
        set(LISTEN, "ฟัง");
        set(TARGET_MET, "บรรลุเป้าหมาย");
        set(TARGET_NOT_MET, "ไม่บรรลุเป้าหมาย");
            set(LEVEL, "ระดับ");
    
        set(LEARN, "เรียนรู้");
        set(PLAY, "เล่น");
    
        set(LEVELS_COMPLETED, "ระดับที่สำเร็จ");
        set(RESET_PROGRESS, "รีเซ็ตความคืบหน้า");
        set(RESET_PROGRESS_CONFIRM, "แน่ใจหรือไม่ว่าต้องการรีเซ็ตความคืบหน้า?");
        set(RESET, "รีเซ็ต");
            set(WPM, "WPM​");
        set(SPACING, "ระยะห่าง");
    }
}