class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // strs = ["eat","bat","ate"]
        Map<String,List<String>> map = new HashMap<>();

        // word : "eat"
        for(String word : strs){
            char[] ch = word.toCharArray();  //e,a,t
            Arrays.sort(ch); // ch -> a,e,t
            String s = new String(ch); //aet
            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            
            map.get(s).add(word);
            

        }
    return new ArrayList<>(map.values());
    }
}