package com.github.heliannuuthus.greedy;

public class D22BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int result = 0;
            // 第一天没有股票可以卖
            for (int i = 1; i < prices.length; i++) {
                // 如果存在连续天数无非就是将两天赚的钱加起来而已
                result += Math.max(0, prices[i] - prices[i - 1]);
            }
            return result;
        }
    }
}
