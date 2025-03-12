package main.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Check if the file is provided in the command line arguments
        if (args.length != 1) {
            System.out.println("File not found.");
            return;
        }
        // Receiving file from the command line
        String filename = args[0];
        String text;

        try {
            // Read the contents of the file into a line and remove extra spaces
            text = new String(Files.readAllBytes(Paths.get(filename))).trim();
        } catch (IOException e) {
            System.out.println("Unable to read file.");
            return;
        }

        TextStatistics stats = new TextStatistics(text);
        ReadabilityAnalyzer analyzer = new ReadabilityAnalyzer(stats);

        System.out.println("The text is:\n" + text);
        // Printing basic statistics about the text
        System.out.printf("\nWords: %d\nSentences: %d\nCharacters: %d\nSyllables: %d\nPolysyllables: %d\n",
                stats.getWords(), stats.getSentences(), stats.getCharacters(), stats.getSyllables(), stats.getPolysyllables());

        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, ALL): ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next().toUpperCase();
        scanner.close();

        System.out.println();
        ReadabilityReport.printResults(analyzer, choice);
    }
}