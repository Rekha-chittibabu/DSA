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
    int goodPairs = 0;

    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        postOrder(root, distance);
        return goodPairs;
    }

    private List<Integer> postOrder(TreeNode node, int distance) {
        if (node == null) return new ArrayList<>();

        // If it's a leaf, return a list with distance = 1
        if (node.left == null && node.right == null) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            return res;
        }

        List<Integer> left = postOrder(node.left, distance);
        List<Integer> right = postOrder(node.right, distance);

        // Count valid pairs between left and right subtrees
        for (int l : left) {
            for (int r : right) {
                if (l + r <= distance) {
                    goodPairs++;
                }
            }
        }

        // Propagate distances to parent (increment by 1)
        List<Integer> res = new ArrayList<>();
        for (int l : left) {
            if (l + 1 < distance) res.add(l + 1);
        }
        for (int r : right) {
            if (r + 1 < distance) res.add(r + 1);
        }

        return res;
    }
}
