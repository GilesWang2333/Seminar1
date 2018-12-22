package com.company;

public class Timer {

    private long startTime;
    private long endTime;
    private long elapsedTime;
    public Timer() {

    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
//        System.out.println("Started at: " + startTime + "\tEnded at: " + endTime);
        elapsedTime = endTime - startTime;
//        System.out.println("Elapsed time: " + (endTime - startTime) + "ns.");
    }

}
