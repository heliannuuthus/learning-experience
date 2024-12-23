package com.github.heliannuuthus.string;

import java.util.Arrays;

public class D9ReverseWords {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("   fffff ff gg ee"));
    }

    private static class Solution {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int left = 0, right = chars.length - 1;
            while (left < chars.length && right >= left) {
                if (chars[left] == ' ') {
                    left++;
                    continue;
                }
                if (chars[right] == ' ') {
                    right--;
                    continue;
                }
                break;
            }

            int i = left;
            for (int j = left; j < right; j++) {
                if (chars[j] == ' ') {
                    reverseString(chars, i, j - 1);
                    i = j + 1;
                }
            }
            reverseString(chars, i, right);
            int k = left, j = k;
            while (k <= right && j <= right) {
                while (j <= right && chars[j] == ' ' && chars[j - 1] == chars[j]) {
                    j++;
                }
                chars[k++] = chars[j++];
            }
            char[] reverseChars = Arrays.copyOfRange(chars, left, k);
            reverseString(reverseChars, 0, reverseChars.length - 1);
            return new String(reverseChars);
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
