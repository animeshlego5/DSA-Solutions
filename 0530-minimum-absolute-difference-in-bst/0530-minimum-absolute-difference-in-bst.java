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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        helper(root, list);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            int diff = list.get(i)-list.get(i-1);
            if(diff<min){
                min = diff;
            }
        }
        return min;
    }
    public void helper(TreeNode node, List<Integer> list){
        if(node==null)return;
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
        
    }
}