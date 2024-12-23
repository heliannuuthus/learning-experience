package com.github.heliannuuthus.backtrack;

import java.util.ArrayList;
import java.util.List;

public class D18Subsets {

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[] {1, 2, 3}));
    }

    private static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrack(nums, 0);
            return result;
        }

        private void backtrack(int[] nums, int start) {
            if (start <= nums.length) {
                result.add(new ArrayList<>(tmp));
            }

            for (int i = start; i < nums.length; i++) {
                tmp.add(nums[i]);
                backtrack(nums, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
