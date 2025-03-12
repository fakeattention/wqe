package main.java;

public enum ReadabilityMethod {
    ARI, FK, CL, SMOG;

    public double calculate(int characters, int words, int sentences, int syllables, int polysyllables) {
        switch (this) {
            case ARI:
                return 4.71 * ((double) characters / words) + 0.5 * ((double) words / sentences) - 21.43;
            case FK:
                return 0.39 * ((double) words / sentences) + 11.8 * ((double) syllables / words) - 15.59;
            case CL:
                double L = ((double) characters / words) * 100;
                double S = ((double) sentences / words) * 100;
                return 0.0588 * L - 0.296 * S - 15.8;
            case SMOG:
                return 1.043 * Math.sqrt(polysyllables * (30.0 / sentences)) + 3.1291;
            default:
                throw new IllegalArgumentException("Unknown method: " + this);
        }
    }

    public double calculate(TextStatistics stats) {
        return calculate(stats.getCharacters(), stats.getWords(), stats.getSentences(), stats.getSyllables(), stats.getPolysyllables());
    }
}