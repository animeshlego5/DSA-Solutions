class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    public void helper(int[] nums, int i, List<Integer>subset){
        if(i==nums.length){
            res.add(new ArrayList(subset));
            return;
        }
        subset.add(nums[i]);
        helper(nums, i+1, subset);
        subset.remove(subset.size()-1);

        helper(nums,i+1, subset);
    }
}