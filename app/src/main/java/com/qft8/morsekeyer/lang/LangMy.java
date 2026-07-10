package com.qft8.morsekeyer.lang;

public class LangMy extends MorseLanguage {
    public LangMy() {
        set(SAVE, "သိမ်းဆည်းရန်");
        set(RESET_DEFAULTS, "မူလအတိုင်းပြန်ထားရန်");
        set(CLOSE, "ပိတ်ရန်");
        
        set(SETTINGS_TITLE, "ဆက်တင်များ");
        set(TONE, "အသံ");
        set(USER_INTERFACE, "အသွင်အပြင်");
        set(ADVANCED, "အဆင့်မြင့် (စွမ်းဆောင်ရည်)");
        set(DECODER_BEHAVIOR, "ဒီကိုဒါ လုပ်ဆောင်ချက်");

        set(KEY_MODE, "ခလုတ် မုဒ်");
        set(WPM_SPEED, "အမြန်နှုန်း (WPM)");
        set(INVERSE_PADDLES, "ခလုတ်ပြောင်းရန်");
        set(STRICT_TIMING, "တိကျသော အချိန်ကိုက်မှု");
        
        set(FREQUENCY, "ကြိမ်နှုန်း");
        set(VOLUME, "အသံပမာဏ");
        set(ENVELOPE, "တက်/ကျ အချိန် (Envelope)");
        set(NOCLICK, "ကလစ်သံမထွက်စေရန် Sawtooth အသုံးပြုရန်");
        
        set(LANGUAGE, "ဘာသာစကား");
        set(KEYBOARD_TYPE, "ကီးဘုတ်အမျိုးအစား");
        set(SHOW_TABLE, "မော့စ် ဇယားပြရန်");
        set(SHOW_TABLE_CODES, "မော့စ်ဇယားတွင် အစက်နှင့် အရှည်အမှတ်များကို ပြရန်");
        set(SHOW_VISUAL, "အမြင်အာရုံ အချက်ပြမှုကို ပြရန်");
        set(SHOW_PADDLES, "မျက်နှာပြင်ပေါ်ရှိ ခလုတ်များကို ပြရန်");
        set(NEXT_WORD_INDICATOR, "နောက်စာလုံး အချက်ပြမှု");
        set(KEEP_SCREEN_ON, "မျက်နှာပြင် အမြဲလင်းစေရန်");
        set(APP_THEME, "အက်ပ် သီမ်");
        set(TEXT_COLOR, "စာသားအရောင်");
        set(TEXT_FONT_SIZE, "စာသား ဖောင့်အရွယ်အစား");
        set(TABLE_FONT_SIZE, "ဇယား ဖောင့်အရွယ်အစား");
        set(TABLE_RATIO, "ဇယား/မျက်နှာပြင် အချိုး");
        
        set(KEEP_ALIVE, "အသံအသင့်ဖြစ်စေရန် (နှောင့်နှေးမှုလျှော့ချရန်)");
        set(WHITE_NOISE, "ပိုအားကောင်းသည် (ဖြူသောဆူညံသံဖွင့်ပါ)");
        set(AUDIO_BUFFER, "အသံ ဘတ်ဖာ (Hardware)");
        set(PROCESSING_CHUNK, "လုပ်ဆောင်ချက် အပိုင်းအစ");
        set(PERFORMANCE_HINT, "အသံထစ်ပါက ဘတ်ဖာကို တိုးပါ။ နှောင့်နှေးပါက လျှော့ပါ။");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "ပံ့ပိုးပေးထားသော ထည့်သွင်းမှုများ- ကီးဘုတ်၊ ထိတွေ့မျက်နှာပြင်၊ မောက်စ် သို့မဟုတ် USB လှော်တက် အဒက်တာ။\n\nမောက်စ်ဘယ်/ညာကလစ်ခလုတ်နှိပ်ခြင်း သို့မဟုတ် USB-မှ-မောက်စ် လှော်တက်အဒက်တာအတွက်၊ မောက်စ်ညွှန်ပြချက်ကို စခရင်ရှိ ဘယ်ဘက်လှော်တက်ခလုတ်ပေါ်တွင် ထားလိုက်ပါ၊ ဘယ်/ညာ ကလစ်ကို မှန်ကန်သော လှော်တက်များနှင့် ပုံဖော်ပေးပါမည်။\n\nUSB-မှ-ကီးဘုတ် လှော်တက် အဒက်တာများ (ဥပမာ VBand) အတွက် ၎င်းသည် ချက်ချင်း အလုပ်လုပ်ပါသည်။\n\nတင်းကျပ်သောအချိန်သတ်မှတ်မှုသည် အက္ခရာများကြားတွင် တိကျသော ရပ်နားမှုများ လိုအပ်သည်။ တင်းကျပ်မှုမရှိသောအချိန်သတ်မှတ်မှုသည် ပိုမိုမြန်ဆန်စွာရိုက်ထည့်နိုင်စေပါသည်။\n\nပြဿနာဖြေရှင်းခြင်း- အသံသည် ကလစ်ဖြစ်နေပါက၊ လွှသွားပုံစံ (Sawtooth) ကို စမ်းကြည့်ပါ သို့မဟုတ် စာအိတ်ကို ပြောင်းပါ။ နောက်ကျမှုမြင့်မားပါက ကြားခံ (buffer) ကိုလျှော့ချပါ။ အသံထစ်နေပါက တိုးပေးပါ။\n\nကီးဘုတ် ခလုတ်များ-\n  ဘယ်ဘက်- [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  ညာဘက်- ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "ခလုတ်");
        
        set(SYSTEM_SETTING, "စနစ် ဆက်တင်");
        set(DARK_THEME, "မှောင်သော သီမ်");
        set(LIGHT_THEME, "လင်းသော သီမ်");
        
        set(MODE_STRAIGHT, "ဒေါင်လိုက်ခလုတ်");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "ဘတ်ဂ် (တစ်ပိုင်းအလိုအလျောက်)");
        set(MODE_COOTIE, "ကူတီး (Sideswiper)");
        
