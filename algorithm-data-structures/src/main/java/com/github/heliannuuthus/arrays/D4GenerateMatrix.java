package com.github.heliannuuthus.arrays;

import java.util.Arrays;

public class D4GenerateMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().generateMatrix(4)));
    }

    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int nums = 1, t = 0, r = n - 1, b = n - 1, l = 0;
            while (nums <= n * n) {
                for (int i = l; i <= r; i++) {
                    matrix[t][i] = nums++;
                }
                t++;
                for (int i = t; i <= b; i++) {
                    matrix[i][r] = nums++;
                }
                r--;
                for (int i = r; i >= l; i--) {
                    matrix[b][i] = nums++;
                }
                b--;
                for (int i = b; i >= t; i--) {
                    matrix[i][l] = nums++;
                }
                l++;
            }
            return matrix;
        }
    }
}
