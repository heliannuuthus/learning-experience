package com.github.heliannuuthus.hashtable;

public class D8CanConstruct {

    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("aa", "aab"));
    }

    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] chars = new int[26];

            for (char c : magazine.toCharArray()) {
                chars[c - 'a']++;
            }

            for (char c : ransomNote.toCharArray()) {
                chars[c - 'a']--;
            }

            for (int i : chars) {
                if (i < 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
