package DSAcoding;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "aabebcdd";
        int length = longestRepeatingSubsequence(s);
        System.out.println("Length of the longest repeating subsequence: " + length);
    }

    public static int longestRepeatingSubsequence(String s) {
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

        return dp[n][n];
    }
}
