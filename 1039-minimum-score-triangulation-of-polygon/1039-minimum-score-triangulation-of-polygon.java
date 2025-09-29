class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        Integer[][] dp = new Integer[n][n];
        return helper(values, 0, n-1, dp);
    }
    private int helper(int[] values, int i, int j, Integer[][] dp){
        if(i+1==j)return 0;
        int result = Integer.MAX_VALUE;

        if(dp[i][j]!=null)return dp[i][j];
        for(int k = i + 1; k < j; k++){
            result = Math.min(result, values[i] * values[j] * values[k] + helper(values, i, k, dp) + helper(values, k, j, dp));
        }
        dp[i][j] = result;
        return result;
    }
}