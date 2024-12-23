package com.github.heliannuuthus.greedy;

import java.util.ArrayList;
import java.util.List;

public class D25PartitionLabels {

    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    }

    private static class Solution {
        public List<Integer> partitionLabels(String s) {
            char[] charArray = s.toCharArray();
            int[] charIndex = new int[26];
            for (int i = 0; i < charArray.length; i++) {
                charIndex[charArray[i] - 'a'] = Math.max(i, charIndex[charArray[i] - 'a']);
            }
            List<Integer> result = new ArrayList<>();
            int left = 0, right = 0;
            for (int i = 0; i < charArray.length; i++) {
                right = Math.max(right, charIndex[charArray[i] - 'a']);
                if (right == i) {
                    result.add(right - left + 1);
                    left = right + 1;
                }
            }
            return result;
        }
    }
}
