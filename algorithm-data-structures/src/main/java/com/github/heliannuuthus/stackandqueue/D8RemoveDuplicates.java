package com.github.heliannuuthus.stackandqueue;

public class D8RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("abbaca"));
    }

    private static class Solution {
        public String removeDuplicates(String s) {
            char[] chars = s.toCharArray();
            int left = 0, right = 0;
            while (right < chars.length) {
                chars[left] = chars[right];
                if (left > 0 && chars[left - 1] == chars[left]) {
                    left--;
                } else {
                    left++;
                }
                right++;
            }
            return new String(chars, 0, left);
        }
    }
}
