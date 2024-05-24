package DP;

import java.util.*;

public class Knapsackprint {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int result = recm(0, maxWeight, weight, value, dp);
        printDpMatrix(dp);
        return result;
    }

    public static int recm(int i, int j, int[] weight, int[] value, int[][] dp) {
        if (j <= 0)
            return 0;
        if (i == weight.length)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int take = 0;
        if (j - weight[i] >= 0)
            take = value[i] + recm(i + 1, j - weight[i], weight, value, dp);
        int notake = recm(i + 1, j, weight, value, dp);

        dp[i][j] = Math.max(take, notake);
        return dp[i][j];
    }

    public static void printDpMatrix(int[][] dp) {
        System.out.println("Final DP Matrix:");
        for (int[] row : dp) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] weight = { 1, 2, 3, 8, 7, 4 };
        int[] value = { 20, 7, 12, 19, 18, 4 };
        int maxWeight = 15;
        int n = weight.length;

        int maxProfit = knapsack(weight, value, n, maxWeight);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
