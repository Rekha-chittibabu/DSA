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
    Map<String, Integer> subTreeMap = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();

    public String preOrder(TreeNode node) {
        if (node == null) return "null";

        // serialize subtree
        String s = node.val + "," + preOrder(node.left) + "," + preOrder(node.right);

        int count = subTreeMap.getOrDefault(s, 0);
        if (count == 1) { // add only once, even if a subtree is prsent 3 times , add it only once
            res.add(node);
        }
        subTreeMap.put(s, count + 1);

        return s;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preOrder(root);
        return res;
    }
}
