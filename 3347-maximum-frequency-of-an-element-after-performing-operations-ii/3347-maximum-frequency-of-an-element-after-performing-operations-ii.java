class Solution {
    public int maxFrequency(int[] nums, int k, int ops) {
        int n = nums.length;
        int left = 0; 
        int right = 0;
        int i = 0;
        Arrays.sort(nums);
        int res = 0;

        // if num is in array

        while(i<n){
            int same = 0;
            int num = nums[i];
            while(i<n && num==nums[i]){
                same++;
                i++;
            }
            while(right<n && nums[right] <= num+k){
                right++;
            }
            while(left<n && nums[left] < num-k){
                left++;
            }
            res = Math.max(res, Math.min(right - left, same + ops));
        }

        // num is not in the arr
        left = 0;
        right = 0;
        while(right < n){
            while(right < n && nums[left] + k >= nums[right] - k){
                right++;
            }
            res = Math.max(res, Math.min(right-left, ops));
            left++;
        }
        return res;
    }
}