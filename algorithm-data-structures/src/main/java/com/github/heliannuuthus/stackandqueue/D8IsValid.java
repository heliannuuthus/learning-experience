package com.github.heliannuuthus.stackandqueue;

public class D8IsValid {

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
    }

    private static class Solution {
        public boolean isValid(String s) {
            char[] store = new char[s.length()];
            char[] chars = s.toCharArray();
            int idx = 0;
            for (char aChar : chars) {
                if (aChar == '(' || aChar == '[' || aChar == '{') {
                    store[idx++] = aChar;
                } else if (aChar == ')' || aChar == ']' || aChar == '}') {
                    if (idx == 0) {
                        return false;
                    }
                    switch (aChar) {
                        case ')':
                            if (store[--idx] != '(') {
                                return false;
                            }
                            break;
                        case ']':
                            if (store[--idx] != '[') {
                                return false;
                            }
                            break;
                        case '}':
                            if (store[--idx] != '{') {
                                return false;
                            }
                            break;
                    }
                }
            }
            return idx == 0;
        }
    }
}
