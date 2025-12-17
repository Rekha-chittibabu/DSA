class Solution {
    public boolean isPossible(int[] piles,int speed,int h){
        int totalTime = 0;

        for(int banana : piles){
            totalTime += (banana + speed - 1) / speed;
            if(totalTime > h) return false;
        }
        return true;

    }
    public int minEatingSpeed(int[] piles, int h) {
        // define search space
        int low = 1; // min 1 hour
        int result = -1;
        int high = 0;

        // find max pile
        for (int p : piles) {
            high = Math.max(high, p);
        }
        while(low <= high){
            int mid = (low + high)/2;

            if(isPossible(piles,mid,h)){
                result = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
    return result;
    }
}