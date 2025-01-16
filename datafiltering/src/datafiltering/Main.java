package datafiltering;
public class Main {
	public static void main(String[] args) {
        try {
            CommandLineArgs commandLineArgs = CommandLineParser.parse(args);
            FileProcessor fileProcessor = new FileProcessor(commandLineArgs);
            Statistics statistics = new Statistics();

            for (String filePath : commandLineArgs.getInputFiles()) {
                fileProcessor.processFile(filePath, statistics);
            }

            statistics.printStatistics(commandLineArgs.getStatMode());
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
