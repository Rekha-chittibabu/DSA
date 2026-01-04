class Solution {
   /* ✅ Key idea:

Use a stack to keep track of numbers for which we haven’t found the next greater yet.

Once we find a bigger number, we resolve all smaller numbers in the stack.*/

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Stack<Integer> stack = new Stack<>();   
        Map<Integer,Integer> nge = new HashMap<>();

        // Build Next greater element map

        for(int num : nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                nge.put(stack.pop(),num); // peek value is nge for num
            }
            stack.push(num);
        }

        // for rem ele in stack , nge is -1
        while(!stack.isEmpty()){
            nge.put(stack.pop(),-1);
        }

        int[] result = new int[n];

        for(int i=0;i<n;i++){
            result[i]=nge.get(nums1[i]);
        }
    return result;
    }
}