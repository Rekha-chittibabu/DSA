class Solution {
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