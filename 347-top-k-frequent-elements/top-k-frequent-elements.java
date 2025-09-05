class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        // 1. store freq in map
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int ele : nums){
            freqMap.put(ele,freqMap.getOrDefault(ele,0)+1);
        }

        // 2. traverse map and store k top in minHeap
        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();
            minHeap.add(new int[]{freq,num});

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while(minHeap.size() !=0){
            result[i++] = minHeap.poll()[1];
        }
    return result;

    }
}