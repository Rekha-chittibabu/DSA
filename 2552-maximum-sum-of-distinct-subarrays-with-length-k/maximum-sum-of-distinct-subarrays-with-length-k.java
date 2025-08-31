class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        long maxSum = 0;
        Map<Integer, Integer> index_map = new HashMap<>(); // store element -> last index
        
        for (int i = 0; i < k; i++) {
            index_map.put(nums[i], i);  // store last index of nums[i]
            sum = sum + nums[i];
        }

        if (index_map.size() == k) {
            maxSum = sum;
        }

        for (int right = k; right < n; right++) {
            // get left ele
            int leftEle = nums[right - k];

            // remove left ele only if its last index == (right-k)
            if (index_map.get(leftEle) == right - k) {
                index_map.remove(leftEle);
            }
            sum = sum - leftEle;

            // add right ele into window
            int rightEle = nums[right];
            index_map.put(rightEle, right); // update last index
            sum += rightEle;

            //check window size for distinctness
            if (index_map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
