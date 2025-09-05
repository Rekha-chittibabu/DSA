class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
    (a, b) -> {
        if (a[0] == b[0]) {
            return Integer.compare(b[1], a[1]); // tie → larger element treated as "worse"
        }
        return Integer.compare(b[0], a[0]); // compare by distance
    }
);


        for(int ele: arr){
            int dist =  Math.abs(ele-x);
            maxHeap.add(new int[]{dist,ele});
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while(maxHeap.size() != 0){
            result.add(maxHeap.peek()[1]);
            maxHeap.poll();
        }
    Collections.sort(result);
    return result;
    }
}