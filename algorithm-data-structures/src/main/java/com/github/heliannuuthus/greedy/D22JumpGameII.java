package com.github.heliannuuthus.greedy;

public class D22JumpGameII {
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[] {3, 2, 1, 0, 4}));
    }

    private static class Solution {
        public int canJump(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }
            int ans = 0, right = 0, nextRight = 0;

            for (int i = 0; i <= right; i++) {
                nextRight = Math.max(nextRight, i + nums[i]);
                if (i == right) {
                    ans++;
                    right = nextRight;
                    if (nextRight >= nums.length - 1) {
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
