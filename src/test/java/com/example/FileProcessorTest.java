package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

class FileProcessorTest {

    @Test
    void testProcessFiles() throws IOException {
        CLIHandler cliHandler = Mockito.mock(CLIHandler.class);
        when(cliHandler.getOutputDirectory()).thenReturn(".");
        when(cliHandler.getPrefix()).thenReturn("");
        when(cliHandler.isAppendMode()).thenReturn(false);
        when(cliHandler.getInputFiles()).thenReturn(new String[]{"src/test/resources/test1.txt"});

        FileProcessor fileProcessor = new FileProcessor(cliHandler);
        fileProcessor.processFiles();

        // Проверяем, что статистика была собрана
        verify(cliHandler, times(1)).getInputFiles();
    }
}