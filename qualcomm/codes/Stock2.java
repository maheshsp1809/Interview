package qualcomm.codes;

class Stock2 {
    public int maxProfit(int[] prices) {
        int total = 0; // Total profit
        int valley = Integer.MAX_VALUE; // Initialize valley to the maximum possible value
        int peak = valley; // Initialize peak to valley (max value)

        for (int i = 0; i < prices.length; ++i) {
            // If the current price is less than the peak
            if (prices[i] < peak) {
                // Sell stocks before the current price (at peak) and buy at valley
                total += peak - valley; // Add the profit from previous transactions
                valley = prices[i]; // Update valley to the current price
                peak = valley; // Set peak to the new valley (as we will be looking for a new peak)
            } else {
                peak = prices[i]; // Update peak to the current price if it's higher
            }
        }

        total += peak - valley; // Add the profit from the last transaction
        return total; // Return total profit
    }

    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 4, 6, 2 };
        Stock2 st = new Stock2();
        int ans = st.maxProfit(arr);
        System.out.println(ans);
    }
}
