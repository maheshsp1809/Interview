package javacodes;

import java.util.*;

public class ArrayRearrangement {
    public static void rearrangeArray(int[] arr) {
        int n = arr.length;
        int maxIdx = n - 1; // Pointer for maximum elements
        int minIdx = 0; // Pointer for minimum elements
        int maxElement = arr[maxIdx] + 1; // Adding 1 to avoid conflicts with minimum elements

        for (int i = 0; i < n; i++) {
            // At odd indices, store maximum elements
            if (i % 2 == 0) {
                arr[i] += (arr[maxIdx] % maxElement) * maxElement;
                maxIdx--;
            }
            // At even indices, store minimum elements
            else {
                arr[i] += (arr[minIdx] % maxElement) * maxElement;
                minIdx++;
            }
        }

        // Restore the original elements and update the array
        for (int i = 0; i < n; i++) {
            arr[i] /= maxElement;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 11, 21, 33, 42, 50, 69, 71, 88 };
        rearrangeArray(arr);

        System.out.println("Rearranged Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
