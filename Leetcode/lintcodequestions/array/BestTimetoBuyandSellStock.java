public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - min > 0){
                max = Math.max(max, prices[i] - min);
            }
            min = Math.min(min, prices[i]);
        }
        
        if(max == Integer.MIN_VALUE){
            return 0;
        }
        return max;
    }
}