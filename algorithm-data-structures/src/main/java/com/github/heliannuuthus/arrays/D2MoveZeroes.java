package com.github.heliannuuthus.arrays;

import java.util.Arrays;

public class D2MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 0, 0, 4, 5};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0, j = i;
            while (i < nums.length && j < nums.length) {
                if (nums[j] != 0) {
                    nums[i++] = nums[j];
                }
                j++;
            }
            while (i < nums.length) {
                nums[i++] = 0;
            }
        }
    }
}
