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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            for(int i = 0; i < queue.size(); i++){
               TreeNode node =  queue.poll();
               if(node==null)continue;
               if(node.val==subRoot.val){
                 if(BFS(node, subRoot)==true)return true;
               }
               queue.offer(node.left);
               queue.offer(node.right);
            }
        }
        return false;
    }
    public boolean BFS(TreeNode a, TreeNode b){
        if(a==null && b==null)return true;
        if(a==null || b==null || a.val!=b.val)return false;
        return BFS(a.left, b.left)&&BFS(a.right, b.right);

    }
}