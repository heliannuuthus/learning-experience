package com.github.heliannuuthus.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D18PermuteUnique {
    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[] {1, 1, 2}));
    }

    private static class Solution {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            used = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums);
            return result;
        }

        private void backtrack(int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                if (!used[i]) {
                    used[i] = true;
                    path.add(nums[i]);
                    backtrack(nums);
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}
