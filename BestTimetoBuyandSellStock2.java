public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) return 0;
        int diff;
        int global = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            diff = prices[i + 1] - prices[i];
            if(diff > 0) global += diff;
            else continue;
        }
        return global;
    }
}