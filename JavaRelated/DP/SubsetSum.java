package DP;

import java.util.Arrays;

class SubsetSum {
    static Boolean isSubsetSum(int N, int arr[], int sum) {
        // code here
        int[][] memo = new int[N + 1][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        if (knapSackHelper(sum, arr, N, memo) == sum)
            return true;
        return false;
    }

    static int knapSackHelper(int W, int[] val, int n, int[][] memo) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (memo[n][W] != -1) {
            return memo[n][W];
        }
        if (val[n - 1] > W) {
            memo[n][W] = knapSackHelper(W, val, n - 1, memo);
        } else {
            int include = val[n - 1] + knapSackHelper(W - val[n - 1], val, n - 1, memo);
            int exclude = knapSackHelper(W, val, n - 1, memo);
            memo[n][W] = Math.max(include, exclude);
        }
        return memo[n][W];
    }

    public static void main(String[] args) {
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int N = arr.length;
        if (isSubsetSum(N, arr, sum)) {
            System.out.println("Subset with given sum exists");
        } else {
            System.out.println("Subset with given sum does not exist");
        }
    }
}