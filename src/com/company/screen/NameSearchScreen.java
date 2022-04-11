package com.company.screen;

import com.company.controller.ContactController;
import com.company.model.User;
import com.company.validator.UserValidator;

import java.util.Scanner;

public class NameSearchScreen extends Screen {
    @Override
    public void process() {
        System.out.println("Search by name");
        System.out.println("Enter name");
        UserValidator userValidator = new UserValidator();
        String name = getStringFromUser();
        while (!userValidator.isValidName(name)) {
            System.out.println("Wrong input! Please enter valid name");
            name = getStringFromUser();
        }
        ContactController contactController = new ContactController();
        User user = contactController.searchByName(name);
        StartScreen startScreen = new StartScreen();
        if (user == null) {
            while (true) {
                System.out.println("There are no number whit " + name + "\n" +
                                   "1. Continue searching \n" +
                                   "2. Exit");
                String command = getStringFromUser();
                if (command.equals("1")) {
                    break;
                } else if (command.equals("2")) {
                    startScreen.process();
                }
            }
        } else {
            System.out.println(user);
        }
        startScreen.process();
    }

    public void alertMessage(String message) {
        System.out.println(message);
        process();
    }
}
