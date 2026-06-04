package com.qft8.morsekeyer.lang;

public class LangFr extends MorseLanguage {
    public LangFr() {
        set(SAVE, "Enregistrer");
        set(RESET_DEFAULTS, "Réinitialiser");
        set(CLOSE, "Fermer");
        
        set(SETTINGS_TITLE, "Paramètres");
        set(TONE, "Tonalité");
        set(USER_INTERFACE, "Interface utilisateur");
        set(ADVANCED, "Avancé (performance)");
        set(DECODER_BEHAVIOR, "Comportement du décodeur");

        set(KEY_MODE, "Mode de manipulation");
        set(WPM_SPEED, "Vitesse (WPM)");
        set(INVERSE_PADDLES, "Inverser les palettes");
        set(STRICT_TIMING, "Temporisation stricte");
        set(INTERLETTER_SPACING, "Espacement des lettres");
        set(INTERWORD_SPACING, "Espacement des mots");
        
        set(FREQUENCY, "Fréquence");
        set(VOLUME, "Volume");
        set(ENVELOPE, "Temps de montée/descente (enveloppe)");
        set(NOCLICK, "Signal en dents de scie pour éviter les clics");
        
        set(LANGUAGE, "Langue");
        set(KEYBOARD_TYPE, "Type de clavier");
        set(SHOW_TABLE, "Afficher la table Morse");
        set(SHOW_TABLE_CODES, "Afficher les points et traits dans la table Morse");
        set(SHOW_VISUAL, "Afficher l'indicateur visuel");
        set(SHOW_PADDLES, "Afficher les palettes à l'écran");
        set(NEXT_WORD_INDICATOR, "Indicateur de mot suivant");
        set(KEEP_SCREEN_ON, "Garder l'écran allumé");
        set(APP_THEME, "Thème de l'application");
        set(TEXT_COLOR, "Couleur du texte");
        set(TEXT_FONT_SIZE, "Taille de police du texte");
        set(TABLE_FONT_SIZE, "Taille de police du tableau");
        set(TABLE_RATIO, "Ratio tableau/texte");
        
        set(KEEP_ALIVE, "Maintenir l'audio actif (réduit la latence)");
        set(AUDIO_BUFFER, "Tampon audio (matériel)");
        set(PROCESSING_CHUNK, "Fragment de traitement");
        set(PERFORMANCE_HINT, "Si le son coupe, augmentez le tampon ou le fragment. Si la latence est élevée, réduisez-les.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Entrées supportées : clavier, écran tactile, souris ou manipulateur avec adaptateur USB.\n\n" +
                "Pour la manipulation avec le clic gauche/droit de la souris ou l'adaptateur de palette USB vers souris, laissez le pointeur de la souris sur le bouton de la palette gauche à l'écran, le clic gauche/droit sera mappé aux palettes correctes.\n\n" +
                "Pour les adaptateurs clavier (ex. VBand), cela fonctionne directement sans configuration.\n\n" +
                "Le mode strict exige un timing précis ; le mode non-strict permet une manipulation plus rapide.\n\n" +
                "Problèmes courants : Si le son cliquette trop, essayez l'option 'Dents de scie' ou modifiez l'enveloppe. Si la latence est élevée, réduisez le tampon. Si le son se coupe, augmentez-le.\n\n" +
                "Touches du clavier :\n" +
                "  Gauche : [  A  ,  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Droite : ]  D  .  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Clé");
        
        set(SYSTEM_SETTING, "Réglage système");
        set(DARK_THEME, "Thème sombre");
        set(LIGHT_THEME, "Thème clair");
        
        set(MODE_STRAIGHT, "Pioche (Vertical)");
        set(MODE_IAMBIC_A, "Iambique A");
        set(MODE_IAMBIC_B, "Iambique B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug (Semi-automatique)");
        set(MODE_COOTIE, "Cootie / Sideswiper");
        
        set(CAT_LETTERS, "LETTRES");
        set(CAT_NUMBERS, "CHIFFRES");
        set(CAT_SYMBOLS, "SYMBOLES");
        set(CAT_SPECIAL_SYMBOLS, "SYMBOLES SPÉCIAUX");
        set(CAT_SPECIAL, "LETTRES SPÉCIALES");
        set(CAT_PROSIGNS_COMMON, "SIGNAUX DE PROCÉDURE COURANTS");
        set(CAT_ABBREVIATIONS, "ABRÉVIATIONS COURANTES");
        set(CAT_QCODES, "CODES Q");
        set(CAT_PROSIGNS_OTHER, "Autres Signaux");

        set(COLOR_WHITE, "Blanc");
        set(COLOR_BLACK, "Noir");
        set(COLOR_RED, "Rouge");
        set(COLOR_ORANGE, "Orange");
        set(COLOR_YELLOW, "Jaune");
        set(COLOR_GREEN, "Vert");
        set(COLOR_CYAN, "Cyan");
        set(COLOR_BLUE, "Bleu");
        set(COLOR_PURPLE, "Violet");
        set(COLOR_PINK, "Rose");
        set(SUPPORT_WINDLEREYE, "Soutenez-moi en écoutant mon projet musical Windlereye");
        set(CANCEL, "Annuler");
        set(QUIT, "Quitter");
        set(QUIT_GAME_PROMPT, "Voulez-vous vraiment quitter ce jeu ?");

        set(SCORE, "Score : ");
        set(HIGH_SCORE, "Note élevée");
        set(YOUR_HIGH_SCORE_IS, "Votre meilleur score est :");
        set(TIME, "Temps : ");
                set(MATCH_COMPLETED, "Partie terminée");
        set(TRY_AGAIN, "Réessayer");
        set(WORDS, "Mots");
                set(QUIT_GAME, "Quitter");
        set(MATCH_SETTINGS, "Paramètres du jeu");
        set(SHARE_PREVIEW, "Aperçu");
        set(GAMES, "Jeux");
        set(SHARE, "Partager");
        set(SHARE_SUBJECT, "Partage de mon score Morse Training");
        set(SHARE_PROMO_TEXT, "Jouez à Morse Training sur https://morsetraining.com");
        set(THEME, "Thème");

        set(MATCH_RESULTS, "Résultats");
                
        set(INFINITE, "Entraînez-vous sans limite de temps");
        set(THREE_MINUTES, "Battez votre score en 3 minutes");

        set(REPEAT, "RÉPÉTER");

        set(START, "DÉMARRER");
        set(PICK_LANG_THEME_ON_SHARE, "Choisir la langue et le thème lors du partage des scores");
        set(CONTINUE, "CONTINUER");
        set(RX, "Recevoir");
        set(TX, "Transmettre");
}
}
