package com.qft8.morsekeyer.lang;

public class LangUk extends MorseLanguage {
    public LangUk() {
        set(SAVE, "Зберегти");
        set(RESET_DEFAULTS, "Скинути налаштування");
        set(CLOSE, "Закрити");
        
        set(SETTINGS_TITLE, "Налаштування");
        set(TONE, "Тон");
        set(USER_INTERFACE, "Інтерфейс");
        set(ADVANCED, "Додатково");
        set(DECODER_BEHAVIOR, "Поведінка декодера");

        set(KEY_MODE, "Режим ключа");
        set(WPM_SPEED, "Швидкість (WPM)");
        set(INVERSE_PADDLES, "Інверсія важелів");
        set(STRICT_TIMING, "Суворі інтервали");
        set(INTERLETTER_SPACING, "Міжлітерний інтервал");
        set(INTERWORD_SPACING, "Міжслівний інтервал");
        
        set(FREQUENCY, "Частота");
        set(VOLUME, "Гучність");
        set(ENVELOPE, "Час наростання/спаду (обвідна)");
        set(NOCLICK, "Пилоподібний сигнал (без кліків)");
        
        set(LANGUAGE, "Мова");
        set(KEYBOARD_TYPE, "Тип клавіатури");
        set(SHOW_TABLE, "Показати таблицю Морзе");
        set(SHOW_TABLE_CODES, "Показати точки та тире в таблиці Морзе");
        set(SHOW_VISUAL, "Показати візуальний індикатор");
        set(SHOW_PADDLES, "Показати важелі на екрані");
        set(NEXT_WORD_INDICATOR, "Індикатор наступного слова");
        set(KEEP_SCREEN_ON, "Не вимикати екран");
        set(APP_THEME, "Тема додатка");
        set(TEXT_COLOR, "Колір тексту");
        set(TEXT_FONT_SIZE, "Розмір шрифту тексту");
        set(TABLE_FONT_SIZE, "Розмір шрифту таблиці");
        set(TABLE_RATIO, "Пропорція таблиця/текст");
        
        set(KEEP_ALIVE, "Постійний звук (знижує затримку)");
        set(AUDIO_BUFFER, "Аудіо-буфер (апаратний)");
        set(PROCESSING_CHUNK, "Фрагмент обробки");
        set(PERFORMANCE_HINT, "Якщо звук переривається, збільште буфер. Якщо затримка велика, зменште.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Підтримуване введення: клавіатура, сенсорний екран, миша або ключ через USB.\n\n" +
                "Для введення клацанням лівої/правої кнопки миші або адаптера маніпулятора USB-миша залиште вказівник миші над кнопкою лівого маніпулятора на екрані, клацання лівої/правої кнопки миші буде зіставлено з правильними маніпуляторами.\n\n" +
                "USB-адаптери клавіатури (наприклад, VBand) працюють відразу без налаштування.\n\n" +
                "Суворий режим вимагає точних інтервалів; несуворий дозволяє передавати швидше.\n\n" +
                "Проблеми: Якщо звук занадто різкий, спробуйте 'Пилоподібний сигнал'. Якщо затримка велика, зменште буфер. Якщо звук заїкається, збільште його.\n\n" +
                "Клавіші:\n" +
                "  Вліво: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Вправо: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Ключ");
        
        set(SYSTEM_SETTING, "Системне налаштування");
        set(DARK_THEME, "Темна тема");
        set(LIGHT_THEME, "Світла тема");
        
        set(MODE_STRAIGHT, "Вертикальний");
        set(MODE_IAMBIC_A, "Ямбічний A");
        set(MODE_IAMBIC_B, "Ямбічний B");
        set(MODE_ULTIMATIC, "Ультиматик");
        set(MODE_BUG, "Віброплекс (Bug)");
        set(MODE_COOTIE, "Куті (Sideswiper)");
        
        set(CAT_LETTERS, "БУКВИ");
        set(CAT_NUMBERS, "ЦИФРИ");
        set(CAT_SYMBOLS, "СИМВОЛИ");
        set(CAT_SPECIAL_SYMBOLS, "СПЕЦСИМВОЛИ");
        set(CAT_SPECIAL, "СПЕЦБУКВИ");
        set(CAT_PROSIGNS_COMMON, "ЗАГАЛЬНІ СЛУЖБОВІ ЗНАКИ");
        set(CAT_ABBREVIATIONS, "ЗАГАЛЬНІ СКОРОЧЕННЯ");
        set(CAT_QCODES, "Q-КОДИ");
        set(CAT_PROSIGNS_OTHER, "Інші сигнали");

        set(COLOR_WHITE, "Білий");
        set(COLOR_BLACK, "Чорний");
        set(COLOR_RED, "Червоний");
        set(COLOR_ORANGE, "Помаранчевий");
        set(COLOR_YELLOW, "Жовтий");
        set(COLOR_GREEN, "Зелений");
        set(COLOR_CYAN, "Ціан");
        set(COLOR_BLUE, "Синій");
        set(COLOR_PURPLE, "Пурпуровий");
        set(COLOR_PINK, "Рожевий");
        set(SUPPORT_WINDLEREYE, "Підтримайте мене, послухавши мій музичний проект Windlereye");
        set(CANCEL, "Скасувати");
        set(QUIT, "Вийти");
        set(QUIT_GAME_PROMPT, "Ви впевнені, що хочете вийти з цієї гри?");

        set(SCORE, "Рахунок");
        set(HIGH_SCORE, "Високий бал");
        set(YOUR_HIGH_SCORE_IS, "Ваш рекорд");
        set(TIME, "Час");
                set(MATCH_COMPLETED, "Матч завершено");
        set(TRY_AGAIN, "Спробувати ще раз");
        set(WORDS, "Слова");
                set(QUIT_GAME, "Вийти з гри");
        set(MATCH_SETTINGS, "Параметри гри");
        set(SHARE_PREVIEW, "Поділитися попереднім переглядом");
        set(SHARE, "Поділіться");
        set(SHARE_SUBJECT, "Ділюся моїм балом Морзе-Кейєр");
        set(SHARE_PROMO_TEXT, "Грайте в Morse Training безкоштовно на сайті https://morsetraining.com");
        set(THEME, "Тема");

        set(MATCH_RESULTS, "Результати матчів");
                

        set(REPEAT, "ПОВТОРИТИ");

        set(START, "ПОЧАТИ");
        set(PICK_LANG_THEME_ON_SHARE, "Вибирати мову та тему під час публікації результатів");
        set(GAMES, "Ігри");
        set(CONTINUE, "ПРОДОВЖУЙТЕ");
        set(RX, "Отримувати");
        set(TX, "Передавати");

        set(KOCH_METHOD, "Метод Коха");
        set(TARGET, "Ціль");
set(TARGET_MET, "Ціль досягнута");
        set(TARGET_NOT_MET, "Ціль не досягнута");
            set(LEVEL, "Рівень");
    
        set(LEARN, "Вчити");
        set(PLAY, "Грати");
    
        set(LEVELS_COMPLETED, "Завершені рівні");
        set(RESET_PROGRESS, "Скинути прогрес");
        set(RESET_PROGRESS_CONFIRM, "Ви впевнені, що хочете скинути прогрес?");
        set(RESET, "Скинути");
            set(WPM, "WPM​");
        set(SPACING, "Інтервал");
        set(BACK, "Назад");
        set(NEXT_LEVEL, "Наступний рівень");
    }
}