class Solution {
    public int lengthOfLongestSubstring(String s) {

        int maxLen = 0;
        int l = 0;
        int r = 0; int len = 0;
        Map<Character,Integer> map = new HashMap<>();

        for(r = 0; r < s.length(); r++){
            Character rightChar = s.charAt(r);
            if(!map.containsKey(rightChar)){
                map.put(rightChar,r);
                len = r - l + 1;
                
            }
            else{
                // map has the char already
                int lastPos = map.get(rightChar);
                l = Math.max(l,lastPos + 1);
                len = r - l + 1;
                map.put(rightChar,r);
                
            }
            maxLen = Math.max(len,maxLen);
        }
    return maxLen ;
    }

}