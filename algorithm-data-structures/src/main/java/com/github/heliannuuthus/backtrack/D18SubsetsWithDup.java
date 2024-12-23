package com.github.heliannuuthus.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D18SubsetsWithDup {
    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[] {4, 4, 4, 1, 4}));
    }

    private static class Solution {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backtrack(nums, 0);
            return res;
        }

        private void backtrack(int[] nums, int start) {
            if (start <= nums.length) {
                res.add(new ArrayList<>(tmp));
            }

            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                tmp.add(nums[i]);
                backtrack(nums, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
