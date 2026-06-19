package com.qft8.morsekeyer.lang;

public class LangHe extends MorseLanguage {
    public LangHe() {
        set(SAVE, "שמור");
        set(RESET_DEFAULTS, "אפס לברירות מחדל");
        set(CLOSE, "סגור");
        
        set(SETTINGS_TITLE, "הגדרות");
        set(TONE, "צליל");
        set(USER_INTERFACE, "ממשק משתמש");
        set(ADVANCED, "מתקדם (ביצועים)");
        set(DECODER_BEHAVIOR, "התנהגות מפענח");

        set(KEY_MODE, "מצב מפתח");
        set(WPM_SPEED, "מהירות WPM");
        set(INVERSE_PADDLES, "משוטים הפוכים (Paddles)");
        set(STRICT_TIMING, "תזמון קפדני");
        set(INTERLETTER_SPACING, "מרווח בין אותיות");
        set(INTERWORD_SPACING, "מרווח בין מילים");
        
        set(FREQUENCY, "תדר");
        set(VOLUME, "עוצמת שמע");
        set(ENVELOPE, "זמן עליה/ירידה (מעטפת)");
        set(NOCLICK, "השתמש באות שן מסור למניעת קליקים");
        
        set(LANGUAGE, "שפה");
        set(KEYBOARD_TYPE, "סוג מקלדת");
        set(SHOW_TABLE, "הצג טבלת מורס");
        set(SHOW_TABLE_CODES, "הצג נקודות וקווים בטבלת מורס");
        set(SHOW_VISUAL, "הצג מחוון חזותי");
        set(SHOW_PADDLES, "הצג משוטי מסך");
        set(NEXT_WORD_INDICATOR, "מחוון מילה הבאה");
        set(KEEP_SCREEN_ON, "השאר את המסך דולק בזמן שהאפליקציה פעילה");
        set(APP_THEME, "ערכת נושא");
        set(TEXT_COLOR, "צבע טקסט");
        set(TEXT_FONT_SIZE, "גודל גופן טקסט");
        set(TABLE_FONT_SIZE, "גודל גופן טבלה");
        set(TABLE_RATIO, "יחס טבלה למסך טקסט");
        
        set(COLOR_WHITE, "לבן");
        set(COLOR_BLACK, "שחור");
        set(COLOR_RED, "אדום");
        set(COLOR_ORANGE, "כתום");
        set(COLOR_YELLOW, "צהוב");
        set(COLOR_GREEN, "ירוק");
        set(COLOR_CYAN, "ציאן");
        set(COLOR_BLUE, "כחול");
        set(COLOR_PURPLE, "סגול");
        set(COLOR_PINK, "ורוד");
        
        set(KEEP_ALIVE, "שמור שמע פעיל (מפחית השהיה)");
        set(WHITE_NOISE, "חזק יותר (נגן רעש לבן)");
        set(AUDIO_BUFFER, "באפר שמע (חומרה)");
        set(PROCESSING_CHUNK, "מקטע עיבוד");
        set(PERFORMANCE_HINT, "אם הצליל נחתך, הגדל את הבאפר או את המקטע. אם ההשהיה גבוהה, הקטן אותם.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "קלטים נתמכים: מקלדת, מסך מגע, עכבר או משוט עם מתאם USB.\n\n" +
                "עבור הפעלה בלחיצה שמאלית/ימנית של העכבר או מתאם משוט USB-לעכבר, השאר את סמן העכבר מעל כפתור המשוט השמאלי במסך, ולחיצה שמאלית/ימנית תמופה למשוטים הנכונים.\n\n" +
                "עבור מתאם משוט USB-למקלדת, זה עובד ללא צורך בהגדרה (למשל נבדק עם VBand) - עדכן אותי אם לא.\n\n" +
                "מצב קפדני דורש את התזמון הנכון בין אותיות, מצב לא קפדני מאפשר מניפולציה מהירה יותר.\n\n" +
                "בעיות נפוצות: אם הצליל קליקי מדי במכשיר שלך, נסה את האפשרות של אות שן מסור או נסה לשנות את המעטפת. אם ההשהיה גבוהה מדי, נסה להקטין את הבאפר. אם הצליל נשבר, נסה להגדיל אותו.\n\n" +
                "מקשי מקלדת:\n" +
                "  שמאל: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  ימין: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "מפתח");
        
        set(SYSTEM_SETTING, "הגדרת מערכת");
        set(DARK_THEME, "ערכת נושא כהה");
        set(LIGHT_THEME, "ערכת נושא בהירה");
        
        set(MODE_STRAIGHT, "ישיר (Straight)");
        set(MODE_IAMBIC_A, "יאמבי A");
        set(MODE_IAMBIC_B, "יאמבי B");
        set(MODE_ULTIMATIC, "אולטימטיבי (Ultimatic)");
        set(MODE_BUG, "באג");
        set(MODE_COOTIE, "קוטי (Cootie)");
        
        set(CAT_LETTERS, "אותיות");
        set(CAT_NUMBERS, "מספרים");
        set(CAT_SYMBOLS, "סמלים");
        set(CAT_SPECIAL_SYMBOLS, "סמלים מיוחדים");
        set(CAT_SPECIAL, "אותיות מיוחדות");
        set(CAT_PROSIGNS_COMMON, "אותות נוהל נפוצים");
        set(CAT_ABBREVIATIONS, "קיצורים נפוצים");
        set(CAT_QCODES, "קודי Q");
        set(CAT_PROSIGNS_OTHER, "אותות נוהל אחרים");
        set(SUPPORT_WINDLEREYE, "תמכו בי על ידי האזנה לפרויקט המוזיקלי שלי Windlereye");
        set(CANCEL, "ביטול");
        set(QUIT, "יציאה");
        set(QUIT_GAME_PROMPT, "האם אתה בטוח שברצונך לצאת מהמשחק הזה?");
        set(WORDS, "מילים");
                set(QUIT_GAME, "צא מהמשחק");
        set(MATCH_SETTINGS, "פרמטרים של משחק");
        set(SHARE_PREVIEW, "שתף תצוגה מקדימה");
        set(GAMES, "משחקים");
        set(SHARE, "לַחֲלוֹק");
        set(SHARE_SUBJECT, "משתף את ציון מורס קייר שלי");
        set(SHARE_PROMO_TEXT, "שחקו את Morse Training בחינם בכתובת https://morsetraining.com");
        set(THEME, "נוֹשֵׂא");

        set(MATCH_RESULTS, "תוצאות התאמה");
        set(TIME, "זְמַן");
        set(TRY_AGAIN, "נסה שוב");
        set(SCORE, "צִיוּן");
        set(MATCH_COMPLETED, "התאמה הושלמה");
        set(HIGH_SCORE, "ציון גבוה");

                

        set(REPEAT, "חזור");

        set(START, "התחל");
        set(PICK_LANG_THEME_ON_SHARE, "בחר שפה ונושא בעת שיתוף ציונים");
        set(CONTINUE, "לְהַמשִׁיך");
        set(RX, "לקבל");
        set(TX, "לשדר");

        set(KOCH_METHOD, "שיטת קוך");
        set(TARGET, "יעד");
set(TARGET_MET, "היעד הושג");
        set(TARGET_NOT_MET, "היעד לא הושג");
            set(LEVEL, "שלב");
    
        set(LEARN, "למד");
        set(PLAY, "שחק");
    
        set(LEVELS_COMPLETED, "שלבים שהושלמו");
        set(RESET_PROGRESS, "אפס התקדמות");
        set(RESET_PROGRESS_CONFIRM, "האם אתה בטוח שברצונך לאפס התקדמות?");
        set(RESET, "אפס");
            set(WPM, "WPM​");
        set(SPACING, "ריווח");
        set(BACK, "חזור");
        set(NEXT_LEVEL, "השלב הבא");
    }
}