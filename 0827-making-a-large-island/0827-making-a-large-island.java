class Solution {
    public void bfs(int m, int n, Queue<int[]> q, int[][] grid, int[][] vis, int[] sum, int id, Map<Integer, Integer> maxisland) {
        int[] row = {-1, 0, 0, 1};
        int[] col = {0, 1, -1, 0};
        while (!q.isEmpty()) {
            int[] val = q.poll();
            int r = val[0];
            int c = val[1];
            for (int i = 0; i < 4; i++) {
                int nrow = r + row[i];
                int ncol = c + col[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    q.offer(new int[]{nrow, ncol});
                    vis[nrow][ncol] = 1;
                    grid[nrow][ncol] = id;
                    sum[0]++;
                }
            }
        }
        maxisland.put(id, sum[0]);
    }

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Map<Integer, Integer> maxisland = new HashMap<>(); 
        int id = 2; 
        int maxi = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    int[] sum = {1}; 
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    vis[i][j] = 1;
                    grid[i][j] = id;
                    bfs(m, n, q, grid, vis, sum, id, maxisland);
                    maxi = Math.max(maxi, sum[0]); 
                    id++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) { 
                    Set<Integer> mp = new HashSet<>(); 
                    int num = 1; 
                    int[] row = {-1, 0, 0, 1};
                    int[] col = {0, 1, -1, 0};
                    for (int k = 0; k < 4; k++) {
                        int nrow = i + row[k];
                        int ncol = j + col[k];
                        if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] > 1) {
                            mp.add(grid[nrow][ncol]); 
                        }
                    }
                    for (int val : mp) {
                        num += maxisland.get(val);
                    }
                    maxi = Math.max(maxi, num); 
                }
            }
        }
        return maxi; 
    }
}
