package com.qft8.morsekeyer.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordGenerator {

    private static final String[] GAME_WORDS_1 = { "CQ", "DE", "GM", "GA", "GE", "GN", "HI", "BK", "TU", "OM", "YL",
            "73", "88", "QR" };
    private static final String[] GAME_WORDS_2 = { "QTH", "QSL", "QSO", "QRN", "QRZ", "QSY", "RST", "CUL", "RIG",
            "FER", "OPR", "HNY" };
    private static final String[] ITU_PREFIXES = {
            "W", "K", "N", "A", "VE", "VA", "VY", "XE", "CE", "LU", "PY", "CX", "ZP", "OA", "HC", "HK", "YV", "CP",
            "G", "M", "2", "GM", "MM", "GW", "MW", "GI", "MI", "F", "EA", "EB", "EC", "I", "IN", "IK", "IZ",
            "D", "DL", "DJ", "DK", "PA", "PB", "PC", "PD", "PE", "PI", "ON", "OO", "OP", "OQ", "OR", "OS", "OT",
            "HB", "OE", "OK", "OL", "OM", "SP", "SQ", "SN", "UA", "UB", "UC", "UD", "UE", "UF", "UG", "UH", "UI",
            "RV", "RW", "RX", "RY", "RZ", "UR", "US", "UT", "UU", "UV", "UW", "UX", "UY", "UZ", "EM", "EN", "EO",
            "EW", "EU", "LY", "YL", "ES", "ER", "4X", "4Z", "OD", "JY", "TA", "TB", "SV", "SZ", "J4", "LZ", "YO",
            "YR", "HA", "HG", "S5", "9A", "E7", "YU", "YT", "Z3", "ZA", "LA", "LB", "LC", "LD", "LE", "SM", "SA",
            "SB", "SC", "SD", "SE", "OH", "OF", "OG", "OZ", "OU", "OV", "TF", "JA", "JE", "JF", "JG", "JH", "JI",
            "JJ", "JK", "JL", "JM", "JN", "JO", "JP", "JQ", "JR", "JS", "HL", "DS", "BY", "BA", "BD", "BG", "BV",
            "VR", "XX", "VU", "VT", "AP", "4S", "9V", "9M", "YB", "YC", "YD", "YE", "DU", "DV", "HS", "E2", "VK",
            "ZL", "ZS", "ZR", "ZT", "ZU", "SU", "CN", "7X", "3V", "5A", "9G", "5N", "5Z", "5H", "9J", "Z2", "V5"
    };
    private static final String[] GAME_SUFFIXES = { "/P", "/M", "/MM", "/MA", "/QRP", "/1", "/2", "/3", "/4", "/5",
            "/6", "/7", "/8", "/9" };

    private static final String[] Q_CODES_WITH_QUESTION = {
            "QTH?", "QRZ?", "QSL?", "QRL?", "QRM?", "QRN?", "QSB?", "QRK?", "QSA?",
            "QRI?", "QSY?", "QRO?", "QRP?", "QRS?", "QRQ?", "QSO?", "QRU?", "QRV?", "QTR?"
    };

    private static List<String> availableWords1 = new ArrayList<>();
    private static List<String> availableWords2 = new ArrayList<>();
    private static int wordsGenerated = 0;

    public static void reset() {
        availableWords1 = new ArrayList<>(Arrays.asList(GAME_WORDS_1));
        availableWords2 = new ArrayList<>(Arrays.asList(GAME_WORDS_2));
        wordsGenerated = 0;
    }

    public static String generateCallsign(int length) {
        String prefix = ITU_PREFIXES[(int) (Math.random() * ITU_PREFIXES.length)];
        int lettersLeft = length - 1 - prefix.length();
        if (lettersLeft < 1) {
            prefix = prefix.substring(0, 1);
            lettersLeft = length - 1 - prefix.length();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append((char) ('0' + (int) (Math.random() * 10)));
        for (int i = 0; i < lettersLeft; i++) {
            sb.append((char) ('A' + (int) (Math.random() * 26)));
        }
        return sb.toString();
    }

    public static String generateGameWord(int gameWordsSolved, String[] currentActive) {
        String word = "";
        while (true) {
            int qCodeChance = (gameWordsSolved <= 30) ? 40 : 60;
            if (Math.random() * qCodeChance < 1.0) {
                word = Q_CODES_WITH_QUESTION[(int) (Math.random() * Q_CODES_WITH_QUESTION.length)];
            } else {
                if (wordsGenerated < 2) {
                    if (!availableWords1.isEmpty()) {
                        int idx = (int) (Math.random() * availableWords1.size());
                        word = availableWords1.remove(idx);
                    } else {
                        word = GAME_WORDS_1[(int) (Math.random() * GAME_WORDS_1.length)];
                    }
                } else if (wordsGenerated < 3) {
                    if (!availableWords2.isEmpty()) {
                        int idx = (int) (Math.random() * availableWords2.size());
                        word = availableWords2.remove(idx);
                    } else {
                        word = GAME_WORDS_2[(int) (Math.random() * GAME_WORDS_2.length)];
                    }
                } else if (gameWordsSolved < 20) {
                    word = generateCallsign(4);
                } else if (gameWordsSolved < 30) {
                    word = generateCallsign(5);
                } else {
                    word = generateCallsign(6);
                }

                if (word.length() > 1) {
                    int prefixChance = 0;
                    int suffixChance = 0;

                    if (gameWordsSolved < 15) {
                        // 0% chance
                    } else if (gameWordsSolved <= 19) {
                        suffixChance = 10;
                    } else if (gameWordsSolved <= 24) {
                        prefixChance = 10;
                    } else if (gameWordsSolved <= 29) {
                        suffixChance = 20;
                    } else if (gameWordsSolved <= 34) {
                        prefixChance = 20;
                    } else if (gameWordsSolved <= 40) {
                        suffixChance = 10;
                        prefixChance = 10;
                    } else if (gameWordsSolved <= 50) {
                        suffixChance = 12;
                        prefixChance = 12;
                    } else if (gameWordsSolved <= 60) {
                        suffixChance = 15;
                        prefixChance = 15;
                    } else if (gameWordsSolved <= 70) {
                        suffixChance = 20;
                        prefixChance = 20;
                    } else {
                        int extra = (gameWordsSolved - 71) / 10;
                        prefixChance = 30 + extra * 10;
                        suffixChance = 30 + extra * 10;
                    }

                    if (prefixChance > 100)
                        prefixChance = 100;
                    if (suffixChance > 100)
                        suffixChance = 100;

                    if (prefixChance > 0 && Math.random() * 100 < prefixChance) {
                        String p = ITU_PREFIXES[(int) (Math.random() * ITU_PREFIXES.length)];
                        word = p + "/" + word;
                    }
                    if (suffixChance > 0 && Math.random() * 100 < suffixChance) {
                        String s = GAME_SUFFIXES[(int) (Math.random() * GAME_SUFFIXES.length)];
                        word = word + s;
                    }
                }
            }

            boolean active = false;
            if (currentActive != null) {
                for (String w : currentActive) {
                    if (w != null && w.equals(word)) {
                        active = true;
                        break;
                    }
                }
            }
            if (!active) {
                wordsGenerated++;
                return word;
            }
        }
    }
}
