package com.company.controller.impl;

import com.company.model.Email;
import com.company.model.PhoneNumber;
import com.company.model.User;
import com.company.screen.StartScreen;
import com.company.service.ContactService;

public class UserControllerImpl {

    public void add(User user){
        ContactService contact = new ContactService();
        contact.add(user);
        StartScreen startScreen = new StartScreen();
        startScreen.alertMessage("/New contact successfully added/");
    }

    public void editName(String name, User user){
        user.setName(name);
        StartScreen startScreen = new StartScreen();
        startScreen.alertMessage("/ Name successfully edited /");
    }

    public void editCompany(String company, User user){
        user.setCompany(company);
        StartScreen startScreen = new StartScreen();
        startScreen.alertMessage("/ Company successfully edited /");
    }

    public void editPhoneNumber(String phoneNumber, User user){
        StartScreen startScreen = new StartScreen();
        PhoneNumber number = user.getPhoneNumbers().get(0);
        number.setPhoneNumber(phoneNumber);
        startScreen.alertMessage("/ Phone number successfully edited /");
    }

    public void editEmail(String newEmail, User user){
        StartScreen startScreen = new StartScreen();
        Email email = user.getEmails().get(0);
        email.setEmail(newEmail);
        startScreen.alertMessage("/ Email number successfully edited /");
    }



}
