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
    public int rob(TreeNode root) {
        if(root.left==null && root.right==null)return root.val;
        int[] options = helper(root);
        return Math.max(options[1], options[0]);
    }
    private int[] helper(TreeNode root){
        if(root==null)return new int[2];

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] options = new int[2];

        //not picked is options[0];
        options[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
         
        // options[1] means picking that node
        options[1] = root.val + left[0] + right[0];

        return options;
    }
}