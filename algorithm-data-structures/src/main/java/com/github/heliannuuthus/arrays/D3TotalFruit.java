package com.github.heliannuuthus.arrays;

public class D3TotalFruit {
    public static void main(String[] args) {
        System.out.println(new Solution().totalFruit(new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    private static class Solution {
        public int totalFruit(int[] fruits) {
            int[] types = new int[fruits.length];
            int count = 0, j = 0, typeLength = -1;

            for (int i = 0; i < fruits.length; i++) {
                if (types[fruits[i]] == 0) {
                    count++; // 种类 + 1
                }
                types[fruits[i]] += 1;
                while (count > 2) {
                    types[fruits[j]] -= 1;
                    if (types[fruits[j]] == 0) {
                        count--;
                    }
                    j++;
                }
                typeLength = Math.max(typeLength, i - j + 1);
            }
            return typeLength;
        }
    }
}
