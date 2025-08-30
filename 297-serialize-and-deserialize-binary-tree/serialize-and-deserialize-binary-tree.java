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
    if (root == null) return "";

    Queue<TreeNode> queue = new LinkedList<>();
    StringBuilder res = new StringBuilder();

    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node == null) {
            res.append("null,");
            continue;
        }
        res.append(node.val).append(",");
        queue.add(node.left);
        queue.add(node.right);
    }
    return res.toString();
}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) return null;

    String[] s = data.split(",");
    if (s[0].equals("null")) return null;

    TreeNode root = new TreeNode(Integer.parseInt(s[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    int i = 1;
    while (!queue.isEmpty() && i < s.length) {
        TreeNode parent = queue.poll();

        // left child
        if (!s[i].equals("null")) {
            TreeNode left = new TreeNode(Integer.parseInt(s[i]));
            parent.left = left;
            queue.add(left);
        }
        i++;

        // right child
        if (i < s.length && !s[i].equals("null")) {
            TreeNode right = new TreeNode(Integer.parseInt(s[i]));
            parent.right = right;
            queue.add(right);
        }
        i++;
    }
    return root;
}

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));