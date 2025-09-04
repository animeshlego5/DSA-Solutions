class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            long low = lower_bound(nums, i + 1, nums.length-1, lower-nums[i]);
            long high = lower_bound(nums, i+1, nums.length-1, upper - nums[i] + 1);
            res += 1 *(high - low);
        }
        return res;
    }
    private long lower_bound(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]>=target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }
}