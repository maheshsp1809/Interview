package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceSum {

    public static void printSubseq(int[] arr, int i, int currSum, int k, List<Integer> subseq) {
        if (i == arr.length) {
            if (currSum == k) {
                System.out.println(subseq);
            }
            return;
        }

        // include current element
        subseq.add(arr[i]);
        printSubseq(arr, i + 1, currSum + arr[i], k, subseq);
        subseq.remove(subseq.size() - 1);

        // exclude current element
        printSubseq(arr, i + 1, currSum, k, subseq);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 2, 1, 7, 6, 8 };
        int k = 10;
        printSubseq(arr, 0, 0, k, new ArrayList<Integer>());
    }
}
