package com.codecool.timer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MonitorRunnable implements Runnable {

    private final Runnable runnable;
    private static final List<Runnable> activeTasks = Collections.synchronizedList(new ArrayList<>());

    MonitorRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        activeTasks.add(runnable);
        runnable.run();
        activeTasks.remove(runnable);
    }

    public static List<Runnable> getActiveTasks() {
        return activeTasks;
    }
}