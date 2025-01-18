import java.util.*;

class Solution {
    class Pair {
        int edge, wt;

        public Pair(int edge, int wt) {
            this.edge = edge;
            this.wt = wt;
        }
    }

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < m * n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int node = m * i + j;
                if (grid[i][j] == 1) {
                    if (j + 1 < m) graph.get(node).add(new Pair(node + 1, 0));
                    if (i + 1 < n) graph.get(node).add(new Pair(node + m, 1));
                    if (i - 1 >= 0) graph.get(node).add(new Pair(node - m, 1));
                    if (j - 1 >= 0) graph.get(node).add(new Pair(node - 1, 1));
                } else if (grid[i][j] == 2) {
                    if (j + 1 < m) graph.get(node).add(new Pair(node + 1, 1));
                    if (i + 1 < n) graph.get(node).add(new Pair(node + m, 1));
                    if (i - 1 >= 0) graph.get(node).add(new Pair(node - m, 1));
                    if (j - 1 >= 0) graph.get(node).add(new Pair(node - 1, 0));
                } else if (grid[i][j] == 3) {
                    if (j + 1 < m) graph.get(node).add(new Pair(node + 1, 1));
                    if (i + 1 < n) graph.get(node).add(new Pair(node + m, 0));
                    if (i - 1 >= 0) graph.get(node).add(new Pair(node - m, 1));
                    if (j - 1 >= 0) graph.get(node).add(new Pair(node - 1, 1));
                } else {
                    if (j + 1 < m) graph.get(node).add(new Pair(node + 1, 1));
                    if (i + 1 < n) graph.get(node).add(new Pair(node + m, 1));
                    if (i - 1 >= 0) graph.get(node).add(new Pair(node - m, 0));
                    if (j - 1 >= 0) graph.get(node).add(new Pair(node - 1, 1));
                }
            }
        }

        return dijkstra(graph, n, m);
    }
    private int dijkstra(ArrayList<ArrayList<Pair>> graph, int n, int m) {
        int[] dist = new int[n * m];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(0, 0)); 

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.edge;
            int cost = current.wt;

            if (cost > dist[node]) continue;

            for (Pair neighbor : graph.get(node)) {
                int newCost = cost + neighbor.wt;
                if (newCost < dist[neighbor.edge]) {
                    dist[neighbor.edge] = newCost;
                    pq.add(new Pair(neighbor.edge, newCost));
                }
            }
        }

        return dist[n * m - 1]; 
    }
}
