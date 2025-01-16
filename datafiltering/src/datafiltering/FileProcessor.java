package datafiltering;
import java.io.*;
public class FileProcessor {
	public FileProcessor(CommandLineArgs args) {
    }

    public void processFile(String filePath, Statistics statistics) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line, statistics);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла " + filePath + ": " + e.getMessage());
        }
    }

    private void processLine(String line, Statistics statistics) {
        try {
            if (isInteger(line)) {
                statistics.addInteger(Integer.parseInt(line));
            } else if (isFloat(line)) {
                statistics.addFloat(Float.parseFloat(line));
            } else {
                statistics.addString(line);
            }
        } catch (NumberFormatException e) {
            // Не число, но обработано как строка
            statistics.addString(line);
        }
    }

    private boolean isInteger(String line) {
        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isFloat(String line) {
        try {
            Float.parseFloat(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
