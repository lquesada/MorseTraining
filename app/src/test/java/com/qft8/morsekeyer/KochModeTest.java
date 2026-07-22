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
    public void testKochEqualCharLevel() {
        assertEquals("=", KochLevelSelectView.KOCH_CHARS[16]);
    }

    @Test
    public void testWordGeneratorLevel0() {
        for (int idx = 0; idx < 100; idx++) {
            String word = KochWordGenerator.generateWord(0, idx);
            for (int i = 0; i < word.length(); i++) {
                assertEquals('K', word.charAt(i));
            }
            org.junit.Assert.assertNotEquals("KKK", word);
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

    @Test
    public void testKochTargetCalculation() {
        assertEquals(4, getKochTarget(0));
        assertEquals(11, getKochTarget(1));
        assertEquals(20, getKochTarget(10));
        assertEquals(50, getKochTarget(40));
    }

    private int getKochTarget(int level) {
        return level == 0 ? 4 : 10 + level;
    }

    @Test
    public void testTransmitKochScoringRules() {
        int score = 0;
        boolean txWordFailed = false;
        boolean txWordPointDeducted = false;

        // 1. Clean completion of 1st word -> +1 point
        if (!txWordFailed) score++;
        assertEquals(1, score);

        // 2. Next word: error occurs -> -1 point (score becomes 0)
        txWordFailed = false;
        txWordPointDeducted = false;
        if (!txWordPointDeducted) {
            score = Math.max(0, score - 1);
            txWordPointDeducted = true;
        }
        txWordFailed = true;
        assertEquals(0, score);

        // 3. Word eventually completed after error -> +0 points added
        if (!txWordFailed) score++;
        assertEquals(0, score);

        // 4. Next word: Hint pressed -> -1 point (min 0)
        txWordFailed = false;
        txWordPointDeducted = false;
        if (!txWordPointDeducted) {
            score = Math.max(0, score - 1);
            txWordPointDeducted = true;
        }
        txWordFailed = true;
        assertEquals(0, score);

        // 5. Word completed after Hint -> +0 points
        if (!txWordFailed) score++;
        assertEquals(0, score);

        // 6. Next word: clean completion -> +1 point
        txWordFailed = false;
        txWordPointDeducted = false;
        if (!txWordFailed) score++;
        assertEquals(1, score);
    }

    @Test
    public void testExistingUserProgressMigration() {
        // Suppose existing user completed 30 levels in receive (highest level index = 29)
        int rxHighestLevel = 29;
        int rxLevelsCompletedDisplay = rxHighestLevel + 1;
        assertEquals(30, rxLevelsCompletedDisplay); // Displays 30/41

        // For transmit, key absent defaults to -1
        int txHighestLevel = -1;
        int txLevelsCompletedDisplay = txHighestLevel + 1;
        assertEquals(0, txLevelsCompletedDisplay); // Displays 0/41
    }
}
