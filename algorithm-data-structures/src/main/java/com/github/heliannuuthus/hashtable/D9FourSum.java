package com.github.heliannuuthus.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D9FourSum {

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[] {1, 1, 1, 1, 1}, 4));
    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    int k = j + 1, m = nums.length - 1;
                    while (k < m) {
                        long sum =
                                (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[m];
                        if (sum > target) {
                            m--;
                        } else if (sum < target) {
                            k++;
                        } else {
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                            while (k < m && nums[k] == nums[k + 1]) k++;
                            while (k < m && nums[m] == nums[m - 1]) m--;
                            k++;
                            m--;
                        }
                    }
                }
            }
            return res;
        }
    }
}
