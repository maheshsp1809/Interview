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

        for (long[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        // return ans;
        return tab(values, n);
    }

    public static long tab(long[] values, int n) {
        long[][] dp = new long[n + 1][2];
        for (int i = n - 2; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    // Choice to buy or not buy
                    dp[i][buy] = Math.max(-values[i] + dp[i + 1][0], dp[i + 1][1]);
                } else {
                    // Choice to sell or not sell
                    dp[i][buy] = Math.max(values[i] + dp[i + 1][1], dp[i + 1][0]);
                }
            }
        }
        for (long[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[0][1];
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
        // long[] values = { 1, 2, 3, 4, 5, 6, 0 };
        int n = values.length;
        // Calculate and print the maximum profit
        long maxProfit = getMaximumProfit(n, values);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
