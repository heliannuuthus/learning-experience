package com.github.heliannuuthus.greedy;

public class D21WiggleMaxLength {
    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[] {1, 7}));
    }

    private static class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int preSlop = 0, result = 1, currSlop;
            for (int i = 1; i < nums.length; i++) {
                currSlop = nums[i] - nums[i - 1];
                if ((preSlop >= 0 && currSlop < 0) || (preSlop <= 0 && currSlop > 0)) {
                    result++;
                    preSlop = currSlop;
                }
            }
            return result;
        }
    }
}
