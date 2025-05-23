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
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        return findnodes(root);
    }
    public int findnodes(TreeNode root){
        if(root==null)return 0;
        int leftNodes = findleft(root);
        int rightNodes = findright(root);
        //if equal
        if(leftNodes==rightNodes)return (int)Math.pow(2,leftNodes)-1;
        //if not equal
        return 1 + findnodes(root.left)+ findnodes(root.right);

    }
    public int findleft(TreeNode root){
        if(root==null)return 0;
        int count = 0;
        while(root!=null){
            root =root.left;
            count++;
        }
        return count;
    }
    public int findright(TreeNode root){
        if(root==null)return 0;
        int count = 0;
        while(root!=null){
            root =root.right;
            count++;
        }
        return count;
    }
}