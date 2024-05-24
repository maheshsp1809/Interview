package DP;

public class Solution {
    public static int minSubsetSumDifference(int[] arr, int n) {
        // Write your code here.
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return tab(arr, n - 1, sum);
    }

    public static int tab(int[] arr, int n, int target) {
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; ++i)
            dp[i][0] = true;
        if (arr[0] <= target)
            dp[0][arr[0]] = true;

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= target; ++j) {
                boolean take = false;
                if (arr[i] <= j) {
                    take = dp[i - 1][j - arr[i]];
                }
                boolean ntake = dp[i - 1][j];
                dp[i][j] = take || ntake;
            }
        }
        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = target; i >= 0; i--) {
            if (dp[n - 1][i]) {
                System.out.println(dp[n - 1][26]);
                int diff = Math.abs(i - (target - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;

    }

    public static void main(String[] args) {
        int[] arr = { 14, 14, 14, 10, 15, 2 };
        int n = arr.length;
        System.out.println(minSubsetSumDifference(arr, n));
    }
}
