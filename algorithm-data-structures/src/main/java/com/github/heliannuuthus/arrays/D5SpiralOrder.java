package com.github.heliannuuthus.arrays;

import java.util.ArrayList;
import java.util.List;

public class D5SpiralOrder {
    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        }));

    }


    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> results = new ArrayList<>();
            int t = 0, r = matrix[0].length - 1, b = matrix.length - 1, l = 0, sum = matrix[0].length * matrix.length;
            while (true) {
                for (int i = l; i <= r; i++) {
                    results.add(matrix[t][i]);
                }
                if (++t > b) {
                    break;
                }
                for (int i = t; i <= b; i++) {
                    results.add(matrix[i][r]);
                }
                if (--r < l) {
                    break;
                }
                for (int i = r; i >= l; i--) {
                    results.add(matrix[b][i]);
                }
                if (--b < t) {
                    break;
                }
                for (int i = b; i >= t; i--) {
                    results.add(matrix[i][l]);
                }
                if (++l > r) {
                    break;
                }
            }
            return results;
        }
    }
}
