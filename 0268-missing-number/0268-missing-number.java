class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            int middle = right - (right - left)/2;
            if(nums[middle]==middle){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right + 1;
    }
}