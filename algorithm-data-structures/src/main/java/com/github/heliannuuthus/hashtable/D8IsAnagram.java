package com.github.heliannuuthus.hashtable;

public class D8IsAnagram {

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            int[] chars = new int[26];
            int length = 0;
            for (char c : s.toCharArray()) {
                if (chars[c - 'a'] == 0) {
                    length++;
                }
                chars[c - 'a'] += 1;
            }
            for (char c : t.toCharArray()) {
                chars[c - 'a'] -= 1;
                if (chars[c - 'a'] == 0) {
                    length--;
                }
                if (chars[c - 'a'] < 0) {
                    return false;
                }
            }
            return length == 0;
        }
    }
}
