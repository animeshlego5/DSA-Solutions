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
    int good = 0;
    public int goodNodes(TreeNode root) {
        int prev = root.val;
        DFS(root, prev);
        return good;
    }
    public void DFS(TreeNode root, int prev){
        if(root==null)return;
        if(prev>root.val){
            
        } else {
            prev = root.val;
            good++;
        }
        DFS(root.left, prev);
        DFS(root.right, prev);
    }
}