package com.github.heliannuuthus.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class D18RestoreIpAddresses {
    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("000256"));
    }

    private static class Solution {

        List<String> res = new ArrayList<>();

        List<String> path = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            char[] chars = s.toCharArray();
            backtrack(chars, 0);
            return res;
        }

        private void backtrack(char[] chars, int start) {
            // 长度要为 4 且刚好 chars 遍历完成
            if (path.size() == 4 && start == chars.length) {
                StringJoiner sj = new StringJoiner(".");
                for (String s : path) {
                    sj.add(s);
                }
                res.add(sj.toString());
            } else if (start == chars.length || path.size() >= 4) {
                return;
            }

            for (int i = start; i < chars.length; i++) {
                if (isIpAddress(chars, start, i)) {
                    path.add(String.valueOf(chars, start, i - start + 1));
                } else {
                    continue;
                }
                backtrack(chars, i + 1);
                path.remove(path.size() - 1);
            }
        }

        private boolean isIpAddress(char[] chars, int start, int end) {
            if ((end - start >= 1 && chars[start] == '0') || end - start > 2) {
                return false;
            }
            int num = 0;
            for (int i = start; i <= end; i++) {
                if (chars[i] < '0' || chars[i] > '9') {
                    return false;
                }
                num = num * 10 + (chars[i] - '0');
                if (num > 255) {
                    return false;
                }
            }
            return true;
        }
    }
}
