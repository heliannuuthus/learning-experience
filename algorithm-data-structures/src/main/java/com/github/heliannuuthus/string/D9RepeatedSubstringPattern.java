package com.github.heliannuuthus.string;

public class D9RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("abcabc"));
    }

    static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            char[] chars = s.toCharArray();
            int[] lps = new int[s.length()];
            lps[0] = 0;
            int i = 1, j = 0;
            while (i < chars.length) {
                if (chars[i] == chars[j]) {
                    lps[i++] = ++j;
                } else {
                    if (j > 0) {
                        j = lps[j - 1];
                    } else {
                        lps[i++] = 0;
                    }
                }
            }
            return lps[s.length() - 1] != 0
                    && (chars.length) % (chars.length - lps[s.length() - 1]) == 0;
        }
    }
}
