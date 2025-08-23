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
    int maxPathSum = Integer.MIN_VALUE;
      public int dfs(TreeNode node) {
        if (node == null) return 0;

        // ignore negative paths (take 0 instead)
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // path passing through this node
        int pathThroughNode = left + right + node.val;

        // update global answer
        maxPathSum = Math.max(maxPathSum, pathThroughNode);

        // return best path going UP (choose one side)
        return Math.max(left, right) + node.val;
    }
    public int maxPathSum(TreeNode root) {
        int res = dfs(root);
        return maxPathSum;
    }
}
