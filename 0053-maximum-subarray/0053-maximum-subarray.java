class Solution {
    public int maxSubArray(int[] nums) {
        int curmax = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            curmax = Math.max(curmax+nums[i],nums[i]);
            max = Math.max(curmax, max);
        }
        return max;
    }
}