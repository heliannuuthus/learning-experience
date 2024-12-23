package com.github.heliannuuthus.string;

public class D9ReverseStr {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdabcdcd", 4));
    }

    private static class Solution {
        public String reverseStr(String s, int k) {
            char[] sArrays = s.toCharArray();

            for (int i = 0; i < sArrays.length; i += (2 * k)) {
                reverseString(sArrays, i, Math.min(sArrays.length, i + k) - 1);
            }

            return new String(sArrays);
        }

        private void reverseString(char[] s, int left, int right) {
            while (left < right) {
                s[left] ^= s[right];
                s[right] ^= s[left];
                s[left] ^= s[right];
                left++;
                right--;
            }
        }
    }
}
