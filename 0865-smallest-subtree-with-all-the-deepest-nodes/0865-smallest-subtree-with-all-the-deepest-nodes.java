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
    int maxDepth = -1;
    TreeNode res;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null)return null;
        dfs(root, 0);
        return res;
    }
    private int dfs(TreeNode root, int depth){
        if(root==null){
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }
        int left = dfs(root.left, depth+1);
        int right = dfs(root.right, depth + 1);
        if(left==right && left==maxDepth){
            res = root;
        }
        return left>right?left: right;
    }
}