package com.company.controller;

import com.company.model.PhoneNumber;
import com.company.model.User;
import com.company.screen.StartScreen;
import com.company.service.ContactService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactController {

    public void show(){
        HashMap<String, User> contacts = ContactService.contacts;
        List<String> userNameList = new ArrayList<>();
        if (contacts.size() == 0) {
            System.out.println("Contacts list is empty! ");

        }
        for (Map.Entry<String, User> entry : contacts.entrySet()) {
            userNameList.add(entry.getKey());
        }

        for (String userName : userNameList) {
            System.out.println(contacts.get(userName));
        }

    }

    public ArrayList<User> searchByPhoneNumber(String phoneNumber){
        HashMap<String, User> contacts = ContactService.contacts;
        ArrayList<User> users = new ArrayList<>();

        for (Map.Entry<String, User> entry : contacts.entrySet()) {
            ArrayList<PhoneNumber> phoneNumbers = entry.getValue().getPhoneNumbers();
            for (PhoneNumber number: phoneNumbers) {
                if (number.getPhoneNumber().equals(phoneNumber)){
                    users.add(entry.getValue());
                }
            }
        }

        return users;
    }

    public User searchByName(String name){
        return ContactService.contacts.getOrDefault(name, null);
    }

    public void deleteByName(String name){
        User remove = ContactService.contacts.remove(name);
        System.out.println(remove);
        StartScreen startScreen = new StartScreen();
        startScreen.alertMessage("/ '" + name + "'" + " contact successfully deleted");
    }



}
