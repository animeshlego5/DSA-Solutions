class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(map.containsKey(sum%k)){
                if((i-map.get(sum%k))>=2){
                    return true;
                }
            }
            map.putIfAbsent(sum%k, i);
            
        }
        return false;
    }
}