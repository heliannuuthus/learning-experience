package com.github.heliannuuthus.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class D17LetterCombinations {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations(""));
    }

    private static class Solution {

        Map<Character, char[]> characters =
                Map.of(
                        '2', new char[] {'a', 'b', 'c'},
                        '3', new char[] {'d', 'e', 'f'},
                        '4', new char[] {'g', 'h', 'i'},
                        '5', new char[] {'j', 'k', 'l'},
                        '6', new char[] {'m', 'n', 'o'},
                        '7', new char[] {'p', 'q', 'r', 's'},
                        '8', new char[] {'t', 'u', 'v'},
                        '9', new char[] {'w', 'x', 'y', 'z'});

        List<String> results = new ArrayList<>();
        char[] combine;

        public List<String> letterCombinations(String digits) {
            combine = new char[digits.length()];
            char[] chars = digits.toCharArray();
            backtrack(chars, 0, chars.length);
            return results;
        }

        private void backtrack(char[] chars, int start, int end) {
            if (start == end) {
                String res = new String(combine);
                if (!res.isEmpty()) {
                    results.add(res);
                }
                return;
            }
            for (char c : characters.get(chars[start])) {
                combine[start] = c;
                backtrack(chars, start + 1, end);
                combine[start] = 0;
            }
        }
    }
}
