class Solution {
    public boolean findSubarrays(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      int n = nums.length;
      for(int i = 0; i < n-1; i++){
        int sum = nums[i] + nums[i+1];
        if(map.containsKey(sum)){
            return true;
        }
        map.put(sum, i);
      } 
      return false;
    }
}