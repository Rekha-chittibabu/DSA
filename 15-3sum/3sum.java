class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for(int i=0; i<n; i++){
            if ((i>0) && (nums[i] == nums[i-1])) continue;
            else{
                int left = i+1;
                int right = n-1;
                int target = 0 - nums[i];
                while(left<right){
                    int currSum = nums[left] + nums[right];
                    if(currSum < target){
                        left++;
                    }
                    else if (currSum > target){
                        right--;
                    }
                    else{
                        result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left++;
                        right--;

                        // Skip duplicates for left
                        while(left<right && nums[left]==nums[left-1]){
                            left++;
                        }

                        // Skip duplicates for right
                        while(left<right && nums[right]==nums[right+1]){
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }
}