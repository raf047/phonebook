package com.company.screen;

import com.company.controller.impl.UserControllerImpl;
import com.company.model.Email;
import com.company.model.PhoneNumber;
import com.company.model.PhoneNumberType;
import com.company.model.User;
import com.company.service.ContactService;
import com.company.validator.UserValidator;

import java.util.ArrayList;

public class AddScreen extends Screen {
    @Override
    public void process() {
        while (true) {
            System.out.println("Add new contact");

            System.out.println("Input name");
            String name = getValidName();
            if (ContactService.isExist(name)) {
                System.out.println("Contact already exist! ");
                continue;
            }

            ArrayList<PhoneNumber> phoneNumbers = getPhoneNumbers();

            System.out.println("Input company");
            String company = getValidCompany();

            ArrayList<Email> emails = getEmails();

            User newUser = new User(name, phoneNumbers, company, emails);
            UserControllerImpl userController = new UserControllerImpl();
            userController.add(newUser);
            break;
        }
    }


    public String getValidName() {
        UserValidator userValidator = new UserValidator();
        String name = getStringFromUser();
        while (!userValidator.isValidName(name)) {
            System.out.println("Wrong input! Please enter valid name");
            name = getStringFromUser();
        }

        return name;
    }

    private ArrayList<PhoneNumber> getPhoneNumbers() {
        ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
        boolean isRunning = true;
        String phoneNumber = getValidPhoneNumber();
        while (isRunning) {
            System.out.println("1. Enter phone number type \n" +
                               "2. Continue");
            String i = getStringFromUser();
            PhoneNumber number = new PhoneNumber(phoneNumber);
            if (i.equals("1")) {
                PhoneNumberType phoneNumberType = choosePhoneNumberType();
                number.setPhoneNumberType(phoneNumberType);
                while (true) {
                    System.out.println("1. Enter another phone number \n" +
                                       "2. Continue ");
                    String j = getStringFromUser();
                    if (j.equals("2")) {
                        isRunning = false;
                        break;
                    } else if (j.equals("1")) {
                        phoneNumber = getValidPhoneNumber();
                        break;
                    } else {
                        System.out.println("Wrong input! enter valid command");
                    }
                }

            } else if (i.equals("2")) {
                while (true) {
                    System.out.println("1. Enter another phone number \n" +
                                       "2. Continue ");
                    String k = getStringFromUser();
                    if (k.equals("2")) {
                        isRunning = false;
                        break;
                    } else if (k.equals("1")) {
                        phoneNumber = getValidPhoneNumber();
                        break;
                    } else {
                        System.out.println("Wrong input! enter valid command");
                    }
                }

            } else {
                System.out.println("Wrong input! enter valid command");
            }
            phoneNumbers.add(number);
        }
        return phoneNumbers;
    }

    public String getValidPhoneNumber() {
        UserValidator userValidator = new UserValidator();
        System.out.println("Enter phone number ");
        String number = getStringFromUser();
        while (!userValidator.isValidPhoneNumber(number)) {
            System.out.println("Wrong input! Please enter valid number");
            number = getStringFromUser();
        }

        return number;
    }

    public String getValidEmail() {
        UserValidator userValidator = new UserValidator();
        System.out.println("Enter email ");
        String email = getStringFromUser();
        while (!userValidator.isValidEmail(email)) {
            System.out.println("Wrong input! Please enter valid email");
            email = getStringFromUser();
        }

        return email;
    }

    public PhoneNumberType choosePhoneNumberType() {
        while (true) {
            System.out.println("Choose phone number type \n" +
                               "1. Work \n" +
                               "2. Mobile \n" +
                               "3. Home \n" +
                               "4. School ");

            String i = getStringFromUser();
            switch (i) {
                case "1":
                    return PhoneNumberType.Work;
                case "2":
                    return PhoneNumberType.Mobile;
                case "3":
                    return PhoneNumberType.Home;
                case "4":
                    return PhoneNumberType.School;
            }

            System.out.println("Wrong input! Please enter valid type");
        }
    }

    public String getValidEmailType() {
        UserValidator userValidator = new UserValidator();
        String emailType = getStringFromUser();
        while (!userValidator.isValidEmailType(emailType)) {
            System.out.println("Wrong input! Please enter valid email type");
            emailType = getStringFromUser();
        }

        return emailType;
    }

    public String getValidCompany() {
        UserValidator userValidator = new UserValidator();
        String company = getStringFromUser();
        while (!userValidator.isValidCompany(company)) {
            System.out.println("Wrong input! Please enter valid name");
            company = getStringFromUser();
        }

        return company;
    }

    private ArrayList<Email> getEmails() {
        ArrayList<Email> emails = new ArrayList<>();
        boolean isRunning = true;
        String newEmail = getValidEmail();
        while (isRunning) {
            System.out.println("1. Enter email type \n" +
                               "2. Continue");
            String i = getStringFromUser();
            Email email = new Email(newEmail);
            if (i.equals("1")) {
                String emailType = getValidEmailType();
                email.setEmailType(emailType);
                while (true) {
                    System.out.println("1. Enter another email \n" +
                                       "2. Continue ");
                    String j = getStringFromUser();
                    if (j.equals("2")) {
                        isRunning = false;
                        break;
                    } else if (j.equals("1")) {
                        newEmail = getValidEmail();
                        break;
                    } else {
                        System.out.println("Wrong input! enter valid command");
                    }
                }

            } else if (i.equals("2")) {
                while (true) {
                    System.out.println("1. Enter another email \n" +
                                       "2. Continue ");
                    String k = getStringFromUser();
                    if (k.equals("2")) {
                        isRunning = false;
                        break;
                    } else if (k.equals("1")) {
                        newEmail = getValidEmail();
                        break;
                    } else {
                        System.out.println("Wrong input! enter valid command");
                    }
                }
            }
            emails.add(email);
        }
        return emails;
    }

}
