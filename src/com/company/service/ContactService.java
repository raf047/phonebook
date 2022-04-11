package com.company.service;

import com.company.model.User;
import java.util.HashMap;


public class ContactService {
    public static HashMap<String, User> contacts = new HashMap<>();

    public void add(User user){
        contacts.put(user.getName(), user);
    }

    public static boolean isExist(String name){
        return ContactService.contacts.containsKey(name);
    }
}
