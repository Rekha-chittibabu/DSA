class Solution {
    public int findPeakElement(int[] nums) {
        // finding peak ele
       
        int n = nums.length;
        
        if(n==1) return 0;
//          the crux in 2 sentences**:
// > At each step, we compare `nums[mid]` with `nums[mid + 1]`.
// > If the slope is falling, a peak lies on the left (including `mid`); if rising, the peak lies on the right.
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
        
        int low = 1;
        int high = n-2;
        while(low <= high){
            int mid = (low + high)/2;

            // // Check for peak safely at the bounds
            // boolean leftOk = (mid == 0) || (nums[mid] > nums[mid - 1]);
            // boolean rightOk = (mid == n - 1) || (nums[mid] > nums[mid + 1]);

            if ((nums[mid] > nums[mid-1]) && (nums[mid] > nums[mid+1]))
                return mid;
            else if(nums[mid] < nums[mid+1])
                low = mid + 1;
            else
                high = mid - 1;
        }
    return -1;  
    }
}