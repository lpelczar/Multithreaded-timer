package com.codecool.timer;

import java.util.List;
import java.util.Scanner;

public class TimerConsoleView implements TimerView {

    @Override
    public String getCommand() {
        System.out.println("Enter command.");
        return new Scanner(System.in).nextLine();
    }

    @Override
    public void displayTimersData(List<Timer> timers) {
        for (Timer timer : timers) {
            System.out.println(timer);
        }
    }

    @Override
    public void displayWrongInputError() {
        System.out.println("Wrong input. Try again!");
    }
}
