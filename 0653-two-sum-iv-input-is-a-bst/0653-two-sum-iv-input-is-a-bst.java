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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int start = 0;
        int end= list.size()-1;
        while(start<end){
            if(list.get(end)+list.get(start)==k)return true;
            else if(list.get(end)+list.get(start)>k){
                end = end -1;
            } else {
                start = start+1;
            }
        }
        return false;
    }
    public void inorder(TreeNode node, ArrayList<Integer> list){
        if(node==null)return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}