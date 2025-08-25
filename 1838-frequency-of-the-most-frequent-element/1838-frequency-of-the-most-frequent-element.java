class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
         left = 0;
        long currSum = 0;
        int right = 0;
        for(; right < nums.length; right++){
            long target = nums[right];
            currSum += target;

            if((right - left + 1) * target -currSum > k ){
                
                currSum -= nums[left];
            }
        }
        return nums.length - left;
    }
}