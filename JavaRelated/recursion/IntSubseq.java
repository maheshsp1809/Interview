package recursion;

import java.util.*;

public class IntSubseq {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printSubsequences(arr);
    }

    public static void printSubsequences(int[] arr) {
        printSubsequencesHelper(arr, new ArrayList<Integer>(), 0);
    }

    public static void printSubsequencesHelper(int[] arr, List<Integer> currSeq, int idx) {
        if (idx == arr.length) {
            // Base case: print the current subsequence
            System.out.println(currSeq);
        } else {
            // Recursive case: include or exclude the current element
            // Include the current element in the subsequence
            currSeq.add(arr[idx]);
            printSubsequencesHelper(arr, currSeq, idx + 1);
            currSeq.remove(currSeq.size() - 1);
            // Exclude the current element from the subsequence
            printSubsequencesHelper(arr, currSeq, idx + 1);
        }
    }
}
