class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;

        for(int state = 2; state <= n; state++){
            dp[state] = Math.min(cost[state-1] + dp[state-1], cost[state-2] + dp[state-2]);
        }
        return dp[n];
    }
}