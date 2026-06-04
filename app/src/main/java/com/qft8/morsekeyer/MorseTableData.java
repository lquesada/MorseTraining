package com.qft8.morsekeyer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Data for the morse code reference table (the "Show Table" panel).
 * Contains all sections from the web app: Letters, Numbers, Symbols,
 * Special Letters, Common Procedural Signals, Common Abbreviations,
 * Q Codes, Other Procedural Signals.
 */
public class MorseTableData {

    public static class Item {
        public final String character;
        public final String morseCode; // may be null for abbreviation-only entries
        public final String description; // may be null

        public Item(String character, String morseCode, String description) {
            this.character = character;
            this.morseCode = morseCode;
            this.description = description;
        }
    }

    public static class Section {
        public final String title;
        public final List<Item> items;

        public Section(String title, List<Item> items) {
            this.title = title;
            this.items = items;
        }
    }

    public static List<Section> getSections() {
        List<Section> sections = new ArrayList<>();
        Map<String, List<Item>> categoryMap = new LinkedHashMap<>();

        for (MorseDictionary.Entry entry : MorseDictionary.ENTRIES) {
            String cat = entry.category;
            String name = entry.name;
            
            // Special handling for Prosigns: wrap in < > if they have a code 
            // (unless they are Special Letters or Space)
            if (entry.code != null && name.length() > 1 
                && !cat.equals(MorseDictionary.CAT_SPECIAL) 
                && !cat.equals("SPACE")) {
                 name = "<" + name + ">";
            }
            
            Item item = new Item(name, entry.code, entry.description);
            categoryMap.computeIfAbsent(cat, k -> new ArrayList<>()).add(item);
        }

        for (Map.Entry<String, List<Item>> entry : categoryMap.entrySet()) {
            sections.add(new Section(MorseDictionary.getCategoryName(entry.getKey()), entry.getValue()));
        }

        return sections;
    }
}
