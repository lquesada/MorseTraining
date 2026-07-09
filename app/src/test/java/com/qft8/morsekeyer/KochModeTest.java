package com.qft8.morsekeyer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.qft8.morsekeyer.game.KochLevelSelectView;
import com.qft8.morsekeyer.game.KochWordGenerator;

import org.junit.Test;

public class KochModeTest {

    @Test
    public void testKochCharsCount() {
        assertEquals(41, KochLevelSelectView.KOCH_CHARS.length);
        assertEquals("K", KochLevelSelectView.KOCH_CHARS[0]);
        assertEquals("X", KochLevelSelectView.KOCH_CHARS[40]);
    }

    @Test
    public void testWordGeneratorLevel0() {
        // Level 0 word generator should only generate words consisting of 'K'
        String word = KochWordGenerator.generateWord(0, 0);
        for (int i = 0; i < word.length(); i++) {
            assertEquals('K', word.charAt(i));
        }
    }

    @Test
    public void testWordGeneratorContainsTargetChar() {
        for (int level = 0; level < KochLevelSelectView.KOCH_CHARS.length; level++) {
            String lessonChar = KochLevelSelectView.KOCH_CHARS[level];
            for (int wordIdx = 0; wordIdx < 100; wordIdx++) {
                String word = KochWordGenerator.generateWord(level, wordIdx);
                assertTrue("Generated word '" + word + "' at level " + level + " does not contain target character '" + lessonChar + "'", word.contains(lessonChar));
            }
        }
    }

    @Test
    public void testMigrationMapping() {
        // Map old progress levels (0 to 40) to new levels (-1 to 15)
        assertEquals(-1, getMigratedLevel(0));
        assertEquals(0, getMigratedLevel(1));
        assertEquals(1, getMigratedLevel(2));
        assertEquals(1, getMigratedLevel(3));
        assertEquals(1, getMigratedLevel(4));
        assertEquals(3, getMigratedLevel(5));
        assertEquals(3, getMigratedLevel(15));
        assertEquals(14, getMigratedLevel(16));
        assertEquals(14, getMigratedLevel(26));
        assertEquals(15, getMigratedLevel(27));
        assertEquals(15, getMigratedLevel(40));
    }

    private int getMigratedLevel(int oldVal) {
        int newVal = -1;
        if (oldVal == 1) newVal = 0;
        else if (oldVal >= 2 && oldVal <= 4) newVal = 1;
        else if (oldVal >= 5 && oldVal <= 15) newVal = 3;
        else if (oldVal >= 16 && oldVal <= 26) newVal = 14;
        else if (oldVal >= 27) newVal = 15;
        return newVal;
    }
}
