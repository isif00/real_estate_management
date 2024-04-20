package isifoo.real_estate_management.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParser {
    public static String parse(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
