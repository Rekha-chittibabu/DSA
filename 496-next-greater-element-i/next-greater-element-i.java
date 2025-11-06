class Solution {
   /* ✅ Key idea:

Use a stack to keep track of numbers for which we haven’t found the next greater yet.

Once we find a bigger number, we resolve all smaller numbers in the stack.*/

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Stack<Integer> stack = new Stack<>();   
        Map<Integer,Integer> nge = new HashMap<>();

        for(int num : nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                nge.put(stack.pop(),num);
            }
            stack.push(num);
        }

        while(!stack.isEmpty()){
            nge.put(stack.pop(),-1);
        }

        int[] result = new int[n];
        int k = 0;
        for(int ele : nums1){
            result[k] = nge.get(ele);
            k++;
        }
    return result;
    }
}