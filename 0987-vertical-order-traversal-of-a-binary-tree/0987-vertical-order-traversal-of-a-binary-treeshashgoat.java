/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map= new TreeMap<>(); 
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        //[col]->[level->[list]]
        
        
        dfs(root,0,0);

        //sorting
        for(Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> entry : map.entrySet()){
            TreeMap<Integer, ArrayList<Integer>> levelmap = entry.getValue();
            ArrayList<Integer> list = new ArrayList<>();
            for(Map.Entry<Integer, ArrayList<Integer>> subentry :levelmap.entrySet()){
                ArrayList<Integer> sublist = subentry.getValue();
                Collections.sort(sublist);
                list.addAll(sublist);
            }
            ans.add(list);
        }
        return ans;
    }
    public void dfs(TreeNode node, int col, int level){
        if(node==null)return;
        //insert col
        if(!map.containsKey(col))map.put(col, new TreeMap<>());
        if(!map.get(col).containsKey(level))map.get(col).put(level, new ArrayList<>());
        map.get(col).get(level).add(node.val);
        dfs(node.left, col-1, level+1);
        dfs(node.right, col+1, level+1);


    }
}