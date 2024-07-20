import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        // Create an array to store the minimum number of coins needed for each amount
        int[] dp = new int[amount + 1];
        // Initialize the dp array with a value larger than the possible maximum
        Arrays.fill(dp, amount + 1);
        // Base case: No coins are needed to make up 0 amount
        dp[0] = 0;

        // Loop through each amount from 1 to the target amount
        for (int i = 1; i <= amount; i++) {
            // Try every coin that is smaller than the current amount i
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still greater than amount, it means it's not possible to
        // make that amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        // Test cases
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println("Minimum coins needed: " + coinChange(coins, amount)); // Output: 3

        int[] coins2 = { 2 };
        int amount2 = 3;
        System.out.println("Minimum coins needed: " + coinChange(coins2, amount2)); // Output: -1

        int[] coins3 = { 1, 3, 4 };
        int amount3 = 6;
        System.out.println("Minimum coins needed: " + coinChange(coins3, amount3)); // Output: 2
    }
}
