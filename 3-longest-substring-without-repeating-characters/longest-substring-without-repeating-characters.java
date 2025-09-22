class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        int left = 0;
        int right = 0;
        int n = s.length();
        int len = 0;
        int maxLen = 0;

        while (right < n) {
            char rightChar = s.charAt(right);

            if (!freqMap.containsKey(rightChar) || freqMap.get(rightChar) < left) {
                // char not present in current window
                len = right - left + 1;         
                freqMap.put(rightChar, right);
                
            } else {
                // char already present in current window
                int prevPos = freqMap.get(rightChar);
                if (prevPos >= left) {
                    left = prevPos + 1;  // move left only if inside current window
                }
                freqMap.put(rightChar, right);
                len = right - left + 1;
               
            }
            maxLen = Math.max(maxLen, len);
            right++;
        }

        return maxLen;
    }
}