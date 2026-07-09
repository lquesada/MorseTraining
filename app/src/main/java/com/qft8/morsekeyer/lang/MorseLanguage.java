package com.qft8.morsekeyer.lang;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for all language translations.
 */
public abstract class MorseLanguage {

    private final Map<String, String> strings = new HashMap<>();

    public String get(String key) {
        return strings.getOrDefault(key, key);
    }

    protected void set(String key, String value) {
        strings.put(key, value);
    }

    // Keys
    public static final String SETTINGS_TITLE = "SETTINGS_TITLE";
    public static final String SAVE = "SAVE";
    public static final String RESET_DEFAULTS = "RESET_DEFAULTS";
    public static final String RESET_PROGRESS = "RESET_PROGRESS";
    public static final String RESET_PROGRESS_CONFIRM = "RESET_PROGRESS_CONFIRM";
    public static final String RESET = "RESET";
    public static final String WPM = "WPM";
    public static final String CLOSE = "CLOSE";
    public static final String BACK = "BACK";
    public static final String NEXT_LEVEL = "NEXT_LEVEL";

    public static final String CANCEL = "CANCEL";
    public static final String QUIT = "QUIT";
    public static final String QUIT_GAME_PROMPT = "QUIT_GAME_PROMPT";
    public static final String SCORE = "SCORE";
    public static final String TIME = "TIME";
    public static final String HIGH_SCORE = "HIGH_SCORE";
    public static final String YOUR_HIGH_SCORE_IS = "YOUR_HIGH_SCORE_IS";
    public static final String MATCH_COMPLETED = "MATCH_COMPLETED";
    public static final String TRY_AGAIN = "TRY_AGAIN";
    
    public static final String KEY_MODE = "KEY_MODE";
    public static final String WPM_SPEED = "WPM_SPEED";
    public static final String INVERSE_PADDLES = "INVERSE_PADDLES";
    public static final String STRICT_TIMING = "STRICT_TIMING";
    public static final String PICK_LANG_THEME_ON_SHARE = "PICK_LANG_THEME_ON_SHARE";
    
    public static final String TONE = "TONE";
    public static final String FREQUENCY = "FREQUENCY";
    public static final String VOLUME = "VOLUME";
    public static final String ENVELOPE = "ENVELOPE";
    public static final String NOCLICK = "NOCLICK";
    
    public static final String USER_INTERFACE = "USER_INTERFACE";
    public static final String LANGUAGE = "LANGUAGE";
    public static final String KEYBOARD_TYPE = "KEYBOARD_TYPE";
    public static final String SHOW_TABLE = "SHOW_TABLE";
    public static final String SHOW_TABLE_CODES = "SHOW_TABLE_CODES";
    public static final String SHOW_VISUAL = "SHOW_VISUAL";
    public static final String SHOW_PADDLES = "SHOW_PADDLES";
    public static final String NEXT_WORD_INDICATOR = "NEXT_WORD_INDICATOR";
    public static final String KEEP_SCREEN_ON = "KEEP_SCREEN_ON";
    public static final String APP_THEME = "APP_THEME";
    public static final String TEXT_COLOR = "TEXT_COLOR";
    public static final String TEXT_FONT_SIZE = "TEXT_FONT_SIZE";
    public static final String TABLE_FONT_SIZE = "TABLE_FONT_SIZE";
    public static final String TABLE_RATIO = "TABLE_RATIO";
    
    public static final String COLOR_WHITE = "COLOR_WHITE";
    public static final String COLOR_BLACK = "COLOR_BLACK";
    public static final String COLOR_RED = "COLOR_RED";
    public static final String COLOR_ORANGE = "COLOR_ORANGE";
    public static final String COLOR_YELLOW = "COLOR_YELLOW";
    public static final String COLOR_GREEN = "COLOR_GREEN";
    public static final String COLOR_CYAN = "COLOR_CYAN";
    public static final String COLOR_BLUE = "COLOR_BLUE";
    public static final String COLOR_PURPLE = "COLOR_PURPLE";
    public static final String COLOR_PINK = "COLOR_PINK";
    
