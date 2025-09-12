class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int barcode : barcodes)
            freqMap.put(barcode,freqMap.getOrDefault(barcode,0)+1);
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> b[1] - a[1]
        );

        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            maxHeap.add(new int[]{key,value});
            
        }

        // build result
        int n = barcodes.length;
        int[] result = new int[n];
        int i = 0;

        while(maxHeap.size() >= 2){
            int[] first = maxHeap.poll();
            int[] second = maxHeap.poll();

            result[i++] = first[0];
            result[i++] = second[0];

            // dec freq and see if its still positive
            first[1]--;
            second[1]--;

            if(first[1] > 0){
                maxHeap.add(first);
            }
            if(second[1] > 0){
                maxHeap.add(second);
            }

        }
    // If one element left
        if (!maxHeap.isEmpty()) {
            result[i] = maxHeap.poll()[0];
        }
    return result;
    }
}