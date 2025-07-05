class Solution {
    List<List<Integer>>res = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        helper(nums, 0);

        return res;
    }
    public void helper(int[] nums, int i){
        int n = nums.length;
        if(i==n-1){
            List<Integer> sublist = new ArrayList<>();
            for(int num:nums){
                sublist.add(num);
            }
            res.add(new ArrayList<>(sublist));
            return;
        }
        for(int j = i; j<n;j++){
        swap(nums, i, j);
        helper(nums, i+1);
        swap(nums, i, j);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}