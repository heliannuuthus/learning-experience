package com.github.heliannuuthus.string;

public class D9StrStr {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("a", "ab"));
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            char[] source = haystack.toCharArray();
            char[] target = needle.toCharArray();
            int[] lps = buildLPS(needle);
            int tIdx = 0;
            for (int i = 0; i < source.length; i++) {
                while (tIdx > 0 && target[tIdx] != source[i]) {
                    tIdx = lps[tIdx - 1];
                }
                if (source[i] == target[tIdx]) {
                    tIdx++;
                    if (tIdx == target.length) {
                        return i - tIdx + 1;
                    }
                }
            }
            return -1;
        }

        private int[] buildLPS(String target) {
            char[] chars = target.toCharArray();
            int[] lps = new int[chars.length];
            lps[0] = 0;
            int i = 1, j = 0;
            while (i < chars.length) {
                if (chars[i] == chars[j]) {
                    lps[i++] = ++j;
                } else {
                    if (j > 0) { // 只能 == 0 或者 > 0
                        j = lps[j - 1];
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }
            return lps;
        }
    }
}
