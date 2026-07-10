package com.qft8.morsekeyer.lang;

public class LangTa extends MorseLanguage {
    public LangTa() {
        set(SAVE, "சேமி");
        set(RESET_DEFAULTS, "இயல்புநிலைக்கு மீட்டமை");
        set(CLOSE, "மூடு");
        
        set(SETTINGS_TITLE, "அமைப்புகள்");
        set(TONE, "ஒலி");
        set(USER_INTERFACE, "பயனர் இடைமுகம்");
        set(ADVANCED, "மேம்பட்ட (செயல்திறன்)");
        set(DECODER_BEHAVIOR, "டிகோடர் நடத்தை");

        set(KEY_MODE, "கீ முறை");
        set(WPM_SPEED, "வேகம் (WPM)");
        set(INVERSE_PADDLES, "பேடில்களை மாற்று");
        set(STRICT_TIMING, "துல்லியமான நேரம்");
        
        set(FREQUENCY, "அதிர்வெண்");
        set(VOLUME, "ஒலி அளவு");
        set(ENVELOPE, "எழுச்சி/வீழ்ச்சி நேரம் (Envelope)");
        set(NOCLICK, "கிளிக் ஒலிகளைத் தவிர்க்க சாடூத் சிக்னலைப் பயன்படுத்துங்கள்");
        
        set(LANGUAGE, "மொழி");
        set(KEYBOARD_TYPE, "விசைப்பலகை வகை");
        set(SHOW_TABLE, "மோர்ஸ் அட்டவணையைக் காண்பி");
        set(SHOW_TABLE_CODES, " மோர்ஸ் அட்டவணையில் புள்ளிகள் மற்றும் கோடுகளைக் காண்பி");
        set(SHOW_VISUAL, "காட்சி குறிகாட்டியைக் காண்பி");
        set(SHOW_PADDLES, "திரை பேடில்களைக் காண்பி");
        set(NEXT_WORD_INDICATOR, "அடுத்த சொல் குறிகாட்டி");
        set(KEEP_SCREEN_ON, "திரையை ஆன் செய்து வை");
        set(APP_THEME, "ஆப் தீம்");
        set(TEXT_COLOR, "உரை நிறம்");
        set(TEXT_FONT_SIZE, "உரை எழுத்துரு அளவு");
        set(TABLE_FONT_SIZE, "அட்டவணை எழுத்துரு அளவு");
        set(TABLE_RATIO, "அட்டவணை/திரை விகிதம்");
        
        set(KEEP_ALIVE, "ஆடியோவைச் செயல்பாட்டில் வை (தாமதத்தைக் குறைக்கும்)");
        set(WHITE_NOISE, "வலுவானது (வெள்ளை இரைச்சலை இசைக்க)");
        set(AUDIO_BUFFER, "ஆடியோ பஃபர் (வன்பொருள்)");
        set(PROCESSING_CHUNK, "செயலாக்கப் பகுதி");
        set(PERFORMANCE_HINT, "ஒலி தடைபட்டால், பஃபரை அதிகரிக்கவும். தாமதம் அதிகமாக இருந்தால், அதைக் குறைக்கவும்.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "ஆதரிக்கப்படும் உள்ளீடுகள்: விசைப்பலகை, தொடுதிரை, மவுஸ் அல்லது USB பேடில் அடாப்டர்.\n\nமவுஸ் இடது/வலது கிளிக் கீயிங் அல்லது யூ.எஸ்.பி-டு-மவுஸ் பேடில் அடாப்டருக்கு, திரையில் உள்ள இடது பேடில் பட்டனின் மேல் மவுஸ் பாயிண்டரை விடுங்கள், இடது/வலது கிளிக் சரியான பேடில்களுக்கு வரைபடமாக்கப்படும்.\n\nUSB-டு-விசைப்பலகை பேடில் அடாப்டர்களுக்கு (உதாரணமாக VBand) இது நேரடியாக வேலை செய்யும்.\n\nகடுமையான நேரத்திற்கு துல்லியமான எழுத்து இடைவெளிகள் தேவை; கடுமையானதல்லாதது விரைவான கீயிங்கை அனுமதிக்கிறது.\n\nசிக்கல் தீர்க்கும் முறை: ஒலி கிளிக்காக இருந்தால், சாடூத்-ஐ முயற்சிக்கவும் அல்லது உறை மாற்றவும். தாமதம் அதிகமாக இருந்தால், இடையகத்தைக் குறைக்கவும். ஒலி திக்கினால், அதை அதிகரிக்கவும்.\n\nவிசைப்பலகை விசைகள்:\n  இடது: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  வலது: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "விசை");
        
        set(SYSTEM_SETTING, "கணினி அமைப்பு");
        set(DARK_THEME, "டார்க் தீம்");
        set(LIGHT_THEME, "லைட் தீம்");
        
        set(MODE_STRAIGHT, "நேரடி விசை (Straight key)");
        set(MODE_IAMBIC_A, "Iambic A");
        set(MODE_IAMBIC_B, "Iambic B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "பக் (அரை தானியங்கி)");
        set(MODE_COOTIE, "கூட்டி (Sideswiper)");
        
        set(CAT_LETTERS, "எழுத்துக்கள்");
        set(CAT_NUMBERS, "எண்கள்");
        set(CAT_SYMBOLS, "குறியீடுகள்");
        set(CAT_SPECIAL_SYMBOLS, "சிறப்பு குறியீடுகள்");
        set(CAT_SPECIAL, "சிறப்பு எழுத்துக்கள்");
        set(CAT_PROSIGNS_COMMON, "பொதுவான நடைமுறை சமிக்ஞைகள்");
        set(CAT_ABBREVIATIONS, "பொதுவான சுருக்கங்கள்");
        set(CAT_QCODES, "Q குறியீடுகள்");
        set(CAT_PROSIGNS_OTHER, "இதர நடைமுறை சமிக்ஞைகள்");

        set(COLOR_WHITE, "வெள்ளை");
        set(COLOR_BLACK, "கருப்பு");
        set(COLOR_RED, "சிவப்பு");
        set(COLOR_ORANGE, "ஆரஞ்சு");
        set(COLOR_YELLOW, "மஞ்சள்");
        set(COLOR_GREEN, "பச்சை");
        set(COLOR_CYAN, "சியான்");
        set(COLOR_BLUE, "நீலம்");
        set(COLOR_PURPLE, "ஊதா");
        set(COLOR_PINK, "இளஞ்சிவப்பு");
        set(SUPPORT_WINDLEREYE, "எனது இசை திட்டமான Windlereye ஐக் கேட்டு என்னை ஆதரிக்கவும்");
        set(CANCEL, "ரத்துசெய்");
        set(QUIT, "வெளியேறு");
        set(QUIT_GAME_PROMPT, "நிச்சயமாக இந்த விளையாட்டிலிருந்து வெளியேற விரும்புகிறீர்களா?");

        set(SCORE, "மதிப்பெண்");
        set(HIGH_SCORE, "அதிக மதிப்பெண்");
        set(YOUR_HIGH_SCORE_IS, "உங்களின் அதிகபட்ச மதிப்பெண்");
        set(TIME, "நேரம்");
                set(MATCH_COMPLETED, "ஆட்டம் முடிந்தது");
        set(TRY_AGAIN, "மீண்டும் முயற்சி செய்");
        set(WORDS, "வார்த்தைகள்");
                set(QUIT_GAME, "விளையாட்டிலிருந்து வெளியேறு");
        set(MATCH_SETTINGS, "விளையாட்டு அளவுருக்கள்");
        set(SHARE_PREVIEW, "முன்னோட்டத்தைப் பகிரவும்");
        set(SHARE, "பகிரவும்");
        set(SHARE_SUBJECT, "எனது மோர்ஸ் கீயர் ஸ்கோரைப் பகிர்கிறேன்");
        set(SHARE_PROMO_TEXT, "https://morsetraining.com இல் மோர்ஸ் கீயரை இலவசமாக இயக்கவும்");
        set(THEME, "தீம்");

        set(MATCH_RESULTS, "போட்டி முடிவுகள்");
                

        set(REPEAT, "மீண்டும் சொல்");

        set(START, "தொடங்கு");
        set(PICK_LANG_THEME_ON_SHARE, "மதிப்பெண்களைப் பகிரும்போது மொழி மற்றும் தீமைத் தேர்ந்தெடுக்கவும்");
        set(GAMES, "விளையாட்டுகள்");
        set(CONTINUE, "தொடரவும்");
        set(RX, "பெற");
        set(TX, "அனுப்ப");

        set(KOCH_METHOD, "கோச் முறை");
        set(TARGET, "இலக்கு");
set(TARGET_MET, "இலக்கு எட்டப்பட்டது");
        set(TARGET_NOT_MET, "இலக்கு எட்டப்படவில்லை");
            set(LEVEL, "நிலை");
    
        set(LEARN, "கற்றுக்கொள்");
        set(PLAY, "விளையாடு");
    
        set(LEVELS_COMPLETED, "முடிக்கப்பட்ட நிலைகள்");
        set(RESET_PROGRESS, "முன்னேற்றத்தை மீட்டமை");
        set(RESET_PROGRESS_CONFIRM, "முன்னேற்றத்தை மீட்டமைக்க உறுதியாக உள்ளீர்களா?");
        set(RESET, "மீட்டமை");
            set(WPM, "WPM​");
        set(BACK, "பின்செல்");
        set(NEXT_LEVEL, "அடுத்த நிலை");

                set(EFFECTIVE_WPM_FARNSWORTH, "செயல்திறன் மிக்க WPM (Farnsworth)");
                set(EXTRA_WORD_SPACING, "வார்த்தை இடைவெளி");
                set(EFFECTIVE_WPM_SHORT, "செயல்திறன்");

                set(WORD_SPACING_ADD, "வார்த்தை +");
    }
}