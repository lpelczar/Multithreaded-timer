package com.codecool.timer;

import java.util.Scanner;

public class TimerConsoleView implements TimerView {

    @Override
    public String getCommand() {
        System.out.println("Enter command.");
        return new Scanner(System.in).nextLine();
    }
}
