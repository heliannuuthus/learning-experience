package com.github.heliannuuthus.arrays;

import java.util.Arrays;

public class D1SearchRange {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8)));
    }

    private static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int first = searchRange(nums, target, true);
            int last = searchRange(nums, target, false);
            return new int[] {first, last};
        }

        public int searchRange(int[] nums, int target, boolean leftEdge) {
            int left = 0, right = nums.length - 1, result = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    result = mid;
                    if (leftEdge) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return result;
        }
    }
}
