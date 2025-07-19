class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[right];
        int p = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, p++);
            }
        }
        swap(nums, p, right);
        
        int count = p - left + 1; // Number of elements greater than pivot
        if (count == k) return nums[p];
        else if (count > k) return quickSelect(nums, left, p - 1, k);
        else return quickSelect(nums, p + 1, right, k - count);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
