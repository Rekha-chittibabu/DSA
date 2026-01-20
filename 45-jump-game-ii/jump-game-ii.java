class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int jumps = 0;      // number of jumps taken (BFS levels)
        int l = 0;          // left boundary of current BFS level
        int r = 0;          // right boundary of current BFS level

        // Continue until the current level can reach the last index
        while (r < n - 1) {

            int farthest = 0;   // farthest index reachable from this level

            // Explore all indices in the current BFS level [l..r]
            for (int i = l; i <= r; i++) {
                // From index i, we can reach up to i + nums[i]
                farthest = Math.max(farthest, i + nums[i]);
            }

            // Move to the next BFS level
            l = r + 1;          // next level starts after current r
            r = farthest;       // next level ends at farthest reachable index
            jumps++;            // one jump completed (one BFS level)
        }

        return jumps;
    }
}