    public static final String ADVANCED = "ADVANCED";
    public static final String KEEP_ALIVE = "KEEP_ALIVE";
    public static final String WHITE_NOISE = "WHITE_NOISE";
    public static final String AUDIO_BUFFER = "AUDIO_BUFFER";
    public static final String PROCESSING_CHUNK = "PROCESSING_CHUNK";
    public static final String PERFORMANCE_HINT = "PERFORMANCE_HINT";
    
    public static final String DECODER_BEHAVIOR = "DECODER_BEHAVIOR";
    
    public static final String INFO_TITLE = "INFO_TITLE";
    public static final String INFO_TEXT = "INFO_TEXT";
    public static final String SUPPORT_WINDLEREYE = "SUPPORT_WINDLEREYE";
    
    public static final String KEY = "KEY";
    
    public static final String SYSTEM_SETTING = "SYSTEM_SETTING";
    public static final String DARK_THEME = "DARK_THEME";
    public static final String LIGHT_THEME = "LIGHT_THEME";
    
    public static final String MODE_STRAIGHT = "MODE_STRAIGHT";
    public static final String MODE_IAMBIC_A = "MODE_IAMBIC_A";
    public static final String MODE_IAMBIC_B = "MODE_IAMBIC_B";
    public static final String MODE_ULTIMATIC = "MODE_ULTIMATIC";
    public static final String MODE_BUG = "MODE_BUG";
    public static final String MODE_COOTIE = "MODE_COOTIE";
    
    public static final String CAT_LETTERS = "CAT_LETTERS";
    public static final String CAT_NUMBERS = "CAT_NUMBERS";
    public static final String CAT_SYMBOLS = "CAT_SYMBOLS";
    public static final String CAT_SPECIAL_SYMBOLS = "CAT_SPECIAL_SYMBOLS";
    public static final String CAT_SPECIAL = "CAT_SPECIAL";
    public static final String CAT_PROSIGNS_COMMON = "CAT_PROSIGNS_COMMON";
    public static final String CAT_ABBREVIATIONS = "CAT_ABBREVIATIONS";
    public static final String CAT_QCODES = "CAT_QCODES";
    public static final String CAT_PROSIGNS_OTHER = "CAT_PROSIGNS_OTHER";

    // Match summary
    public static final String WORDS = "WORDS";
    public static final String TX = "TX";
    public static final String RX = "RX";
    public static final String LEARN = "LEARN";
    public static final String KOCH_METHOD = "KOCH_METHOD";
    public static final String TARGET = "TARGET";

    public static final String TARGET_MET = "TARGET_MET";
    public static final String TARGET_NOT_MET = "TARGET_NOT_MET";
    public static final String LEVEL = "LEVEL";
    public static final String LEVELS_COMPLETED = "LEVELS_COMPLETED";

    public static final String PLAY = "PLAY";
    public static final String REPEAT = "REPEAT";
    public static final String START = "START";
    public static final String CONTINUE = "CONTINUE";
    public static final String QUIT_GAME = "QUIT_GAME";
    public static final String MATCH_SETTINGS = "MATCH_SETTINGS";
    public static final String MATCH_RESULTS = "MATCH_RESULTS";

    // Share
    public static final String SHARE_PREVIEW = "SHARE_PREVIEW";
    public static final String GAMES = "GAMES";
    public static final String SHARE = "SHARE";
    public static final String SHARE_SUBJECT = "SHARE_SUBJECT";
    public static final String SHARE_PROMO_TEXT = "SHARE_PROMO_TEXT";
    public static final String THEME = "THEME";
    public static final String EFFECTIVE_WPM_FARNSWORTH = "EFFECTIVE_WPM_FARNSWORTH";
    public static final String EXTRA_WORD_SPACING = "EXTRA_WORD_SPACING";
    public static final String EFFECTIVE_WPM_SHORT = "EFFECTIVE_WPM_SHORT";
    public static final String WORD_SPACING_ADD = "WORD_SPACING_ADD";
}
