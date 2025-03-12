package main.java;

public class ReadabilityAnalyzer {
    private final TextStatistics stats;

    public ReadabilityAnalyzer(TextStatistics stats) {
        this.stats = stats;
    }

    public double calculate(ReadabilityMethod method) {
        return ReadabilityCalculator.calculate(method, stats);
    }
}