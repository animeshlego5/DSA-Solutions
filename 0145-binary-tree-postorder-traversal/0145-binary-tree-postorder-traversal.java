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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;
        while(!stack.isEmpty() || current!=null){
            
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.peek();

            if(node.right==null || node.right==prev){
                res.add(node.val);
                stack.pop();
                prev = node;
                current = null;
            } else {
                current = node.right;
            }
        
        }
        return res;
    }
}