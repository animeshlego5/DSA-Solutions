class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>(2);
            row.add(null); // buy == 0 (have stock, can sell)
            row.add(null); // buy == 1 (no stock, can buy)
            dp.add(row);
        }
        return helper(prices, 0, 1, dp, n); // Start with the option to buy
    }

    private int helper(int[] prices, int i, int buy, List<List<Integer>> dp, int n) {
        if (i == n) return 0;
        if (dp.get(i).get(buy) != null) return dp.get(i).get(buy);

        int profit;
        if (buy == 1) {
            // We can buy
            profit = Math.max(
                0 + helper(prices, i + 1, 1, dp, n),           // Skip buying
                -prices[i] + helper(prices, i + 1, 0, dp, n)   // Buy
            );
        } else {
            // We can sell
            profit = Math.max(
                0 + helper(prices, i + 1, 0, dp, n),           // Skip selling
                prices[i] + helper(prices, i + 1, 1, dp, n)    // Sell
            );
        }

        dp.get(i).set(buy, profit);
        return profit;
    }
}
