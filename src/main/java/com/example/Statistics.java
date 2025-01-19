package com.example;

public abstract class Statistics {
    protected int count = 0;

    public void addData(String data) {
        count++;
        processData(data);
    }

    public void printStatistics(boolean full) {
        System.out.println("Count: " + count);
        if (full) {
            printFullStatistics();
        }
    }

    protected abstract void processData(String data);

    protected abstract void printFullStatistics();
}
