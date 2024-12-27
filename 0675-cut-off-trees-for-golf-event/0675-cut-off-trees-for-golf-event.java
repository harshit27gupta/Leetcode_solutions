class Solution {
    class Triplet {
        int height;
        int x;
        int y;
        public Triplet(int height, int x, int y) {
            this.height = height;
            this.x = x;
            this.y = y;
        }
    }
    static void dfs(int i, int j, int mat[][], boolean visited[][], int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || mat[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
       dfs(i + 1, j, mat, visited, n, m);
        dfs(i - 1, j, mat, visited, n, m);
        dfs(i, j + 1, mat, visited, n, m);
        dfs(i, j - 1, mat, visited, n, m);
    }
  public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size();
        int m = forest.get(0).size();
        int mat[][] = new int[n][m];
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.height, b.height));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = forest.get(i).get(j);
                if (mat[i][j] > 1) {
                    pq.offer(new Triplet(mat[i][j], i, j));
                }
            }
        }
        boolean visited[][] = new boolean[n][m];
        dfs(0, 0, mat, visited, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] > 0 && !visited[i][j]) {
                    return -1; 
                }
            }
        }

        ArrayList<Triplet> ts = new ArrayList<>();
        while (!pq.isEmpty()) {
            ts.add(pq.poll());
        }

        int ans = 0, startX = 0, startY = 0;
        for (Triplet tree : ts) {
            int steps = bfs(mat, startX, startY, tree.x, tree.y, n, m);
            if (steps == -1) {
                return -1;
            }
            ans += steps;
            startX = tree.x;
            startY = tree.y;
        }
        return ans;
    }

    static int bfs(int[][] mat, int startX, int startY, int targetX, int targetY, int n, int m) {
        if (startX == targetX && startY == targetY) {
            return 0;
        }

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startX, startY, 0 });
        visited[startX][startY] = true;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], steps = curr[2];
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && mat[newX][newY] > 0 && !visited[newX][newY]) {
                    if (newX == targetX && newY == targetY) {
                        return steps + 1;
                    }
                    queue.offer(new int[] { newX, newY, steps + 1 });
                    visited[newX][newY] = true;
                }
            }
        }
        return -1; 
    }
}
