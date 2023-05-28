package Abominodo;

public abstract class LanguageSetting {
    public abstract String getMessage(int index);
}

class EnglishLanguageSetting extends LanguageSetting {
    private static String[] messages = {"Enter your name:", "Welcome", "Have a good time playing Abominodo"};

    public String getMessage(int index) {
        return messages[index];
    }
}

class KlingonLanguageSetting extends LanguageSetting {
    private static String[] messages = {"'el lIj pong:", "nuqneH", "QaQ poH Abominodo"};

    public String getMessage(int index) {
        return messages[index];
    }
}

class MultiLingualStringTable {
    private static LanguageSetting languageSetting = new EnglishLanguageSetting();

    public static void setLanguageSetting(LanguageSetting setting) {
        languageSetting = setting;
    }

    public static String getMessage(int index) {
        return languageSetting.getMessage(index);
    }
}

