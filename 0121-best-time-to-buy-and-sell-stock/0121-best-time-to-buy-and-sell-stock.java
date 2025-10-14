class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            int cost = prices[i] - min;
            res = Math.max(res, cost);
            min = Math.min(prices[i],min); 
        }

        return res;
    }
}