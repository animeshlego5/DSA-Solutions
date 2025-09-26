class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[201][201];
        return helper(triangle, 0, 0, dp);
    }
    private int helper(List<List<Integer>> triangle, int row, int col, int[][] dp){
        if(row > triangle.size() - 1)return 0;
        int number = triangle.get(row).get(col);
        if(dp[row][col]!= null){
            return dp[row][col];
        }
        
        int result =  number + Math.min(helper(triangle, row + 1, col, dp), helper(triangle, row + 1, col +1, dp));
        dp[row][col] = result;
        return result;
    }
}