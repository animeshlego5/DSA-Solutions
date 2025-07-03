/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    
    public String serialize(TreeNode root) {
        if(root==null)return "n";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    int i = 0;
    String[] val;
    public TreeNode deserialize(String data) {
        val = data.split(",");
        return helper();
    }
    public TreeNode helper(){
        if(val[i].equals("n")){
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val[i]));
        i++;
        node.left = helper();
        node.right = helper();
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));