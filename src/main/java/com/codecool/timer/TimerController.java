package com.codecool.timer;

class TimerController {

    private TimerView timerView;

    TimerController(TimerView timerView) {
        this.timerView = timerView;
    }

    void start() {
        String command;
        boolean isAppRunning = true;

        while (isAppRunning) {
            command = timerView.getCommand();

            if (command.trim().equalsIgnoreCase("exit")) {
                isAppRunning = false;
            } else if (command.trim().equalsIgnoreCase("check")) {
                // Print all timers data
            } else if (command.trim().toLowerCase().startsWith("check"))  {
                // Print specific timer data
            } else if (command.trim().toLowerCase().startsWith("stop")) {
                // Stop timer
            } else if (command.trim().toLowerCase().startsWith("start")) {
                // Start the timer
            }
        }
    }
}
