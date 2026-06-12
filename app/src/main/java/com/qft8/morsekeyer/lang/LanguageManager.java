package com.qft8.morsekeyer.lang;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class LanguageManager {

    private static final Map<String, MorseLanguage> LANGUAGES = new LinkedHashMap<>();
    private static final Map<String, String> NAMES = new LinkedHashMap<>();
    private static MorseLanguage current;
    private static String currentKey;

    static {
        register("az", new LangAz(), "Azərbaycanca");
        register("id", new LangId(), "Bahasa Indonesia");
        register("jv", new LangJv(), "Basa Jawa");
        register("su", new LangSu(), "Basa Sunda");
        register("ca", new LangCa(), "Català");
        register("de", new LangDe(), "Deutsch");
        register("en", new LangEn(), "English");
        register("es", new LangEs(), "Español");
        register("eo", new LangEo(), "Esperanto");
        register("eu", new LangEu(), "Euskara");
        register("fr", new LangFr(), "Français");
        register("gl", new LangGl(), "Galego");
        register("ha", new LangHa(), "Hausa");
        register("it", new LangIt(), "Italiano");
        register("sw", new LangSw(), "Kiswahili");
        register("hu", new LangHu(), "Magyar");
        register("pcm", new LangPcm(), "Naijá (Pidgin)");
        register("uz", new LangUz(), "O'zbek");
        register("pl", new LangPl(), "Polski");
        register("pt", new LangPt(), "Português");
        register("ro", new LangRo(), "Română");
        register("fi", new LangFi(), "Suomi");
        register("sv", new LangSv(), "Svenska");
        register("tl", new LangTl(), "Tagalog");
        register("vi", new LangVi(), "Tiếng Việt");
        register("tr", new LangTr(), "Türkçe");
        register("yo", new LangYo(), "Yorùbá");
        register("cs", new LangCs(), "Čeština");
        register("ru", new LangRu(), "Русский");
        register("uk", new LangUk(), "Українська");
        register("ur", new LangUr(), "اردو");
        register("arq", new LangArq(), "العربية (الجزائرية)");
        register("apd", new LangApd(), "العربية (السودانية)");
        register("apc", new LangApc(), "العربية (الشامية)");
        register("ar", new LangAr(), "العربية (العظمى)");
        register("ary", new LangAry(), "العربية (المغربية)");
        register("arz", new LangArz(), "العربية (مصر)");
        register("fa", new LangFa(), "فارسی");
        register("bho", new LangBho(), "भोजपुरी");
        register("mr", new LangMr(), "मराठी");
        register("hi", new LangHi(), "हिन्दी");
        register("bn", new LangBn(), "বাংলা");
        register("pa", new LangPa(), "ਪੰਜਾਬੀ (ਪੂਰਬੀ)");
        register("gu", new LangGu(), "ગુજરાતી");
        register("or", new LangOr(), "ଓଡ଼ିଆ");
        register("ta", new LangTa(), "தமிழ்");
        register("te", new LangTe(), "తెలుగు");
        register("kn", new LangKn(), "ಕನ್ನಡ");
        register("ml", new LangMl(), "മലയാളം");
        register("th", new LangTh(), "ไทย");
        register("my", new LangMy(), "မြန်မာစာ");
        register("am", new LangAm(), "አማርኛ");
        register("zh", new LangZh(), "中文 (普通话)");
        register("wuu", new LangWuu(), "吳語 (上海話)");
        register("ja", new LangJa(), "日本語");
        register("yue", new LangYue(), "粵語 (廣東話)");
        register("ko", new LangKo(), "한국어");
    }

    public static void register(String key, MorseLanguage lang, String nativeName) {
        LANGUAGES.put(key, lang);
        NAMES.put(key, nativeName);
    }

    public static void init(String setting) {
        if ("system".equals(setting)) {
            String sys = Locale.getDefault().getLanguage();
            if (LANGUAGES.containsKey(sys)) {
                currentKey = sys;
            } else {
                currentKey = "en";
            }
        } else {
            currentKey = LANGUAGES.containsKey(setting) ? setting : "en";
        }
        current = LANGUAGES.get(currentKey);
    }

    public static String get(String key) {
        if (current == null) init("system");
        return current.get(key);
    }

    public static final String KOCH_METHOD = "KOCH_METHOD";
    public static final String CONTINUE = "CONTINUE";

    public static Map<String, String> getAvailableLanguages() {
        return NAMES;
    }

    public static java.util.List<Map.Entry<String, String>> getSortedLanguages(java.util.Set<String> excludeKeys) {
        java.util.List<Map.Entry<String, String>> list = new java.util.ArrayList<>();
        for (Map.Entry<String, String> entry : NAMES.entrySet()) {
            if (excludeKeys == null || !excludeKeys.contains(entry.getKey())) {
                list.add(entry);
            }
        }
        java.util.Collections.sort(list, new java.util.Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> a, Map.Entry<String, String> b) {
                return a.getValue().compareToIgnoreCase(b.getValue());
            }
        });
        return list;
    }

    public static String getCurrentKey() {
        return currentKey;
    }
    }