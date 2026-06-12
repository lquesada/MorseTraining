package com.qft8.morsekeyer.lang;

public class LangZh extends MorseLanguage {
    public LangZh() {
        set(SAVE, "保存");
        set(RESET_DEFAULTS, "重置为默认值");
        set(CLOSE, "关闭");
        
        set(SETTINGS_TITLE, "设置");
        set(TONE, "音调");
        set(USER_INTERFACE, "用户界面");
        set(ADVANCED, "高级（性能）");
        set(DECODER_BEHAVIOR, "解码器行为");

        set(KEY_MODE, "电键模式");
        set(WPM_SPEED, "速度 (WPM)");
        set(INVERSE_PADDLES, "反转拨片");
        set(STRICT_TIMING, "严格时序");
        set(INTERLETTER_SPACING, "字母间距");
        set(INTERWORD_SPACING, "单词间距");
        
        set(FREQUENCY, "频率");
        set(VOLUME, "音量");
        set(ENVELOPE, "上升/下降时间（包络）");
        set(NOCLICK, "使用锯齿波信号避免点击声");
        
        set(LANGUAGE, "语言");
        set(KEYBOARD_TYPE, "键盘类型");
        set(SHOW_TABLE, "显示摩尔斯电码表");
        set(SHOW_TABLE_CODES, "在摩尔斯电码表中显示点和划");
        set(SHOW_VISUAL, "显示视觉指示器");
        set(SHOW_PADDLES, "显示屏幕拨片");
        set(NEXT_WORD_INDICATOR, "下一个单词指示器");
        set(KEEP_SCREEN_ON, "保持屏幕常亮");
        set(APP_THEME, "应用主题");
        set(TEXT_COLOR, "文字颜色");
        set(TEXT_FONT_SIZE, "文字字体大小");
        set(TABLE_FONT_SIZE, "表格字体大小");
        set(TABLE_RATIO, "表格/屏幕比例");
        
        set(KEEP_ALIVE, "保持音频活动（降低延迟）");
        set(AUDIO_BUFFER, "音频缓冲区（硬件）");
        set(PROCESSING_CHUNK, "处理块");
        set(PERFORMANCE_HINT, "如果声音断断续续，请增大缓冲区。如果延迟较高，请减小。");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "支持的输入：键盘、触摸屏、鼠标或带有 USB 适配器的电键。\n\n" +
                "对于鼠标左/右键点击输入或者USB转鼠标拨片适配器，请将鼠标指针停在屏幕上的左边拨片上方，左/右键点击将会映射到正确的拨片。\n\n" +
                "对于 USB 键盘适配器（例如 VBand），无需设置即可直接使用。\n\n" +
                "严格模式要求字母间有时序准确；非严格模式允许更快的操作。\n\n" +
                "常见问题：如果声音点击声太重，请尝试“锯齿波”选项或修改包络。如果延迟太高，请减小缓冲区。\n\n" +
                "键盘按键：\n" +
                "  左： [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  右： ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "键");
        
        set(SYSTEM_SETTING, "系统设置");
        set(DARK_THEME, "深色主题");
        set(LIGHT_THEME, "浅色主题");
        
        set(MODE_STRAIGHT, "直键");
        set(MODE_IAMBIC_A, "双桨 A");
        set(MODE_IAMBIC_B, "双桨 B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "快键 (Bug)");
        set(MODE_COOTIE, "双向键 (Cootie)");
        
        set(CAT_LETTERS, "字母");
        set(CAT_NUMBERS, "数字");
        set(CAT_SYMBOLS, "符号");
        set(CAT_SPECIAL_SYMBOLS, "特殊符号");
        set(CAT_SPECIAL, "特殊字母");
        set(CAT_PROSIGNS_COMMON, "常用简语");
        set(CAT_ABBREVIATIONS, "常用缩写");
        set(CAT_QCODES, "Q 简语");
        set(CAT_PROSIGNS_OTHER, "其他简语");

        set(COLOR_WHITE, "白色");
        set(COLOR_BLACK, "黑色");
        set(COLOR_RED, "红色");
        set(COLOR_ORANGE, "橙色");
        set(COLOR_YELLOW, "黄色");
        set(COLOR_GREEN, "绿色");
        set(COLOR_CYAN, "青色");
        set(COLOR_BLUE, "蓝色");
        set(COLOR_PURPLE, "紫色");
        set(COLOR_PINK, "粉红色");
        set(SUPPORT_WINDLEREYE, "通过收听我的音乐项目 Windlereye 来支持我");
        set(CANCEL, "取消");
        set(QUIT, "退出");
        set(QUIT_GAME_PROMPT, "您确定要退出此游戏吗？");

        set(SCORE, "分数");
        set(HIGH_SCORE, "高分");
        set(YOUR_HIGH_SCORE_IS, "你的最高分是");
        set(TIME, "时间");
                set(MATCH_COMPLETED, "比赛完成");
        set(TRY_AGAIN, "重试");
        set(WORDS, "单词");
                set(QUIT_GAME, "退出");
        set(MATCH_SETTINGS, "游戏参数");
        set(SHARE_PREVIEW, "分享预览");
        set(SHARE, "分享");
        set(SHARE_SUBJECT, "分享我的 Morse Training 分数");
        set(SHARE_PROMO_TEXT, "在 https://morsetraining.com 免费玩 Morse Training");
        set(THEME, "主题");

        set(MATCH_RESULTS, "比赛结果");
                

        set(REPEAT, "重复");

        set(START, "开始");
        set(PICK_LANG_THEME_ON_SHARE, "分享分数时选择语言和主题");
        set(GAMES, "游戏");
        set(CONTINUE, "继续");
        set(RX, "接收");
        set(TX, "传输");

        set(KOCH_METHOD, "柯赫方法");
        set(TARGET, "目标");
set(TARGET_MET, "目标达成");
        set(TARGET_NOT_MET, "目标未达成");
            set(LEVEL, "等级");
    
        set(LEARN, "学习");
        set(PLAY, "玩");
    
        set(LEVELS_COMPLETED, "已完成等级");
        set(RESET_PROGRESS, "重置进度");
        set(RESET_PROGRESS_CONFIRM, "您确定要重置进度吗？");
        set(RESET, "重置");
            set(WPM, "WPM​");
        set(SPACING, "间距");
        set(BACK, "返回");
        set(NEXT_LEVEL, "下一关");
    }
}