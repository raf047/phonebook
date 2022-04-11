package com.company.screen;

import com.company.controller.ContactController;
import com.company.service.ContactService;
import com.company.validator.UserValidator;

public class DeleteByNameScreen extends Screen {
    @Override
    public void process() {
        System.out.println("Delete by name");
        while (true) {
            System.out.println("Enter name");
            UserValidator userValidator = new UserValidator();
            String name = getStringFromUser();
            while (!userValidator.isValidName(name)) {
                System.out.println("Wrong input! Please enter valid name");
                name = getStringFromUser();
            }
            if (!ContactService.isExist(name)) {
                System.out.println("Contact not exist! ");
                while (true) {
                    System.out.println("There are no number whit " + name + "\n" +
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
                continue;
            }

            ContactController contactController = new ContactController();
            contactController.deleteByName(name);
            break;
        }
    }
}
