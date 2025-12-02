class Solution {
  /*  Time comp:

Building HashSet → O(n)

Outer loop → O(n)

Inner while loop → O(n) in total across all runs (not per element)

So total = O(n + n + n) = O(n) */
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        int n = nums.length;
        if(n == 0) return 0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            int len = 0;
            if(!set.contains(num-1)){
                while(set.contains(num++)){
                    len++;
                }
                maxLen = Math.max(maxLen,len);
            }
        }
    return maxLen;
    }
}