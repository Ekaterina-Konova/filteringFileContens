package com.example;

import org.apache.commons.cli.ParseException;

public class Main {
    public static void main(String[] args) {
        try {
            CLIHandler cliHandler = new CLIHandler(args);
            FileProcessor fileProcessor = new FileProcessor(cliHandler);
            fileProcessor.processFiles();
            fileProcessor.printStatistics();
        } catch (ParseException e) {
            System.err.println("Error parsing command line arguments: " + e.getMessage());

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}