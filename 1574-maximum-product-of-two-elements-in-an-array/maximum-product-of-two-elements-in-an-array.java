class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int n:nums){
            maxHeap.add(n);
        }

        int first = maxHeap.poll();
        int second = maxHeap.poll();

        return (first - 1) * (second - 1);
    }
}