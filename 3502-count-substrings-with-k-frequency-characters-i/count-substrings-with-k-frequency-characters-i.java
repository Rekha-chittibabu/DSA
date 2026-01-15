class Solution {
    public int numberOfSubstrings(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int count = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char right = s.charAt(r);
            freqMap.put(right, freqMap.getOrDefault(right, 0) + 1);

            while (freqMap.getOrDefault(right, 0) >= k) {
                count += s.length() - r;

                char left = s.charAt(l);
                freqMap.put(left, freqMap.get(left) - 1);
                if (freqMap.get(left) == 0) {
                    freqMap.remove(left);
                }
                l++;  
            }
        }
        return count;
    }
}
