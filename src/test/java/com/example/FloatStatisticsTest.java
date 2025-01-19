package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FloatStatisticsTest {

    @Test
    void testAddData() {
        FloatStatistics stats = new FloatStatistics();
        stats.addData("1.5");
        stats.addData("2.5");
        stats.addData("3.5");

        stats.printStatistics(true); // Для проверки вывода в консоль
        assertEquals(3, stats.count);
    }

    @Test
    void testFullStatistics() {
        FloatStatistics stats = new FloatStatistics();
        stats.addData("1.5");
        stats.addData("2.5");
        stats.addData("3.5");

        stats.printStatistics(true);
        assertEquals(1.5, stats.getMin());
        assertEquals(3.5, stats.getMax());
        assertEquals(7.5, stats.getSum());
        assertEquals(2.5, stats.getSum() / stats.count);
    }
}