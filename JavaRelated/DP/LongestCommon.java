package DP;

import java.util.Arrays;

public class LongestCommon {

    public static int lcs(String s, String t) {
        // Use the space-optimized approach
        return tab(s, t);
    }

    public static int tab(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];

        for (int i = 0; i < t.length(); ++i) {
            if (s.charAt(0) == t.charAt(i))
                dp[0][i] = 1;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == t.charAt(0))
                dp[i][0] = 1;
        }
        for (int i = 1; i < s.length(); ++i) {
            for (int j = 1; j < t.length(); ++j) {
                int x = 0;
                if (s.charAt(i) == t.charAt(j))
                    x = 1 + ((j > 0) ? dp[i - 1][j - 1] : 0);
                int y = (j > 0) ? dp[i][j - 1] : 0;
                int z = dp[i - 1][j];
                dp[i][j] = Math.max(x, Math.max(y, z));
            }

        }
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        int i = s.length() - 1;
        int j = t.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == t.charAt(j)) {
                sb.append(s.charAt(i));
                --i;
                --j;
            } else if (dp[i][j - 1] >= dp[i - 1][j]) {
                --j;
            } else
                --i;
        }
        System.out.println(sb.toString());
        return dp[s.length() - 1][t.length() - 1];
    }

    public static int space(String s, String t) {
        int[] dp = new int[t.length()];
        for (int i = 0; i < t.length(); ++i) {
            if (s.charAt(0) == t.charAt(i))
                dp[i] = 1;
        }
        for (int i = 1; i < s.length(); ++i) {
            int[] curr = new int[t.length()];
            for (int j = 0; j < t.length(); ++j) {
                if (s.charAt(i) == t.charAt(j))
                    curr[j] = 1;
                int x = 0;
                if (s.charAt(i) == t.charAt(j))
                    x = 1 + ((j > 0) ? dp[j - 1] : 0);
                int y = (j > 0) ? curr[j - 1] : 0;
                int z = dp[j];
                curr[j] = Math.max(x, Math.max(y, z));
            }
            dp = curr.clone();
        }
        return dp[t.length() - 1];
    }

    public static int recm(int sl, int st, String s, String t) {
        if (sl < 0 || st < 0)
            return 0;
        int x = 0;
        if (s.charAt(sl) == t.charAt(st))
            x = 1 + recm(sl - 1, st - 1, s, t);
        int y = recm(sl, st - 1, s, t);
        int z = recm(sl - 1, st, s, t);
        return Math.max(x, Math.max(y, z));
    }

    public static void main(String[] args) {
        // Default input strings for LCS problem
        String s = "AGGTAB";
        String t = "GXTXAYB";

        int result = lcs(s, t);
        System.out.println("Length of Longest Common Subsequence: " + result);
    }
}
