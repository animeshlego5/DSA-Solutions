class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int left = 0, maxFreq = 1;
        long cost = 0;
        int med = 0;
        for (int right = 1; right < nums.length; right++) {
            cost += nums[right] - nums[med];
            med = (left + right + 1) / 2;
            while (cost > k) {
                cost -= nums[med] - nums[left];
                left++;
                med = (left + right + 1) / 2;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}