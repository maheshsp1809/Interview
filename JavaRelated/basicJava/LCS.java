package basicJava;

public class LCS {

    // Method to find the length of the longest common subsequence
    public static int lcs(String str1, String str2) {
        int m = str1.length();
        int s = str2.length();
        int[][] dp = new int[m + 1][s + 1];

        // Build the dp array from bottom-up
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= s; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][s];
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        int lcsLength = lcs(str1, str2);
        System.out.println("Length of LCS: " + lcsLength);
    }
}
