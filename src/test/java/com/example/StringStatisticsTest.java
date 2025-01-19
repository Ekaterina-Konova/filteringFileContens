package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringStatisticsTest {

    @Test
    void testAddData() {
        StringStatistics stats = new StringStatistics();
        stats.addData("short");
        stats.addData("medium_length");
        stats.addData("very_long_string");

        stats.printStatistics(true); // Для проверки вывода в консоль
        assertEquals(3, stats.count);
    }

    @Test
    void testFullStatistics() {
        StringStatistics stats = new StringStatistics();
        stats.addData("short");
        stats.addData("medium_length");
        stats.addData("very_long_string");

        stats.printStatistics(true);
        assertEquals(5, stats.getMinLength());
        assertEquals(16, stats.getMaxLength());
    }
}
