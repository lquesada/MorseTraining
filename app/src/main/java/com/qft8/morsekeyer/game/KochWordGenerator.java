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
}
