class Solution {
    public List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        if(nums.length==0)return res;
        if(nums.length==1){
            res.add(nums[0]);
            return res;
        }
        int prev = 0;
        if(nums[prev]!=nums[prev+1] && nums[prev+1]!= nums[prev]+1){
            res.add(nums[prev]);
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[prev]==nums[i])continue;
            prev = i;
            if(i>0){
                if(nums[i-1]==nums[i] || nums[prev-1]==nums[i]-1){
                    continue;
                }
            }
            if(i < nums.length - 1){
                if(nums[i+1]==nums[i] || nums[i+1]==nums[i]+1){
                    continue;
                }
            }
            res.add(nums[i]);
        }
        // if(nums[nums.length-1]!=nums[nums.length-2] && nums[nums.length-1]-1!=nums[nums.length-2])res.add(nums[nums.length-1]);
        return res;
    }
}