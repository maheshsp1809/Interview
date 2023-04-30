package DP;

import java.util.Arrays;

class TknapSack {
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] memo = new int[n + 1][W + 1];

        // Initialize the memoization table with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Iterate over all subproblems from the smallest to the largest
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    memo[i][j] = Math.max(val[i - 1] + memo[i - 1][j - wt[i - 1]], memo[i - 1][j]);
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }

        // Return the maximum value that can be put in the knapsack
        return memo[n][W];
    }

    public static void main(String[] args) {
        int[] wt = { 10, 20, 25, 19, 30 };
        int[] val = { 60, 100, 200, 230, 120 };
        int W = 50;
        int n = wt.length;
        int maxVal = knapSack(W, wt, val, n);
        System.out.println("The maximum value that can be put in the knapsack is: " + maxVal);
    }
}
