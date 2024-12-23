package com.github.heliannuuthus.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D8ThreeSum {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }

    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) return null;
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int k = i + 1;
                int j = nums.length - 1;
                while (k < j) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0) {
                        j--;
                    } else if (sum < 0) {
                        k++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (k < j && nums[k] == nums[k + 1]) k++;
                        while (k < j && nums[j] == nums[j - 1]) j--;
                        k++;
                        j--;
                    }
                }
            }
            return result;
        }
    }
}
