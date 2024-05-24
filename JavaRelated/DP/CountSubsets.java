package DP;

import java.util.*;
import java.io.*;

public class CountSubsets {
    public static int mod = (int) 1e9 + 7;

    public static int findWays(int[] num, int tar) {
        int[][] dp = new int[num.length][tar + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = recm(num.length - 1, tar, num, dp);
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return ans;

    }

    public static int recm(int i, int j, int[] num, int[][] dp) {
        if (i < 0) {
            if (j == 0)
                return 1;
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int pick = 0;
        if (j >= num[i])
            pick = recm(i - 1, j - num[i], num, dp);
        int npick = recm(i - 1, j, num, dp);
        return dp[i][j] = (pick + npick) % mod;
    }

    public static void main(String[] args) {
        // Default input
        int[] num = { 1, 1, 4, 5 };
        int tar = 5;

        int result = findWays(num, tar);
        System.out.println("Number of ways to achieve the target sum: " + result);
    }
}
