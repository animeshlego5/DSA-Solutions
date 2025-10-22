class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> arrMap = new TreeMap<>(); //to keep it sorted
        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
            int left = Math.max(0, nums[i] - k);
            arrMap.put(left, arrMap.getOrDefault(left, 0)+1);
            int right = nums[i] + k + 1;
            arrMap.put(right, arrMap.getOrDefault(right, 0)-1);
            arrMap.put(nums[i], arrMap.getOrDefault(nums[i], 0));
        }
        int max = 1;
        int sweep = 0;
        for(Map.Entry<Integer, Integer> entry : arrMap.entrySet()){
            sweep += entry.getValue();
            int frequency = sweep - freq.getOrDefault(entry.getKey(), 0);
            max = Math.max(max, Math.min(frequency, numOperations) + freq.getOrDefault(entry.getKey(), 0));
        }
        return max;
    }
}