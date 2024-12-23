package com.github.heliannuuthus.dynamicprograming;

public class D27FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(new Solution().fib(10));
    }

    private static class Solution {
        public int fib(int n) {
            // 1. 确定 dp 数组以及下标含义
            // dp 数组：代表第 i-1 和 i-2 个数的和，i 为当前是哪个数
            // 2. 推导 dp 公式
            // dp[i] = dp[i - 1] + dp[i - 2]
            // 3. 确定 dp 数组的初始化值
            // dp[0] = 0, dp[1] = 1
            // 4. 确定遍历顺序
            // 递增序列，从小到大从左到右
            // 5. 带入例子进行计算验证
            if (n < 2) {
                return n;
            }
            int[] dp = new int[2];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                if (i % 2 == 0) {
                    dp[0] += dp[1];
                } else {
                    dp[1] += dp[0];
                }
            }
            return n % 2 == 0 ? dp[0] : dp[1];
        }
    }
}
