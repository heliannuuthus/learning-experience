package com.github.heliannuuthus.backtrack;

import java.util.ArrayList;
import java.util.List;

public class D18Permute {
    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[] {1, 2, 3}));
    }

    private static class Solution {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            backtrack(nums, Integer.MAX_VALUE);
            return result;
        }

        private void backtrack(int[] nums, int start) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (path.contains(nums[i])) {
                    continue;
                }
                path.add(nums[i]);
                backtrack(nums, i);
                path.remove(path.size() - 1);
            }
        }
    }
}
