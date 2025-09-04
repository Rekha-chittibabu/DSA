class Solution {
            public int[] kWeakestRows(int[][] mat, int k) {
                PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            // Case 1: compare by soldier count
            if (a[0] != b[0]) {
                return b[0] - a[0];   // more soldiers = stronger
            }
            // Case 2: same soldier count → compare by index
            return b[1] - a[1];       // higher index = stronger
        });


        for(int i = 0;i<mat.length;i++){
            int soldiers=0;
            for(int value:mat[i]){
                if(value==1) 
                    soldiers++;
                else break;
            }
            maxHeap.add(new int[]{soldiers,i});
            if(maxHeap.size()>k)
                maxHeap.poll(); // remove strongest row

            
        }
        int[] result = new int[k];
        for(int i=k-1;i>=0;i--)
            result[i]=maxHeap.poll()[1]; // get row index
        return result;
    }
}