package com.company.screen;

public class ScreenFactory {
    public static Screen getScreen(String i){
        Screen screen = null;
        switch (i){
            case "1":
                screen = new SearchScreen();
                break;
            case "2":
                screen = new AddScreen();
                break;
            case "3":
                screen = new EditScreen();
                break;
            case "4":
                screen = new DeleteScreen();
                break;
            case "5":
                screen = new ShowContactsScreen();
                break;
        }
        return screen;
    }
}
