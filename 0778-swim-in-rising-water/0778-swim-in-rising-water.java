import java.util.PriorityQueue;

class Solution {
    static class Cell implements Comparable<Cell> {
        int x, y, time;

        Cell(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Cell other) {
            return this.time - other.time;
        }
    }

    private static final int[] DIRECTIONS = {0, 1, 0, -1, 0};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];
        pq.add(new Cell(0, 0, grid[0][0]));

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int x = cell.x;
            int y = cell.y;
            int time = cell.time;

            if (x == n - 1 && y == n - 1) {
                return time;
            }

            for (int d = 0; d < 4; d++) {
                int newX = x + DIRECTIONS[d];
                int newY = y + DIRECTIONS[d + 1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    pq.add(new Cell(newX, newY, Math.max(time, grid[newX][newY])));
                }
            }
        }

        return -1;
    }
}
