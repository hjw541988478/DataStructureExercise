class Solution {
    public boolean isValidInRow(char val, int i, int x, char[][] board) {
        for (int j = 0; j < 9; j++) {
            if (x != j && board[i][j] == val) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidInCol(char val, int j, int x, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (x != i && board[i][j] == val) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidInCell(char val, int i, int j, char[][] board) {
        int m = i / 3;
        int n = j / 3;
        for (int k = m * 3; k < 3 * (m + 1); k++) {
            for (int l = n * 3; l < 3 * (n + 1); l++) {
                if (k != i && l != j && board[k][l] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!isValidInRow(board[i][j], i, j, board) || !isValidInCol(board[i][j], j, i, board) || !isValidInCell(board[i][j], i, j, board)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] data = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new Solution().isValidSudoku(data));
    }
}