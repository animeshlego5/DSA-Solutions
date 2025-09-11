class Solution {
    public int rob(int[] nums) {
        
       if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = nums[0]; // house 0 tak max
        int prev1 = Math.max(nums[0], nums[1]); // house 1 tak max

        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1; 
    }
}