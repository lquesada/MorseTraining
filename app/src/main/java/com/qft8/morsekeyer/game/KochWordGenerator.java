package com.qft8.morsekeyer.game;

import java.util.Random;

public class KochWordGenerator {
    private static final Random random = new Random();
    
    private static final int[] LENGTHS = {2, 2, 3, 3, 3, 4, 4, 4, 4, 4};
    
    public static String generateWord(int level, int wordIndex) {
        int length = wordIndex < LENGTHS.length ? LENGTHS[wordIndex] : 5;
        
        String newChar = KochLevelSelectView.KOCH_CHARS[level];
        
        StringBuilder sb = new StringBuilder();
        int newCharPos = random.nextInt(length);
        
        for (int i = 0; i < length; i++) {
            if (i == newCharPos) {
                sb.append(newChar);
            } else {
                int rndLevel = random.nextInt(level + 1);
                sb.append(KochLevelSelectView.KOCH_CHARS[rndLevel]);
            }
        }
        String word = sb.toString();
        if ("KKK".equals(word)) {
            word = "KK";
        }
        return word;
    }

    /**
     * Generates a word using only characters from the provided custom character set.
     * All characters in the word are picked uniformly at random from customChars.
     *
     * @param customChars  Non-null, non-empty array of characters to use.
     * @param wordIndex    Index of the word in the game (used to determine length).
     * @return             A word composed only of characters from customChars.
     */
    public static String generateCustomWord(String[] customChars, int wordIndex) {
        if (customChars == null || customChars.length == 0) {
            return "K"; // fallback, should never happen
        }
        int length = wordIndex < LENGTHS.length ? LENGTHS[wordIndex] : 5;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(customChars[random.nextInt(customChars.length)]);
        }
        return sb.toString();
    }
}
