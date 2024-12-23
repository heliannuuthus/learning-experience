package com.github.heliannuuthus.backtrack;

import java.util.ArrayList;
import java.util.List;

public class D18Partition {
    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
    }

    private static class Solution {

        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        public List<List<String>> partition(String s) {
            char[] chars = s.toCharArray();
            backtrack(chars, 0);
            return result;
        }

        private void backtrack(char[] chars, int start) {
            if (start == chars.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < chars.length; i++) {
                if (check(chars, start, i)) {
                    path.add(String.valueOf(chars, start, i - start + 1));
                } else {
                    continue;
                }
                this.backtrack(chars, i + 1);
                path.remove(path.size() - 1);
            }
        }

        private boolean check(char[] chars, int start, int end) {
            while (start < end) {
                if (chars[start] != chars[end]) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
}
