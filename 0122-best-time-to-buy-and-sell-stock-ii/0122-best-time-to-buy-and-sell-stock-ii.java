class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // List<List<Integer>> dp = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     List<Integer> row = new ArrayList<>(2);
        //     row.add(null); // buy == 0 (have stock, can sell)
        //     row.add(null); // buy == 1 (no stock, can buy)
        //     dp.add(row);
        // }

        int[] ahead = new int[2];
        int[] cur = new int[2];
        
        int profit = 0;
        for(int i = n - 1; i >= 0; i--){
            cur[0] = Math.max(prices[i] + ahead[1], 0 + ahead[0]);
            cur[1] = Math.max(-prices[i] + ahead[0], 0 + ahead[1]); 
            ahead[0] = cur[0];
            ahead[1] = cur[1];         
        }
        return cur[1]; // Start with the option to buy
    }

    // private int helper(int[] prices, int i, int buy, List<List<Integer>> dp, int n) {
    //     if (i == n) return 0;
    //     if (dp.get(i).get(buy) != null) return dp.get(i).get(buy);

    //     int profit;
    //     if (buy == 1) {
    //         // We can buy
    //         profit = Math.max(
    //             0 + helper(prices, i + 1, 1, dp, n),           // Skip buying
    //             -prices[i] + helper(prices, i + 1, 0, dp, n)   // Buy
    //         );
    //     } else {
    //         // We can sell
    //         profit = Math.max(
    //             0 + helper(prices, i + 1, 0, dp, n),           // Skip selling
    //             prices[i] + helper(prices, i + 1, 1, dp, n)    // Sell
    //         );
    //     }

    //     dp.get(i).set(buy, profit);
    //     return profit;
    // }
}
