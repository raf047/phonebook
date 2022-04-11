package com.company.model;

import java.util.HashMap;
import java.util.Map;

public enum PhoneNumberType {
    Work(1, "Work"),
    Mobile(2, "Mobile"),
    Home(3, "Home"),
    School(4, "School");
    private static final Map<Integer, PhoneNumberType> phoneNumberType = new HashMap<>();

    static {
        for (PhoneNumberType type : PhoneNumberType.values()) {
            phoneNumberType.put(type.getCode(), type);
        }
    }

    private final int code;
    private final String name;

    PhoneNumberType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static PhoneNumberType getId(int id) {
        return phoneNumberType.get(id);
    }
}
