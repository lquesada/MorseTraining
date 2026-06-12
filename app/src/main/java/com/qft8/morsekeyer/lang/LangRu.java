package com.qft8.morsekeyer.lang;

public class LangRu extends MorseLanguage {
    public LangRu() {
        set(SAVE, "Сохранить");
        set(RESET_DEFAULTS, "Сбросить настройки");
        set(CLOSE, "Закрыть");
        
        set(SETTINGS_TITLE, "Настройки");
        set(TONE, "Тон");
        set(USER_INTERFACE, "Интерфейс");
        set(ADVANCED, "Дополнительно");
        set(DECODER_BEHAVIOR, "Поведение декодера");

        set(KEY_MODE, "Режим ключа");
        set(WPM_SPEED, "Скорость (WPM)");
        set(INVERSE_PADDLES, "Инверсия рычагов");
        set(STRICT_TIMING, "Строгие интервалы");
        set(INTERLETTER_SPACING, "Межбуквенный интервал");
        set(INTERWORD_SPACING, "Межсловный интервал");
        
        set(FREQUENCY, "Частота");
        set(VOLUME, "Громкость");
        set(ENVELOPE, "Время нарастания/спада (огибающая)");
        set(NOCLICK, "Пилообразный сигнал (без кликов)");
        
        set(LANGUAGE, "Язык");
        set(KEYBOARD_TYPE, "Тип клавиатуры");
        set(SHOW_TABLE, "Показать таблицу Морзе");
        set(SHOW_TABLE_CODES, "Показать точки и тире в таблице Морзе");
        set(SHOW_VISUAL, "Показать визуальный индикатор");
        set(SHOW_PADDLES, "Показать рычаги на экране");
        set(NEXT_WORD_INDICATOR, "Индикатор следующего слова");
        set(KEEP_SCREEN_ON, "Не выключать экран");
        set(APP_THEME, "Тема приложения");
        set(TEXT_COLOR, "Цвет текста");
        set(TEXT_FONT_SIZE, "Размер шрифта текста");
        set(TABLE_FONT_SIZE, "Размер шрифта таблицы");
        set(TABLE_RATIO, "Пропорция таблица/текст");
        
        set(KEEP_ALIVE, "Постоянный звук (снижает задержку)");
        set(AUDIO_BUFFER, "Аудио-буфер (аппаратный)");
        set(PROCESSING_CHUNK, "Фрагмент обработки");
        set(PERFORMANCE_HINT, "Если звук прерывается, увеличьте буфер. Если задержка велика, уменьшите.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Поддерживаемый ввод: клавиатура, сенсорный экран, мышь или ключ через USB.\n\n" +
                "Для управления щелчком левой/правой кнопки мыши или адаптера манипулятора USB-мышь оставьте указатель мыши над кнопкой левого манипулятора на экране, щелчок левой/правой кнопки мыши будет сопоставлен с правильными манипуляторами.\n\n" +
                "USB-адаптеры клавиатуры (например, VBand) работают сразу без настройки.\n\n" +
                "Строгий режим требует точных интервалов; нестрогий позволяет передавать быстрее.\n\n" +
                "Проблемы: Если звук слишком резкий, включите 'Пилообразный сигнал'. Если задержка велика, уменьшите буфер. Если звук заикается, увеличьте его.\n\n" +
                "Клавиши:\n" +
                "  Лево: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Право: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Ключ");
        
        set(SYSTEM_SETTING, "Системная настройка");
        set(DARK_THEME, "Темная тема");
        set(LIGHT_THEME, "Светлая тема");
        
        set(MODE_STRAIGHT, "Вертикальный");
        set(MODE_IAMBIC_A, "Ямбический A");
        set(MODE_IAMBIC_B, "Ямбический B");
        set(MODE_ULTIMATIC, "Ультиматик");
        set(MODE_BUG, "Виброплекс (Bug)");
        set(MODE_COOTIE, "Кути (Sideswiper)");
        
        set(CAT_LETTERS, "БУКВЫ");
        set(CAT_NUMBERS, "ЦИФРЫ");
        set(CAT_SYMBOLS, "СИМВОЛЫ");
        set(CAT_SPECIAL_SYMBOLS, "СПЕЦСИМВОЛЫ");
        set(CAT_SPECIAL, "СПЕЦБУКВЫ");
        set(CAT_PROSIGNS_COMMON, "ОБЩИЕ СЛУЖЕБНЫЕ ЗНАКИ");
        set(CAT_ABBREVIATIONS, "ОБЩИЕ СОКРАЩЕНИЯ");
        set(CAT_QCODES, "Q-КОДЫ");
        set(CAT_PROSIGNS_OTHER, "Другие сигналы");

        set(COLOR_WHITE, "Белый");
        set(COLOR_BLACK, "Черный");
        set(COLOR_RED, "Красный");
        set(COLOR_ORANGE, "Оранжевый");
        set(COLOR_YELLOW, "Желтый");
        set(COLOR_GREEN, "Зеленый");
        set(COLOR_CYAN, "Циан");
        set(COLOR_BLUE, "Синий");
        set(COLOR_PURPLE, "Пурпурный");
        set(COLOR_PINK, "Розовый");
        set(SUPPORT_WINDLEREYE, "Поддержите меня, послушав мой музыкальный проект Windlereye");
        set(CANCEL, "Отмена");
        set(QUIT, "Выйти");
        set(QUIT_GAME_PROMPT, "Вы уверены, что хотите выйти из этой игры?");

        set(SCORE, "Счет: ");
        set(HIGH_SCORE, "Высокий балл");
        set(YOUR_HIGH_SCORE_IS, "Ваш рекорд:");
        set(TIME, "Время: ");
                set(MATCH_COMPLETED, "Матч завершен");
        set(TRY_AGAIN, "Попробовать снова");
        set(WORDS, "Слова");
                set(QUIT_GAME, "Выйти");
        set(MATCH_SETTINGS, "Параметры игры");
        set(SHARE_PREVIEW, "Предпросмотр");
        set(GAMES, "Игры");
        set(SHARE, "Поделиться");
        set(SHARE_SUBJECT, "Мой счет в Morse Training");
        set(SHARE_PROMO_TEXT, "Играйте в Morse Training на https://morsetraining.com");
        set(THEME, "Тема");

        set(MATCH_RESULTS, "Результаты");
                

        set(REPEAT, "ПОВТОРИТЬ");

        set(START, "СТАРТ");
        set(PICK_LANG_THEME_ON_SHARE, "Выбирать язык и тему при публикации результатов");
        set(CONTINUE, "ПРОДОЛЖАТЬ");
        set(RX, "Принимать");
        set(TX, "Передавать");

        set(KOCH_METHOD, "Метод Коха");
        set(TARGET, "Цель");
        set(LISTEN, "Слушать");
        set(TARGET_MET, "Цель достигнута");
        set(TARGET_NOT_MET, "Цель не достигнута");
            set(LEVEL, "Уровень");
    
        set(LEARN, "Учить");
        set(PLAY, "Играть");
    
        set(LEVELS_COMPLETED, "Завершенные уровни");
        set(RESET_PROGRESS, "Сбросить прогресс");
        set(RESET_PROGRESS_CONFIRM, "Вы уверены, что хотите сбросить прогресс?");
        set(RESET, "Сбросить");
            set(WPM, "WPM​");
        set(SPACING, "Интервал");
    }
}