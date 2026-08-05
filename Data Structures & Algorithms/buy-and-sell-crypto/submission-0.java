class Solution {
    public int maxProfit(int[] prices) {
        int lowestLeft = prices[0];
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - lowestLeft);
            if (prices[i] < lowestLeft) {
                lowestLeft = prices[i];
            }
        }

        return max;
    }
}
