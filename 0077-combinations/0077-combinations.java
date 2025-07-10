class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, new ArrayList<>(), 1);
        return res;
    }

    public void helper(int n, int k, List<Integer> sublist, int start) {
        if (sublist.size() == k) {
            res.add(new ArrayList<>(sublist));
            return;
        }
        //pick
        for (int i = start; i <= n -(k-sublist.size())+1; i++) {
            sublist.add(i);
            helper(n, k, sublist, i + 1);
            sublist.remove(sublist.size() - 1);
        }

    }
}