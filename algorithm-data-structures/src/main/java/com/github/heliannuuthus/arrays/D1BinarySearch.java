package com.github.heliannuuthus.arrays;

public class D1BinarySearch {

    public static void main(String[] args) {
        System.out.println(new Solution1().search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
    }

    // binary search method2
    private static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            // 处于左闭右闭的场景，left == right 是有意义的（是存在的）
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (nums[middle] == target) {
                    return middle;
                    // 收敛左边的区间
                } else if (nums[middle] > target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            return -1;
        }
    }

    // binary search method2
    private static class Solution1 {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length;
            // 处于左闭右开的场景，left == right 是没有意义的（是不存在的）
            while (left < right) {
                int middle = left + (right - left) / 2;
                if (nums[middle] == target) {
                    return middle;
                    // 收敛左边的区间
                } else if (nums[middle] > target) {
                    right = middle;
                } else {
                    left = middle;
                }
            }
            return -1;
        }
    }
}
