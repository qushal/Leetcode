class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[2][prices.length];
        for(int i=0; i<2; i++){
            Arrays.fill(dp[i], -1);
        }
        return profit(prices, 0, 0, dp);
    }
    public int profit(int [] prices, int day, int state, int[][] dp){
        if(day == prices.length) return 0;
        if(dp[state][day] != -1) return dp[state][day];
        int maxProfit = 0;
        if(state == 0){
            int buy = -prices[day] + profit(prices, day+1, 1, dp);
            int dontbuy = profit(prices, day + 1, 0, dp);
            maxProfit = Math.max(buy, dontbuy);
        }
        else{
            int sell = prices[day] +  profit(prices, day+1, 0, dp);
            int dontsell = profit(prices, day+1, 1, dp);
            maxProfit = Math.max(sell , dontsell);

        }
        return dp[state][day] = maxProfit;
    }
}