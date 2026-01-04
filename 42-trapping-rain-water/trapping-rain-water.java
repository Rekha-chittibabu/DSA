class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int [] left_greatest = new int[n];
        int [] right_greatest = new int[n];
        int vol = 0;

        // Find prev greatest 
        // initilaise prev greatest for first ele
        left_greatest[0] = height[0];
        for(int i=1;i<n;i++){
            left_greatest[i] = Math.max(left_greatest[i-1],height[i]);
        }

        right_greatest[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            right_greatest[i] = Math.max(right_greatest[i+1],height[i]);
        }

        // find vol of water it can hold on of it for each elevation
        for(int i=0;i<n;i++){
            vol += Math.min(left_greatest[i], right_greatest[i]) - height[i];
        }

        return vol;
    }
}