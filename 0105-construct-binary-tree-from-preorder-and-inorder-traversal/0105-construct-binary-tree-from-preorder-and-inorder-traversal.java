class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        // Build a hashmap to store value -> index mappings for inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1,
                     inorderIndexMap);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd,
                           Map<Integer, Integer> inorderIndexMap) {

        if (preStart > preEnd || inStart > inEnd) {
            return null; // base case
        }

        int rootVal = preorder[preStart]; // first element is root
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inorderIndexMap.get(rootVal); // index of root in inorder
        int numsLeft = inRootIndex - inStart; // # of nodes in left subtree

        root.left = build(preorder, preStart + 1, preStart + numsLeft,
                          inorder, inStart, inRootIndex - 1,
                          inorderIndexMap);

        root.right = build(preorder, preStart + numsLeft + 1, preEnd,
                           inorder, inRootIndex + 1, inEnd,
                           inorderIndexMap);

        return root;
    }
}
