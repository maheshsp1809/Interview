package Sorts;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 3, 6, 1, -1 };
        insertionSort(arr, arr.length);
        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void insertionSort(int[] arr, int n) {
        // Base case: If there's only one element or the array is empty, it's already
        // sorted.
        if (n <= 1) {
            return;
        }

        // Sort the first n-1 elements recursively.
        insertionSort(arr, n - 1);

        // Insert the nth element into the sorted part of the array using recursion.
        insert(arr, n - 1);
    }

    public static void insert(int[] arr, int n) {
        if (n > 0 && arr[n] < arr[n - 1]) {
            // Swap arr[n] and arr[n-1]
            int temp = arr[n];
            arr[n] = arr[n - 1];
            arr[n - 1] = temp;

            // Recursively continue to insert the element
            insert(arr, n - 1);
        }
    }
}
