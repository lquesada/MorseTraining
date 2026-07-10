package com.qft8.morsekeyer.lang;

public class LangId extends MorseLanguage {
    public LangId() {
        set(SAVE, "Simpan");
        set(RESET_DEFAULTS, "Atur ulang ke default");
        set(CLOSE, "Tutup");
        
        set(SETTINGS_TITLE, "Pengaturan");
        set(TONE, "Nada");
        set(USER_INTERFACE, "Antarmuka Pengguna");
        set(ADVANCED, "Lanjutan (performa)");
        set(DECODER_BEHAVIOR, "Perilaku Dekoder");

        set(KEY_MODE, "Mode Kunci");
        set(WPM_SPEED, "Kecepatan (WPM)");
        set(INVERSE_PADDLES, "Balikkan Pedal");
        set(STRICT_TIMING, "Timing Ketat");
        
        set(FREQUENCY, "Frekuensi");
        set(VOLUME, "Volume");
        set(ENVELOPE, "Waktu naik/turun (envelope)");
        set(NOCLICK, "Sinyal gigi gergaji untuk menghindari klik");
        
        set(LANGUAGE, "Bahasa");
        set(KEYBOARD_TYPE, "Jenis keyboard");
        set(SHOW_TABLE, "Tampilkan tabel Morse");
        set(SHOW_TABLE_CODES, "Tampilkan titik dan garis di tabel Morse");
        set(SHOW_VISUAL, "Tampilkan indikator visual");
        set(SHOW_PADDLES, "Tampilkan pedal layar");
        set(NEXT_WORD_INDICATOR, "Indikator kata berikutnya");
        set(KEEP_SCREEN_ON, "Layar tetap menyala");
        set(APP_THEME, "Tema aplikasi");
        set(TEXT_COLOR, "Warna teks");
        set(TEXT_FONT_SIZE, "Ukuran font teks");
        set(TABLE_FONT_SIZE, "Ukuran font tabel");
        set(TABLE_RATIO, "Rasio tabel/layar");
        
        set(KEEP_ALIVE, "Jaga audio tetap aktif (mengurangi latensi)");
        set(WHITE_NOISE, "Lebih kuat (putar white noise)");
        set(AUDIO_BUFFER, "Buffer audio (perangkat keras)");
        set(PROCESSING_CHUNK, "Fragmen pemrosesan");
        set(PERFORMANCE_HINT, "Jika suara putus-putus, tingkatkan buffer. Jika latensi tinggi, kurangi.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Input yang didukung: keyboard, layar sentuh, mouse, atau pedal dengan adaptor USB.\n\n" +
                "Untuk kunci klik kiri/kanan mouse atau adaptor paddle USB-ke-mouse, biarkan penunjuk mouse di atas tombol paddle kiri di layar, klik kiri/kanan akan memetakan ke paddle yang benar.\n\n" +
                "Untuk adaptor keyboard (misalnya VBand), ini langsung berfungsi tanpa pengaturan.\n\n" +
                "Mode ketat memerlukan waktu yang tepat antar huruf; mode tidak ketat memungkinkan manipulasi lebih cepat.\n\n" +
                "Masalah umum: Jika suara terlalu banyak klik, coba opsi 'Gigi Gergaji' atau ubah envelope. Jika latensi tinggi, kurangi buffer.\n\n" +
                "Tombol keyboard:\n" +
                "  Kiri: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Kanan: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Kunci");
        
        set(SYSTEM_SETTING, "Pengaturan sistem");
        set(DARK_THEME, "Tema gelap");
        set(LIGHT_THEME, "Tema terang");
        
        set(MODE_STRAIGHT, "Kunci lurus");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Semi-otomatis)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "HURUF");
        set(CAT_NUMBERS, "ANGKA");
        set(CAT_SYMBOLS, "SIMBOL");
        set(CAT_SPECIAL_SYMBOLS, "SIMBOL KHUSUS");
        set(CAT_SPECIAL, "HURUF KHUSUS");
        set(CAT_PROSIGNS_COMMON, "SINYAL PROSEDUR UMUM");
        set(CAT_ABBREVIATIONS, "SINGKATAN UMUM");
        set(CAT_QCODES, "KODE Q");
        set(CAT_PROSIGNS_OTHER, "SINYAL PROSEDUR LAINNYA");

        set(COLOR_WHITE, "Putih");
        set(COLOR_BLACK, "Hitam");
        set(COLOR_RED, "Merah");
        set(COLOR_ORANGE, "Oranye");
        set(COLOR_YELLOW, "Kuning");
        set(COLOR_GREEN, "Hijau");
        set(COLOR_CYAN, "Sian");
        set(COLOR_BLUE, "Biru");
        set(COLOR_PURPLE, "Ungu");
        set(COLOR_PINK, "Merah Muda");
        set(SUPPORT_WINDLEREYE, "Dukung saya dengan mendengarkan proyek musik saya Windlereye");
        set(CANCEL, "Batal");
        set(QUIT, "Keluar");
        set(QUIT_GAME_PROMPT, "Apakah Anda yakin ingin keluar dari permainan ini?");

        set(SCORE, "Skor");
        set(HIGH_SCORE, "Skor tinggi");
        set(YOUR_HIGH_SCORE_IS, "Skor tertinggi Anda");
        set(TIME, "Waktu");
                set(MATCH_COMPLETED, "Pertandingan selesai");
        set(TRY_AGAIN, "Coba lagi");
        set(WORDS, "Kata");
                set(QUIT_GAME, "Keluar");
        set(MATCH_SETTINGS, "Parameter permainan");
        set(SHARE_PREVIEW, "Pratinjau");
        set(GAMES, "Permainan");
        set(SHARE, "Bagikan");
        set(SHARE_SUBJECT, "Membagikan skor");
        set(SHARE_PROMO_TEXT, "Mainkan di https://morsetraining.com");
        set(THEME, "Tema");

        set(MATCH_RESULTS, "Hasil");
                

        set(REPEAT, "ULANGI");

        set(START, "MULAI");
        set(PICK_LANG_THEME_ON_SHARE, "Pilih bahasa dan tema saat membagikan skor");
        set(CONTINUE, "MELANJUTKAN");
        set(RX, "Menerima");
        set(TX, "Mengirim");

        set(KOCH_METHOD, "Metode Koch");
        set(TARGET, "Target");
set(TARGET_MET, "Target tercapai");
        set(TARGET_NOT_MET, "Target tidak tercapai");
            set(LEVEL, "Tingkat");
    
        set(LEARN, "Belajar");
        set(PLAY, "Mainkan");
    
        set(LEVELS_COMPLETED, "Tingkat diselesaikan");
        set(RESET_PROGRESS, "Atur ulang kemajuan");
        set(RESET_PROGRESS_CONFIRM, "Anda yakin ingin mengatur ulang kemajuan?");
        set(RESET, "Atur ulang");
            set(WPM, "WPM​");
        set(BACK, "Kembali");
        set(NEXT_LEVEL, "Level berikutnya");

                set(EFFECTIVE_WPM_FARNSWORTH, "WPM Efektif (Farnsworth)");
                set(EXTRA_WORD_SPACING, "Spasi kata");
                set(EFFECTIVE_WPM_SHORT, "Efektif");

                set(WORD_SPACING_ADD, "Kata +");
    }
}