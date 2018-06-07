package com.codecool.timer;

import java.util.List;
import java.util.Scanner;

public class TimerConsoleView implements TimerView {

    @Override
    public String getCommand() {
        System.out.print("Enter command (or 'c' to show all possible commands'): ");
        return new Scanner(System.in).nextLine();
    }

    @Override
    public void displayPossibleOptions() {
        System.out.println("\nPossible commands: " +
                "\n- 'start -timername-' to start new timer" +
                "\n- 'stop -timername-' to stop a timer " +
                "\n- 'check' to display all timers" +
                "\n- 'check -timername-' to check specific timer" +
                "\n- 'exit' to finish\n");
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
