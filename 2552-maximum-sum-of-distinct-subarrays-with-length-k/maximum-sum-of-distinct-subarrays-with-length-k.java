class Solution {
//    First, I calculate the sum and frequency map for the initial window of size k.
// If all elements are distinct, I update the answer.
// Then I slide the window one step at a time by adding the next element and removing the leftmost element.
// I maintain a running sum and a frequency map.
// Whenever the map size equals k, the window contains all distinct elements, so I update the maximum sum.

    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long sum = 0;
        long max = 0;

        // 1️⃣ Build first window
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }

        // check first window
        if (freq.size() == k) {
            max = sum;
        }

        // 2️⃣ Slide the window
        for (int right = k; right < nums.length; right++) {
            int left = right - k;

            // add new element
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            sum += nums[right];

            // remove old element
            freq.put(nums[left], freq.get(nums[left]) - 1);
            if (freq.get(nums[left]) == 0) {
                freq.remove(nums[left]);
            }
            sum -= nums[left];

            // check window
            if (freq.size() == k) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
