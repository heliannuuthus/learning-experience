package com.github.heliannuuthus.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D8TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numSet = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (numSet.containsKey(temp)) return new int[]{numSet.get(temp), i};
                else numSet.put(nums[i], i);
            }
            return null;
        }
    }
}

