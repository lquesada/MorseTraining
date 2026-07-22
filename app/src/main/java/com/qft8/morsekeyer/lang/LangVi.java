package com.qft8.morsekeyer.lang;

public class LangVi extends MorseLanguage {
    public LangVi() {
        set(SAVE, "Lưu");
        set(RESET_DEFAULTS, "Đặt lại mặc định");
        set(CLOSE, "Đóng");
        
        set(SETTINGS_TITLE, "Cài đặt");
        set(TONE, "Âm thanh");
        set(USER_INTERFACE, "Giao diện");
        set(ADVANCED, "Nâng cao (hiệu suất)");
        set(DECODER_BEHAVIOR, "Hành vi giải mã");

        set(KEY_MODE, "Chế độ phím");
        set(WPM_SPEED, "Tốc độ (WPM)");
        set(INVERSE_PADDLES, "Đảo ngược cần gạt");
        set(STRICT_TIMING, "Thời gian nghiêm ngặt");
        
        set(FREQUENCY, "Tần số");
        set(VOLUME, "Âm lượng");
        set(ENVELOPE, "Thời gian tăng/giảm (envelope)");
        set(NOCLICK, "Sử dụng tín hiệu răng cưa để tránh tiếng click");
        
        set(LANGUAGE, "Ngôn ngữ");
        set(KEYBOARD_TYPE, "Loại bàn phím");
        set(SHOW_TABLE, "Hiển thị bảng mã Morse");
        set(SHOW_TABLE_CODES, "Hiển thị chấm và gạch trong bảng mã Morse");
        set(SHOW_VISUAL, "Hiển thị chỉ báo hình ảnh");
        set(SHOW_PADDLES, "Hiển thị cần gạt trên màn hình");
        set(NEXT_WORD_INDICATOR, "Chỉ báo từ tiếp theo");
        set(KEEP_SCREEN_ON, "Luôn bật màn hình");
        set(APP_THEME, "Chủ đề ứng dụng");
        set(TEXT_COLOR, "Màu văn bản");
        set(TEXT_FONT_SIZE, "Kích thước chữ văn bản");
        set(TABLE_FONT_SIZE, "Kích thước chữ bảng");
        set(TABLE_RATIO, "Tỷ lệ bảng/màn hình");
        
        set(KEEP_ALIVE, "Giữ âm thanh luôn bật (giảm độ trễ)");
        set(WHITE_NOISE, "Mạnh hơn (phát tiếng ồn trắng)");
        set(AUDIO_BUFFER, "Bộ đệm âm thanh (phần cứng)");
        set(PROCESSING_CHUNK, "Khối xử lý");
        set(PERFORMANCE_HINT, "Nếu âm thanh bị ngắt quãng, hãy tăng bộ đệm. Nếu độ trễ cao, hãy giảm chúng.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Đầu vào hỗ trợ: bàn phím, màn hình cảm ứng, chuột hoặc cần gạt Morse với bộ chuyển đổi USB.\n\n" +
                "Đối với phím bấm chuột trái/phải hoặc bộ điều hợp mái chèo USB-to-mouse, hãy để con trỏ chuột trên nút mái chèo bên trái trên màn hình, nhấp chuột trái/phải sẽ ánh xạ đến đúng mái chèo.\n\n" +
                "Đối với bộ chuyển đổi bàn phím USB (ví dụ: VBand), nó hoạt động ngay lập tức mà không cần cài đặt.\n\n" +
                "Chế độ nghiêm ngặt yêu cầu thời gian chính xác giữa các chữ cái; chế độ không nghiêm ngặt cho phép thao tác nhanh hơn.\n\n" +
                "Các vấn đề thường gặp: Nếu âm thanh quá nhiều tiếng click, hãy thử tùy chọn 'Răng cưa' hoặc thay đổi envelope. Nếu độ trễ cao, hãy giảm bộ đệm.\n\n" +
                "Các phím bàn phím:\n" +
                "  Trái: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Phải: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Phím");
        
        set(SYSTEM_SETTING, "Cài đặt hệ thống");
        set(DARK_THEME, "Chủ đề tối");
        set(LIGHT_THEME, "Chủ đề sáng");
        
        set(MODE_STRAIGHT, "Phím dọc");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Bán tự động)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "CHỮ CÁI");
        set(CAT_NUMBERS, "CHỮ SỐ");
        set(CAT_SYMBOLS, "KÝ HIỆU");
        set(CAT_SPECIAL_SYMBOLS, "KÝ HIỆU ĐẶC BIỆT");
        set(CAT_SPECIAL, "CHỮ CÁI ĐẶC BIỆT");
        set(CAT_PROSIGNS_COMMON, "TÍN HIỆU THỦ TỤC CHUNG");
        set(CAT_ABBREVIATIONS, "TỪ VIẾT TẮT CHUNG");
        set(CAT_QCODES, "MÃ Q");
        set(CAT_PROSIGNS_OTHER, "TÍN HIỆU THỦ TỤC KHÁC");

        set(COLOR_WHITE, "Trắng");
        set(COLOR_BLACK, "Đen");
        set(COLOR_RED, "Đỏ");
        set(COLOR_ORANGE, "Cam");
        set(COLOR_YELLOW, "Vàng");
        set(COLOR_GREEN, "Xanh lá");
        set(COLOR_CYAN, "Xanh lơ");
        set(COLOR_BLUE, "Xanh dương");
        set(COLOR_PURPLE, "Tím");
        set(COLOR_PINK, "Hồng");
        set(SUPPORT_WINDLEREYE, "Ủng hộ tôi bằng cách nghe dự án âm nhạc Windlereye của tôi");
        set(CANCEL, "Hủy");
        set(QUIT, "Thoát");
        set(QUIT_GAME_PROMPT, "Bạn có chắc chắn muốn thoát khỏi trò chơi này không?");

        set(SCORE, "Điểm");
        set(HIGH_SCORE, "Điểm cao");
        set(YOUR_HIGH_SCORE_IS, "Điểm cao nhất của bạn là");
        set(TIME, "Thời gian");
                set(MATCH_COMPLETED, "Trận đấu kết thúc");
        set(TRY_AGAIN, "Thử lại");
        set(WORDS, "Từ");
                set(QUIT_GAME, "Thoát");
        set(MATCH_SETTINGS, "Thông số trò chơi");
        set(SHARE_PREVIEW, "Xem trước");
        set(SHARE, "Chia sẻ");
        set(SHARE_SUBJECT, "Chia sẻ điểm");
        set(SHARE_PROMO_TEXT, "Chơi tại https://morsetraining.com");
        set(THEME, "Chủ đề");

        set(MATCH_RESULTS, "Kết quả");
                

        set(REPEAT, "LẶP LẠI");
        set(HINT, "GỢI Ý");

        set(START, "BẮT ĐẦU");
        set(PICK_LANG_THEME_ON_SHARE, "Chọn ngôn ngữ và chủ đề khi chia sẻ điểm số");
        set(GAMES, "Trò chơi");
        set(CONTINUE, "TIẾP TỤC");
        set(RX, "Nhận");
        set(TX, "Truyền");

        set(KOCH_METHOD, "Phương pháp Koch");
        set(TARGET, "Mục tiêu");
set(TARGET_MET, "Đã đạt mục tiêu");
        set(TARGET_NOT_MET, "Chưa đạt mục tiêu");
            set(LEVEL, "Cấp độ");
    
        set(LEARN, "Học");
        set(PLAY, "Chơi");
    
        set(LEVELS_COMPLETED, "Các cấp độ đã hoàn thành");
        set(RESET_PROGRESS, "Đặt lại tiến trình");
        set(RESET_PROGRESS_CONFIRM, "Bạn có chắc chắn muốn đặt lại tiến trình?");
        set(RESET, "Đặt lại");
            set(WPM, "WPM​");
        set(BACK, "Quay lại");
        set(NEXT_LEVEL, "Cấp độ tiếp theo");

                set(EFFECTIVE_WPM_FARNSWORTH, "WPM Hiệu quả (Farnsworth)");
                set(EXTRA_WORD_SPACING, "Khoảng cách");
                set(EFFECTIVE_WPM_SHORT, "Hiệu quả");

                set(WORD_SPACING_ADD, "Từ +");
    }
}
