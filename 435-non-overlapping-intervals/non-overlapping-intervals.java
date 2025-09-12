class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));
        int count = 0;
        int lastEndTime = Integer.MIN_VALUE;
        int n = intervals.length;

        for(int[] interval : intervals){
            int startTime = interval[0];
            int endTime = interval[1];

            if(startTime >= lastEndTime){
                count++;
                lastEndTime = endTime;
            }
        }
    return n - count;
    }
}