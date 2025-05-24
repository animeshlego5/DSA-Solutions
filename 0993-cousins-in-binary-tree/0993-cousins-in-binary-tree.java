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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                int parent = 0;
                if (current.left != null) {
                    if (current.left.val == x || current.left.val == y){
                        parent++;
                    count++;}
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    if (current.right.val == x || current.right.val == y){
                        parent++;
                    count++;}
                    queue.offer(current.right);
                }
                if (parent == 2)
                    return false;
            }
            if (count == 2)
                return true;
            // if (count==1)return false;
        }
        return false;
    }
}