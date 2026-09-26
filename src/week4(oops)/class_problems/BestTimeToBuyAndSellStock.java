public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }

            int profit = prices[i] - lowestPrice;
            if (profit > maximumProfit) {
                maximumProfit = profit;
            }
        }

        return maximumProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
