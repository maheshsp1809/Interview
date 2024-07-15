package DP;

import java.util.Arrays;

public class LIS {
    public static int longestIncreasingSubsequence(int arr[]) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return tab(arr);
    }

    public static int tab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n + 1];

        for (int i = n - 2; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int take = 0;
                if (prev == -1 || arr[i] > arr[prev]) {
                    take = 1 + dp[i + 1][i + 1];
                }
                int ntake = dp[i + 1][prev + 1];
                dp[i][prev + 1] = Math.max(take, ntake);
            }
        }

        // Printing the final dp matrix
        System.out.println("DP Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int result = longestIncreasingSubsequence(arr);
        System.out.println("The length of the longest increasing subsequence is: " + result);
    }
}
