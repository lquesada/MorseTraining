package com.qft8.morsekeyer;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Tests for MorseTableData: section structure, item completeness,
 * data integrity, and consistency with MorseTable.
 */
public class MorseTableDataTest {

    @Test
    public void testGetSectionsNotNull() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        assertNotNull(sections);
    }

    @Test
    public void testSectionCount() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        assertEquals("Expected 9 sections", 9, sections.size());
    }

    @Test
    public void testSectionTitles() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        assertEquals("LETTERS", sections.get(0).title);
        assertEquals("NUMBERS", sections.get(1).title);
        assertEquals("SYMBOLS", sections.get(2).title);
        assertEquals("SPECIAL SYMBOLS", sections.get(3).title);
        assertEquals("SPECIAL LETTERS", sections.get(4).title);
        assertEquals("COMMON PROCEDURAL SIGNALS", sections.get(5).title);
        assertEquals("COMMON ABBREVIATIONS", sections.get(6).title);
        assertEquals("Q CODES", sections.get(7).title);
        assertEquals("OTHER PROCEDURAL SIGNALS", sections.get(8).title);
    }

    @Test
    public void testLettersSectionHas26Items() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        assertEquals(26, sections.get(0).items.size());
    }

    @Test
    public void testNumbersSectionHas10Items() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        assertEquals(10, sections.get(1).items.size());
    }

    @Test
    public void testSymbolsSectionHasAtLeast10Items() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        assertTrue(sections.get(2).items.size() >= 10);
    }

    @Test
    public void testSpecialSymbolsSectionHasAtLeast5Items() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        assertTrue(sections.get(3).items.size() >= 5);
    }

    @Test
    public void testSpecialLettersSectionHas22Items() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        assertEquals(22, sections.get(4).items.size());
    }

    @Test
    public void testAllLettersHaveMorseCode() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        for (MorseTableData.Item item : sections.get(0).items) {
            assertNotNull("Letter " + item.character + " missing morse code", item.morseCode);
            assertFalse("Letter " + item.character + " has empty morse code",
                item.morseCode.isEmpty());
        }
    }

    @Test
    public void testAllNumbersHaveMorseCode() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        for (MorseTableData.Item item : sections.get(1).items) {
            assertNotNull("Number " + item.character + " missing morse code", item.morseCode);
        }
    }

    @Test
    public void testAbbreviationsHaveNoMorseCode() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        MorseTableData.Section abbrevs = sections.get(6);
        for (MorseTableData.Item item : abbrevs.items) {
            assertNull("Abbreviation " + item.character + " should not have morse code",
                item.morseCode);
        }
    }

    @Test
    public void testAbbreviationsHaveDescriptions() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        MorseTableData.Section abbrevs = sections.get(6);
        for (MorseTableData.Item item : abbrevs.items) {
            assertNotNull("Abbreviation " + item.character + " missing description",
                item.description);
        }
    }

    @Test
    public void testProsignsHaveDescriptions() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        MorseTableData.Section prosigns = sections.get(5);
        for (MorseTableData.Item item : prosigns.items) {
            assertNotNull("Prosign " + item.character + " missing description",
                item.description);
            assertNotNull("Prosign " + item.character + " missing morse code",
                item.morseCode);
        }
    }

    @Test
    public void testQCodesHaveDescriptions() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        MorseTableData.Section qcodes = sections.get(7);
        for (MorseTableData.Item item : qcodes.items) {
            assertNotNull("Q code " + item.character + " missing description",
                item.description);
        }
    }

    @Test
    public void testQCodesArePaired() {
        // Q codes come in question/answer pairs (? and _)
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        MorseTableData.Section qcodes = sections.get(7);
        assertEquals("Q codes should be in pairs",
            0, qcodes.items.size() % 2);
    }

    @Test
    public void testLetterMorseCodesConsistentWithMorseTable() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        for (MorseTableData.Item item : sections.get(0).items) {
            String expected = MorseTable.MORSE_TABLE.get(item.character);
            assertNotNull("MorseTable missing " + item.character, expected);
            assertEquals("Code mismatch for " + item.character,
                expected, item.morseCode);
        }
    }

    @Test
    public void testNumberMorseCodesConsistentWithMorseTable() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        for (MorseTableData.Item item : sections.get(1).items) {
            String expected = MorseTable.MORSE_TABLE.get(item.character);
            assertNotNull("MorseTable missing " + item.character, expected);
            assertEquals("Code mismatch for " + item.character,
                expected, item.morseCode);
        }
    }

    @Test
    public void testAllItemsHaveCharacter() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        for (MorseTableData.Section section : sections) {
            for (MorseTableData.Item item : section.items) {
                assertNotNull("Null character in section " + section.title, item.character);
                assertFalse("Empty character in section " + section.title,
                    item.character.isEmpty());
            }
        }
    }

    @Test
    public void testNoEmptySections() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        for (MorseTableData.Section section : sections) {
            assertFalse("Section " + section.title + " is empty",
                section.items.isEmpty());
        }
    }

    @Test
    public void testSectionTitlesAreUnique() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        Set<String> titles = new HashSet<>();
        for (MorseTableData.Section section : sections) {
            assertTrue("Duplicate section title: " + section.title,
                titles.add(section.title));
        }
    }

    @Test
    public void testOtherProsignsHaveMorseCode() {
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        MorseTableData.Section other = sections.get(8);
        for (MorseTableData.Item item : other.items) {
            assertNotNull("Other prosign " + item.character + " missing morse code",
                item.morseCode);
            assertNotNull("Other prosign " + item.character + " missing description",
                item.description);
        }
    }
}
