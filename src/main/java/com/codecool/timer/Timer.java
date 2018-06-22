package com.codecool.timer;


public class Timer implements Runnable {

    private final int id;
    private static int nextId = 0;
    private final String name;
    private double timeElapsed;
    private double timePaused;
    private long pauseTime;
    private boolean paused = false;

    private long startingTime;

    Timer(String name) {
        this.id = ++nextId;
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public void run() {

        startingTime = System.nanoTime();

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                pause();
            }
        }
    }

    private void pause() {
        paused = true;
        pauseTime = System.nanoTime();
        while (paused) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        timePaused = timePaused + (System.nanoTime() - pauseTime) / 1000000000.0;
    }

    synchronized void resume() {
        paused = false;
    }

    synchronized boolean isPaused() {
        return paused;
    }

    @Override
    public String toString() {
        calculateCurrentTime();
        return String.format("Name: %s, ThreadId: %d, Seconds: %.2f", name, id, timeElapsed);
    }

    private void calculateCurrentTime() {
        if (isPaused()) {
            timeElapsed = (pauseTime - startingTime) / 1000000000.0 - timePaused;
        } else {
            timeElapsed = (System.nanoTime() - startingTime) / 1000000000.0 - timePaused;
        }
    }
}
