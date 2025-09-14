class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length; // n workers
        
        // 1. sort ratio and quality
        double[][] pairs = new double[n][2];

        for(int i = 0; i < n; i++){
            pairs[i][0] = (double) wage[i] / quality[i]; // ratio
            pairs[i][1] = quality[i];
        }

        Arrays.sort(pairs,(a,b) -> Double.compare(a[0],b[0]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        int sumQ = 0;
        double minCost = Double.MAX_VALUE;

        for(double[] p : pairs){
            int q = (int)p[1];
            sumQ += q;
            maxHeap.add(q);

            if(maxHeap.size() > k){
                sumQ = sumQ - maxHeap.poll();
            }
            if(maxHeap.size() == k){
                minCost = Math.min(minCost, sumQ * p[0]);
            }
        }
    return minCost;
    }
}