package com.github.heliannuuthus.arrays;

public class D1BinaryInsert {
    public static void main(String[] args) {}

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // 永远在小的一侧，当元素只有 2 个时进行查询会将元素变成 -1
            return right + 1;
        }
    }
}
