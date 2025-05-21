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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        int n = preorder.length - 1;
        int m = inorder.length - 1;
        TreeNode root = constructTree(preorder, inorder, index, 0, n, 0, m);
        return root;

    }

    public TreeNode constructTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> index, int preIndStart,
            int preIndEnd, int inIndStart, int inIndEnd) {
        //base case
        if (preIndStart > preIndEnd || inIndStart > inIndEnd) {
            return null;
        }
        int rootValue = preorder[preIndStart];
        int rootIndex = index.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        int leftSubTree = rootIndex - inIndStart;
       
        root.left = constructTree(preorder, inorder, index, preIndStart + 1, preIndStart + leftSubTree, inIndStart,
                rootIndex - 1);
        root.right = constructTree(preorder, inorder, index, preIndStart + leftSubTree + 1, preIndEnd, rootIndex + 1,
                inIndEnd);

        return root;
    }
}