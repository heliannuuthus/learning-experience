package com.github.heliannuuthus.greedy;

public class D22JumpGame {
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[] {3, 2, 1, 0, 4}));
    }

    private static class Solution {
        public boolean canJump(int[] nums) {
            int right = 0;
            if (nums.length == 1) {
                return true;
            }
            for (int i = 0; i <= right; i++) {
                if (right >= nums.length - 1) {
                    return true;
                }
                right = Math.max(right, i + nums[i]);
            }
            return false;
        }
    }
}
