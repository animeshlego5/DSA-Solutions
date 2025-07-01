class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;

        path.add(node.val);

        // Check if it's a leaf and sum matches
        if (node.left == null && node.right == null && remainingSum == node.val) {
            res.add(new ArrayList<>(path)); // Add a copy of the path
        } else {
            dfs(node.left, remainingSum - node.val, path, res);
            dfs(node.right, remainingSum - node.val, path, res);
        }

        path.remove(path.size() - 1); // Backtrack
    }
}
