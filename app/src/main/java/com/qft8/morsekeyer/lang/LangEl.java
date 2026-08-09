package com.qft8.morsekeyer.lang;

public class LangEl extends MorseLanguage {
    public LangEl() {
        set(SAVE, "Αποθήκευση");
        set(RESET_DEFAULTS, "Επαναφορά στις προεπιλογές");
        set(CLOSE, "Κλείσιμο");
        
        set(SETTINGS_TITLE, "Ρυθμίσεις");
        set(TONE, "Τόνος");
        set(USER_INTERFACE, "Διεπαφή Χρήστη");
        set(ADVANCED, "Για προχωρημένους (απόδοση)");
        set(DECODER_BEHAVIOR, "Συμπεριφορά αποκωδικοποιητή");

        set(KEY_MODE, "Λειτουργία κλειδιού");
        set(WPM_SPEED, "Ταχύτητα WPM");
        set(INVERSE_PADDLES, "Αντίστροφα paddles");
        set(STRICT_TIMING, "Αυστηρός συγχρονισμός");
        
        set(FREQUENCY, "Συχνότητα");
        set(VOLUME, "Ένταση");
        set(ENVELOPE, "Χρόνος ανόδου/καθόδου (περιβάλλουσα)");
        set(NOCLICK, "Χρήση σήματος πριονωτής μορφής για αποφυγή κλικ");
        
        set(LANGUAGE, "Γλώσσα");
        set(KEYBOARD_TYPE, "Τύπος πληκτρολογίου");
        set(SHOW_TABLE, "Εμφάνιση πίνακα Μορς");
        set(SHOW_TABLE_CODES, "Εμφάνιση τελειών και παυλών στον πίνακα Μορς");
        set(SHOW_VISUAL, "Εμφάνιση οπτικής ένδειξης");
        set(SHOW_PADDLES, "Εμφάνιση paddles οθόνης");
        set(NEXT_WORD_INDICATOR, "Ένδειξη επόμενης λέξης");
        set(KEEP_SCREEN_ON, "Διατήρηση οθόνης ενεργής όσο η εφαρμογή είναι ανοιχτή");
        set(APP_THEME, "Θέμα εφαρμογής");
        set(TEXT_COLOR, "Χρώμα κειμένου");
        set(TEXT_FONT_SIZE, "Μέγεθος γραμματοσειράς κειμένου");
        set(TABLE_FONT_SIZE, "Μέγεθος γραμματοσειράς πίνακα");
        set(TABLE_RATIO, "Αναλογία πίνακα προς οθόνη κειμένου");
        
        set(COLOR_WHITE, "Λευκό");
        set(COLOR_BLACK, "Μαύρο");
        set(COLOR_RED, "Κόκκινο");
        set(COLOR_ORANGE, "Πορτοκαλί");
        set(COLOR_YELLOW, "Κίτρινο");
        set(COLOR_GREEN, "Πράσινο");
        set(COLOR_CYAN, "Κυανό");
        set(COLOR_BLUE, "Μπλε");
        set(COLOR_PURPLE, "Μωβ");
        set(COLOR_PINK, "Ροζ");
        
        set(KEEP_ALIVE, "Διατήρηση ήχου (μειώνει την καθυστέρηση)");
        set(WHITE_NOISE, "Πιο δυνατό (αναπαραγωγή λευκού θορύβου)");
        set(AUDIO_BUFFER, "Προσωρινή μνήμη ήχου (υλικό)");
        set(PROCESSING_CHUNK, "Τμήμα επεξεργασίας");
        set(PERFORMANCE_HINT, "Αν ο ήχος διακόπτεται, αυξήστε την προσωρινή μνήμη ή το τμήμα. Αν η καθυστέρηση είναι υψηλή, μειώστε τα.");
        
        set(INFO_TITLE, "Morse Training");
        set(INFO_TEXT, "Υποστηριζόμενες είσοδοι: πληκτρολόγιο, οθόνη αφής, ποντίκι, ή paddle με προσαρμογέα USB.\n\n" +
                "Για πληκτρολόγηση με αριστερό/δεξί κλικ ποντικιού ή προσαρμογέα paddle USB-σε-ποντίκι, αφήστε τον δείκτη του ποντικιού πάνω από το αριστερό κουμπί paddle στην οθόνη, και το αριστερό/δεξί κλικ θα αντιστοιχιστεί στα σωστά paddles.\n\n" +
                "Για προσαρμογέα paddle USB-σε-πληκτρολόγιο, λειτουργεί κατευθείαν (π.χ. δοκιμασμένο με VBand) - ενημερώστε με αν δεν λειτουργεί.\n\n" +
                "Η αυστηρή λειτουργία απαιτεί το σωστό χρονισμό μεταξύ των γραμμάτων, η μη αυστηρή λειτουργία επιτρέπει ταχύτερο χειρισμό.\n\n" +
                "Κοινά προβλήματα: Αν ο ήχος έχει πολλά κλικ στη συσκευή σας, δοκιμάστε την επιλογή 'σήματος πριονωτής μορφής' ή προσπαθήστε να τροποποιήσετε την περιβάλλουσα. Αν η καθυστέρηση είναι πολύ υψηλή, προσπαθήστε να μειώσετε την προσωρινή μνήμη. Αν ο ήχος σπάει, προσπαθήστε να την αυξήσετε.\n\n" +
                "Πλήκτρα πληκτρολογίου:\n" +
                "  Αριστερά: [  A  ,  1  0  \u2190  L-Ctrl  L-Shift  L-Alt  Num.  F1\n" +
                "  Δεξιά: ]  D  S  .  3  9  \u2192  R-Ctrl  R-Shift  R-Alt  NumEnter  F2");

        set(KEY, "Κλειδί");
        
        set(SYSTEM_SETTING, "Ρύθμιση συστήματος");
        set(DARK_THEME, "Σκοτεινό θέμα");
        set(LIGHT_THEME, "Φωτεινό θέμα");
        
        set(MODE_STRAIGHT, "Ευθύ (Straight)");
        set(MODE_IAMBIC_A, "Ιαμβικό A");
        set(MODE_IAMBIC_B, "Ιαμβικό B");
        set(MODE_ULTIMATIC, "Ultimatic");
        set(MODE_BUG, "Bug");
        set(MODE_COOTIE, "Cootie");
        
        set(CAT_LETTERS, "ΓΡΑΜΜΑΤΑ");
        set(CAT_NUMBERS, "ΑΡΙΘΜΟΙ");
        set(CAT_SYMBOLS, "ΣΥΜΒΟΛΑ");
        set(CAT_SPECIAL_SYMBOLS, "ΕΙΔΙΚΑ ΣΥΜΒΟΛΑ");
        set(CAT_SPECIAL, "ΕΙΔΙΚΑ ΓΡΑΜΜΑΤΑ");
        set(CAT_PROSIGNS_COMMON, "ΚΟΙΝΑ ΣΗΜΑΤΑ ΔΙΑΔΙΚΑΣΙΑΣ");
        set(CAT_ABBREVIATIONS, "ΚΟΙΝΕΣ ΣΥΝΤΟΜΟΓΡΑΦΙΕΣ");
        set(CAT_QCODES, "ΚΩΔΙΚΟΙ Q");
        set(CAT_PROSIGNS_OTHER, "ΑΛΛΑ ΣΗΜΑΤΑ ΔΙΑΔΙΚΑΣΙΑΣ");
        set(SUPPORT_WINDLEREYE, "Υποστηρίξτε με ακούγοντας το μουσικό μου έργο Windlereye");
        set(CANCEL, "Ακύρωση");
        set(QUIT, "Έξοδος");
        set(QUIT_GAME_PROMPT, "Είστε βέβαιοι ότι θέλετε να εγκαταλείψετε αυτό το παιχνίδι;");
        set(WORDS, "Λόγια");
                set(QUIT_GAME, "Κλείστε το παιχνίδι");
        set(MATCH_SETTINGS, "Παράμετροι παιχνιδιού");
        set(SHARE_PREVIEW, "Κοινή χρήση προεπισκόπησης");
        set(GAMES, "Παιχνίδια");
        set(SHARE, "Μερίδιο");
        set(SHARE_SUBJECT, "Μοιράζομαι τη βαθμολογία μου Morse Training");
        set(SHARE_PROMO_TEXT, "Παίξτε Morse Training δωρεάν στη διεύθυνση https://morsetraining.com");
        set(THEME, "Θέμα");

        set(MATCH_RESULTS, "Αποτελέσματα αγώνων");
        set(TIME, "Φορά");
        set(TRY_AGAIN, "Προσπαθήστε ξανά");
        set(SCORE, "Σκορ");
        set(MATCH_COMPLETED, "Ολοκληρώθηκε ο αγώνας");
        set(HIGH_SCORE, "Υψηλή βαθμολογία");

                

        set(REPEAT, "ΕΠΑΝΆΛΗΨΗ");
        set(HINT, "ΥΠΌΔΕΙΞΗ");

        set(START, "ΈΝΑΡΞΗ");
        set(PICK_LANG_THEME_ON_SHARE, "Επιλέξτε γλώσσα και θέμα κατά την κοινή χρήση βαθμολογιών");
        set(CONTINUE, "ΣΥΝΕΧΙΖΩ");
        set(RX, "Λαμβάνω");
        set(TX, "Εκπέμπω");

        set(KOCH_METHOD, "Μέθοδος Koch");
        set(TARGET, "Στόχος");
set(TARGET_MET, "Ο στόχος επιτεύχθηκε");
        set(TARGET_NOT_MET, "Ο στόχος δεν επιτεύχθηκε");
            set(LEVEL, "Επίπεδο");
    
        set(LEARN, "Μάθετε");
        set(PLAY, "Παίξτε");
    
        set(LEVELS_COMPLETED, "Ολοκληρωμένα επίπεδα");
        set(RESET_PROGRESS, "Επαναφορά προόδου");
        set(RESET_PROGRESS_CONFIRM, "Είστε σίγουροι για την επαναφορά;");
        set(RESET, "Επαναφορά");
            set(WPM, "WPM​");
        set(BACK, "Πίσω");
        set(NEXT_LEVEL, "Επόμενο επίπεδο");

                set(EFFECTIVE_WPM_FARNSWORTH, "Πραγματικό WPM (Farnsworth)");
                set(EXTRA_WORD_SPACING, "Διάστημα");
                set(EFFECTIVE_WPM_SHORT, "Πραγματικό");

                set(WORD_SPACING_ADD, "Λέξη +");

        // Koch custom level
        set(CUSTOM_LEVEL, "Προσαρμοσμένο επίπεδο");
        set(SELECT_CHARACTERS_PROMPT, "Πατήστε στο πληκτρολόγιο για να επιλέξετε τους χαρακτήρες που σας ενδιαφέρουν");
    }
}
