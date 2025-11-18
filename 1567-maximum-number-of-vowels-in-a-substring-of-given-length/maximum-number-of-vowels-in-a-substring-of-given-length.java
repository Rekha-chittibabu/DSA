class Solution {
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch == 'u'){
            return true;

        }
        else return false;
    }
    public int maxVowels(String s, int k) {
        // fixed length sliding window

        int left = 0;
        int right = 0;
        int n = s.length();
        int count = 0;
        int maxCount = 0;

        // first window of length k
        for(int i = 0; i < k ; i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                count++;
            }
        }
        maxCount = count;
        right = k; 

        while(right < n){
            char rightChar = s.charAt(right);
            if(isVowel(rightChar)){
                // check left
                count++;
            }

            if(isVowel(s.charAt(left))){
                    count--;    
            }
            maxCount=Math.max(maxCount,count);
            left++;
            right++;
        }
    return maxCount;
    }
}