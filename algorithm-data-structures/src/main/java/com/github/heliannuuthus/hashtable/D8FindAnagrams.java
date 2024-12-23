package com.github.heliannuuthus.hashtable;

import java.util.*;

public class D8FindAnagrams {

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("abab", "ab"));
    }

    private static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int[] pCount = new int[26];
            int[] sCount = new int[26];
            List<Integer> result = new ArrayList<>();
            for (char c : p.toCharArray()) {
                pCount[c - 'a']++;
            }
            char[] charArray = s.toCharArray();

            for (int i = 0, j = 0; i < charArray.length; i++) {
                sCount[charArray[i] - 'a']++;
                if (i - j + 1 == p.length()) {
                    if (Arrays.equals(pCount, sCount)) {
                        result.add(j);
                    }
                    sCount[charArray[j] - 'a']--;
                    j++;
                }
            }
            return result;
        }
    }
}
