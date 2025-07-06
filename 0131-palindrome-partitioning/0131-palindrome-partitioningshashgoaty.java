class Solution {
    List<List<String>> res = new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        helper(s, 0 , new ArrayList<>());
        return res;
    }
    public void helper(String s, int partition, List<String> sublist){
        if(partition == n){
            res.add(new ArrayList<>(sublist));
            return;
        }

        for(int i = partition; i<n; i++){
            if(isPalindrome(s,partition, i)){
                sublist.add(s.substring(partition, i+1));
                helper(s, i+1, sublist);
                sublist.remove(sublist.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
}