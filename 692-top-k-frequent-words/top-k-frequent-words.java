class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. store freq of each word in a map
        Map<String,Integer> freqMap = new HashMap<>();
        for(String word : words){
            freqMap.put(word,freqMap.getOrDefault(word,0)+1);
        }

        // 2. Min-heap with custom comparator
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a.getValue().equals(b.getValue())) {
                    return b.getKey().compareTo(a.getKey()); 
                }
                return a.getValue() - b.getValue();
            }
        );

        // 3. traverse freq map and add to min heap
        for(Map.Entry<String,Integer>  entry : freqMap.entrySet()){
            String word = entry.getKey();
            int freq = entry.getValue();
            minHeap.add(entry);

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        // 4. extract ele from heap 
        List<String> result = new ArrayList<>();
        while(minHeap.size()!=0){
            result.add(minHeap.poll().getKey());
        }
        Collections.reverse(result);
        return result;


    }
}