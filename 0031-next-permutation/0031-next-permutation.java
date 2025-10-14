class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int idx = -1;
        for(int i = n-2; i >=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            reverse(nums, 0, n-1);
            return;
        }

        for(int i = n-1; i > idx; i--){
            if(nums[i]>nums[idx]){
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverse(nums, idx+1, n-1);
    }
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}