class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> freqMap = new HashMap<>(); // ele:freq

        for(int ele : nums) 
            freqMap.put(ele,freqMap.getOrDefault(ele,0)+1);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        // traverse the map
        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            int ele = entry.getKey();
            int freq = entry.getValue();

            // add to heap
            minHeap.add(new int[]{freq,ele});
            if(minHeap.size()>k)
                minHeap.poll();
        }

        int j = 0;
        while(minHeap.size() != 0){
            result[j++] = minHeap.poll()[1];
        }
    return result;
    }
}