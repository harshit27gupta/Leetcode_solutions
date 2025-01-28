class Solution {
    public int dfs(int i, int j, int n, int m, int[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        int fishCount = grid[i][j];
        if (i + 1 < n && !visited[i + 1][j] && grid[i + 1][j] > 0)
            fishCount += dfs(i + 1, j, n, m, grid, visited);
        if (j + 1 < m && !visited[i][j + 1] && grid[i][j + 1] > 0)
            fishCount += dfs(i, j + 1, n, m, grid, visited);
        if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] > 0)
            fishCount += dfs(i - 1, j, n, m, grid, visited);
        if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] > 0)
            fishCount += dfs(i, j - 1, n, m, grid, visited);
        return fishCount;
    }

    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxFish = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    int fishCollected = dfs(i, j, n, m, grid, visited);
                    maxFish = Math.max(maxFish, fishCollected);
                }
            }
        }

        return maxFish;
    }
}
