class Solution {
  /*  Time comp:

Building HashSet → O(n)

Outer loop → O(n)

Inner while loop → O(n) in total across all runs (not per element)

So total = O(n + n + n) = O(n) */
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int maxLen = Integer.MIN_VALUE;
        for(int num : numSet){
            if (!numSet.contains(num-1)){ // this num is start of a sequence
                int len = 1;
                while(numSet.contains(num+len)){
                    len+=1;                 
                }
                maxLen = Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}