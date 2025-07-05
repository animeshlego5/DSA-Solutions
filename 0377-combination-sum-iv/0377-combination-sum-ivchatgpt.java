class Solution {
    Map<Integer, Integer> dp = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        if(target==0) return 1;
        if(dp.containsKey(target))return dp.get(target);
        int count = 0;
        for(int num:nums){
            if(num<=target){
                count+=combinationSum4(nums, target-num);
            }
        }
        dp.put(target, count);
        return count;
    }
}