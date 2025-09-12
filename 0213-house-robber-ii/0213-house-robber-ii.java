class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        
        int n = nums.length; 

        int[] num1 = new int[n];
        int[] num2 = new int[n];
        for(int i = 0; i < nums.length -1; i++){
            num1[i] = nums[i];
            num2[i] = nums[i+1];
        }
        return Math.max(helper(num1), helper(num2));
    }
    private int helper(int[] nums){
        if(nums.length==1)return nums[0];
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[n - 1];
    }
}