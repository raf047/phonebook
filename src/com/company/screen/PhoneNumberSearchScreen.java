package com.company.screen;

import com.company.controller.ContactController;
import com.company.model.User;
import com.company.validator.UserValidator;

import java.util.ArrayList;

public class PhoneNumberSearchScreen extends Screen {
    @Override
    public void process() {
        System.out.println("Search by phone number");
        while (true) {
            System.out.println("Enter phone number");
            UserValidator userValidator = new UserValidator();
            String phoneNumber = getStringFromUser();
            while (!userValidator.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Wrong input! Please enter valid phoneNumber");
                phoneNumber = getStringFromUser();
            }

            ContactController contactController = new ContactController();
            ArrayList<User> users = contactController.searchByPhoneNumber(phoneNumber);
            if (users.isEmpty()) {
                while (true) {
                    System.out.println("There are no number whit " + phoneNumber + "\n" +
                                       "1. Continue searching \n" +
                                       "2. Exit");
                    String command = getStringFromUser();
                    if (command.equals("1")) {
                        break;
                    } else if (command.equals("2")) {
                        StartScreen startScreen = new StartScreen();
                        startScreen.process();
                    }
                }
            } else {
                for (User user : users) {
                    System.out.println(user);
                }
            }
            StartScreen startScreen = new StartScreen();
            startScreen.process();
        }
    }
}
