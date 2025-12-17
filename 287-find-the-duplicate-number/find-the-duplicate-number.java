class Solution {
    public int findDuplicate(int[] nums) {
//         Clean, precise version (interview-grade)

// Phase 1: Use fast and slow pointers to detect a cycle by making them meet somewhere inside the loop.
// Phase 2: Reset one pointer to the start and move both one step at a time; the point where they meet is the cycle entry, which corresponds to the duplicate number.

        // 1 to n , but nums length is n+1
        int n = nums.length-1;
        //Flyod's algo same as cycle detection in LinkedList
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);

        //phase 2:
        slow= nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}