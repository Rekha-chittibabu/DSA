class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1_map = new HashMap<>();
        Map<Character, Integer> window_map = new HashMap<>();

        int left = 0;
        int right = 0;
        int windowSize = 0;

        for(char ch : s1.toCharArray()){
            s1_map.put(ch,s1_map.getOrDefault(ch,0)+1);
        }

        windowSize = s1.length();

        while(right < s2.length()){
            char rightChar = s2.charAt(right);
            window_map.put(rightChar,window_map.getOrDefault(rightChar,0)+1);

            // invalid window case
            if(right - left + 1 > windowSize){
                char leftChar = s2.charAt(left);
                window_map.put(leftChar,window_map.getOrDefault(leftChar,0)-1);

                if(window_map.get(leftChar)==0){
                    window_map.remove(leftChar);
                }
                left++;
            }

            if(window_map.equals(s1_map)) return true;
            right++;

        }

    return false;

    }
}