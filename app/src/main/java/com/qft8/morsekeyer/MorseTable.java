package com.qft8.morsekeyer;

import java.util.HashMap;
import java.util.Map;

/**
 * Static morse code table and reverse lookup.
 * Exact reproduction of MORSE_TABLE and REVERSE_MORSE from index.html.
 */
public class MorseTable {

    public static final Map<String, String> MORSE_TABLE = new HashMap<>();
    public static final Map<String, String> REVERSE_MORSE = new HashMap<>();
    public static final Map<String, java.util.List<String>> COLLISIONS = new java.util.LinkedHashMap<>();

    static {
        // Build forward and reverse maps from the single source of truth: MorseDictionary
        java.util.Map<String, java.util.Set<String>> collisions = new java.util.LinkedHashMap<>();

        for (MorseDictionary.Entry entry : MorseDictionary.ENTRIES) {
            if (entry.code != null) {
                MORSE_TABLE.put(entry.name, entry.code);
                if (!entry.code.equals(" ")) {
                    collisions.computeIfAbsent(entry.code, k -> new java.util.LinkedHashSet<>()).add(entry.name);
                }
            }
        }

        // Add space mapping manually (not in dictionary to avoid showing in UI table)
        MORSE_TABLE.put(" ", " ");

        // Build REVERSE_MORSE from collected collisions
        for (java.util.Map.Entry<String, java.util.Set<String>> entry : collisions.entrySet()) {
            String code = entry.getKey();
            java.util.List<String> names = new java.util.ArrayList<>(entry.getValue());

            // Sort: prosigns (multi-char) first, then alphabetical
            java.util.Collections.sort(names, (a, b) -> {
                if (a.length() != b.length()) return b.length() - a.length();
                return a.compareTo(b);
            });

            if (names.size() > 1) {
                COLLISIONS.put(code, names);
                REVERSE_MORSE.put(code, formatCombined(names));
            } else {
                REVERSE_MORSE.put(code, formatSymbol(names.get(0)));
            }
        }
    }

    public static String formatSymbol(String name) {
        if (name.length() > 1) {
            return "<" + name + ">";
        }
        return name;
    }

    public static String formatCombined(java.util.List<String> names) {
        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < names.size(); i++) {
            if (i > 0) sb.append("/");
            sb.append(names.get(i));
        }
        sb.append(">");
        return sb.toString();
    }



    /**
     * Lookup a morse code pattern and return the character.
     * Returns "[?]" if the code is not recognized.
     */
    public static String lookup(String code) {
        if (code == null || code.isEmpty()) return "";
        String result = REVERSE_MORSE.get(code);
        return result != null ? result : "[?]";
    }
}
