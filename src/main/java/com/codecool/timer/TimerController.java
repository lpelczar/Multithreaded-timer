package com.codecool.timer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

            if (command.trim().equalsIgnoreCase(TimerCommand.HINT.toString())) {
                timerView.displayPossibleOptions();
            } else if (command.trim().equalsIgnoreCase(TimerCommand.EXIT.toString())) {
                isAppRunning = false;
            } else if (command.trim().equalsIgnoreCase(TimerCommand.CHECK.toString())) {
                timerView.displayTimersData(timers);
            } else if (command.trim().toLowerCase().startsWith(TimerCommand.CHECK.toString()))  {
                showTimerData(command);
            } else if (command.trim().toLowerCase().startsWith(TimerCommand.STOP.toString())) {
                stopTimer(command);
            } else if (command.trim().toLowerCase().startsWith(TimerCommand.START.toString())) {
                startTimer(command);
            }
        }
        System.exit(0);
    }

    private void stopTimer(String command) {
        String timerName = InputUtils.getCommandValue(command);
        if (timerName == null || timerName.isEmpty()) {
            timerView.displayWrongInputError();
            return;
        }

        Optional<Thread> thread = getThreadByName(timerName);
        if (thread.isPresent()) {
            thread.get().interrupt();
            timerView.displayTimerStopped(timerName);
        } else {
            timerView.displayNoSuchTimerError();
        }
    }

    private void showTimerData(String command) {
        String timerName = InputUtils.getCommandValue(command);
        if (timerName == null || timerName.isEmpty()) {
            timerView.displayWrongInputError();
            return;
        }

        getTimerByName(timerName).ifPresent(x -> timerView.displayTimersData(Collections.singletonList(x)));
    }

    private Optional<Timer> getTimerByName(String name) {
        return timers.stream()
                .filter(x -> x.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst();
    }

    private Optional<Thread> getThreadByName(String name) {
        return threads.stream()
                .filter(x -> x.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst();
    }

    private void startTimer(String command) {
        String timerName = InputUtils.getCommandValue(command);
        if (timerName == null || timerName.isEmpty()) {
            timerView.displayWrongInputError();
            return;
        }

        Optional<Timer> timer = getTimerByName(timerName);
        if (timer.isPresent()) {
            if (timer.get().isPaused()) {
                startStoppedTimer(timer.get());
            } else {
                timerView.displayTimerWithThatNameIsAlreadyRunningError();
            }
        } else {
            createNewTimer(timerName);
            timerView.displayTimerCreated(timerName);
        }
    }

    private void startStoppedTimer(Timer timer) {
        timer.resume();
        timerView.displayTimerStartedMessage(timer.getName());
    }

    private void createNewTimer(String timerName) {
        Timer timer = new Timer(timerName);
        Thread thread = new Thread(timer, timerName);
        threads.add(thread);
        timers.add(timer);
        thread.start();
    }
}
