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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        int n = postorder.length - 1;
        int m = inorder.length - 1;
        TreeNode root = constructTree(postorder, inorder, index, 0, n, 0, m);
        return root;
    }
    public TreeNode constructTree(int[] postorder, int[] inorder, HashMap<Integer, Integer> index, int preIndStart,
            int preIndEnd, int inIndStart, int inIndEnd) {
        //base case
        if (preIndStart > preIndEnd || inIndStart > inIndEnd) {
            return null;
        }
        int rootValue = postorder[preIndEnd];
        int rootIndex = index.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        int leftSubTree = rootIndex - inIndStart;
       
        root.left = constructTree(postorder, inorder, index, preIndStart, preIndStart + leftSubTree-1, inIndStart,
                rootIndex - 1);
        root.right = constructTree(postorder, inorder, index, preIndStart + leftSubTree, preIndEnd-1, rootIndex + 1,
                inIndEnd);

        return root;
    }
}