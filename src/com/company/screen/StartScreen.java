package com.company.screen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartScreen extends Screen {
    @Override
    public void process() {
        boolean isRunning = true;
        while (isRunning){
            System.out.println("Contacts");
            System.out.println("1. Search \n" +
                               "2. Add contact \n" +
                               "3. Edit contact \n" +
                               "4. Delete contact \n" +
                               "5. See contacts");

            String i = getStringFromUser();

            Screen screen = ScreenFactory.getScreen(i);
            if (screen == null){
                System.out.println("Wrong input! Please enter valid command");
            }else {
                screen.process();
                isRunning = false;
            }
        }
    }

    public void alertMessage(String message){
        System.out.println(message);
        process();
    }

    public void test(){
        String str = getStringFromUser();

        String allCountryRegex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";

        Pattern pattern = Pattern.compile(allCountryRegex);
            Matcher matcher = pattern.matcher(str);
            System.out.println((matcher.matches()));
    }
}
