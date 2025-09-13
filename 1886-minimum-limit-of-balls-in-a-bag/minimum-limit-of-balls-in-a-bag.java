class Solution {
    public boolean canDivide(int[] nums,int maxOps,int size){
        int ops = 0;

        for(int num : nums){
            ops = ops + (num - 1)/size;
            if(ops > maxOps)
                return false;
        }
        return true;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        // find max from nums
        // how to divide it ?

        int low = 1;
        int high = -1;
        for(int n : nums){
            if(n > high)
                high = n;
        }
        // Binary search on answer space
        // here , answer space is min limit of balls to max
        // min is always 1 , max is max ele in array
        while(low < high){
            int mid = (low + high )/ 2;
            boolean res = canDivide(nums,maxOperations,mid);
            if(res)
                high = mid; 
            else
                low = mid + 1;

        }
        return low;
    }
}