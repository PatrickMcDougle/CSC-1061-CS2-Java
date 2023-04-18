package edu.csc1061.utils;

public class Timer {
    private Timer() {
        // Don't allow others to create the timer.
    }

    private static Timer instance;

    public static Timer getTimer() {
        if (instance == null) {
            // timer does not exist so create it.
            instance = new Timer();
        }
        return instance;
    }

    private long startTime;
    private long finishTime;

    public void start() {
        startTime = System.currentTimeMillis();
        finishTime = startTime;
    }

    public void finish() {
        finishTime = System.currentTimeMillis();
    }

    public int getElapsedTime() {
        Long d = Long.valueOf(finishTime - startTime);
        return d.intValue();
    }

    public long getElapsedTimeLong() {
        return finishTime - startTime;
    }

}
