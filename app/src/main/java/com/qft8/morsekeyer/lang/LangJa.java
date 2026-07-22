package com.qft8.morsekeyer.lang;

public class LangJa extends MorseLanguage {
    public LangJa() {
        set(SAVE, "保存");
        set(RESET_DEFAULTS, "デフォルトに戻す");
        set(CLOSE, "閉じる");
        
        set(SETTINGS_TITLE, "設定");
        set(TONE, "トーン");
        set(USER_INTERFACE, "ユーザーインターフェース");
        set(ADVANCED, "高度な設定（パフォーマンス）");
        set(DECODER_BEHAVIOR, "デコーダーの動作");

        set(KEY_MODE, "キーモード");
        set(WPM_SPEED, "速度 (WPM)");
        set(INVERSE_PADDLES, "パドル反転");
        set(STRICT_TIMING, "厳密なタイミング");
        
        set(FREQUENCY, "周波数");
        set(VOLUME, "音量");
        set(ENVELOPE, "立ち上がり/立ち下がり（エンベロープ）");
        set(NOCLICK, "クリック音防止（のこぎり波）");
        
        set(LANGUAGE, "言語");
        set(KEYBOARD_TYPE, "キーボードタイプ");
        set(SHOW_TABLE, "モールス符号表を表示");
        set(SHOW_TABLE_CODES, "モールス符号表に短点と長点を表示");
        set(SHOW_VISUAL, "視覚インジケーターを表示");
        set(SHOW_PADDLES, "画面パドルを表示");
        set(NEXT_WORD_INDICATOR, "次の単語インジケーター");
        set(KEEP_SCREEN_ON, "画面を常時点灯");
        set(APP_THEME, "アプリのテーマ");
        set(TEXT_COLOR, "文字の色");
        set(TEXT_FONT_SIZE, "文字のサイズ");
        set(TABLE_FONT_SIZE, "表の文字サイズ");
        set(TABLE_RATIO, "表の表示比率");
        
        set(KEEP_ALIVE, "オーディオを維持（遅延を低減）");
        set(WHITE_NOISE, "より強く（ホワイトノイズを再生）");
        set(AUDIO_BUFFER, "オーディオバッファ（ハードウェア）");
        set(PROCESSING_CHUNK, "処理チャンク");
        set(PERFORMANCE_HINT, "音が途切れる場合はバッファを増やしてください。遅延が大きい場合は減らしてください。");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "サポートされている入力：キーボード、タッチスクリーン、マウス、またはUSBアダプター付きパドル。\n\n" +
                "マウスの左/右クリックキーイング、またはUSBからマウスへのパドルアダプタの場合、マウスポインタを画面の左パドルボタンの上に置いたままにすると、左/右クリックが正しいパドルにマッピングされます。\n\n" +
                "USBキーボードアダプター（VBandなど）は設定なしでそのまま動作します。\n\n" +
                "厳密モードは文字間の正確なタイミングを必要とします。非厳密モードはより高速な操作が可能です。\n\n" +
                "よくある問題：クリック音が気になる場合は「のこぎり波」を試すか、エンベロープを調整してください。遅延が大きい場合はバッファを減らしてください。\n\n" +
                "キーボードキー：\n" +
                "  左： [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  右： ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "キー");
        
        set(SYSTEM_SETTING, "システム設定");
        set(DARK_THEME, "ダークテーマ");
        set(LIGHT_THEME, "ライトテーマ");
        
        set(MODE_STRAIGHT, "縦振り");
        set(MODE_IAMBIC_A, "アイアンビック A");
        set(MODE_IAMBIC_B, "アイアンビック B");
        set(MODE_ULTIMATIC, "アルティマチック");
        set(MODE_BUG, "バグキー");
        set(MODE_COOTIE, "クーティー（複式）");
        
        set(CAT_LETTERS, "アルファベット");
        set(CAT_NUMBERS, "数字");
        set(CAT_SYMBOLS, "記号");
        set(CAT_SPECIAL_SYMBOLS, "特殊記号");
        set(CAT_SPECIAL, "特殊文字");
        set(CAT_PROSIGNS_COMMON, "常用略符号");
        set(CAT_ABBREVIATIONS, "常用略語");
        set(CAT_QCODES, "Q符号");
        set(CAT_PROSIGNS_OTHER, "その他の略語");

        set(COLOR_WHITE, "白色");
        set(COLOR_BLACK, "黒色");
        set(COLOR_RED, "赤色");
        set(COLOR_ORANGE, "オレンジ色");
        set(COLOR_YELLOW, "黄色");
        set(COLOR_GREEN, "緑色");
        set(COLOR_CYAN, "シアン");
        set(COLOR_BLUE, "青色");
        set(COLOR_PURPLE, "紫色");
        set(COLOR_PINK, "桃色");
        set(SUPPORT_WINDLEREYE, "私の音楽プロジェクト Windlereye を聴いて私を応援してください");
        set(CANCEL, "キャンセル");
        set(QUIT, "終了");
        set(QUIT_GAME_PROMPT, "このゲームを終了してもよろしいですか？");

        set(SCORE, "スコア");
        set(HIGH_SCORE, "ハイスコ​​ア");
        set(YOUR_HIGH_SCORE_IS, "あなたのハイスコア");
        set(TIME, "時間");
                set(MATCH_COMPLETED, "マッチ完了");
        set(TRY_AGAIN, "再試行");
        set(WORDS, "単語");
                set(QUIT_GAME, "終了する");
        set(MATCH_SETTINGS, "ゲームパラメータ");
        set(SHARE_PREVIEW, "プレビュー");
        set(SHARE, "共有");
        set(SHARE_SUBJECT, "私のスコア");
        set(SHARE_PROMO_TEXT, "https://morsetraining.com でプレイ");
        set(THEME, "テーマ");

        set(MATCH_RESULTS, "結果");
                

        set(REPEAT, "リピート");
        set(HINT, "ヒント");

        set(START, "開始");
        set(PICK_LANG_THEME_ON_SHARE, "スコア共有時に言語とテーマを選択する");
        set(GAMES, "ゲーム");
        set(CONTINUE, "続く");
        set(RX, "受信する");
        set(TX, "送信する");

        set(KOCH_METHOD, "コッホ法");
        set(TARGET, "目標");
set(TARGET_MET, "目標達成");
        set(TARGET_NOT_MET, "目標未達成");
            set(LEVEL, "レベル");
    
        set(LEARN, "学ぶ");
        set(PLAY, "プレイ");
    
        set(LEVELS_COMPLETED, "完了したレベル");
        set(RESET_PROGRESS, "進捗をリセット");
        set(RESET_PROGRESS_CONFIRM, "進捗をリセットしてもよろしいですか？");
        set(RESET, "リセット");
            set(WPM, "WPM​");
        set(BACK, "戻る");
        set(NEXT_LEVEL, "次のレベル");

                set(EFFECTIVE_WPM_FARNSWORTH, "実効WPM (Farnsworth)");
                set(EXTRA_WORD_SPACING, "スペース");
                set(EFFECTIVE_WPM_SHORT, "実効");

                set(WORD_SPACING_ADD, "単語 +");
    }
}
