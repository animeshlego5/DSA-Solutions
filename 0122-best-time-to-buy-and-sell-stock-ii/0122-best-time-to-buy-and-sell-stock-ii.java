class Solution {
    public int maxProfit(int[] prices) {
    int n = prices.length;
    int aheadBuy = 0, aheadSell = 0;
    int currBuy, currSell;

    for (int i = n - 1; i >= 0; i--) {
        currSell = Math.max(prices[i] + aheadBuy, aheadSell);
        currBuy = Math.max(-prices[i] + aheadSell, aheadBuy);

        aheadBuy = currBuy;
        aheadSell = currSell;
    }

    return aheadBuy; // start with the ability to buy
}

}