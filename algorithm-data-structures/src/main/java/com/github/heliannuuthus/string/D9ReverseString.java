package com.github.heliannuuthus.string;

public class D9ReverseString {
    public static void main(String[] args) {
        char[] charArray = "123".toCharArray();
        new Solution().reverseString(charArray);
        System.out.println(new String(charArray));
    }

    static class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
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
