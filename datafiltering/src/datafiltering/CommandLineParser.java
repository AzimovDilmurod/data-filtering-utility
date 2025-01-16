package datafiltering;
import java.util.*;
public class CommandLineParser {
	public static CommandLineArgs parse(String[] args) throws IllegalArgumentException {
        List<String> inputFiles = new ArrayList<>();
        String outputPath = "./";
        String prefix = "";
        boolean append = false;
        StatMode statMode = StatMode.SHORT;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    outputPath = args[++i];
                    break;
                case "-p":
                    prefix = args[++i];
                    break;
                case "-a":
                    append = true;
                    break;
                case "-s":
                    statMode = StatMode.SHORT;
                    break;
                case "-f":
                    statMode = StatMode.FULL;
                    break;
                default:
                    if (args[i].startsWith("-")) {
                        throw new IllegalArgumentException("Неизвестный параметр: " + args[i]);
                    } else {
                        inputFiles.add(args[i]);
                    }
                    break;
            }
        }

        if (inputFiles.isEmpty()) {
            throw new IllegalArgumentException("Не указаны входные файлы.");
        }

        return new CommandLineArgs(inputFiles, outputPath, prefix, append, statMode);
    }
}

class CommandLineArgs {
    private final List<String> inputFiles;
    private final String outputPath;
    private final String prefix;
    private final boolean append;
    private final StatMode statMode;

    public CommandLineArgs(List<String> inputFiles, String outputPath, String prefix, boolean append, StatMode statMode) {
        this.inputFiles = inputFiles;
        this.outputPath = outputPath;
        this.prefix = prefix;
        this.append = append;
        this.statMode = statMode;
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isAppend() {
        return append;
    }

    public StatMode getStatMode() {
        return statMode;
    }
}

enum StatMode {
    SHORT, FULL
}

