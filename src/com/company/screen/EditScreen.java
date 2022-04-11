package com.company.screen;

import com.company.controller.ContactController;
import com.company.controller.impl.UserControllerImpl;
import com.company.model.User;
import com.company.validator.UserValidator;

public class EditScreen extends Screen {
    @Override
    public void process() {
        System.out.println("Edit contact \n" +
                           "Search contact for editing");
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
            while (true) {
                System.out.println("1. Edit name \n" +
                                   "2. Edit phone number \n" +
                                   "3. Edit company \n" +
                                   "4. Edit email");
                String command = getStringFromUser();
                AddScreen addScreen = new AddScreen();
                UserControllerImpl userController = new UserControllerImpl();
                switch (command) {
                    case "1":
                        System.out.println("Enter new name");
                        String newName = addScreen.getValidName();
                        userController.editName(newName, user);
                        break;
                    case "2":
                        System.out.println("Enter new phone number");
                        String newNumber = addScreen.getValidPhoneNumber();
                        userController.editPhoneNumber(newNumber, user);
                        break;
                    case "3":
                        System.out.println("Enter new company");
                        String newCompany = addScreen.getValidCompany();
                        userController.editCompany(newCompany, user);
                        break;
                    case "4":
                        System.out.println("Enter new email");
                        String newEmail = addScreen.getValidEmail();
                        userController.editEmail(newEmail, user);
                        break;
                    default:
                        System.out.println("Enter valid command !");
                        continue;
                }
                break;
            }

        }
    }
}
