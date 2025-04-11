class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxGold = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(i, j, grid, visited));
                }
            }
        }

        return maxGold;
    }

    static int dfs(int x, int y, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        visited[x][y] = true;
        int maxCollect = 0;

        for (int k = 0; k < 4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m &&
                !visited[newX][newY] && grid[newX][newY] > 0) {
                maxCollect = Math.max(maxCollect, dfs(newX, newY, grid, visited));
            }
        }

        visited[x][y] = false; 
        return grid[x][y] + maxCollect;
    }
}
