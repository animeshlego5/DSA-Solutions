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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode parent = new TreeNode();
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size!=0){
                TreeNode node = queue.poll();
                if(node.left!=null){
                queue.offer(node.left);
                }  
             if(node.right!=null){
                queue.offer(node.right);
                }
                size--;
                if(size==0)list.add(node.val);
            }      
        }
        return list;
    }
}