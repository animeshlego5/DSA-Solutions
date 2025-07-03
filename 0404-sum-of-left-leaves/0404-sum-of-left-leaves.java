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
    int[] sum = {0};
    public int sumOfLeftLeaves(TreeNode root) {
        helper(sum, root);
        return sum[0];
    }
    public void helper(int[] sum, TreeNode node){
        if(node==null)return;
        if(node.left==null||node.right==null)return;
        if(node.left.left==null&&node.left.right==null){
            sum[0] += node.left.val;
        }
        helper(sum, node.left);
        helper(sum, node.right);
    }
}