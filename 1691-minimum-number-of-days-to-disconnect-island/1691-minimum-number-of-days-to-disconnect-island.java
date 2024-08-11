class Solution {
    public int minDays(int[][] grid) {
        if (countIslands(grid) != 1) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
                return 2;
    }

    private int countIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int ct= 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ct++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return ct;
    }

    static void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];

            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length &&
                grid[newX][newY] == 1 && !visited[newX][newY]) {
                dfs(grid, visited, newX, newY);
            }
        }
    }
}