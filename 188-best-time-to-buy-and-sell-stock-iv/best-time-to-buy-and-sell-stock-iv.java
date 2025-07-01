class Solution {
    public int maxProfit(int k, int [] prices) {
        int [][][] dp = new int[2][prices.length][k+1];
        for(int i=0; i<2; i++){
            for(int j=0; j<prices.length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return profit(prices, 0, 0, dp, k);
    }
    public int profit(int [] prices, int day, int state, int[][][] dp, int k){
        if (k == 0 || day == prices.length) return 0;
        if(dp[state][day][k] != -1) return dp[state][day][k];
        int maxProfit = 0;
        if(state == 0){
            int buy = -prices[day] + profit(prices, day + 1, 1, dp, k);
            int dontbuy = profit(prices, day + 1, 0, dp, k);
            maxProfit = Math.max(buy, dontbuy);
        }
        else{
            int sell = prices[day] + profit(prices, day+1, 0, dp, k-1);
            int dontsell = profit(prices, day+1, 1, dp, k);
            maxProfit = Math.max(sell , dontsell);
        }
        return dp[state][day][k] = maxProfit;
    }
}