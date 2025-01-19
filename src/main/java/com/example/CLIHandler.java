package com.example;

import org.apache.commons.cli.*;

public class CLIHandler {
    private final CommandLine cmd;

    public CLIHandler(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("o", "output", true, "Output directory");
        options.addOption("p", "prefix", true, "Output file prefix");
        options.addOption("a", "append", false, "Append to output files");
        options.addOption("s", "short", false, "Short statistics");
        options.addOption("f", "full", false, "Full statistics");
        CommandLineParser parser = new DefaultParser();
        cmd = parser.parse(options, args);
    }

    public String getOutputDirectory() {
        return cmd.getOptionValue("o", ".");
    }

    public String getPrefix() {
        return cmd.getOptionValue("p", "");
    }

    public boolean isAppendMode() {
        return cmd.hasOption("a");
    }

    public boolean isShortStatistics() {
        return cmd.hasOption("s");
    }

    public boolean isFullStatistics() {
        return cmd.hasOption("f");
    }

    public String[] getInputFiles() {
        return cmd.getArgs();
    }
}
