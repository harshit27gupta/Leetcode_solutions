class Solution {
    boolean[][] rowUsed = new boolean[9][10];
    boolean[][] colUsed = new boolean[9][10];
    boolean[][] boxUsed = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        // Initialize usage from pre-filled board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int d = board[i][j] - '0';
                    rowUsed[i][d] = true;
                    colUsed[j][d] = true;
                    boxUsed[(i / 3) * 3 + (j / 3)][d] = true;
                }
            }
        }
        solve(board, 0, 0);
    }

    boolean solve(char[][] board, int i, int j) {
        if (i == 9) return true;
        if (j == 9) return solve(board, i + 1, 0);

        if (board[i][j] != '.') return solve(board, i, j + 1);

        for (int d = 1; d <= 9; d++) {
            int boxId = (i / 3) * 3 + (j / 3);
            if (!rowUsed[i][d] && !colUsed[j][d] && !boxUsed[boxId][d]) {
                board[i][j] = (char) ('0' + d);
                rowUsed[i][d] = colUsed[j][d] = boxUsed[boxId][d] = true;

                if (solve(board, i, j + 1)) return true;

                // backtrack
                board[i][j] = '.';
                rowUsed[i][d] = colUsed[j][d] = boxUsed[boxId][d] = false;
            }
        }
        return false;
    }
}
