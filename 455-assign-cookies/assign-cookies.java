class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int l = 0, r = 0;

        while(l < g.length && r < s.length){
            if(g[l] <= s[r]){
                count++;
                l++; r++;
            }
            else {
                r++;
            }
        }

    return count;
    }
}