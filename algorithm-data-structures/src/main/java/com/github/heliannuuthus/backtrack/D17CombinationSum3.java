package com.github.heliannuuthus.backtrack;

import java.util.ArrayList;
import java.util.List;

public class D17CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
    }

    private static class Solution {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            backtrack(1, k, n);
            return result;
        }

        private void backtrack(int start, int k, int n) {
            if (k == 0 || n < 0) {
                if (n == 0) {
                    result.add(new ArrayList<>(tmp));
                }
                return;
            }

            for (int i = start; i <= 9 - k + 1; i++) {
                tmp.add(i);
                backtrack(i + 1, k - 1, n - i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
