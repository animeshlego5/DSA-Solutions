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
    int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)return maxsum;
        if(root.left==null || root.right==null)return Math.max(maxsum, root.val);
        maxsum = Math.max(maxsum, root.val + root.left.val + root.right.val);
       int left = maxPathSum(root.left);
       int right = maxPathSum(root.right);
        return Math.max(left, right);
    }
}