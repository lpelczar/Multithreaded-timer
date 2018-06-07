package com.codecool.timer;

public class App {

    public static void main(String[] args) {

        TimerView timerView = new TimerConsoleView();
        TimerController timerController = new TimerController(timerView);
        timerController.start();
    }
}
