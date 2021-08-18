package main.problems.java;

public class Nr121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int startPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < startPrice) {
                startPrice = prices[i];
            } else {
                max = Math.max(max, prices[i] - startPrice);
            }
        }
        return max;
    }
}
