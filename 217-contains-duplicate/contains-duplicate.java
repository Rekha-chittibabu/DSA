class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> seenMap = new HashMap<>();

        for (int ele : nums){
            if(!seenMap.containsKey(ele)){
                seenMap.put(ele,1);
            }
            else{
                return true;
            }
        }
    return false;
    }
}