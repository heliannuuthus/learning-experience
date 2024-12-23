package com.github.heliannuuthus.dynamicprograming;

import java.util.Arrays;

public class D27MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new Solution().minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    private static class Solution {
        public int minCostClimbingStairs(int[] cost) {
            // dp[i] 攀升到 i 需要支付的费用
            // dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
            // dp[0] = 0 dp[1] = 0
            int[] dp = new int[cost.length + 1];
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i <= cost.length; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
                System.out.println(Arrays.toString(dp));
            }
            return dp[cost.length];
        }
    }
}
