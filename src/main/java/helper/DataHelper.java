package helper;

import java.util.regex.Pattern;

public class DataHelper {
    public boolean regexValidate(String input, String regexPattern) {
        return Pattern.compile(regexPattern).matcher(input).matches();
    }
}
