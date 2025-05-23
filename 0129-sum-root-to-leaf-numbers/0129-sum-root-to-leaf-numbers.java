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
    int sum= 0;
    public int sumNumbers(TreeNode root) {

       int currSum = 0;   
       findSum(root, 0);    
        return sum;
    }
    public void findSum(TreeNode root, int currSum){
        if(root==null)return;
        int value = root.val;
        currSum = 10 * currSum + value;
        if(root.left==null && root.right==null){
            sum += currSum; 
            return;}
        findSum(root.left, currSum);
        findSum(root.right, currSum);
    }
}