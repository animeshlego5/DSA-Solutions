class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int state = 2; state<=n; state++){
            int pick = nums[state-1] + dp[state-2];
            int nopick = 0 + dp[state-1];
            dp[state] = Math.max(pick, nopick);
        }
        return dp[n];
    }
}