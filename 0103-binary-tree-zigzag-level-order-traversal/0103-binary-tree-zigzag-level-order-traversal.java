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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty()){
            
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            
            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                if(count%2==0){
                    if(node.left!=null){
                        queue.offer(node.left);
                    } 
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                } else {
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                    if(node.left!=null){
                        queue.offer(node.left);
                    } 
                }
                
                sublist.add(node.val);
            }
            count++;
            list.add(sublist);
        }
    return list;
    }
}