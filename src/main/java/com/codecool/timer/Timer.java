package com.codecool.timer;

public class Timer implements Runnable {

    private final int id;
    private static int nextId = 0;
    private final String name;
    private double startingNanoTime;
    private double timeElapsed;

    Timer(String name) {
        this.id = ++nextId;
        this.name = name;
    }

    @Override
    public void run() {
        startingNanoTime = System.nanoTime();
        while (true) {
            double currentNanoTime = System.nanoTime();
            timeElapsed = timeElapsed + currentNanoTime - startingNanoTime;
            startingNanoTime = currentNanoTime;
        }
    }

    @Override
    public String toString() {
        double timeElapsedInSeconds = timeElapsed / 1000000000.0;
        return String.format("Name: %s, ThreadId: %d Seconds: %.2f", name, id, timeElapsedInSeconds);
    }
}
