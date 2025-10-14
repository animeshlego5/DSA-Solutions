class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int lmin = Integer.MAX_VALUE;

        int profit = 0;
        for (int r : prices) {
            if (r <= lmin) {
                lmin = r;
            }
            profit = r - lmin;
            max = Math.max(profit, max);

        }
        if (0 > max) {
            return 0;
        }
        return max;
    }

}
