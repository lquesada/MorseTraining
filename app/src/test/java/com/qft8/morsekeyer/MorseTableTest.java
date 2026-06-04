package com.qft8.morsekeyer;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;

/**
 * Unit tests for the MorseTable decoder and lookup logic.
 * Driven by the single source of truth: MorseDictionary.
 */
public class MorseTableTest {

    @Test
    public void testSpaceMapping() {
        assertEquals(" ", MorseTable.MORSE_TABLE.get(" "));
    }

    // ================================================================
    // Comprehensive Dictionary Test
    // ================================================================

    @Test
    public void testAllDictionaryEntriesAreDecodable() {
        for (MorseDictionary.Entry entry : MorseDictionary.ENTRIES) {
            // Skip space and entries without codes (abbreviations)
            if (entry.code == null || entry.code.equals(" ")) continue;
            
            String decoded = MorseTable.lookup(entry.code);
            assertNotEquals("Code " + entry.code + " (for " + entry.name + ") returned [?]", 
                "[?]", decoded);
            
            // The decoded value should contain the original name
            // (either as "A", "<SOS>", or within a collision "<A/B>")
            assertTrue("Round-trip failed for: " + entry.name + " (code: " + entry.code + ", got: " + decoded + ")",
                decoded.equals(entry.name) || 
                decoded.equals("<" + entry.name + ">") || 
                decoded.contains(entry.name + "/") || 
                decoded.contains("/" + entry.name));
        }
    }

    @Test
    public void testReverseLookupAllLetters() {
        assertEquals("A", MorseTable.lookup(".-"));
        assertEquals("E", MorseTable.lookup("."));
        assertEquals("T", MorseTable.lookup("-"));
    }

    @Test
    public void testReverseLookupSOS() {
        assertEquals("<SOS>", MorseTable.lookup("...---..."));
    }

    @Test
    public void testCollisionsAreMergedAndWrapped() {
        assertEquals("<KN/(>", MorseTable.lookup("-.--."));
        assertEquals("<BT/=>", MorseTable.lookup("-...-"));
        assertEquals("<AA/\u00C4/\u00C6/\u0104>", MorseTable.lookup(".-.-"));
    }

    @Test
    public void testReverseMorseSizeMatchesForwardSize() {
        // REVERSE_MORSE may be smaller if multiple chars map to the same code
        // (e.g. "=" and "<BT>" both map to "-...-"), but it shouldn't be larger
        assertTrue("Reverse map should not be larger than forward map",
            MorseTable.REVERSE_MORSE.size() <= MorseTable.MORSE_TABLE.size());
    }

    // ================================================================
    // lookup() method
    // ================================================================

    @Test
    public void testLookupKnownCode() {
        assertEquals("A", MorseTable.lookup(".-"));
        assertEquals("E", MorseTable.lookup("."));
        assertEquals("T", MorseTable.lookup("-"));
    }

    @Test
    public void testLookupUnknownCode() {
        assertEquals("[?]", MorseTable.lookup(".-.-.-.-.-"));
        assertEquals("[?]", MorseTable.lookup(".........."));
    }

    @Test
    public void testLookupNull() {
        assertEquals("", MorseTable.lookup(null));
    }

    @Test
    public void testLookupEmpty() {
        assertEquals("", MorseTable.lookup(""));
    }

    // ================================================================
    // Size / completeness
    // ================================================================

    @Test
    public void testMinimumTableSize() {
        // Current size is around 95 entries
        assertTrue("MORSE_TABLE should have at least 90 entries",
            MorseTable.MORSE_TABLE.size() >= 90);
    }

    @Test
    public void testAllCodesOnlyContainDitsAndDahsOrSpace() {
        for (Map.Entry<String, String> entry : MorseTable.MORSE_TABLE.entrySet()) {
            String code = entry.getValue();
            assertTrue("Code for '" + entry.getKey() + "' contains invalid chars: " + code,
                code.matches("[.\\- ]+"));
        }
    }
}
