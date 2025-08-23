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
    public int depth(TreeNode node){
        if(node == null) 
            return 0; 

        int leftHeight = depth(node.left);
        int rightHeight = depth(node.right);

        return 1 + Math.max(leftHeight,rightHeight);
    }
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
}