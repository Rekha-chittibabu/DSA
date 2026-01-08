class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> pMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(char ch: p.toCharArray()){
            pMap.put(ch,pMap.getOrDefault(ch,0)+1);
        }

        int size = pMap.size();
        int right = 0;
        int left = 0;
       
        while(right < s.length()){
            char ch = s.charAt(right);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
            // invalid window
            if(right-left+1 > p.length()){
                // remove left char and shrink window
                char leftChar = s.charAt(left);
                sMap.put(leftChar,sMap.get(leftChar)-1);
                if(sMap.get(leftChar)==0) sMap.remove(leftChar);
                left++;
            }
            if(sMap.equals(pMap)) result.add(left);
            
            right++;
        }

        return result;

    }
}