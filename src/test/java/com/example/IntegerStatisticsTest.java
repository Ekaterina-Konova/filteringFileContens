package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerStatisticsTest {

    @Test
    void testAddData() {
        IntegerStatistics stats = new IntegerStatistics();
        stats.addData("10");
        stats.addData("20");
        stats.addData("30");

        stats.printStatistics(true); // Для проверки вывода в консоль
        assertEquals(3, stats.count);
    }

    @Test
    void testFullStatistics() {
        IntegerStatistics stats = new IntegerStatistics();
        stats.addData("10");
        stats.addData("20");
        stats.addData("30");

        stats.printStatistics(true);
        assertEquals(10, stats.getMin());
        assertEquals(30, stats.getMax());
        assertEquals(60, stats.getSum());
        assertEquals(20.0, stats.getSum() / (double) stats.count);
    }
}