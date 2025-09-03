class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        int n = nums.length;
        long good = 0;
        for(int i = 0; i < n; i++){
            int val = nums[i] - i;
            good+= map.getOrDefault(val, 0L);
            map.put(val, map.getOrDefault(val, 0L)+1L);
        }
        return 1L * n*(n-1)/2 -good;
    }
}