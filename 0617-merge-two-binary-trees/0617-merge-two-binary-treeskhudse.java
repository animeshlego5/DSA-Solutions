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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)return null;
        TreeNode dummy = new TreeNode();
        if(root1!=null && root2!=null){
            dummy.val = root1.val + root2.val;
            dummy.left = mergeTrees(root1.left, root2.left);
        dummy.right = mergeTrees(root1.right, root2.right);
        } else if (root1!=null) {
            dummy.val = root1.val;
            dummy.left = root1.left;
            dummy.right = root1.right;

        } else {
            dummy.val = root2.val;
            dummy.left = root2.left;
            dummy.right = root2.right;
        }
        
        return dummy;
    }
}