class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> sMap = new HashMap<>();

        for(char ch : s.toCharArray()){
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
        }

        // a:3,n:1,g:1,r:1,m:1 sMap
        // a:1 sMap

        for(char ch : t.toCharArray()){
            if(sMap.containsKey(ch)){
                sMap.put(ch,sMap.get(ch)-1);
                if(sMap.get(ch)==0)
                    sMap.remove(ch);
            }
            else{
                return false;
            }

        }
        if(sMap.size() > 0) return false;
        else return true;

    }
}