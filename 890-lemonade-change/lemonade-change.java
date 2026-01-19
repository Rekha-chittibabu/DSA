class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0 ;

// Those who are wondering where is greedy approach in this question: 
// suppose a customer pays 20 Rs then we first try to give him change by giving 10 Rs and 5 Rs  and if are unable to do then we given three 5 Rs change , in this way saving 5 Rs for future customers.
        for(int bill : bills){
            if(bill == 5){
                five++;
            }
            else if (bill == 10){
                ten++;
                if(five < 1){
                    return false;
                }
                else{
                    // give 5 as change
                    five--;
                }
            }

            else{
                if(ten >= 1 && five >= 1){
                    ten--; five--;
                }
                    
                else if(five < 3) return false;
                else five = five - 3;
            }

    }
    return true;
    }
}