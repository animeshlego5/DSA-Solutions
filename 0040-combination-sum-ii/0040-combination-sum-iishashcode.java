class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<>() );
        return res;
    }
    public void helper(int i, int[] candidates, int target, List<Integer> sublist ){
     
            if(target==0){
                res.add(new ArrayList<>(sublist));
                return;
            }
        for(int ind = i; i <candidates.length; i++){
            if((ind==i || candidates[i]!=candidates[i-1])&&candidates[i]<=target){
                sublist.add(candidates[i]);
                helper(i+1,candidates,target-candidates[i],sublist);
                sublist.remove(sublist.size()-1);
            }
        }
    }
}