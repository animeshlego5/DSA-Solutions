class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {binarySearch(nums, target, true), binarySearch(nums, target, false)};
    }
    public int binarySearch(int[] nums, int target, boolean isFirst) {
        int start = 0;
        int end = nums.length - 1;
        int answer = -1;

        while (start <= end) {
            int mid = end + (start - end)/2;

            if (nums[mid] == target){
                answer = mid;
                if(isFirst){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (target > nums[mid]) {
                start = mid + 1;
            }  else if (target < nums[mid]) {
                end = mid - 1;
            }
        }
        return answer;
    }
}