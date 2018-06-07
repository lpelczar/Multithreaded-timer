package com.codecool.timer;

class TimerController {

    void start() {

        String command;
        boolean isAppRunning = true;

        while (isAppRunning) {
            timerView.clear();
            command = timerView.getCommand();

            if (command.trim().equalsIgnoreCase("exit")) {
                System.out.println("Bye bye!");
                System.exit(0);
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
