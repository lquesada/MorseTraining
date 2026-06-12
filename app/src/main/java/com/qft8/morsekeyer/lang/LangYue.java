package com.qft8.morsekeyer.lang;

public class LangYue extends MorseLanguage {
    public LangYue() {
        set(SAVE, "儲存");
        set(RESET_DEFAULTS, "重設為預設值");
        set(CLOSE, "關閉");
        
        set(SETTINGS_TITLE, "設定");
        set(TONE, "音調");
        set(USER_INTERFACE, "用戶介面");
        set(ADVANCED, "進階（性能）");
        set(DECODER_BEHAVIOR, "解碼器行為");

        set(KEY_MODE, "電鍵模式");
        set(WPM_SPEED, "速度 (WPM)");
        set(INVERSE_PADDLES, "反轉撥片");
        set(STRICT_TIMING, "嚴格時序");
        set(INTERLETTER_SPACING, "字母間距");
        set(INTERWORD_SPACING, "單詞間距");
        
        set(FREQUENCY, "頻率");
        set(VOLUME, "音量");
        set(ENVELOPE, "上升/下降時間（包絡）");
        set(NOCLICK, "使用鋸齒波信號避免點擊聲");
        
        set(LANGUAGE, "語言");
        set(KEYBOARD_TYPE, "鍵盤類型");
        set(SHOW_TABLE, "顯示摩斯密碼表");
        set(SHOW_TABLE_CODES, "在摩斯密碼表中顯示點同劃");
        set(SHOW_VISUAL, "顯示視覺指示器");
        set(SHOW_PADDLES, "顯示屏幕撥片");
        set(NEXT_WORD_INDICATOR, "下一個單詞指示器");
        set(KEEP_SCREEN_ON, "保持螢幕常亮");
        set(APP_THEME, "應用主題");
        set(TEXT_COLOR, "文字顏色");
        set(TEXT_FONT_SIZE, "文字字體大小");
        set(TABLE_FONT_SIZE, "表格字體大小");
        set(TABLE_RATIO, "表格/屏幕比例");
        
        set(KEEP_ALIVE, "保持音訊活動（降低延遲）");
        set(AUDIO_BUFFER, "音訊緩衝區（硬件）");
        set(PROCESSING_CHUNK, "處理塊");
        set(PERFORMANCE_HINT, "如果聲音斷斷續續，請增大緩衝區。如果延遲較高，請減小。");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "支援的輸入：鍵盤、觸控螢幕、滑鼠或帶有 USB 適配器的電鍵。\n\n" +
                "對於滑鼠左/右鍵點擊輸入或者USB轉滑鼠撥片適配器，請將滑鼠指標停喺螢幕上嘅左邊撥片上面，左/右鍵點擊就會對應到正確嘅撥片。\n\n" +
                "對於 USB 鍵盤適配器（例如 VBand），無需設定即可直接使用。\n\n" +
                "嚴格模式要求字母間有準確時序；非嚴格模式允許更快的操作。\n\n" +
                "常見問題：如果聲音點擊聲太重，請嘗試「鋸齒波」選項或修改包絡。如果延遲太高，請減小緩衝區。\n\n" +
                "鍵盤按鍵：\n" +
                "  左： [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  右： ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "鍵");
        
        set(SYSTEM_SETTING, "系統設定");
        set(DARK_THEME, "深色主題");
        set(LIGHT_THEME, "淺色主題");
        
        set(MODE_STRAIGHT, "直鍵");
        set(MODE_IAMBIC_A, "雙槳 A");
        set(MODE_IAMBIC_B, "雙槳 B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "快鍵 (Bug)");
        set(MODE_COOTIE, "雙向鍵 (Cootie)");
        
        set(CAT_LETTERS, "字母");
        set(CAT_NUMBERS, "數字");
        set(CAT_SYMBOLS, "符號");
        set(CAT_SPECIAL_SYMBOLS, "特殊符號");
        set(CAT_SPECIAL, "特殊字母");
        set(CAT_PROSIGNS_COMMON, "常用簡語");
        set(CAT_ABBREVIATIONS, "常用縮寫");
        set(CAT_QCODES, "Q 簡語");
        set(CAT_PROSIGNS_OTHER, "其他簡語");

        set(COLOR_WHITE, "白色");
        set(COLOR_BLACK, "黑色");
        set(COLOR_RED, "紅色");
        set(COLOR_ORANGE, "橙色");
        set(COLOR_YELLOW, "黃色");
        set(COLOR_GREEN, "綠色");
        set(COLOR_CYAN, "青色");
        set(COLOR_BLUE, "藍色");
        set(COLOR_PURPLE, "紫色");
        set(COLOR_PINK, "粉紅色");
        set(SUPPORT_WINDLEREYE, "透過收聽我嘅音樂項目 Windlereye 嚟支持我");
        set(CANCEL, "取消");
        set(QUIT, "退出");
        set(QUIT_GAME_PROMPT, "你確定要退出呢個遊戲？");

        set(SCORE, "分數");
        set(HIGH_SCORE, "高分");
        set(YOUR_HIGH_SCORE_IS, "你嘅最高分係");
        set(TIME, "時間");
                set(MATCH_COMPLETED, "比賽完成");
        set(TRY_AGAIN, "再試一次");
        set(WORDS, "单词");
                set(QUIT_GAME, "退出");
        set(MATCH_SETTINGS, "游戏参数");
        set(SHARE_PREVIEW, "分享预览");
        set(SHARE, "分享");
        set(SHARE_SUBJECT, "分享我的 Morse Training 分数");
        set(SHARE_PROMO_TEXT, "在 https://morsetraining.com 免费玩 Morse Training");
        set(THEME, "主题");

        set(MATCH_RESULTS, "比赛结果");
                

        set(REPEAT, "重複");

        set(START, "開始");
        set(PICK_LANG_THEME_ON_SHARE, "分享分數時選擇語言同主題");
        set(GAMES, "遊戲");
        set(CONTINUE, "繼續");
        set(RX, "接收");
        set(TX, "傳輸");

        set(KOCH_METHOD, "柯赫方法");
        set(TARGET, "目標");
set(TARGET_MET, "目標達到");
        set(TARGET_NOT_MET, "目標未達到");
            set(LEVEL, "等級");
    
        set(LEARN, "學習");
        set(PLAY, "玩");
    
        set(LEVELS_COMPLETED, "完成嘅等級");
        set(RESET_PROGRESS, "重置進度");
        set(RESET_PROGRESS_CONFIRM, "你確定要重置進度？");
        set(RESET, "重置");
            set(WPM, "WPM");
        set(SPACING, "間距");
        set(BACK, "返去");
        set(NEXT_LEVEL, "下一關");
    }
}