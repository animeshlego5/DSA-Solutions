class Solution {
    public int fib(int n) {
        if(n<=1)return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        recur(n, dp);
        return dp[n];
    }
    private int recur(int n, int[] dp){
        if(n<=1){
            dp[n] = n;
            return dp[n];
        }
        if(dp[n]!=-1)return dp[n];
        dp[n] = recur(n-1, dp) + recur(n-2, dp);
        return dp[n];
    }
}