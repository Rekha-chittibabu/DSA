class Solution {
    public int findMin(int[] nums) {
//        🔑 Core Insight (Most Important)
// A rotated sorted array consists of two sorted parts.
// The minimum element is the only element where order breaks.
// That break happens right after the maximum.

        int low = 0;
        int n = nums.length;
        int high = n-1;
        if (n==1) return nums[low];
        
        while(low < high){
            int mid = (low+high)/2;
            
            if(nums[mid] > nums[high]){ // if ele lesser than both adjacent ele then that is min             
               low = mid + 1;
            }


              // Right part is sorted, min must be on left or at mid(as pivot is on left)
               else high = mid;
                // Why do we write high = mid;
// instead of high = mid - 1;
// we do high = mid (not mid - 1) because:

// in the case of finding the minimum,
// mid could be the minimum itself.

// We don't want to skip mid by doing high = mid - 1.


        }
    return nums[low];
    }
}