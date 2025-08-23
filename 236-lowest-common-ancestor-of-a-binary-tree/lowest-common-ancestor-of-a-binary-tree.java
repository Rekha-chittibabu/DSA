/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode dfs(TreeNode node,TreeNode p , TreeNode q){
        if(node==null || node==p|| node==q) return node ;

        TreeNode left = dfs(node.left,p,q);
        TreeNode right = dfs(node.right,p,q);

        if(left==null)
            return right;
        else if(right==null)
            return left;
        else // both left and right not null so we found our LCA
            return node;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }
}