class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int result = 0;
        for(int i = length-1; i>=2; i--){
            if(nums[i]<nums[i-1] + nums[i-2]){
                result = Math.max(result, nums[i]+nums[i-1]+nums[i-2]);
            }
        }
        return result;
    }
}