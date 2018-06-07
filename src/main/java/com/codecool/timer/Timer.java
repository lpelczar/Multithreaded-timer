package com.codecool.timer;


public class Timer implements Runnable {

    private final int id;
    private static int nextId = 0;
    private final String name;
    private long timeElapsed;
    private boolean paused = false;

    Timer(String name) {
        this.id = ++nextId;
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                timeElapsed++;
            } catch (InterruptedException e) {
                pause();
            }
        }
    }

    private void pause() {
        paused = true;
        while (paused) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void resume() {
        paused = false;
    }

    boolean isPaused() {
        return paused;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, ThreadId: %d, Seconds: %d", name, id, timeElapsed);
    }
}