        set(CAT_LETTERS, "စာလုံးများ");
        set(CAT_NUMBERS, "ဂဏန်းများ");
        set(CAT_SYMBOLS, "သင်္ကေတများ");
        set(CAT_SPECIAL_SYMBOLS, "အထူးသင်္ကေတများ");
        set(CAT_SPECIAL, "အထူးစာလုံးများ");
        set(CAT_PROSIGNS_COMMON, "အသုံးများသော အချက်ပြမှုများ");
        set(CAT_ABBREVIATIONS, "အသုံးများသော အတိုကောက်များ");
        set(CAT_QCODES, "Q ကုဒ်များ");
        set(CAT_PROSIGNS_OTHER, "အခြားအချက်ပြမှုများ");

        set(COLOR_WHITE, "အဖြူရောင်");
        set(COLOR_BLACK, "အမည်းရောင်");
        set(COLOR_RED, "အနီရောင်");
        set(COLOR_ORANGE, "လိမ္မော်ရောင်");
        set(COLOR_YELLOW, "အဝါရောင်");
        set(COLOR_GREEN, "အစိမ်းရောင်");
        set(COLOR_CYAN, "စိမ်းပြာရောင်");
        set(COLOR_BLUE, "အပြာရောင်");
        set(COLOR_PURPLE, "ခရမ်းရောင်");
        set(COLOR_PINK, "ပန်းရောင်");
        set(SUPPORT_WINDLEREYE, "ကျွန်ုပ်၏ တေးဂီတ ပရောဂျက် Windlereye ကို နားဆင်ခြင်းဖြင့် ကျွန်ုပ်ကို ပံ့ပိုးပေးပါ");
        set(CANCEL, "ပယ်ဖျက်ရန်");
        set(QUIT, "ထွက်ရန်");
        set(QUIT_GAME_PROMPT, "သင် ဤဂိမ်းမှ အမှန်တကယ် ထွက်လိုပါသလား?");

        set(SCORE, "ရမှတ်");
        set(HIGH_SCORE, "မြင့်မားသောရမှတ်");
        set(YOUR_HIGH_SCORE_IS, "သင့်၏ အမြင့်ဆုံးရမှတ်မှာ");
        set(TIME, "အချိန်");
                set(MATCH_COMPLETED, "ပွဲပြီးဆုံးပါပြီ");
        set(TRY_AGAIN, "ထပ်စမ်းကြည့်ပါ");
        set(WORDS, "စကား");
                set(QUIT_GAME, "ဂိမ်းကိုထွက်လိုက်ပါ။");
        set(MATCH_SETTINGS, "ဂိမ်းဘောင်များ");
        set(SHARE_PREVIEW, "အကြိုမျှဝေပါ။");
        set(SHARE, "မျှဝေပါ။");
        set(SHARE_SUBJECT, "ကျွန်ုပ်၏ Morse Training ရမှတ်ကို မျှဝေခြင်း။");
        set(SHARE_PROMO_TEXT, "https://morsetraining.com တွင် Morse Training ကို အခမဲ့ကစားပါ။");
        set(THEME, "အပြင်အဆင်");

        set(MATCH_RESULTS, "ပွဲရလဒ်များ");
                

        set(REPEAT, "ထပ်လုပ်ပါ");

        set(START, "စတင်ရန်");
        set(PICK_LANG_THEME_ON_SHARE, "ရမှတ်များ မျှဝေသည့်အခါ ဘာသာစကားနှင့် အပြင်အဆင်ကို ရွေးချယ်ပါ");
        set(GAMES, "ဂိမ်းများ");
        set(CONTINUE, "ဆက်ရန်");
        set(RX, "လက်ခံရန်");
        set(TX, "ထုတ်လွှင့်ရန်");

        set(KOCH_METHOD, "ကို့ချ်နည်းလမ်း");
        set(TARGET, "ပစ်မှတ်");
set(TARGET_MET, "ပစ်မှတ်ပြည့်မီသည်");
        set(TARGET_NOT_MET, "ပစ်မှတ်မပြည့်မီပါ");
            set(LEVEL, "အဆင့်");
    
        set(LEARN, "သင်ယူရန်");
        set(PLAY, "ကစားရန်");
    
        set(LEVELS_COMPLETED, "ပြီးစီးသောအဆင့်များ");
        set(RESET_PROGRESS, "တိုးတက်မှုကို ပြန်လည်သတ်မှတ်ရန်");
        set(RESET_PROGRESS_CONFIRM, "တိုးတက်မှုကို ပြန်လည်သတ်မှတ်မည်မှာ သေချာပါသလား?");
        set(RESET, "ပြန်လည်သတ်မှတ်ရန်");
            set(WPM, "WPM​");
        set(BACK, "နောက်သို့");
        set(NEXT_LEVEL, "နောက်အဆင့်");

                set(EFFECTIVE_WPM_FARNSWORTH, "ထိရောက်သော WPM (Farnsworth)");
                set(EXTRA_WORD_SPACING, "စကားလုံး ခြားနားချက်");
                set(EFFECTIVE_WPM_SHORT, "ထိရောက်သော");

                set(WORD_SPACING_ADD, "စကား +");
    }
}