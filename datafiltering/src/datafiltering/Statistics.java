package datafiltering;
import java.util.*;
public class Statistics {
	private final List<Integer> integers = new ArrayList<>();
    private final List<Float> floats = new ArrayList<>();
    private final List<String> strings = new ArrayList<>();

    public void addInteger(int value) {
        integers.add(value);
    }

    public void addFloat(float value) {
        floats.add(value);
    }

    public void addString(String value) {
        strings.add(value);
    }

    public void printStatistics(StatMode statMode) {
        System.out.println("Статистика для целых чисел:");
        printIntegerStatistics(statMode);

        System.out.println("Статистика для вещественных чисел:");
        printFloatStatistics(statMode);

        System.out.println("Статистика для строк:");
        printStringStatistics(statMode);
    }

    private void printIntegerStatistics(StatMode statMode) {
        if (integers.isEmpty()) {
            System.out.println("Нет данных.");
            return;
        }

        if (statMode == StatMode.FULL) {
            int min = Collections.min(integers);
            int max = Collections.max(integers);
            int sum = integers.stream().mapToInt(Integer::intValue).sum();
            double average = integers.stream().mapToInt(Integer::intValue).average().orElse(0.0);

            System.out.printf("Мин: %d, Макс: %d, Сумма: %d, Среднее: %.2f%n", min, max, sum, average);
        }
        System.out.println("Количество: " + integers.size());
    }

    private void printFloatStatistics(StatMode statMode) {
        if (floats.isEmpty()) {
            System.out.println("Нет данных.");
            return;
        }

        if (statMode == StatMode.FULL) {
            double min = floats.stream().mapToDouble(Float::doubleValue).min().orElse(Double.NaN);
            double max = floats.stream().mapToDouble(Float::doubleValue).max().orElse(Double.NaN);
            double sum = floats.stream().mapToDouble(Float::doubleValue).sum();
            double average = floats.stream().mapToDouble(Float::doubleValue).average().orElse(Double.NaN);

            System.out.printf("Мин: %.2f, Макс: %.2f, Сумма: %.2f, Среднее: %.2f%n", min, max, sum, average);
        }
        System.out.println("Количество: " + floats.size());
    }

    private void printStringStatistics(StatMode statMode) {
        if (strings.isEmpty()) {
            System.out.println("Нет данных.");
            return;
        }

        if (statMode == StatMode.FULL) {
            int minLength = strings.stream().mapToInt(String::length).min().orElse(0);
            int maxLength = strings.stream().mapToInt(String::length).max().orElse(0);

            System.out.printf("Самая короткая строка: %d символов, Самая длинная строка: %d символов%n", minLength, maxLength);
        }
        System.out.println("Количество: " + strings.size());
    }
}
