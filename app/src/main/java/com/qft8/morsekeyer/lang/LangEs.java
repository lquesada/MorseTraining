package com.qft8.morsekeyer.lang;

public class LangEs extends MorseLanguage {
        public LangEs() {
                set(SAVE, "Guardar");
                set(RESET_DEFAULTS, "Restablecer ajustes");
                set(CLOSE, "Cerrar");

                set(SETTINGS_TITLE, "Ajustes");
                set(TONE, "Tono");
                set(USER_INTERFACE, "Interfaz de usuario");
                set(ADVANCED, "Avanzado (rendimiento)");
                set(DECODER_BEHAVIOR, "Comportamiento del decodificador");

                set(KEY_MODE, "Modo de manipulador");
                set(WPM_SPEED, "Velocidad (WPM)");
                set(INVERSE_PADDLES, "Invertir palas");
                set(STRICT_TIMING, "Temporización estricta");

                set(FREQUENCY, "Frecuencia");
                set(VOLUME, "Volumen");
                set(ENVELOPE, "Tiempo de subida/bajada (envolvente)");
                set(NOCLICK, "Señal de diente de sierra para evitar clics");

                set(LANGUAGE, "Idioma");
        set(KEYBOARD_TYPE, "Tipo de teclado");
                set(SHOW_TABLE, "Mostrar tabla Morse");
                set(SHOW_TABLE_CODES, "Mostrar puntos y rayas en la tabla Morse");
                set(SHOW_VISUAL, "Mostrar indicador visual");
                set(SHOW_PADDLES, "Mostrar palas en pantalla");
                set(NEXT_WORD_INDICATOR, "Indicador de siguiente palabra");
                set(KEEP_SCREEN_ON, "Mantener pantalla encendida");
                set(APP_THEME, "Aspecto de la aplicación");
                set(TEXT_COLOR, "Color del texto");
                set(TEXT_FONT_SIZE, "Tamaño de fuente del texto");
                set(TABLE_FONT_SIZE, "Tamaño de fuente de la tabla");
                set(TABLE_RATIO, "Proporción tabla/pantalla");

                set(COLOR_WHITE, "Blanco");
                set(COLOR_BLACK, "Negro");
                set(COLOR_RED, "Rojo");
                set(COLOR_ORANGE, "Naranja");
                set(COLOR_YELLOW, "Amarillo");
                set(COLOR_GREEN, "Verde");
                set(COLOR_CYAN, "Cian");
                set(COLOR_BLUE, "Azul");
                set(COLOR_PURPLE, "Morado");
                set(COLOR_PINK, "Rosa");

                set(KEEP_ALIVE, "Mantener audio activo (reduce latencia)");
                set(WHITE_NOISE, "Más fuerte (reproducir ruido blanco)");
                set(AUDIO_BUFFER, "Búfer de audio (hardware)");
                set(PROCESSING_CHUNK, "Bloque de procesamiento");
                set(PERFORMANCE_HINT, "Si el sonido se entrecorta, aumente el búfer o el bloque. Si la latencia es alta, redúzcalos.");

                set(INFO_TITLE, "Morse Training");
                set(INFO_TEXT, "Entradas soportadas: teclado, pantalla táctil, ratón o palas con adaptador USB.\n\n" +
                                "Para manipular con el clic izquierdo/derecho del ratón o con un adaptador de palas USB a ratón, deje el puntero del ratón sobre el botón de la pala izquierda en la pantalla; el clic izquierdo/derecho se asignará a las palas correctas.\n\n"
                                +
                                "Para adaptadores de teclado (ej. VBand), funciona directamente sin configuración adicional.\n\n"
                                +
                                "El modo estricto requiere una temporización precisa entre letras; el modo no estricto permite una manipulación más rápida.\n\n"
                                +
                                "Problemas comunes: Si el sonido tiene demasiados clics, pruebe la opción 'Diente de sierra' o modifique la envolvente. Si la latencia es alta, reduzca el búfer. Si el sonido se entrecorta, auméntelo.\n\n"
                                +
                                "Teclas de teclado:\n" +
                                "  Izquierda: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                                "  Derecha: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

                set(KEY, "Llave");

                set(SYSTEM_SETTING, "Ajuste del sistema");
                set(DARK_THEME, "Aspecto oscuro");
                set(LIGHT_THEME, "Aspecto claro");

                set(MODE_STRAIGHT, "Vertical");
                set(MODE_IAMBIC_A, "Iámbico A");
                set(MODE_IAMBIC_B, "Iámbico B");
                set(MODE_ULTIMATIC, "Ultimatic");
                set(MODE_BUG, "Bug (Semi-automático)");
                set(MODE_COOTIE, "Cootie / Sideswiper");

                set(CAT_LETTERS, "LETRAS");
                set(CAT_NUMBERS, "NÚMEROS");
                set(CAT_SYMBOLS, "SÍMBOLOS");
                set(CAT_SPECIAL_SYMBOLS, "SÍMBOLOS ESPECIALES");
                set(CAT_SPECIAL, "LETRAS ESPECIALES");
                set(CAT_PROSIGNS_COMMON, "SEÑALES DE PROCEDIMIENTO COMUNES");
                set(CAT_ABBREVIATIONS, "ABREVIATURAS COMUNES");
                set(CAT_QCODES, "CÓDIGOS Q");
                set(CAT_PROSIGNS_OTHER, "OTRAS SEÑALES DE PROCEDIMIENTO");
                set(SUPPORT_WINDLEREYE, "Apóyame escuchando mi proyecto musical Windlereye");
                set(CANCEL, "Cancelar");
                set(QUIT, "Salir");
                set(QUIT_GAME_PROMPT, "¿Estás seguro de que quieres salir de este juego?");

                set(SCORE, "Puntos");
        set(HIGH_SCORE, "Récord");
        set(YOUR_HIGH_SCORE_IS, "Tu puntuación más alta es");
                set(TIME, "Tiempo");
                                set(MATCH_COMPLETED, "Partida completada");
                set(TRY_AGAIN, "Reintentar");
                set(WORDS, "Palabras");
                                set(QUIT_GAME, "Salir");
                set(MATCH_SETTINGS, "Parámetros de partida");
                set(SHARE_PREVIEW, "Vista previa");
        set(GAMES, "Juegos");
                set(SHARE, "Compartir");
                set(SHARE_SUBJECT, "Compartiendo mi puntuación de Morse Training");
                set(SHARE_PROMO_TEXT, "Juega a Morse Training gratis en https://morsetraining.com");
                set(THEME, "Tema");

                set(MATCH_RESULTS, "Resultados");
                                        

        set(REPEAT, "REPETIR");
        set(HINT, "PISTA");

        set(START, "EMPEZAR");
        set(PICK_LANG_THEME_ON_SHARE, "Elegir idioma y tema al compartir puntuaciones");
        set(CONTINUE, "CONTINUAR");
        set(RX, "Recibir");
        set(TX, "Transmitir");

        set(KOCH_METHOD, "Método Koch");
        set(TARGET, "Objetivo");
set(TARGET_MET, "Objetivo cumplido");
        set(TARGET_NOT_MET, "Objetivo no cumplido");
            set(LEVEL, "Nivel");
    
        set(LEARN, "Aprender");
        set(PLAY, "Jugar");
    
        set(LEVELS_COMPLETED, "Niveles completados");
        set(RESET_PROGRESS, "Restablecer progreso");
        set(RESET_PROGRESS_CONFIRM, "¿Estás seguro de que deseas restablecer el progreso?");
        set(RESET, "Restablecer");
            set(WPM, "PPM");
        set(BACK, "Atrás");
        set(NEXT_LEVEL, "Siguiente nivel");

                set(EFFECTIVE_WPM_FARNSWORTH, "WPM efectivo (Farnsworth)");
                set(EXTRA_WORD_SPACING, "Espaciado");
                set(EFFECTIVE_WPM_SHORT, "Efectivo");

                set(WORD_SPACING_ADD, "Palabra +");
    }
}
