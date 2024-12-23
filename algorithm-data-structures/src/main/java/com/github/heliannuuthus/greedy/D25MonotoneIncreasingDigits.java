package com.github.heliannuuthus.greedy;

public class D25MonotoneIncreasingDigits {

    public static void main(String[] args) {
        System.out.println(new Solution().monotoneIncreasingDigits(10));
    }

    private static class Solution {
        public int monotoneIncreasingDigits(int n) {
            char[] charArray = String.valueOf(n).toCharArray();
            int start = charArray.length;
            for (int i = charArray.length - 1; i > 0; i--) {
                if ((charArray[i]) < (charArray[i - 1])) {
                    charArray[i - 1]--;
                    start = i;
                }
            }
            for (int i = start; i < charArray.length; i++) {
                charArray[i] = '9';
            }
            return Integer.parseInt(new String(charArray));
        }
    }
}
