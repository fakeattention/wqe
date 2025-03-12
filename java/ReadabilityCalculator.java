package main.java;

public class ReadabilityCalculator {
    public static double calculate(ReadabilityMethod method, TextStatistics stats) {
        return method.calculate(stats);
    }

    public static int getAge(double score) {
        int rounded = (int) Math.round(score);
        int[] ageTable = {6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
        return (rounded >= 15) ? 22 : ageTable[Math.max(0, rounded - 1)];
    }
}