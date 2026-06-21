class Solution {
    public int maxProfit(int[] prices) {
        int buy  = prices[0];
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            int curr = prices[i] - buy;
            profit = Math.max(profit, curr);
            buy = Math.min(buy, prices[i]);
        }

        return profit;
    }
}