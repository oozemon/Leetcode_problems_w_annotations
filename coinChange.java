// Coin change problem... leet 322:

class Solution{
    public int coinChange(int[] coins, int amount) {
        //find max amount
        int max = amount + 1;
        //create proper array size of that amount
        int [] dp = new int[max];
        //fill array with value to check against;
        Arrays.fill(dp, max);
        //initialize array with proper value;
        dp[0] = 0;
        //compute algo:
        
        //start from the first entry in the dp array
        for(int i = 1; i<dp.length; i++){
            //pull the first coin from the denominations array
            for(int j = 0; j<coins.length;j++){
                //is that denomination one in which we can look back? 
                if(coins[j] <= i){
                    //if it is? then our lowest amount is that amounts previous lowest amount plus the current coin value
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
                }
                //if it isnt, leave the old value in there, which will trigger the check at the end
            }
        }
        //now... is the amount we need possible? if it is, then use the amount calculated, if it isn't, then the amount
        //will have not been modified from what we had filled it with, it will contain the default value
        return dp[amount] > amount ? -1: dp[amount];
    }
}	
