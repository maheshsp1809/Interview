package basicJava;

import java.util.*;

public class Assignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine().toLowerCase();
        System.out.println("Enter input 2:");
        int input2 = sc.nextInt();

        String[] words = sentence.split("\\b");
        // for (String word : words)
        // System.out.println(word);
        Map<String, Integer> wC = new HashMap<>();
        for (String word : words) {
            String key = Character.isLetterOrDigit(word.charAt(0)) ? word : "separators";
            wC.put(key, wC.getOrDefault(key, 0) + 1);
        }
        if (input2 == 0) {
            TreeMap<String, Integer> sA = new TreeMap<>(wC);
            System.out.println("Alphabetical Order:");
            for (Map.Entry<String, Integer> entry : sA.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            // sA.forEach((word, count) -> System.out.println(word + ": " + count));
        }
        if (input2 == 1) {
            List<Map.Entry<String, Integer>> sortedByCount = new ArrayList<>(wC.entrySet());
            sortedByCount.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
            System.out.println("\nDescending Order by Count:");
            for (Map.Entry<String, Integer> entry : sortedByCount) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else {
            System.out.println("Invalid input2");
        }
    }
}
