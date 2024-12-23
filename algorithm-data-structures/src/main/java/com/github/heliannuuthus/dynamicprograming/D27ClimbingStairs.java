package com.github.heliannuuthus.dynamicprograming;

public class D27ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(4));
    }

    private static class Solution {
        public int climbStairs(int n) {
            // 1. 确定 dp 数组和下标
            // dp[i] 为爬到第 i 阶有多少种方式
            // 2. 确定状态转移方程
            // dp[i] = dp[i - 1](往前爬一阶) + dp[i - 2]（往前爬两阶）
            // 3. 定义初始化值
            // dp[1] = 1 dp[2] = 2
            // 4. 确定遍历方向
            // 从下往上遍历
            // 5. 带入值进行验证
            if (n <= 2) {
                return n;
            }
            int[] dp = new int[2];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 3; i <= n; i++) {
                if (i % 2 == 1) {
                    dp[0] += dp[1];
                } else {
                    dp[1] += dp[0];
                }
            }
            return n % 2 == 1 ? dp[0] : dp[1];
        }
    }
}
