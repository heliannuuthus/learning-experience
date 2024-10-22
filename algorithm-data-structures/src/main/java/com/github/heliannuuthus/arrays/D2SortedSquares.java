package com.github.heliannuuthus.arrays;

import java.util.Arrays;

public class D2SortedSquares {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().sortedSquares(new int[] {-4, -1, 0, 3, 10})));
    }

    static class Solution {

        // 左右指针开始遍历
        public int[] sortedSquares(int[] nums) {
            int i = 0, j = nums.length - 1, index = nums.length - 1;
            int[] arr = new int[nums.length];
            while (i <= j) {
                if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                    arr[index--] = nums[i] * nums[i];
                    i++;
                } else {
                    arr[index--] = nums[j] * nums[j];
                    j--;
                }
            }
            return arr;
        }
    }
}
