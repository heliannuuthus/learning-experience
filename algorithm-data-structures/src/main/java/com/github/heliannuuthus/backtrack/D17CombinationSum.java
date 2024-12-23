package com.github.heliannuuthus.backtrack;

import java.util.ArrayList;
import java.util.List;

public class D17CombinationSum {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[] {2, 3, 5}, 8));
    }

    private static class Solution {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> tmp = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                tmp.add(candidates[i]);
                backtrack(i, candidates, target - candidates[i]);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
