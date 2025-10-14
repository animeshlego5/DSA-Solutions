class Solution {
    public void sortColors(int[] nums) {
        int low = 0;       // Pointer for the 0s
        int mid = 0;       // Pointer for the 1s
        int high = nums.length - 1;  // Pointer for the 2s
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
    
    private void swap(int[] nums, int num1, int num2) {
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }
}
