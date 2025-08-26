class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 1;
        int left = 0;
        int right = 0; 
        int bitmask = 0;
        for(; right < nums.length; right++){
            while((bitmask & nums[right])!=0){
                bitmask ^= nums[left];
                left++;
            }
            bitmask |= nums[right];
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}