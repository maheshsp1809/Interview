package DP;

import java.util.Arrays;

class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] memo = new int[n + 1][W + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return knapSackHelper(W, wt, val, n, memo);
    }

    static int knapSackHelper(int W, int[] wt, int[] val, int n, int[][] memo) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (memo[n][W] != -1) {
            return memo[n][W];
        }
        if (wt[n - 1] > W) {
            memo[n][W] = knapSackHelper(W, wt, val, n - 1, memo);
        } else {
            int include = val[n - 1] + knapSackHelper(W - wt[n - 1], wt, val, n - 1, memo);
            int exclude = knapSackHelper(W, wt, val, n - 1, memo);
            memo[n][W] = Math.max(include, exclude);
        }
        return memo[n][W];
    }

    public static void main(String[] args) {
        int[] wt = { 10, 20, 30 };
        int[] val = { 60, 100, 120 };
        int W = 50;
        int n = wt.length;
        int maxVal = knapSack(W, wt, val, n);
        System.out.println("The maximum value that can be put in the knapsack is: " + maxVal);
    }

}
