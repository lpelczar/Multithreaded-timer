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

    @Override
    public void displayNoSuchTimerError() {
        System.out.println("There is no timer with given name!");
    }

    @Override
    public void displayTimerWithThatNameIsAlreadyRunningError() {
        System.out.println("Timer with that name is already running!");
    }

    @Override
    public void displayTimerStartedMessage(String name) {
        System.out.println("Timer with name: " + name + " started again!");
    }
}
