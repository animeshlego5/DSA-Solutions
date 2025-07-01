class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        dfs(root, "");
        return res;
    }

    public void dfs(TreeNode root, String path) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        } else {
            path += root.val + "->";
            dfs(root.left, path);
            dfs(root.right, path);
        }
    }
}
