package com.codecool.timer;

import java.util.List;

public interface TimerView {

    String getCommand();
    void displayTimersData(List<Timer> timers);
    void displayWrongInputError();
    void displayNoSuchTimerError();
    void displayTimerWithThatNameIsAlreadyRunningError();
}
