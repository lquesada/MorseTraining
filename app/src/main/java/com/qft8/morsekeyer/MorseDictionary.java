package com.qft8.morsekeyer;

import java.util.*;

/**
 * Single source of truth for all Morse code mappings, categories, and descriptions.
 * Used by the decoder, the UI reference table, and tests.
 */
public class MorseDictionary {

    public static class Entry {
        public final String name;
        public final String code;        // null for abbreviations without special timing
        public final String category;
        public final String description; // null for simple characters

        public Entry(String name, String code, String category, String description) {
            this.name = name;
            this.code = code;
            this.category = category;
            this.description = description;
        }
    }

    public static final List<Entry> ENTRIES = new ArrayList<>();

    // Category names
    public static final String CAT_LETTERS = "LETTERS";
    public static final String CAT_NUMBERS = "NUMBERS";
    public static final String CAT_SYMBOLS = "SYMBOLS";
    public static final String CAT_SPECIAL_SYMBOLS = "SPECIAL SYMBOLS";
    public static final String CAT_SPECIAL = "SPECIAL LETTERS";
    public static final String CAT_PROSIGNS_COMMON = "COMMON PROCEDURAL SIGNALS";
    public static final String CAT_ABBREVIATIONS = "COMMON ABBREVIATIONS";
    public static final String CAT_QCODES = "Q CODES";
    public static final String CAT_PROSIGNS_OTHER = "OTHER PROCEDURAL SIGNALS";

    public static String getCategoryName(String cat) {
        switch (cat) {
            case CAT_LETTERS: return com.qft8.morsekeyer.lang.LanguageManager.get(com.qft8.morsekeyer.lang.MorseLanguage.CAT_LETTERS);
            case CAT_NUMBERS: return com.qft8.morsekeyer.lang.LanguageManager.get(com.qft8.morsekeyer.lang.MorseLanguage.CAT_NUMBERS);
            case CAT_SYMBOLS: return com.qft8.morsekeyer.lang.LanguageManager.get(com.qft8.morsekeyer.lang.MorseLanguage.CAT_SYMBOLS);
            case CAT_SPECIAL_SYMBOLS: return com.qft8.morsekeyer.lang.LanguageManager.get(com.qft8.morsekeyer.lang.MorseLanguage.CAT_SPECIAL_SYMBOLS);
            case CAT_SPECIAL: return com.qft8.morsekeyer.lang.LanguageManager.get(com.qft8.morsekeyer.lang.MorseLanguage.CAT_SPECIAL);
            case CAT_PROSIGNS_COMMON: return com.qft8.morsekeyer.lang.LanguageManager.get(com.qft8.morsekeyer.lang.MorseLanguage.CAT_PROSIGNS_COMMON);
            case CAT_ABBREVIATIONS: return com.qft8.morsekeyer.lang.LanguageManager.get(com.qft8.morsekeyer.lang.MorseLanguage.CAT_ABBREVIATIONS);
            case CAT_QCODES: return com.qft8.morsekeyer.lang.LanguageManager.get(com.qft8.morsekeyer.lang.MorseLanguage.CAT_QCODES);
            case CAT_PROSIGNS_OTHER: return com.qft8.morsekeyer.lang.LanguageManager.get(com.qft8.morsekeyer.lang.MorseLanguage.CAT_PROSIGNS_OTHER);
            default: return cat;
        }
    }

