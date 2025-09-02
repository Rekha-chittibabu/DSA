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
 */class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // Use preorder logic → process root, then left, then right.
        // BUT since we're rewiring pointers, we recurse RIGHT first.
        flatten(root.right);
        flatten(root.left);

        // Rewire like a singly linked list (not DLL).
        root.right = prev;
        root.left = null;  // ❌ remove left link

        // Move prev pointer
        prev = root;
    }
}
