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

 // class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    int maxSum=0;

    // to store each node's sum(to get max sum), min and max value (to verify bst or not)
    class NodeValue {
        int sum;
        int minValue;
        int maxValue;
        
        NodeValue(int sum, int minValue, int maxValue){
            this.sum = sum;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }
    public NodeValue maxSum(TreeNode node){
        if(node == null){
            return new NodeValue(0,Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // post order traversal as we need to know children's values first to get sum of parent
        NodeValue left = maxSum(node.left);
        NodeValue right = maxSum(node.right);

        // process root
        // if current node is greater than largest of left
        // and smaller than smallest of right then its a bst
        if(left.maxValue < node.val && node.val < right.minValue){
            // it is a bst
            int currSum = left.sum + right.sum+node.val;
            maxSum = Math.max(maxSum,currSum);

            return new NodeValue(currSum,
                                 Math.min(node.val, left.minValue),
                                 Math.max(node.val, right.maxValue));
        }

         // otherwise return [-inf,inf] so that parent cannot be a valid BST
        return new NodeValue(0,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public int maxSumBST(TreeNode root) {
       NodeValue result = maxSum(root);
       return maxSum;
    }
}