class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> answer = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++){
            int difference = target - nums[i];
            if(answer.containsKey(difference)){
                
                return new int[] {answer.get(difference),i};
            }
            answer.put(nums[i],i);
        }
    return new int[]{};}
}