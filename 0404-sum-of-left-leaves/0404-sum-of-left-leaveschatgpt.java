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
        
        return helper(root);
    }
    public int helper(TreeNode node){
        if(node==null)return 0;
        int sum =  0;
        if(node.left!=null&&node.left.left==null&&node.left.right==null){
            sum += node.left.val;
        }
        sum+=helper( node.left);
        sum+=helper( node.right);
        return sum;
    }
}