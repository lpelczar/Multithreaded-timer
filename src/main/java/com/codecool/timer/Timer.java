package com.codecool.timer;

import java.util.concurrent.atomic.AtomicBoolean;

public class Timer implements Runnable {

    private final int id;
    private static int nextId = 0;
    private final String name;
    private double timeElapsed;
    private AtomicBoolean isRunning = new AtomicBoolean(true);

    Timer(String name) {
        this.id = ++nextId;
        this.name = name;
    }

    String getName() {
        return name;
    }

    public AtomicBoolean getIsRunning() {
        return isRunning;
    }

    @Override
    public void run() {
        double startingNanoTime = System.nanoTime();
        while (isRunning.get()) {
            double currentNanoTime = System.nanoTime();
            timeElapsed = timeElapsed + currentNanoTime - startingNanoTime;
            startingNanoTime = currentNanoTime;

            if (Thread.interrupted()) {
                isRunning.set(false);
            }
        }
    }

    @Override
    public String toString() {
        double timeElapsedInSeconds = timeElapsed / 1000000000.0;
        return String.format("Name: %s, ThreadId: %d Seconds: %.2f", name, id, timeElapsedInSeconds);
    }
}
