package com.github.heliannuuthus.backtrack;

import java.util.Arrays;

public class D20SolveSudoku {
    public static void main(String[] args) {
        char[][] sudoku = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {
                '.', '6', '.', '.', '.', '.', '2', '8', '.',
            },
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Solution().solveSudoku(sudoku);
        System.out.println(Arrays.deepToString(sudoku));
    }

    private static class Solution {

        public void solveSudoku(char[][] board) {
            backtracking(board);
        }

        private boolean backtracking(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int k = 0; k < 9; k++) {
                    if (board[i][k] != '.') {
                        continue;
                    }
                    for (int j = '1'; j <= '9'; j++) {
                        char c = (char) j;
                        if (sudoku(board, i, k, c)) {
                            board[i][k] = c;
                            if (backtracking(board)) {
                                return true;
                            }
                            board[i][k] = '.';
                        }
                    }
                    return false;
                }
            }
            return true;
        }

        private boolean sudoku(char[][] board, int row, int col, int val) {
            for (int i = 0; i < board[row].length; i++) {
                if (board[row][i] != '.' && board[row][i] == val) {
                    return false;
                }
            }
            // 统计列
            for (char[] chars : board) {
                if (chars[col] == val) {
                    return false;
                }
            }

            // 统计块
            int rowStart = row / 3 * 3, colStart = col / 3 * 3;
            for (int i = rowStart; i < rowStart + 3; i++) {
                for (int j = colStart; j < colStart + 3; j++) {
                    if (board[i][j] != '.' && board[i][j] == val) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
