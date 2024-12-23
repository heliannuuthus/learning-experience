package com.github.heliannuuthus.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class D26BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int[] diffs = new int[prices.length - 1];
            int[] result = new int[Math.max(diffs.length, 2)];

            int idx = 0, sum = 0, maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                int diff = prices[i] - prices[i - 1];
                sum += diff;
                if (sum > maxProfit) {
                    maxProfit = sum;
                }
                if (sum <= 0) {
                    result[idx++] = maxProfit;
                    maxProfit = 0;
                    sum = 0;
                }
            }
            Arrays.sort(result);
            return result[result.length - 1] + result[result.length - 2];
        }
    }
}
