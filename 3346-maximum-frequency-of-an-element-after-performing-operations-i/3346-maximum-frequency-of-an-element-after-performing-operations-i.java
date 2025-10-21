class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        int maxnum = nums[0];
        for(int num : nums){
            if(maxnum< num){
                maxnum = num;
            }
        }
        int[] count = new int[maxnum + k +2];
        for(int num: nums){
            count[num]++;
        }
        int[] prefix = new int[count.length];
        prefix[0] = count[0];
        for(int i = 1; i < count.length; i++){
            prefix[i] = prefix[i-1] + count[i];
        }

        int ans = 0;
        for(int i = 0; i < count.length - k; i++){
            int left = Math.max(0, i -k -1);
            int right = Math.min(i+k, count.length -1);
            int mid = count[i];
            int convertible = prefix[right] - prefix[left] - mid;
            if(convertible>numOperations){
                ans = Math.max(ans, mid + numOperations);
            } else {
                ans = Math.max(ans, mid + convertible);
            }
        }
        return ans;
    }
}