package com.example;

import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CLIHandlerTest {

    @Test
    void testOutputDirectory() throws ParseException {
        String[] args = {"-o", "/some/path", "file1.txt", "file2.txt"};
        CLIHandler cliHandler = new CLIHandler(args);
        assertEquals("/some/path", cliHandler.getOutputDirectory());
    }

    @Test
    void testPrefix() throws ParseException {
        String[] args = {"-p", "result_", "file1.txt"};
        CLIHandler cliHandler = new CLIHandler(args);
        assertEquals("result_", cliHandler.getPrefix());
    }

    @Test
    void testAppendMode() throws ParseException {
        String[] args = {"-a", "file1.txt"};
        CLIHandler cliHandler = new CLIHandler(args);
        assertTrue(cliHandler.isAppendMode());
    }

    @Test
    void testShortStatistics() throws ParseException {
        String[] args = {"-s", "file1.txt"};
        CLIHandler cliHandler = new CLIHandler(args);
        assertTrue(cliHandler.isShortStatistics());
    }

    @Test
    void testFullStatistics() throws ParseException {
        String[] args = {"-f", "file1.txt"};
        CLIHandler cliHandler = new CLIHandler(args);
        assertTrue(cliHandler.isFullStatistics());
    }

    @Test
    void testInputFiles() throws ParseException {
        String[] args = {"file1.txt", "file2.txt"};
        CLIHandler cliHandler = new CLIHandler(args);
        assertArrayEquals(new String[]{"file1.txt", "file2.txt"}, cliHandler.getInputFiles());
    }
}
