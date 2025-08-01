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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;

        if(root.val>key){
            root.left = deleteNode(root.left, key);
        } else if (root.val<key){
            root.right = deleteNode(root.right, key);
        } else {
            //root.val == key
            //leaf node
            if(root.left==null && root.right == null){
                return null;
            } else if(root.left==null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else {
                TreeNode node = findPredecessor(root.left);
                root.val = node.val;
                root.left = deleteNode(root.left, node.val);
            }

        }
        return root;
    }
    public TreeNode findPredecessor(TreeNode node){
        while(node.right!=null){
            node = node.right;
        }
        return node;
    }
}