public class BestSingleTradeProfit {
    // One-pass solution: O(n) time and O(1) additional space.
    // Checking every pair takes O(n^2) time and O(1) additional space.
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minimumPrice = prices[0];
        int bestProfit = 0;

        for (int day = 1; day < prices.length; day++) {
            int profit = prices[day] - minimumPrice;

            if (profit > bestProfit) {
                bestProfit = profit;
            }
            if (prices[day] < minimumPrice) {
                minimumPrice = prices[day];
            }
        }

        return bestProfit;
    }

    public static void main(String[] args) {
        int[] first = { 7, 1, 5, 3, 6, 4 };
        int[] second = { 7, 6, 4, 3, 1 };

        System.out.println(maxProfit(first));
        System.out.println(maxProfit(second));
    }
}
