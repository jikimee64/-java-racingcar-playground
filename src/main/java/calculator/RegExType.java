package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegExType {
    DEFAULT("//(.)\n(.*)");

    private final String pattern;

    RegExType(String pattern) {
        this.pattern = pattern;
    }

    public static boolean validate(RegExType type, String text) {
        RegExType regExType = Arrays.stream(RegExType.values())
            .filter(regEx -> regEx.equals(type))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);

        Pattern pattern = Pattern.compile(regExType.getPattern());
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public String getPattern() {
        return pattern;
    }
}
