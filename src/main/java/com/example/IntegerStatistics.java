package com.example;

public class IntegerStatistics extends Statistics {
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private long sum = 0;

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public long getSum() {
        return sum;
    }

    @Override
    protected void processData(String data) {
        int value = Integer.parseInt(data);
        if (value < min) {
            min = value;
        }
        if (value > max) {
            max = value;
        }
        sum += value;
    }

    @Override
    protected void printFullStatistics() {
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (sum / (double) count));
    }
}
