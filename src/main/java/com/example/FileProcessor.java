package com.example;

import java.io.*;

public class FileProcessor {
    private final CLIHandler cliHandler;
    private final Statistics integerStats;
    private final Statistics floatStats;
    private final Statistics stringStats;

    public FileProcessor(CLIHandler cliHandler) {
        this.cliHandler = cliHandler;
        this.integerStats = new IntegerStatistics();
        this.floatStats = new FloatStatistics();
        this.stringStats = new StringStatistics();
    }

    public void processFiles() throws IOException {
        String outputDir = cliHandler.getOutputDirectory();
        String prefix = cliHandler.getPrefix();
        boolean appendMode = cliHandler.isAppendMode();

        BufferedWriter integerWriter = null;
        BufferedWriter floatWriter = null;
        BufferedWriter stringWriter = null;

        try {
            for (String inputFile : cliHandler.getInputFiles()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (isInteger(line)) {
                            integerStats.addData(line);
                            if (integerWriter == null) {
                                integerWriter = createWriter(outputDir, prefix + "integers.txt", appendMode);
                            }
                            integerWriter.write(line);
                            integerWriter.newLine();
                        } else if (isFloat(line)) {
                            floatStats.addData(line);
                            if (floatWriter == null) {
                                floatWriter = createWriter(outputDir, prefix + "floats.txt", appendMode);
                            }
                            floatWriter.write(line);
                            floatWriter.newLine();
                        } else {
                            stringStats.addData(line);
                            if (stringWriter == null) {
                                stringWriter = createWriter(outputDir, prefix + "strings.txt", appendMode);
                            }
                            stringWriter.write(line);
                            stringWriter.newLine();
                        }
                    }
                }
            }
        } finally {
            if (integerWriter != null) {
                integerWriter.close();
            }
            if (floatWriter != null) {
                floatWriter.close();
            }
            if (stringWriter != null) {
                stringWriter.close();
            }
        }
    }

    public void printStatistics() {
        if (cliHandler.isShortStatistics() || cliHandler.isFullStatistics()) {
            System.out.println("Integer Statistics:");
            integerStats.printStatistics(cliHandler.isFullStatistics());
            System.out.println("Float Statistics:");
            floatStats.printStatistics(cliHandler.isFullStatistics());
            System.out.println("String Statistics:");
            stringStats.printStatistics(cliHandler.isFullStatistics());
        }
    }

    private BufferedWriter createWriter(String outputDir, String filename, boolean appendMode) throws IOException {
        File file = new File(outputDir, filename);
        return new BufferedWriter(new FileWriter(file, appendMode));
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isFloat(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
