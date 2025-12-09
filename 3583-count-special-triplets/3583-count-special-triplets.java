class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        for(int num : nums){
            right.put(num, right.getOrDefault(num, 0)+1);
        }
        long mod = 1000000007;
        long result = 0;
        for(int j = 0; j < n; j++){
            right.put(nums[j], right.getOrDefault(nums[j], 0)-1);
            int target = nums[j] * 2;

            long rightCount = right.getOrDefault(target, 0);
            long leftCount = left.getOrDefault(target, 0);
            result = (result + (rightCount * leftCount)%mod)%mod;

            left.put(nums[j], left.getOrDefault(nums[j], 0)+1);
        }
        return (int) result;
    }
}