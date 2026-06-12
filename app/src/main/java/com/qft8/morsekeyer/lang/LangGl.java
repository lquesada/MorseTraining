package com.qft8.morsekeyer.lang;

public class LangGl extends MorseLanguage {
    public LangGl() {
        set(SAVE, "Gardar");
        set(RESET_DEFAULTS, "Restaurar valores por defecto");
        set(CLOSE, "Pechar");
        
        set(SETTINGS_TITLE, "Axustes");
        set(TONE, "Ton");
        set(USER_INTERFACE, "Interface de usuario");
        set(ADVANCED, "Avanzado (rendemento)");
        set(DECODER_BEHAVIOR, "Comportamento do decodificador");

        set(KEY_MODE, "Modo do manipulador");
        set(WPM_SPEED, "Velocidade (WPM)");
        set(INVERSE_PADDLES, "Inverter palas");
        set(STRICT_TIMING, "Temporización estrita");
        set(INTERLETTER_SPACING, "Espazamento entre letras");
        set(INTERWORD_SPACING, "Espazamento entre palabras");
        
        set(FREQUENCY, "Frecuencia");
        set(VOLUME, "Volume");
        set(ENVELOPE, "Tempo de subida/baixada (envolvente)");
        set(NOCLICK, "Sinal dente de serra para evitar clics");
        
        set(LANGUAGE, "Idioma");
        set(KEYBOARD_TYPE, "Tipo de teclado");
        set(SHOW_TABLE, "Mostrar táboa Morse");
        set(SHOW_TABLE_CODES, "Mostrar puntos e raias na táboa Morse");
        set(SHOW_VISUAL, "Mostrar indicador visual");
        set(SHOW_PADDLES, "Mostrar palas na pantalla");
        set(NEXT_WORD_INDICATOR, "Indicador de seguinte palabra");
        set(KEEP_SCREEN_ON, "Manter pantalla acendida");
        set(APP_THEME, "Tema da app");
        set(TEXT_COLOR, "Cor do texto");
        set(TEXT_FONT_SIZE, "Tamaño da fonte do text");
        set(TABLE_FONT_SIZE, "Tamaño da fonte da táboa");
        set(TABLE_RATIO, "Proporción táboa/pantalla");
        
        set(KEEP_ALIVE, "Manter audio activo (reduce a latencia)");
        set(AUDIO_BUFFER, "Búfer de audio (hardware)");
        set(PROCESSING_CHUNK, "Fragmento de procesamento");
        set(PERFORMANCE_HINT, "Se o son se corta, aumenta o búfer. Se a latencia é alta, redúceo.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Entradas soportadas: teclado, pantalla táctil, rato ou adaptador de pas USB.\n\nPara manipular co clic esquerdo/dereito do rato ou cun adaptador de pas USB a rato, deixe o punteiro do rato sobre o botón da pa esquerda na pantalla; o clic esquerdo/dereito asignarase ás pas correctas.\n\nPara os adaptadores de pas de USB a teclado (por exemplo, VBand) funciona directamente sen configuración.\n\nA temporización estrita require pausas precisas entre letras; a non estrita permite unha manipulación máis rápida.\n\nSolución de problemas: Se o son ten clics, probe Dente de serra o cambie a envolvente. Se a latencia é alta, reduza o búfer. Se o son se entrecorta, auménteo.\n\nTeclas do teclado:\n  Esquerda: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n  Dereita: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Chave");
        
        set(SYSTEM_SETTING, "Axuste do sistema");
        set(DARK_THEME, "Tema escuro");
        set(LIGHT_THEME, "Tema claro");
        
        set(MODE_STRAIGHT, "Chave vertical");
        set(MODE_IAMBIC_A, "Iámbico A");
        set(MODE_IAMBIC_B, "Iámbico B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Semiautomático)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "LETRAS");
        set(CAT_NUMBERS, "NÚMEROS");
        set(CAT_SYMBOLS, "SÍMBOLOS");
        set(CAT_SPECIAL_SYMBOLS, "SÍMBOLOS ESPECIAIS");
        set(CAT_SPECIAL, "LETRAS ESPECIAIS");
        set(CAT_PROSIGNS_COMMON, "SINAIS DE PROCEDEMENTO COMÚNS");
        set(CAT_ABBREVIATIONS, "ABREVIATURAS COMÚNS");
        set(CAT_QCODES, "CÓDIGOS Q");
        set(CAT_PROSIGNS_OTHER, "OUTROS SINAIS DE PROCEDEMENTO");

        set(COLOR_WHITE, "Branco");
        set(COLOR_BLACK, "Negro");
        set(COLOR_RED, "Vermello");
        set(COLOR_ORANGE, "Laranxa");
        set(COLOR_YELLOW, "Amarelo");
        set(COLOR_GREEN, "Verde");
        set(COLOR_CYAN, "Ciano");
        set(COLOR_BLUE, "Azul");
        set(COLOR_PURPLE, "Púrpura");
        set(COLOR_PINK, "Rosa");
        set(SUPPORT_WINDLEREYE, "Apóiame escoitando o meu proxecto musical Windlereye");
        set(CANCEL, "Cancelar");
        set(QUIT, "Saír");
        set(QUIT_GAME_PROMPT, "Estás seguro de que queres saír deste xogo?");

        set(SCORE, "Puntuación: ");
        set(HIGH_SCORE, "Puntuación alta");
        set(YOUR_HIGH_SCORE_IS, "A túa puntuación máis alta é:");
        set(TIME, "Tempo: ");
                set(MATCH_COMPLETED, "Partida completada");
        set(TRY_AGAIN, "Tentar de novo");
        set(WORDS, "Palabras");
                set(QUIT_GAME, "Saír do xogo");
        set(MATCH_SETTINGS, "Parámetros do xogo");
        set(SHARE_PREVIEW, "Compartir vista previa");
        set(SHARE, "Compartir");
        set(SHARE_SUBJECT, "Comparto a miña partitura de Morse Training");
        set(SHARE_PROMO_TEXT, "Xoga a Morse Training de balde en https://morsetraining.com");
        set(THEME, "Tema");

        set(MATCH_RESULTS, "Resultados do partido");
                

        set(REPEAT, "REPETIR");

        set(START, "COMEZAR");
        set(PICK_LANG_THEME_ON_SHARE, "Escoller idioma e tema ao compartir puntuacións");
        set(GAMES, "Xogos");
        set(CONTINUE, "CONTINUAR");
        set(RX, "Recibir");
        set(TX, "Transmitir");

        set(KOCH_METHOD, "Método Koch");
        set(TARGET, "Obxectivo");
        set(LISTEN, "Escoitar");
        set(TARGET_MET, "Obxectivo acadado");
        set(TARGET_NOT_MET, "Obxectivo non acadado");
            set(LEVEL, "Nivel");
    
        set(LEARN, "Aprender");
        set(PLAY, "Xogar");
    
        set(LEVELS_COMPLETED, "Niveis completados");
        set(RESET_PROGRESS, "Restablecer progreso");
        set(RESET_PROGRESS_CONFIRM, "Estás seguro de que queres restablecer o progreso?");
        set(RESET, "Restablecer");
            set(WPM, "WPM​");
        set(SPACING, "Espazamento");
    }
}