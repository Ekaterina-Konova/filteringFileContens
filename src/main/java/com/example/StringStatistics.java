package com.example;

public class StringStatistics extends Statistics {
    private int minLength = Integer.MAX_VALUE;
    private int maxLength = Integer.MIN_VALUE;

    public int getMaxLength() {
        return maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    @Override
    protected void processData(String data) {
        int length = data.length();
        if (length < minLength) {
            minLength = length;
        }
        if (length > maxLength) {
            maxLength = length;
        }
    }

    @Override
    protected void printFullStatistics() {
        System.out.println("Min Length: " + minLength);
        System.out.println("Max Length: " + maxLength);
    }
}
