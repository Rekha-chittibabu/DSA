class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        // to store results
        List<int[]> list = new ArrayList<>();

        if(intervals.length == 1)
            return intervals;
        
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i+1][0] > end){
                // no overlap
                list.add(new int[]{start,end});
                start = intervals[i+1][0];
                end = intervals[i+1][1];
            }
            else{
                // merge
                end = Math.max(end,intervals[i+1][1]);
            }
        }

        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][]);
    }
}