package com.github.heliannuuthus.greedy;

public class D21MaxSubArray {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[] {-2, -1}));
    }

    private static class Solution {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE, sum = 0;
            for (int num : nums) {
                sum += num;
                if (sum > max) {
                    // 此处还可以记录 idx
                    max = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
            return max;
        }
    }
}
