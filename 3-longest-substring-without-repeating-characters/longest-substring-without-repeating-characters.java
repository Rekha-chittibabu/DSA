class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> seenMap = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int right = 0;

        while(right < s.length()){
            char ch = s.charAt(right);

            if((!seenMap.containsKey(ch)) || (seenMap.get(ch) < left)){
                seenMap.put(ch,right);
                maxLen = Math.max(maxLen,right-left+1);
            }
            else{
                int pos = seenMap.get(ch);
                if(pos>=left && pos<=right){
                    left = pos+1;
                }
                seenMap.put(ch,right);
            }
        right++;
        }
        return maxLen;
    }
}