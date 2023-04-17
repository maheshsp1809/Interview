package javacodes;

import java.util.HashMap;

public class Hashmap {
    public static void main(String[] args) {
        // Create a new HashMap object
        HashMap<String, Integer> studentGrades = new HashMap<>();

        // Add key-value pairs to the HashMap
        studentGrades.put("John", 90);
        studentGrades.put("Mary", 85);
        studentGrades.put("Tom", 95);
        studentGrades.put("Sara", 80);

        // Retrieve values from the HashMap using the key
        int johnGrade = studentGrades.get("John");
        System.out.println("John's grade: " + johnGrade);

        // Update the value for a key in the HashMap
        studentGrades.put("Mary", 90);

        // Iterate through the HashMap to print all key-value pairs
        for (String name : studentGrades.keySet()) {
            int grade = studentGrades.get(name);
            System.out.println(name + "'s grade: " + grade);
        }

        // Remove a key-value pair from the HashMap
        studentGrades.remove("Tom");
    }
}

