package com.codecool.timer;

public enum TimerCommand {

    START("start"),
    STOP("stop"),
    EXIT("exit"),
    CHECK("check");

    private final String label;

    TimerCommand(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}