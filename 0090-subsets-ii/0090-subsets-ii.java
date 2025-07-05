class Solution {
     List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>());
        return res;
    }
    public void helper(int i, int[] nums, List<Integer> sublist){
       res.add(new ArrayList<>(sublist));
          
      
        for(int j = i; j<nums.length; j++){
            if(j>i&&nums[j]==nums[j-1])continue;
           
            sublist.add(nums[j]);
            helper(j+1, nums, sublist);
            sublist.remove(sublist.size()-1);
            
        }
        
        
    }
}