class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();       
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, queue, i, j);
                    found = true;
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0], y = point[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                        if (grid[nx][ny] == 1) {
                            return steps;
                        }
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            steps++;
        }
        
        return -1; 
    }

    private void dfs(int[][] grid, boolean[][] visited, Queue<int[]> queue, int x, int y) {
        int n = grid.length;
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] == 0) {
            return;
        }

        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        
        dfs(grid, visited, queue, x + 1, y);
        dfs(grid, visited, queue, x - 1, y);
        dfs(grid, visited, queue, x, y + 1);
        dfs(grid, visited, queue, x, y - 1);
    }
}
