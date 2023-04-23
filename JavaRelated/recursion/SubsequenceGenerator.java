package recursion;

public class SubsequenceGenerator {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println("Subsequences of the array:");
        printSubsequences(arr);
    }

    public static void printSubsequences(int[] arr) {
        int[] currSeq = new int[arr.length];
        printSubsequencesHelper(arr, currSeq, 0, 0);
    }

    public static void printSubsequencesHelper(int[] arr, int[] currSeq, int currIndex, int arrIndex) {
        if (arrIndex == arr.length) {
            for (int i = 0; i < currIndex; i++) {
                System.out.print(currSeq[i] + " ");
            }
            System.out.println();
        } else {
            // Include the current element in the subsequence
            currSeq[currIndex] = arr[arrIndex];
            printSubsequencesHelper(arr, currSeq, currIndex + 1, arrIndex + 1);
            // Exclude the current element from the subsequence
            printSubsequencesHelper(arr, currSeq, currIndex, arrIndex + 1);
        }
    }
}
