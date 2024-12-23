package com.github.heliannuuthus.greedy;

public class D26BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int sum = 0, maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                int diff = prices[i] - prices[i - 1];
                sum += diff;
                if (sum > maxProfit) {
                    maxProfit = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
            return maxProfit;
        }
    }
}
