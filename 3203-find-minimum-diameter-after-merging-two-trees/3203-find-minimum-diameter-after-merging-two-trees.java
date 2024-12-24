import java.util.*;

class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = createAdjList(edges1, n);
        List<List<Integer>> tree2 = createAdjList(edges2, m);

        int dia1 = calculateDiameter(tree1);
        int dia2 = calculateDiameter(tree2);

        int minDia = Math.max(dia1, dia2);
        int half1 = (dia1 + 1) / 2;
        int half2 = (dia2 + 1) / 2;

        minDia = Math.max(minDia, half1 + half2 + 1);

        return minDia;
    }

    private List<List<Integer>> createAdjList(int[][] edges, int size) {
        List<List<Integer>> adj = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    private int calculateDiameter(List<List<Integer>> adj) {
        int[] farNode = {0};
        int dist1 = dfs(adj, 0, farNode);
        int dist2 = dfs(adj, farNode[0], farNode);
        return dist2;
    }

    private int dfs(List<List<Integer>> adj, int start, int[] farthestNode) {
        int size = adj.size();
        int[] dist = new int[size];
        Arrays.fill(dist, -1);

        class DfsVisit {
            void visit(int node, int d) {
                dist[node] = d;
                if (d > dist[farthestNode[0]]) {
                    farthestNode[0] = node;
                }
                for (int neighbor : adj.get(node)) {
                    if (dist[neighbor] == -1) {
                        visit(neighbor, d + 1);
                    }
                }
            }
        }

        DfsVisit dfsVisit = new DfsVisit();
        dfsVisit.visit(start, 0);

        return dist[farthestNode[0]];
    }
}
