package main.java;

public class ReadabilityReport {
    public static void generateReport(ReadabilityAnalyzer analyzer, String choice) {
        ReadabilityMethod[] methods = ReadabilityMethod.values();
        double totalAge = 0;
        int count = 0;

        for (ReadabilityMethod method : methods) {
            if (choice.equalsIgnoreCase(method.name()) || choice.equalsIgnoreCase("ALL")) {
                double score = analyzer.calculate(method);
                int age = ReadabilityCalculator.getAge(score);
                totalAge += age;
                count++;

                String fullName;
                switch (method) {
                    case ARI:
                        fullName = "Automated Readability Index";
                        break;
                    case FK:
                        fullName = "Flesch–Kincaid readability tests";
                        break;
                    case CL:
                        fullName = "Coleman–Liau index";
                        break;
                    case SMOG:
                        fullName = "Simple Measure of Gobbledygook";
                        break;
                    default:
                        fullName = method.name();
                }

                System.out.printf("%s: %.2f (about %d-year-olds).\n", fullName, score, age);
            }
        }

        if (choice.equalsIgnoreCase("ALL")) {
            System.out.printf("\nThis text should be understood on average by %.2f-year-olds.\n", totalAge / count);
        }
    }
}