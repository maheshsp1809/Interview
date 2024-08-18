package Exam;

import java.util.*;
import java.io.*;

class Score {
    private String country;
    private int score;

    public Score(String c, int s) {
        country = c;
        score = s;
    }

    public String getCountry() {
        return country;
    }

    public void unsetCountry() {
        country = "";
    }

    public int getScore() {
        return score;
    }
}

public class Main {
    /**
     * Read `country: score` pairs from infile and return a list of pairs
     * Stop when `infile` reaches EOF
     */
    public static ArrayList<Score> readScores(Scanner infile) {
        ArrayList<Score> scores = new ArrayList<>();
        while (infile.hasNextLine()) {
            String line = infile.nextLine().trim();
            if (!line.isEmpty()) {
                String[] fields = line.split(":");
                Score score = new Score(fields[0].trim(),
                        Integer.parseInt(fields[1].trim()));
                scores.add(score);
            }
        }
        return scores;
    }

    public static int noCenturyCountryCount(ArrayList<Score> scores) {
        Map<String, Integer> countryScores = new HashMap<>();

        // Pass through scores to track highest scores for each country
        for (Score score : scores) {
            String country = score.getCountry();
            if (!country.isEmpty()) {
                // Update the highest score for the country
                countryScores.put(country, Math.max(countryScores.getOrDefault(country, 0), score.getScore()));
            }
        }

        // Count countries with no centuries (score < 100)
        int noCenturyCount = 0;
        for (int highestScore : countryScores.values()) {
            if (highestScore < 100) {
                noCenturyCount++;
            }
        }

        return noCenturyCount;
    }

    public static void main(String[] args) {
        try {
            // Updated to read from file instead of standard input
            File file = new File("input.txt");
            Scanner infile = new Scanner(file);
            ArrayList<Score> scores = Main.readScores(infile);
            infile.close();
            for (Score score : scores) {
                System.out.println(score.getCountry() + ":" + score.getScore());
            }
            int noCenturyCount = Main.noCenturyCountryCount(scores);
            System.out.println(noCenturyCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
