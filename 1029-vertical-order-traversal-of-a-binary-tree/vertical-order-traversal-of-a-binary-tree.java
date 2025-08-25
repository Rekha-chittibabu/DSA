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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap<col, TreeMap<row, PriorityQueue<values>>>
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        // Queue for BFS: each element = (node, row, col)
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));
        
        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode node = t.node;
            int row = t.row, col = t.col;
            
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);
            
            if (node.left != null) queue.offer(new Tuple(node.left, row+1, col-1));
            if (node.right != null) queue.offer(new Tuple(node.right, row+1, col+1));
        }
        
        // Build output
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }
        
        return result;
    }
}

class Tuple {
    TreeNode node;
    int row;
    int col;
    
    Tuple(TreeNode n, int r, int c) {
        node = n;
        row = r;
        col = c;
    }
}
