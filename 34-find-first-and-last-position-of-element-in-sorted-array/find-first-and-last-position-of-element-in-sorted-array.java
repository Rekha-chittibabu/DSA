class Solution {
//     🔑 Core Insight

// When you find the target, don’t return immediately.
// // Instead, store the index and keep searching.
// 🧠 Mental Model (Very Important)
// Question	Action on match
// First occurrence	Move left
// Last occurrence	Move right

// Match ≠ Stop
// Match = Direction change

// 🔁 One-line Interview Explanation

// “I use binary search. When I find the target, I store the index and continue searching—left for first occurrence, right for last—until the search space ends.”
    public int[] searchRange(int[] nums, int target) {
       int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }
    int findFirst(int[] nums,int tgt){
        int low = 0;
        int high = nums.length-1;
        int index = -1;

        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == tgt){
                high = mid - 1;
                index = mid;
            }
            else if(nums[mid] < tgt){
                low = mid + 1;
            }
            else high = mid - 1;
        }
    return index;
    }

    int findLast(int[] nums,int tgt){
        int low = 0;
        int high = nums.length-1;
        int index = -1;

        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == tgt){
                low = mid + 1;
                index = mid; 
            }
            else if (nums[mid]>tgt){
                high = mid - 1;
            }
            else low = mid + 1;
        }
    return index;
    }
    
   
}
    