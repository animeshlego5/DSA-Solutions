class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return recur(cost.length, cost, dp);
    }
    private int recur(int n, int[] cost, int[] dp){
        if(n<=1){
            return 0;
        }
        if(dp[n]!=-1)return dp[n];
        dp[n] = Math.min(cost[n-1] + recur(n-1, cost, dp), cost[n-2]+recur(n-2, cost, dp));
        return dp[n];
    }
}