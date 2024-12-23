package com.github.heliannuuthus.greedy;

import java.util.Arrays;

public class D21FindContentChildren {
    public static void main(String[] args) {
        System.out.println(
                new Solution().findContentChildren(new int[] {1, 2, 3}, new int[] {1, 1}));
    }

    private static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0, j = 0;
            while (i < g.length && j < s.length) {
                if (g[i] <= s[j]) {
                    i++;
                }
                j++;
            }
            return i;
        }
    }
}
