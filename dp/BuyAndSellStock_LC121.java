public class BuyAndSellStock_LC121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0; // Cannot book any profit
        int min = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // Check the best profit available at this price
            maxProfit = Math.max(maxProfit, prices[i] - min);
            // Check if the current buying price is less than all the prices
            // seen till here
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }
}
