package com.github.heliannuuthus.backtrack;

import java.util.ArrayList;
import java.util.List;

public class D17Combine {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 4));
    }

    private static class Solution {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtrack(1, n, k);
            return result;
        }

        private void backtrack(int start, int n, int k) {
            if (k == 0) {
                result.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = start; i <= n - k + 1; i++) {
                tmp.add(i);
                backtrack(i + 1, n, k - 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
