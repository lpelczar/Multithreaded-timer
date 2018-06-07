package com.codecool.timer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                showTimerData(command);
            } else if (command.trim().toLowerCase().startsWith(TimerCommand.STOP.toString())) {
                stopTimer(command);
            } else if (command.trim().toLowerCase().startsWith(TimerCommand.START.toString())) {

                // Resume, there is a thread with given name, there is a active thread with given name
                startNewTimer(command);
            }
        }
        System.exit(0);
    }

    private void stopTimer(String command) {
        String commandValue = InputUtils.getCommandValue(command);
        if (commandValue == null || commandValue.isEmpty()) {
            timerView.displayWrongInputError();
            return;
        } else if (getTimersByName(commandValue).isEmpty()) {
            timerView.displayNoSuchTimerError();
            return;
        }

        List<Timer> timersList = getTimersByName(commandValue);
        for (Timer timer : timersList) {
            for (Thread thread : getThreadsByName(timer.getName())) {
                thread.interrupt();
            }
        }
    }

    private void showTimerData(String command) {
        String commandValue = InputUtils.getCommandValue(command);
        if (commandValue == null || commandValue.isEmpty()) {
            timerView.displayWrongInputError();
            return;
        }

        List<Timer> filteredTimers = getTimersByName(commandValue);
        timerView.displayTimersData(filteredTimers);
    }

    private List<Timer> getTimersByName(String name) {
        return timers.stream()
                .filter(x -> x.getName().toLowerCase().equals(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    private List<Thread> getThreadsByName(String name) {
        return threads.stream()
                .filter(x -> x.getName().toLowerCase().equals(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    private void startNewTimer(String command) {
        String commandValue = InputUtils.getCommandValue(command);
        if (commandValue == null || commandValue.isEmpty()) {
            timerView.displayWrongInputError();
            return;
        }

        Timer timer = new Timer(commandValue);
        Thread thread = new Thread(timer, commandValue);
        threads.add(thread);
        timers.add(timer);
        thread.start();
    }
}
