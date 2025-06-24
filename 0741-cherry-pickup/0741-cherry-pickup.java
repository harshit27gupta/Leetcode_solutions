class Solution {
    private int[][] grid;
    private int n;
    private Integer[][][] memo;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.memo = new Integer[n][n][n];
        int res = Math.max(0, dp(0, 0, 0));
        return res;
    }

    private int dp(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;

        // Check for out-of-bound or thorn
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || 
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -1;
        }

        // If both reach bottom-right
        if (r1 == n - 1 && c1 == n - 1) return grid[r1][c1];

        // Memoization check
        if (memo[r1][c1][r2] != null) return memo[r1][c1][r2];

        // Try all 4 possible movement combinations
        int maxNext = Math.max(
            Math.max(dp(r1 + 1, c1, r2 + 1), dp(r1, c1 + 1, r2)),
            Math.max(dp(r1 + 1, c1, r2), dp(r1, c1 + 1, r2 + 1))
        );

        if (maxNext == -1) {
            memo[r1][c1][r2] = -1;
            return -1;
        }

        // Add cherries from current cells
        int cherries = grid[r1][c1];
        if (r1 != r2 || c1 != c2) {
            cherries += grid[r2][c2];
        }

        memo[r1][c1][r2] = cherries + maxNext;
        return memo[r1][c1][r2];
    }
}
