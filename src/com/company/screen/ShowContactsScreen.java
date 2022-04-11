package com.company.screen;

import com.company.controller.ContactController;

public class ShowContactsScreen extends Screen {
    @Override
    public void process() {
        System.out.println("Contacts list");
        ContactController contactController = new ContactController();
        contactController.show();
        StartScreen startScreen = new StartScreen();
        startScreen.process();
    }
}
