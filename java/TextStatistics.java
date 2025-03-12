package main.java;

public class TextStatistics {
    private final String text;
    private int characters, words, sentences, syllables, polysyllables;

    public TextStatistics(String text) {
        this.text = text;
        analyze();
    }

    private void analyze() {
        characters = text.replaceAll("\\s+", "").length();
        words = text.split("\\s+").length;
        sentences = text.split("[.!?]+").length;

        for (String word : text.split("\\s+")) {
            int count = countSyllables(word);
            syllables += count;
            if (count > 2) polysyllables++;
        }
    }

    private int countSyllables(String word) {
        word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        if (word.isEmpty()) return 0;

        int count = 0;
        boolean prevVowel = false;
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};

        for (char c : word.toCharArray()) {
            boolean isVowel = false;
            for (char v : vowels) {
                if (c == v) {
                    isVowel = true;
                    break;
                }
            }
            if (isVowel) {
                if (!prevVowel) count++;
                prevVowel = true;
            } else {
                prevVowel = false;
            }
        }

        if (word.endsWith("e") && count > 1)
            count--;

        return Math.max(count, 1);
    }

    public int getCharacters() {
        return characters;
    }
    public int getWords() {
        return words;
    }
    public int getSentences() {
        return sentences;
    }
    public int getSyllables() {
        return syllables;
    }
    public int getPolysyllables() {
        return polysyllables;
    }
}