    static {
        // LETTERS
        add("A", ".-", CAT_LETTERS);
        add("B", "-...", CAT_LETTERS);
        add("C", "-.-.", CAT_LETTERS);
        add("D", "-..", CAT_LETTERS);
        add("E", ".", CAT_LETTERS);
        add("F", "..-.", CAT_LETTERS);
        add("G", "--.", CAT_LETTERS);
        add("H", "....", CAT_LETTERS);
        add("I", "..", CAT_LETTERS);
        add("J", ".---", CAT_LETTERS);
        add("K", "-.-", CAT_LETTERS);
        add("L", ".-..", CAT_LETTERS);
        add("M", "--", CAT_LETTERS);
        add("N", "-.", CAT_LETTERS);
        add("O", "---", CAT_LETTERS);
        add("P", ".--.", CAT_LETTERS);
        add("Q", "--.-", CAT_LETTERS);
        add("R", ".-.", CAT_LETTERS);
        add("S", "...", CAT_LETTERS);
        add("T", "-", CAT_LETTERS);
        add("U", "..-", CAT_LETTERS);
        add("V", "...-", CAT_LETTERS);
        add("W", ".--", CAT_LETTERS);
        add("X", "-..-", CAT_LETTERS);
        add("Y", "-.--", CAT_LETTERS);
        add("Z", "--..", CAT_LETTERS);

        // NUMBERS
        add("0", "-----", CAT_NUMBERS);
        add("1", ".----", CAT_NUMBERS);
        add("2", "..---", CAT_NUMBERS);
        add("3", "...--", CAT_NUMBERS);
        add("4", "....-", CAT_NUMBERS);
        add("5", ".....", CAT_NUMBERS);
        add("6", "-....", CAT_NUMBERS);
        add("7", "--...", CAT_NUMBERS);
        add("8", "---..", CAT_NUMBERS);
        add("9", "----.", CAT_NUMBERS);

        // SYMBOLS (Standard ITU-R M.1677-1)
        add("?", "..--..", CAT_SYMBOLS);
        add(".", ".-.-.-", CAT_SYMBOLS);
        add(",", "--..--", CAT_SYMBOLS);
        add(":", "---...", CAT_SYMBOLS);
        add("'", ".----.", CAT_SYMBOLS);
        add("-", "-....-", CAT_SYMBOLS);
        add("/", "-..-.", CAT_SYMBOLS);
        add("\"", ".-..-.", CAT_SYMBOLS);
        add("=", "-...-", CAT_SYMBOLS);
        add("+", ".-.-.", CAT_SYMBOLS);
        add("@", ".--.-.", CAT_SYMBOLS);

        // SPECIAL SYMBOLS (Extended / Non-standard ITU)
        add("!", "-.-.--", CAT_SPECIAL_SYMBOLS);
        add(";", "-.-.-.", CAT_SPECIAL_SYMBOLS);
        add("&", ".-...", CAT_SPECIAL_SYMBOLS);
        add("$", "...-..-", CAT_SPECIAL_SYMBOLS);
        add("_", "..--.-", CAT_SPECIAL_SYMBOLS);
        add("(", "-.--.", CAT_SPECIAL_SYMBOLS);
        add(")", "-.--.-", CAT_SPECIAL_SYMBOLS);


        // SPECIAL LETTERS
        add("\u0104", ".-.-", CAT_SPECIAL);   // Ą
        add("\u00C0", ".-..-", CAT_SPECIAL);  // À
        add("\u00C5", ".-.--", CAT_SPECIAL);  // Å
        add("\u00C4", ".-.-", CAT_SPECIAL);   // Ä
        add("\u00C6", ".-.-", CAT_SPECIAL);   // Æ
        add("\u00C9", "..-..", CAT_SPECIAL);  // É
        add("\u00C8", ".-..-", CAT_SPECIAL);  // È
        add("\u0118", "..-..", CAT_SPECIAL);  // Ę
        add("\u00D3", "---.", CAT_SPECIAL);   // Ó
        add("\u00D6", "---.", CAT_SPECIAL);   // Ö
        add("\u00DC", "..--", CAT_SPECIAL);   // Ü
        add("\u0106", "-.-..", CAT_SPECIAL);  // Ć
        add("\u00C7", "-.-..", CAT_SPECIAL);  // Ç
        add("\u0141", ".-..-", CAT_SPECIAL);  // Ł
        add("\u0143", "--.--", CAT_SPECIAL);  // Ń
        add("\u00D1", "--.--", CAT_SPECIAL);  // Ñ
        add("\u015A", "...-...", CAT_SPECIAL); // Ś
        add("\u0160", "----", CAT_SPECIAL);   // Š
        add("\u0179", "--..-.", CAT_SPECIAL); // Ź
        add("\u017B", "--..-", CAT_SPECIAL);  // Ż
        add("\u00DF", "...--..", CAT_SPECIAL); // ß
        add("CH", "----", CAT_SPECIAL);       // CH

        // COMMON PROCEDURAL SIGNALS
        add("AR", ".-.-.", CAT_PROSIGNS_COMMON, "OUT \u2014 End of message. Commonly used to mark the conclusion of a transmission.");
        add("AS", ".-...", CAT_PROSIGNS_COMMON, "WAIT \u2014 Wait or stand by. Used to request the other station to pause.");
        add("BK", "-...-.-", CAT_PROSIGNS_COMMON, "BREAK-IN \u2014 Break. Interrupt a transmission already in progress.");
        add("BT", "-...-", CAT_PROSIGNS_COMMON, "BREAK \u2014 Paragraph break. Used to separate parts of a message.");
        add("HH", "........", CAT_PROSIGNS_COMMON, "CORRECTION \u2014 Error or correction. Used to indicate a mistake was made.");
        add("KN", "-.--.", CAT_PROSIGNS_COMMON, "GO AHEAD \u2014 Invitation to transmit, used in directed communication.");
        add("SK", "...-.-", CAT_PROSIGNS_COMMON, "END CONTACT \u2014 End of contact. Often used as a polite sign-off.");
        add("VA", "...-.-", CAT_PROSIGNS_COMMON, "END CONTACT \u2014 End of contact. (Same as SK).");

        // COMMON ABBREVIATIONS
        addAbbr("73", "BEST REGARDS \u2014 Friendly sign-off.");
        addAbbr("C", "YES / CORRECT \u2014 Affirmative response.");
        addAbbr("N", "NO / NEGATIVE \u2014 Negative response.");
        addAbbr("K", "OVER \u2014 Invitation to respond.");
        addAbbr("R", "ROGER \u2014 Message received.");
        addAbbr("?", "SAY AGAIN \u2014 Request for repetition.");
        addAbbr("AA", "ALL AFTER \u2014 Resend everything after [word].");
        addAbbr("AB", "ALL BEFORE \u2014 Resend everything before [word].");
        addAbbr("AGN", "AGAIN \u2014 Repeat.");
        addAbbr("ANT", "ANTENNA \u2014 Aerial equipment.");
        addAbbr("BN", "BETWEEN \u2014 Information between two points of a message.");
        addAbbr("CS ?", "CALLSIGN QUERY \u2014 Request for callsign.");
        addAbbr("CS _", "CALLSIGN FOLLOWS \u2014 Identifying station is next.");
        addAbbr("CL", "CLOSING DOWN \u2014 Ending transmission.");
        addAbbr("CFM ?", "CONFIRM \u2014 Request for confirmation or acknowledgment.");
        addAbbr("CFM _", "CONFIRM \u2014 Confirmation of receipt or understanding.");
        addAbbr("CP", "CLOSE PROXIMITY \u2014 Short distance.");
        addAbbr("CQ", "CALLING ALL STATIONS \u2014 General call.");
        addAbbr("DX", "DISTANCE \u2014 Long-distance communication.");
        addAbbr("FER", "FOR \u2014 Indicates purpose or intention.");
        addAbbr("GA", "GOOD AFTERNOON \u2014 Greeting.");
        addAbbr("GB", "GOOD BYE \u2014 Farewell.");
        addAbbr("GE", "GOOD EVENING \u2014 Greeting.");
        addAbbr("GL", "GOOD LUCK \u2014 Best wishes.");
        addAbbr("GM", "GOOD MORNING \u2014 Greeting.");
        addAbbr("GUD", "GOOD \u2014 Positive acknowledgement.");
        addAbbr("HR", "HERE \u2014 Current location.");
        addAbbr("NIL", "NOTHING TO FOLLOW \u2014 No further traffic.");
        addAbbr("OM", "OLD MAN \u2014 Friendly term for a male operator.");
        addAbbr("OP", "OPERATOR \u2014 The person operating the station.");
        addAbbr("PSE", "PLEASE \u2014 Polite request.");
        addAbbr("RX", "RECEIVER \u2014 Receiving equipment.");
        addAbbr("RPT", "REPEAT \u2014 Request to repeat.");
        addAbbr("RIG", "RADIO EQUIPMENT \u2014 Transmitter and receiver gear.");
        addAbbr("RST", "SIGNAL REPORT \u2014 RST format (Readability, Strength, Tone).");
        addAbbr("TU", "THANK YOU \u2014 Expression of gratitude.");
        addAbbr("TNX", "THANKS \u2014 Informal thanks.");
        addAbbr("TX", "TRANSMITTER \u2014 Sending equipment.");
        addAbbr("UR", "YOUR \u2014 Belonging to you.");
        addAbbr("WX", "WEATHER IS \u2014 Weather information follows.");
        addAbbr("WA", "WORK ALL \u2014 Communicate with all stations.");
        addAbbr("WB", "WORK BOTH \u2014 Communicate with both stations.");
        addAbbr("YL", "YOUNG LADY \u2014 Friendly term for a female operator.");
        addAbbr("ZWF", "WRONG \u2014 Your last transmission was wrong. The correct version is.");
        addAbbr("88", "LOVE AND KISSES \u2014 Affectionate sign-off.");
        addAbbr("99", "GO TO HELL \u2014 Humorous/sarcastic sign-off.");

        // Q CODES
        addQ("QRA ?", "What is the name of your station?");
        addQ("QRA _", "The name of my station is...");
        addQ("QRB ?", "How far are you from my station?");
        addQ("QRB _", "The distance between our stations is... km.");
        addQ("QRC ?", "What is your bearing from me?");
        addQ("QRC _", "Your bearing from me is... degrees.");
        addQ("QRG ?", "Is my frequency correct?");
        addQ("QRG _", "Your frequency is...");
        addQ("QRH ?", "Does my frequency vary?");
        addQ("QRH _", "Your frequency varies.");
        addQ("QRI ?", "How is the tone of my transmission?");
        addQ("QRI _", "The tone of your transmission is... (1\u20133).");
        addQ("QRJ ?", "Are you receiving me badly?");
        addQ("QRJ _", "I am receiving you badly.");
        addQ("QRK ?", "What is my signal readability?");
        addQ("QRK _", "Your signal readability is... (1\u20135).");
        addQ("QRL ?", "Are you busy?");
        addQ("QRL _", "I am busy.");
        addQ("QRM ?", "Are you being interfered with?");
        addQ("QRM _", "I am being interfered with.");
        addQ("QRN ?", "Are you troubled by static?");
        addQ("QRN _", "I am troubled by static.");
        addQ("QRO ?", "Shall I increase power?");
        addQ("QRO _", "Increase power.");
        addQ("QRP ?", "Shall I decrease power?");
        addQ("QRP _", "Decrease power.");
        addQ("QRQ ?", "Shall I call you again?");
        addQ("QRQ _", "Call me again.");
        addQ("QRS ?", "Shall I send more slowly?");
        addQ("QRS _", "Send more slowly.");
        addQ("QRT ?", "Shall I stop sending?");
        addQ("QRT _", "I am stopping transmission.");
        addQ("QRU ?", "Shall I stand by?");
        addQ("QRU _", "I have nothing more to send.");
        addQ("QRV ?", "Are you ready?");
        addQ("QRV _", "I am ready.");
        addQ("QRX ?", "Shall I wait?");
        addQ("QRX _", "Wait.");
        addQ("QRY ?", "Are you troubled by my transmission?");
        addQ("QRY _", "You are causing interference.");
        addQ("QTH ?", "What is your location?");
        addQ("QTH _", "My location is...");
        addQ("QSL ?", "Can you acknowledge receipt?");
        addQ("QSL _", "I acknowledge receipt.");
        addQ("QTR ?", "What is the correct time?");
        addQ("QTR _", "The time is...");
        addQ("QWX ?", "What is the weather like?");
        addQ("QWX _", "The weather is...");

        // OTHER PROCEDURAL SIGNALS
        add("CL", "-.-..-..", CAT_PROSIGNS_OTHER, "CLOSING \u2014 Indicates the operator is leaving or going off the air.");
        add("CT", "-.-.-", CAT_PROSIGNS_OTHER, "ATTENTION \u2014 Start of message or alert.");
        add("DDD", "-..-..-..", CAT_PROSIGNS_OTHER, "DISTRESS RELAY \u2014 Start of a distress signal relayed from another station.");
        add("DO", "-..---", CAT_PROSIGNS_OTHER, "RESUME \u2014 Resume transmission after a break.");
        add("INT", "..-.-", CAT_PROSIGNS_OTHER, "INTERROGATE \u2014 What is your intention? Request for clarification.");
        add("KA", "-.-.-", CAT_PROSIGNS_OTHER, "START MESSAGE \u2014 Often used to precede formal traffic.");
        add("NJ", "-..---", CAT_PROSIGNS_OTHER, "CHECK KEY \u2014 Check your key / Change to 5-figure groups.");
        add("SN", "...-.", CAT_PROSIGNS_OTHER, "ROGER \u2014 Message received or understood.");
        add("SOS", "...---...", CAT_PROSIGNS_OTHER, "DISTRESS \u2014 Emergency signal (international).");
        add("VE", "...-.", CAT_PROSIGNS_OTHER, "ROGER \u2014 Confirmation or receipt of message.");
        add("AA", ".-.-", CAT_PROSIGNS_OTHER, "NEW LINE \u2014 New line or unknown station.");
    }

    private static void add(String name, String code, String cat) {
        ENTRIES.add(new Entry(name, code, cat, null));
    }

    private static void add(String name, String code, String cat, String desc) {
        ENTRIES.add(new Entry(name, code, cat, desc));
    }

    private static void addAbbr(String name, String desc) {
        ENTRIES.add(new Entry(name, null, CAT_ABBREVIATIONS, desc));
    }

    private static void addQ(String name, String desc) {
        ENTRIES.add(new Entry(name, null, CAT_QCODES, desc));
    }
}
