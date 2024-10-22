package com.github.heliannuuthus.arrays;

public class D3MinSubArrayLen {

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int length = nums.length + 1, left = 0, sum = 0;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum >= target) {
                    length = Math.min(length, right - left + 1);
                    sum -= nums[left++];
                }
            }
            return length == nums.length + 1 ? 0 : length;
        }
    }
}
