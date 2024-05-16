package DP;

import java.util.*;

public class Grid4Methods {
    public static int uniquePaths(int m, int n) {
        // Write your code here.
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return permu(m, n);
        // Uncomment the desired method to use
        // return space1(m,n);
        // return tab(m, n);
        // return recm(0, 0, dp, m, n);
    }

    public static int permu(int m, int n) {
        int N = m + n - 2;
        int r = n - 1;
        int res = 1;
        for (int i = 1; i <= r; ++i) {
            res = res * (N - r + i) / i;
        }
        return res;
    }

    public static int space1(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 1);
        for (int row = 1; row < m; ++row) {
            int[] curr = new int[n];
            curr[0] = 1;
            for (int col = 1; col < n; ++col) {
                int right = curr[col - 1];
                int down = prev[col];
                curr[col] = right + down;
            }
            prev = curr.clone();
        }
        return prev[n - 1];
    }

    public static int tab(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; ++i) {
            dp[0][i] = 1;
        }
        for (int row = 1; row < m; ++row) {
            for (int col = 1; col < n; ++col) {
                int right = dp[row][col - 1];
                int down = dp[row - 1][col];
                dp[row][col] = right + down;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int recm(int row, int col, int[][] dp, int m, int n) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if (row == m || col == n)
            return 0;
        if (dp[row][col] != -1)
            return dp[row][col];
        int right = recm(row, col + 1, dp, m, n);
        int down = recm(row + 1, col, dp, m, n);
        return dp[row][col] = right + down;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows (m): ");
        int m = scanner.nextInt();

        System.out.print("Enter the number of columns (n): ");
        int n = scanner.nextInt();

        int result = uniquePaths(m, n);
        System.out.println("Number of unique paths: " + result);

        scanner.close();
    }
}
