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
    List<TreeNode> result = new LinkedList<>();
    Map<String,Integer> subTreeMap = new HashMap<>(); // to store flattened strings/subtrees

    public String preOrder(TreeNode node){
        if(node==null){
            return "null";
        }

        String s = node.val+","+preOrder(node.left)+","+preOrder(node.right);

        int count = subTreeMap.getOrDefault(s,0); // count of subtree or 0 if not exists
        if(count==1){
            result.add(node);
        }
        subTreeMap.put(s,count+1);

        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preOrder(root);
        return result;
    }
}