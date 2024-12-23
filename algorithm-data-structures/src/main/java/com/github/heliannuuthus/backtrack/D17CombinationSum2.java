package com.github.heliannuuthus.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D17CombinationSum2 {

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
    }

    private static class Solution {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> tmp = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtrack(0, candidates, target);
            return result;
        }

        private void backtrack(int start, int[] candidates, int target) {
            if (target == 0) {
                result.add(new ArrayList<>(tmp));
                return;
            } else if (target < 0) {
                return;
            }
            for (int i = start; i < candidates.length; i++) {

                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tmp.add(candidates[i]);
                backtrack(i + 1, candidates, target - candidates[i]);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
