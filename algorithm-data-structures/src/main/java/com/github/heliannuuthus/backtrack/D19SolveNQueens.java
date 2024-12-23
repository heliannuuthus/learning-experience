package com.github.heliannuuthus.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D19SolveNQueens {

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }

    private static class Solution {

        List<List<String>> result = new ArrayList<>();
        char[][] path;

        public List<List<String>> solveNQueens(int n) {
            path = new char[n][n];
            for (char[] chars : path) {
                Arrays.fill(chars, '.');
            }
            backtrack(0);
            return result;
        }

        private void backtrack(int row) {
            if (row == path.length) {
                List<String> tmp = new ArrayList<>();
                for (char[] chars : path) {
                    tmp.add(new String(chars));
                }
                result.add(tmp);
                return;
            }
            for (int i = 0; i < path.length; i++) {
                if (findQ(row, i)) {
                    path[row][i] = '.';
                    continue;
                }
                path[row][i] = 'Q';
                backtrack(row + 1);
                path[row][i] = '.';
            }
        }

        private boolean findQ(int row, int col) {
            int i = row, j = col;
            while (i >= 0 && j >= 0) {
                if ('Q' == (path[i][j])) return true;
                i--;
                j--;
            }
            i = row;
            j = col;
            while (i >= 0 && j < path[row].length) {
                if ('Q' == (path[i][j])) return true;
                i--;
                j++;
            }
            i = row;
            j = col;
            while (i >= 0) {
                if ('Q' == (path[i--][j])) return true;
            }
            return false;
        }
    }
}
