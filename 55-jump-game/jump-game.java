class Solution {
    public boolean canJump(int[] nums) {
       int maxReach = 0;
       int currentReach = 0;
       int n = nums.length;

       for(int i = 0 ; i < n; i++){
            if(i > maxReach)
                return false;
            currentReach = i + nums[i];
            maxReach = Math.max(currentReach,maxReach);
            // if we can reach last index
            if (maxReach >= n - 1)
                return true;
       }
       
    return true;
    }
}