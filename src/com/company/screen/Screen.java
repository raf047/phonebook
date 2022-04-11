package com.company.screen;

import java.util.Scanner;

public abstract class Screen {
    private static Scanner scanner = new Scanner(System.in);

    protected int getIntegerFromUser() {
        return scanner.nextInt();
    }

    protected String getStringFromUser() {
        return scanner.nextLine();
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public abstract void process();
}
