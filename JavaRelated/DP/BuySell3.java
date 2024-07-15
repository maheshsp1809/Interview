package DP;

import java.util.Arrays;

public class BuySell3 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][2];
        for (int[][] row : dp) {
            for (int[] col : row)
                Arrays.fill(col, -1);
        }

        // Calculate the result using the recursive method
        int ans = recm(0, 1, 1, prices, dp);

        // Print the dp matrix
        System.out.println("DP Matrix:");
        for (int i = 0; i < dp.length; i++) {
            System.out.println("Day " + i + ":");
            for (int j = 0; j < dp[i].length; j++) {
                System.out.println("  Buy/Sell " + j + ": " + Arrays.toString(dp[i][j]));
            }
        }

        // Return the calculated answer
        return ans;
    }

    public static int recm(int ind, int buy, int cap, int[] prices, int[][][] dp) {
        if (cap <= 0 || ind == prices.length)
            return 0;
        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];

        if (buy == 1) {
            int buys = -prices[ind] + recm(ind + 1, 0, cap, prices, dp);
            int dontBuy = recm(ind + 1, 1, cap, prices, dp);
            dp[ind][buy][cap] = Math.max(buys, dontBuy);
        } else {
            int sells = prices[ind] + recm(ind + 1, 1, cap - 1, prices, dp);
            int dontSell = recm(ind + 1, 0, cap, prices, dp);
            dp[ind][buy][cap] = Math.max(sells, dontSell);
        }
        return dp[ind][buy][cap];
    }

    public static void main(String[] args) {
        // Test case: {3, 3, 5, 0, 0, 3, 1, 4}
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
