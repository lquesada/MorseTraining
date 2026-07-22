package com.qft8.morsekeyer.lang;

public class LangKo extends MorseLanguage {
    public LangKo() {
        set(SAVE, "저장");
        set(RESET_DEFAULTS, "기본값으로 재설정");
        set(CLOSE, "닫기");
        
        set(SETTINGS_TITLE, "설정");
        set(TONE, "톤");
        set(USER_INTERFACE, "사용자 인터페이스");
        set(ADVANCED, "고급 (성능)");
        set(DECODER_BEHAVIOR, "디코더 동작");

        set(KEY_MODE, "키 모드");
        set(WPM_SPEED, "속도 (WPM)");
        set(INVERSE_PADDLES, "패들 반전");
        set(STRICT_TIMING, "엄격한 타이밍");
        
        set(FREQUENCY, "주파수");
        set(VOLUME, "볼륨");
        set(ENVELOPE, "상승/하강 시간 (Envelope)");
        set(NOCLICK, "클릭 노이즈 방지를 위한 톱니파 신호 사용");
        
        set(LANGUAGE, "언어");
        set(KEYBOARD_TYPE, "키보드 유형");
        set(SHOW_TABLE, "모스 부호표 표시");
        set(SHOW_TABLE_CODES, "모스 부호표에 점과 선 표시");
        set(SHOW_VISUAL, "시각적 표시기 표시");
        set(SHOW_PADDLES, "화면 패들 표시");
        set(NEXT_WORD_INDICATOR, "다음 단어 표시기");
        set(KEEP_SCREEN_ON, "화면 켜짐 유지");
        set(APP_THEME, "앱 테마");
        set(TEXT_COLOR, "텍스트 색상");
        set(TEXT_FONT_SIZE, "텍스트 글꼴 크기");
        set(TABLE_FONT_SIZE, "표 글꼴 크기");
        set(TABLE_RATIO, "표/화면 비율");
        
        set(KEEP_ALIVE, "오디오 활성 유지 (지연 시간 감소)");
        set(WHITE_NOISE, "더 강하게 (백색 소음 재생)");
        set(AUDIO_BUFFER, "오디오 버퍼 (하드웨어)");
        set(PROCESSING_CHUNK, "처리 청크");
        set(PERFORMANCE_HINT, "소리가 끊기면 버퍼를 늘리세요. 지연이 심하면 줄이세요.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "지원되는 입력: 키보드, 터치스크린, 마우스 또는 USB 어댑터가 있는 전건.\n\n" +
                "마우스 왼쪽/오른쪽 클릭 키잉 또는 USB-마우스 패들 어댑터의 경우 마우스 포인터를 화면의 왼쪽 패들 버튼 위에 두면 왼쪽/오른쪽 클릭이 올바른 패들에 매핑됩니다.\n\n" +
                "USB 키보드 어댑터(예: VBand)의 경우 설정 없이 바로 작동합니다.\n\n" +
                "엄격 모드는 글자 간의 정확한 타이밍이 필요하며, 일반 모드는 더 빠른 키잉이 가능합니다.\n\n" +
                "일반적인 문제: 소리에 클릭음이 너무 많으면 '톱니파' 옵션을 시도하거나 엔벨로프를 변경하세요. 지연이 심하면 버퍼를 줄이세요.\n\n" +
                "키보드 키:\n" +
                "  왼쪽: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  오른쪽: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "키");
        
        set(SYSTEM_SETTING, "시스템 설정");
        set(DARK_THEME, "다크 테마");
        set(LIGHT_THEME, "라이트 테마");
        
        set(MODE_STRAIGHT, "수직 키");
        set(MODE_IAMBIC_A, "아이앰빅 A");
        set(MODE_IAMBIC_B, "아이앰빅 B");
        set(MODE_ULTIMATIC, "얼티매틱");
        set(MODE_BUG, "버그 (반자동)");
        set(MODE_COOTIE, "쿠티 (Sideswiper)");
        
        set(CAT_LETTERS, "글자");
        set(CAT_NUMBERS, "숫자");
        set(CAT_SYMBOLS, "기호");
        set(CAT_SPECIAL_SYMBOLS, "특수 기호");
        set(CAT_SPECIAL, "특수 글자");
        set(CAT_PROSIGNS_COMMON, "일반 절차 부호");
        set(CAT_ABBREVIATIONS, "일반 약어");
        set(CAT_QCODES, "Q 부호");
        set(CAT_PROSIGNS_OTHER, "기타 절차 부호");

        set(COLOR_WHITE, "흰색");
        set(COLOR_BLACK, "검은색");
        set(COLOR_RED, "빨간색");
        set(COLOR_ORANGE, "주황색");
        set(COLOR_YELLOW, "노란색");
        set(COLOR_GREEN, "초록색");
        set(COLOR_CYAN, "청록색");
        set(COLOR_BLUE, "파란색");
        set(COLOR_PURPLE, "보라색");
        set(COLOR_PINK, "분홍색");
        set(SUPPORT_WINDLEREYE, "내 음악 프로젝트 Windlereye를 들어서 나를 지원해주세요");
        set(CANCEL, "취소");
        set(QUIT, "종료");
        set(QUIT_GAME_PROMPT, "이 게임을 종료하시겠습니까?");

        set(SCORE, "점수");
        set(HIGH_SCORE, "높은 점수");
        set(YOUR_HIGH_SCORE_IS, "당신의 최고 점수는");
        set(TIME, "시간");
                set(MATCH_COMPLETED, "매치 완료");
        set(TRY_AGAIN, "다시 시도");
        set(WORDS, "단어");
                set(QUIT_GAME, "종료");
        set(MATCH_SETTINGS, "게임 매개변수");
        set(SHARE_PREVIEW, "미리보기");
        set(GAMES, "게임");
        set(SHARE, "공유");
        set(SHARE_SUBJECT, "내 점수 공유");
        set(SHARE_PROMO_TEXT, "https://morsetraining.com 에서 플레이");
        set(THEME, "테마");

        set(MATCH_RESULTS, "결과");
                

        set(REPEAT, "반복");
        set(HINT, "힌트");

        set(START, "시작");
        set(PICK_LANG_THEME_ON_SHARE, "점수 공유 시 언어 및 테마 선택");
        set(CONTINUE, "계속하다");
        set(RX, "수신하다");
        set(TX, "송신하다");

        set(KOCH_METHOD, "코흐 방법");
        set(TARGET, "목표");
set(TARGET_MET, "목표 달성");
        set(TARGET_NOT_MET, "목표 미달성");
            set(LEVEL, "레벨");
    
        set(LEARN, "학습");
        set(PLAY, "플레이");
    
        set(LEVELS_COMPLETED, "완료된 레벨");
        set(RESET_PROGRESS, "진행 상황 초기화");
        set(RESET_PROGRESS_CONFIRM, "진행 상황을 초기화하시겠습니까?");
        set(RESET, "초기화");
            set(WPM, "WPM​");
        set(BACK, "뒤로");
        set(NEXT_LEVEL, "다음 레벨");

                set(EFFECTIVE_WPM_FARNSWORTH, "유효 WPM (Farnsworth)");
                set(EXTRA_WORD_SPACING, "간격");
                set(EFFECTIVE_WPM_SHORT, "유효");

                set(WORD_SPACING_ADD, "단어 +");
    }
}
