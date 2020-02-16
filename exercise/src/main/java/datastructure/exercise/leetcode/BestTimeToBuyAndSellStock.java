package datastructure.exercise.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 1, 8, 9}));
    }
}

