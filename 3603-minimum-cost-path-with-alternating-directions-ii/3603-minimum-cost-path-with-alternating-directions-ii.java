import java.util.*;

class Solution {
    static class Pair {
        int i, j, time;
        long cost;

        Pair(int i, int j, int time, long cost) {
            this.i = i;
            this.j = j;
            this.time = time;
            this.cost = cost;
        }
    }

    static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    static long cost(int i, int j) {
        return 1L * (i + 1) * (j + 1);
    }

    public long minCost(int m, int n, int[][] waitCost) {
        PriorityQueue<Pair> cc = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
        cc.offer(new Pair(0, 0, 1, 1)); 

        long[][][] dist = new long[m][n][2];
        for (long[][] row : dist)
            for (long[] cell : row)
                Arrays.fill(cell, Long.MAX_VALUE);

        dist[0][0][1] = 1;

        while (!cc.isEmpty()) {
            Pair node = cc.poll();
            if (node.i == m - 1 && node.j == n - 1)
                return node.cost;

            int parity = node.time % 2;
            if (node.cost > dist[node.i][node.j][parity])
                continue; 

            if (parity == 0) {
                long newCost = node.cost + waitCost[node.i][node.j];
                if (newCost < dist[node.i][node.j][1]) {
                    dist[node.i][node.j][1] = newCost;
                    cc.offer(new Pair(node.i, node.j, node.time + 1, newCost));
                }
            } else {
                if (isValid(node.i + 1, node.j, m, n)) {
                    int ni = node.i + 1, nj = node.j;
                    long newCost = node.cost + cost(ni, nj);
                    if (newCost < dist[ni][nj][0]) {
                        dist[ni][nj][0] = newCost;
                        cc.offer(new Pair(ni, nj, node.time + 1, newCost));
                    }
                }

                if (isValid(node.i, node.j + 1, m, n)) {
                    int ni = node.i, nj = node.j + 1;
                    long newCost = node.cost + cost(ni, nj);
                    if (newCost < dist[ni][nj][0]) {
                        dist[ni][nj][0] = newCost;
                        cc.offer(new Pair(ni, nj, node.time + 1, newCost));
                    }
                }
            }
        }

        return -1; 
    }
}
