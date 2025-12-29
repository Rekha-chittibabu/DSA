class Solution {
    public int subarraySum(int[] nums, int k) {
        // “If at any point my running sum is S, and there was an earlier point where the running sum was S − k, then the elements between those two points must sum to k.
        
        Map<Integer,Integer> pSum = new HashMap<>(); //psum:count
        pSum.put(0,1);

        int r = 0;
        int currSum = 0;
        int n = nums.length;
        int  count = 0;

        while(r < n){
            currSum = currSum + nums[r];
            int diff = currSum - k;
            if(pSum.containsKey(diff)){
                count += pSum.get(diff);
            }

            pSum.put(currSum,pSum.getOrDefault(currSum,0)+1);
            r++;

        }
        return count;
    }
}