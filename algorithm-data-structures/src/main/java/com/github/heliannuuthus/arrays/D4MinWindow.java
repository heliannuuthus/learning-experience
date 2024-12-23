package com.github.heliannuuthus.arrays;

import java.util.Arrays;

public class D4MinWindow {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("cabwefgewcwaefgcf", "cae"));
    }

    private static class Solution {
        public String minWindow(String s, String t) {
            int[] letters = new int[58], idxs = new int[] {0, s.length() + 1};
            Arrays.fill(letters, Integer.MAX_VALUE);
            int i = 0, length = 0;
            for (char c : t.toCharArray()) {
                if (letters[c - 'A'] == Integer.MAX_VALUE) {
                    letters[c - 'A'] = 0;
                    length++;
                }
                letters[c - 'A']++;
            }
            for (int j = 0; j < s.length(); j++) {
                int jIdx = s.charAt(j) - 'A';

                if (letters[jIdx] != Integer.MAX_VALUE) {
                    letters[jIdx]--;
                }

                if (letters[jIdx] == 0) {
                    length--;
                }

                while (length == 0) {
                    int iIdx = s.charAt(i) - 'A';
                    if (letters[iIdx] == 0) {
                        length++;
                    }

                    if (letters[iIdx] != Integer.MAX_VALUE) {
                        letters[iIdx] += 1;
                    }
                    if (j - i + 1 < idxs[1] - idxs[0] + 1) {
                        idxs[0] = i;
                        idxs[1] = j + 1;
                    }
                    i++;
                }
            }
            return idxs[1] == s.length() + 1 ? "" : s.substring(idxs[0], idxs[1]);
        }
    }
}
