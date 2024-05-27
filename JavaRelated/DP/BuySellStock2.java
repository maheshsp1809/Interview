package DP;

import java.util.Arrays;

public class BuySellStock2 {

    public static long getMaximumProfit(int n, long[] values) {
        // Initialize dp array with -1
        long[][] dp = new long[n][2];
        for (long[] row : dp)
            Arrays.fill(row, -1);

        // Calculate the maximum profit using the recursive method
        long ans = recm(0, 1, values, dp);

        // Print dp array for debugging (optional)
        for (long[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        return ans;
    }

    public static long recm(int i, int buy, long[] values, long[][] dp) {
        if (i == values.length)
            return 0;
        if (dp[i][buy] != -1)
            return dp[i][buy];

        if (buy == 1) {
            long b = -values[i] + recm(i + 1, 0, values, dp);
            long db = recm(i + 1, 1, values, dp);
            return dp[i][buy] = Math.max(b, db);
        } else {
            long s = values[i] + recm(i + 1, 1, values, dp);
            long ns = recm(i + 1, 0, values, dp);
            return dp[i][buy] = Math.max(s, ns);
        }
    }

    public static void main(String[] args) {
        // Test case: 7, 1, 5, 3, 6, 4
        long[] values = { 7, 1, 5, 3, 6, 4 };
        int n = values.length;

        // Calculate and print the maximum profit
        long maxProfit = getMaximumProfit(n, values);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
