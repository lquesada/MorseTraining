package com.qft8.morsekeyer.lang;

public class LangPt extends MorseLanguage {
    public LangPt() {
        set(SAVE, "Salvar");
        set(RESET_DEFAULTS, "Redefinir padrões");
        set(CLOSE, "Fechar");
        
        set(SETTINGS_TITLE, "Configurações");
        set(TONE, "Tom");
        set(USER_INTERFACE, "Interface do usuário");
        set(ADVANCED, "Avançado (desempenho)");
        set(DECODER_BEHAVIOR, "Comportamento do decodificador");

        set(KEY_MODE, "Modo do manipulador");
        set(WPM_SPEED, "Velocidade (WPM)");
        set(INVERSE_PADDLES, "Inverter palhetas");
        set(STRICT_TIMING, "Temporização estrita");
        set(INTERLETTER_SPACING, "Espaçamento entre letras");
        set(INTERWORD_SPACING, "Espaçamento entre palavras");
        
        set(FREQUENCY, "Frequência");
        set(VOLUME, "Volume");
        set(ENVELOPE, "Tempo de subida/descida (envelope)");
        set(NOCLICK, "Sinal dente de serra para evitar cliques");
        
        set(LANGUAGE, "Idioma");
        set(KEYBOARD_TYPE, "Tipo de teclado");
        set(SHOW_TABLE, "Mostrar tabela Morse");
        set(SHOW_TABLE_CODES, "Mostrar pontos e traços na tabela Morse");
        set(SHOW_VISUAL, "Mostrar indicador visual");
        set(SHOW_PADDLES, "Mostrar palhetas na tela");
        set(NEXT_WORD_INDICATOR, "Indicador de próxima palavra");
        set(KEEP_SCREEN_ON, "Manter tela ligada");
        set(APP_THEME, "Tema do app");
        set(TEXT_COLOR, "Cor do texto");
        set(TEXT_FONT_SIZE, "Tamanho da fonte do texto");
        set(TABLE_FONT_SIZE, "Tamanho da fonte da tabela");
        set(TABLE_RATIO, "Proporção tabela/tela");
        
        set(KEEP_ALIVE, "Manter áudio ativo (reduz latência)");
        set(AUDIO_BUFFER, "Buffer de áudio (hardware)");
        set(PROCESSING_CHUNK, "Fragmento de processamento");
        set(PERFORMANCE_HINT, "Se o som falhar, aumente o buffer. Se a latência for alta, diminua.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Entradas suportadas: teclado, tela sensível ao toque, mouse ou manipulador com adaptador USB.\n\n" +
                "Para a manipulação com o clique esquerdo/direito do rato ou com um adaptador de pás USB para rato, deixe o ponteiro do rato sobre o botão da pá esquerda no ecrã; o clique esquerdo/direito será atribuído às pás corretas.\n\n" +
                "Para adaptadores de teclado (ex: VBand), funciona diretamente sem configuração.\n\n" +
                "O modo estrito exige tempo preciso entre letras; o modo não estrito permite manipulação mais rápida.\n\n" +
                "Problemas comuns: Se o som tiver muitos cliques, tente a opção 'Dente de serra' ou altere o envelope. Se a latência for alta, diminua o buffer.\n\n" +
                "Teclas do teclado:\n" +
                "  Esquerda: [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Direita: ]  D  S  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Chave");
        
        set(SYSTEM_SETTING, "Configuração do sistema");
        set(DARK_THEME, "Tema escuro");
        set(LIGHT_THEME, "Tema claro");
        
        set(MODE_STRAIGHT, "Chave vertical");
        set(MODE_IAMBIC_A, "Iâmbico A");
        set(MODE_IAMBIC_B, "Iâmbico B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Semiautomático)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "LETRAS");
        set(CAT_NUMBERS, "NÚMEROS");
        set(CAT_SYMBOLS, "SÍMBOLOS");
        set(CAT_SPECIAL_SYMBOLS, "SÍMBOLOS ESPECIAIS");
        set(CAT_SPECIAL, "LETRAS ESPECIAIS");
        set(CAT_PROSIGNS_COMMON, "SINAIS DE PROCEDIMENTO COMUNS");
        set(CAT_ABBREVIATIONS, "ABREVIATURAS COMUNS");
        set(CAT_QCODES, "CÓDIGOS Q");
        set(CAT_PROSIGNS_OTHER, "OUTROS SINAIS DE PROCEDIMENTO");

        set(COLOR_WHITE, "Branco");
        set(COLOR_BLACK, "Preto");
        set(COLOR_RED, "Vermelho");
        set(COLOR_ORANGE, "Laranja");
        set(COLOR_YELLOW, "Amarelo");
        set(COLOR_GREEN, "Verde");
        set(COLOR_CYAN, "Ciano");
        set(COLOR_BLUE, "Azul");
        set(COLOR_PURPLE, "Roxo");
        set(COLOR_PINK, "Rosa");
        set(SUPPORT_WINDLEREYE, "Apoie-me ouvindo meu projeto musical Windlereye");
        set(CANCEL, "Cancelar");
        set(QUIT, "Sair");
        set(QUIT_GAME_PROMPT, "Tem certeza de que deseja sair deste jogo?");

        set(SCORE, "Pontos: ");
        set(HIGH_SCORE, "Pontuação alta");
        set(YOUR_HIGH_SCORE_IS, "Sua pontuação mais alta é:");
        set(TIME, "Tempo: ");
                set(MATCH_COMPLETED, "Partida concluída");
        set(TRY_AGAIN, "Tentar novamente");
        set(WORDS, "Palavras");
                set(QUIT_GAME, "Sair");
        set(MATCH_SETTINGS, "Parâmetros do jogo");
        set(SHARE_PREVIEW, "Pré-visualizar");
        set(GAMES, "Jogos");
        set(SHARE, "Partilhar");
        set(SHARE_SUBJECT, "A partilhar a minha pontuação");
        set(SHARE_PROMO_TEXT, "Joga Morse Training em https://morsetraining.com");
        set(THEME, "Tema");

        set(MATCH_RESULTS, "Resultados");
                
        set(INFINITE, "Pratique sem limite de tempo");
        set(THREE_MINUTES, "Bata sua pontuação em 3 minutos");

        set(REPEAT, "REPETIR");

        set(START, "COMEÇAR");
        set(PICK_LANG_THEME_ON_SHARE, "Escolher idioma e tema ao compartilhar pontuações");
        set(CONTINUE, "CONTINUAR");
        set(RX, "Receber");
        set(TX, "Transmitir");
}
}
