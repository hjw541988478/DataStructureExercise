package datastructure.exercise.leetcode.recursion.backtrack;

/**
 * https://leetcode.com/problems/sudoku-solver/
 */
class Sodoku {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }

    public boolean isValid(char[][] board, int i, int j, char num) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == num) {
                return false;
            }
            if (board[k][j] == num) {
                return false;
            }
            if (board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3] == num) {
                return false;
            }
        }
        return true;

    }

    public boolean backtrack(char[][] board, int index) {
        if (index == 81) {
            return true;
        }
        int i = index / 9;
        int j = index % 9;
        if (board[i][j] == '.') {
            return backtrack(board, index + 1);
        } else {
            for (char num = '1'; num <= '9'; num++) {
                if (isValid(board, i, j, num)) {
                    board[i][j] = num;
                    if (backtrack(board, index + 1)) {
                        return true;
                    }
                    //prune
                    board[i][j] = '.';
                }
            }
            return false;
        }
    }
}