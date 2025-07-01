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
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)return res;
        StringBuilder s = new StringBuilder();
        dfs(root, s);
return res;
    }
    public void dfs(TreeNode root, StringBuilder s){
        if(root==null)return;
        int len = s.length();
        if(len==0){
                s.append(root.val);
            } else {
                s.append("->" + root.val);
            }
        if(root.left==null && root.right==null){
            res.add(s.toString());
        } else {
            dfs(root.left, s);
            dfs(root.right, s);
        }
    s.setLength(len);
    }
}