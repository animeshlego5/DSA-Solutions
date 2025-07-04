class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(new ArrayList<>(), 0, target, candidates);
        return res;
    }
    public void helper(List<Integer> sublist, int i, int target, int[]candidates){
        if(i==candidates.length){               
            if(target==0){
                res.add(new ArrayList<>(sublist));
            }
            return;
        }
        //pick
        if(candidates[i]<=target){
            sublist.add(candidates[i]);
            helper(sublist,i,target-candidates[i],candidates);
            sublist.remove(sublist.size()-1);
        }
        //no pick
        helper(sublist,i+1,target,candidates);
    }
}