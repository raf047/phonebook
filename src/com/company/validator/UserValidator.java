package com.company.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public boolean isValidName(String name) {
        if (name == null || name.length() == 0) {
            return false;
        }
        int length = name.length();
        for (int i = 0; i < length; i++) {
            if (name.charAt(i) < 65 || name.charAt(i) > 122) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidPhoneNumber(String number) {
        String regex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return  (matcher.matches());
    }

    public boolean isValidCompany(String company){
        if (company == null || company.length() == 0) {
            return false;
        }
        return true;
    }

    public boolean isValidEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    public boolean isValidEmailType(String emailType){
        if (emailType == null || emailType.length() == 0) {
            return false;
        }
        return true;
    }
}
