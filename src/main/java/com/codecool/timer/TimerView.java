package com.codecool.timer;

import java.util.List;

public interface TimerView {

    String getCommand();
    void displayTimersData(List<Timer> timers);
    void displayWrongInputError();
    void displayNoSuchTimerError();
    void displayTimerWithThatNameIsAlreadyRunningError();
    void displayTimerStartedMessage(String name);
    void displayPossibleOptions();
    void displayTimerCreated(String timerName);
    void displayTimerStopped(String timerName);
    void displayGoodbyeMessage();
}
