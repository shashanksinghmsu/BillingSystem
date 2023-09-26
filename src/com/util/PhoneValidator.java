
package com.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {
    private Pattern pattern;
    private Matcher matcher;
    private static final String PHONE_REGEX = "^(\\+91|0)?[789]\\d{9}$";

    public PhoneValidator() {
        pattern = Pattern.compile(PHONE_REGEX);
    }

    public boolean validate(final String phone) {
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}

