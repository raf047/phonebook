package com.company.screen;

public class SearchScreen extends Screen {
    @Override
    public void process() {
        while (true){
            System.out.println("Search \n" +
                               "1. Search by name \n" +
                               "2. Search by phone number");

            String i = getStringFromUser();
            if (i.equals("1")){
                NameSearchScreen userNameSearchScreen = new NameSearchScreen();
                userNameSearchScreen.process();
                break;
            } else if (i.equals("2")){
                PhoneNumberSearchScreen phoneNumberSearchScreen = new PhoneNumberSearchScreen();
                phoneNumberSearchScreen.process();
                break;
            }else {
                System.out.println("Wrong input! Please enter valid number");
            }
        }
    }
}
