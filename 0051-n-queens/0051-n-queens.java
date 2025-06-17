class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // row - col + n - 1
        boolean[] diag2 = new boolean[2 * n - 1]; // row + col
        int[][] board = new int[n][n];
        solve(0, n, board, ans, col, diag1, diag2);
        return ans;
    }

    void solve(int row, int n, int[][] board, List<List<String>> ans,
               boolean[] col, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j] == 1 ? 'Q' : '.');
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }

        for (int j = 0; j < n; j++) {
            int d1 = row - j + n - 1;
            int d2 = row + j;

            if (!col[j] && !diag1[d1] && !diag2[d2]) {
                board[row][j] = 1;
                col[j] = diag1[d1] = diag2[d2] = true;

                solve(row + 1, n, board, ans, col, diag1, diag2);

                board[row][j] = 0;
                col[j] = diag1[d1] = diag2[d2] = false;
            }
        }
    }
}
