package DSAcoding;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "aabebcdd";
        String longestRepeatingSubsequence = findLongestRepeatingSubsequence(s);
        System.out.println("Longest Repeating Subsequence: " + longestRepeatingSubsequence);
    }

    public static String findLongestRepeatingSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        print(dp);
        int length = dp[n][n];
        StringBuilder sb = new StringBuilder();
        int i = n, j = n;

        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                sb.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();
    }

    public static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
