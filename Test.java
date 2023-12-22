import java.util.*;

public class Test {

    public static int elementRemoval(int N, int K, int[] A) {
        // Create a frequency map to store the count of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element in the array
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Calculate the total number of elements to be removed
        int elementsToRemove = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            // Calculate the excess elements that need to be removed to make frequency
            // divisible by K
            elementsToRemove += (frequency % K == 0) ? 0 : frequency % K;
        }

        return elementsToRemove;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = { 1, 1, 1, 2, 2 };
        int n1 = 5, k1 = 2;
        System.out.println("Test Case 1: " + elementRemoval(n1, k1, arr1));

        // Test Case 2
        int[] arr2 = { 1, 2, 3, 4, 5 };
        int n2 = 5, k2 = 3;
        System.out.println("Test Case 2: " + elementRemoval(n2, k2, arr2));

        // Test Case 3
        int[] arr3 = { 1, 1, 1, 2, 2, 2 };
        int n3 = 6, k3 = 3;
        System.out.println("Test Case 3: " + elementRemoval(n3, k3, arr3));
    }
}
