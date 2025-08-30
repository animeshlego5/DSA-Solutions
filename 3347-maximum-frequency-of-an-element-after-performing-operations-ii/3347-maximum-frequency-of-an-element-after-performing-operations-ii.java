class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Long, Long> arrMap = new TreeMap<>();
        Map<Long, Long> freq = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n; i++) {
            freq.put((long)nums[i], freq.getOrDefault((long)nums[i], 0L) + 1);
            long left = Math.max(0, nums[i] - k);
            arrMap.put(left, arrMap.getOrDefault(left, 0L) + 1);
            long right = nums[i] + k + 1;
            arrMap.put(right, arrMap.getOrDefault(right, 0L) - 1);
            arrMap.put((long)nums[i], arrMap.getOrDefault((long)nums[i], 0L));
        }
        long max = 1;
        long sweep = 0;
        for(Map.Entry<Long, Long> entry : arrMap.entrySet()) {
            sweep += entry.getValue();
            long fre = sweep - freq.getOrDefault(entry.getKey(), 0L);
            max = Math.max(max, Math.min(fre, numOperations) + freq.getOrDefault(entry.getKey(), 0L));
        }
        return (int)max;
    }
}