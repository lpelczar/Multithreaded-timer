package com.codecool.timer;

import java.util.ArrayList;
import java.util.List;

class TimerController {

    private TimerView timerView;
    private final List<Timer> timers = new ArrayList<>();
    private final List<Thread> threads = new ArrayList<>();

    TimerController(TimerView timerView) {
        this.timerView = timerView;
    }

    void start() {
        String command;
        boolean isAppRunning = true;

        while (isAppRunning) {
            command = timerView.getCommand();

            if (command.trim().equalsIgnoreCase(TimerCommand.EXIT.toString())) {
                isAppRunning = false;
            } else if (command.trim().equalsIgnoreCase(TimerCommand.CHECK.toString())) {
                timerView.displayTimersData(timers);
            } else if (command.trim().toLowerCase().startsWith(TimerCommand.CHECK.toString()))  {
            } else if (command.trim().toLowerCase().startsWith(TimerCommand.STOP.toString())) {
            } else if (command.trim().toLowerCase().startsWith(TimerCommand.START.toString())) {
                Timer timer = new Timer("blabla");
                Thread thread = new Thread(timer);
                threads.add(thread);
                timers.add(timer);
                thread.start();
            }
        }
    }
}
