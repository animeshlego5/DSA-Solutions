class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, new ArrayList<>(),0,1);
        return res;
    }
    public void helper(int k, int n, List<Integer> sublist, int i, int l){
        if(i==k){
            if(n==0){
                res.add(new ArrayList<>(sublist));
            }
            return;
        }
        for(int j = l;j<=9;j++){
            if(j<=n){
                sublist.add(j);
                helper(k,n-j, sublist, i+1,j+1);
                sublist.remove(sublist.size()-1);
            } 
        }
    }
}