class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            }
            if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}