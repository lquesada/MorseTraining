package com.qft8.morsekeyer.lang;

public class LangJv extends MorseLanguage {
    public LangJv() {
        set(SAVE, "Simpen");
        set(RESET_DEFAULTS, "Balekake menyang standar");
        set(CLOSE, "Tutup");
        
        set(SETTINGS_TITLE, "Setelan");
        set(TONE, "Nada");
        set(USER_INTERFACE, "Tampilan");
        set(ADVANCED, "Lanjut (performa)");
        set(DECODER_BEHAVIOR, "Cara Dekoder");

        set(KEY_MODE, "Mode Kunci");
        set(WPM_SPEED, "Kacepetan (WPM)");
        set(INVERSE_PADDLES, "Walik Pedal");
        set(STRICT_TIMING, "Wektu Ketat");
        set(INTERLETTER_SPACING, "Jarak Antar Aksara");
        set(INTERWORD_SPACING, "Jarak Antar Tembung");
        
        set(FREQUENCY, "Frekuensi");
        set(VOLUME, "Volume");
        set(ENVELOPE, "Wektu munggah/mudhun (envelope)");
        set(NOCLICK, "Nganggo sinyal untu gergaji supaya ora ana klik");
        
        set(LANGUAGE, "Basa");
        set(KEYBOARD_TYPE, "Jinis keyboard");
        set(SHOW_TABLE, "Tampilake tabel Morse");
        set(SHOW_TABLE_CODES, "Tampilake titik lan garis ing tabel Morse");
        set(SHOW_VISUAL, "Tampilake indikator visual");
        set(SHOW_PADDLES, "Tampilake pedal layar");
        set(NEXT_WORD_INDICATOR, "Indikator tembung sabanjure");
        set(KEEP_SCREEN_ON, "Layar tetep murub");
        set(APP_THEME, "Tema aplikasi");
        set(TEXT_COLOR, "Werna teks");
        set(TEXT_FONT_SIZE, "Ukuran font teks");
        set(TABLE_FONT_SIZE, "Ukuran font tabel");
        set(TABLE_RATIO, "Rasio tabel/layar");
        
        set(KEEP_ALIVE, "Audio tetep aktif (nyuda latensi)");
        set(AUDIO_BUFFER, "Buffer audio (hardware)");
        set(PROCESSING_CHUNK, "Fragmen pangolahan");
        set(PERFORMANCE_HINT, "Yen swara pedhot-pedhot, tambah buffer. Yen latensi dhuwur, suda buffer.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Input sing didhukung: keyboard, layar demek, mouse utawa adaptor paddle USB.\n\nKanggo mouse nengen/kiwa-klik keying utawa USB-kanggo-mouse paddle adaptor, ninggalake mouse pointer liwat tombol kiwa paddle ing layar, kiwa/nengen bakal peta kanggo paddles bener.\n\nKanggo adaptor paddle USB-menyang-keyboard (umpamane VBand) kerjane langsung tanpa persiyapan.\n\nWektu sing ketat mbutuhake jeda antar-huruf sing tepat; sing ora ketat ngidini keying sing luwih cepet.\n\nNgatasi Masalah: Yen swara muni klik, coba Sawtooth utawa ganti amplop. Yen latensi dhuwur, kurangi buffer. Yen swara gagap, tambahake.\n\nTombol keyboard:\n  Kiwa: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  Tengen: ]  D  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Kunci");
        
        set(SYSTEM_SETTING, "Setelan sistem");
        set(DARK_THEME, "Tema peteng");
        set(LIGHT_THEME, "Tema padhang");
        
        set(MODE_STRAIGHT, "Kunci lurus");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Semi-otomatis)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "AKSARA");
        set(CAT_NUMBERS, "ANGKA");
        set(CAT_SYMBOLS, "SIMBOL");
        set(CAT_SPECIAL_SYMBOLS, "SIMBOL KHUSUS");
        set(CAT_SPECIAL, "AKSARA KHUSUS");
        set(CAT_PROSIGNS_COMMON, "SINYAL PROSEDUR UMUM");
        set(CAT_ABBREVIATIONS, "SINGKATAN UMUM");
        set(CAT_QCODES, "KODE Q");
        set(CAT_PROSIGNS_OTHER, "SINYAL PROSEDUR LIYANE");

        set(COLOR_WHITE, "Putih");
        set(COLOR_BLACK, "Irem");
        set(COLOR_RED, "Abang");
        set(COLOR_ORANGE, "Oranye");
        set(COLOR_YELLOW, "Kuning");
        set(COLOR_GREEN, "Ijo");
        set(COLOR_CYAN, "Sian");
        set(COLOR_BLUE, "Biru");
        set(COLOR_PURPLE, "Ungu");
        set(COLOR_PINK, "Merah Muda");
        set(SUPPORT_WINDLEREYE, "Dukung kula kanthi ngrungokake proyek musik kula Windlereye");
        set(CANCEL, "Batal");
        set(QUIT, "Metu");
        set(QUIT_GAME_PROMPT, "Apa sampeyan yakin arep metu saka game iki?");

        set(SCORE, "Skor: ");
        set(HIGH_SCORE, "Skor dhuwur");
        set(YOUR_HIGH_SCORE_IS, "Skor paling dhuwur sampeyan:");
        set(TIME, "Wektu: ");
                set(MATCH_COMPLETED, "Pertandhingan rampung");
        set(TRY_AGAIN, "Coba maneh");
        set(WORDS, "Tembung");
                set(QUIT_GAME, "Mungkasi Game");
        set(MATCH_SETTINGS, "Paramèter game");
        set(SHARE_PREVIEW, "Nuduhake pratinjau");
        set(SHARE, "Nuduhake");
        set(SHARE_SUBJECT, "Nuduhake skor Morse Training");
        set(SHARE_PROMO_TEXT, "Muter Morse Training gratis ing https://morsetraining.com");
        set(THEME, "Tema");

        set(MATCH_RESULTS, "Hasil pertandhingan");
                
        set(TX_PRACTICE, "Transmit (Latihan)");
        set(TX_CONTEST, "Kirim (Skor Serangan)");
        set(INFINITE, "Laku tanpa watesan wektu");
        set(THREE_MINUTES, "Ngalahake skor sampeyan sajrone 3 menit");

        set(RX_PRACTICE, "Nampa (Latihan)");
        set(RX_CONTEST, "Nampa (Skor Serangan)");
        set(REPEAT, "BALENI");

        set(START, "MULAI");
        set(PICK_LANG_THEME_ON_SHARE, "Pilih basa lan tema nalika nuduhake skor");
        set(GAMES, "Game");
        set(CONTINUE, "TERUS");
        set(RX, "Nampa");
        set(TX, "ngirim");
}
}
