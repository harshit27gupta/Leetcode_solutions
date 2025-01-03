class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] edge1 = null;
        int[] edge2 = null;
        int[] lastCycleEdge = null;

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parent[v] != v) {
                edge1 = new int[]{parent[v], v};
                edge2 = new int[]{u, v};
                edge[1] = -1;
            } else {
                parent[v] = u;
            }
        }
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[1] == -1) continue;
            int u = edge[0];
            int v = edge[1];

            if (!union(parent, u, v)) {
                lastCycleEdge = edge;
            }
        }
        if (edge1 != null && edge2 != null && lastCycleEdge == null) {
            return edge2;
        }
        if (lastCycleEdge != null && edge1 == null) {
            return lastCycleEdge;
        }
        if (edge1 != null && edge2 != null && lastCycleEdge != null) {
            return edge1;
        }

        return new int[]{};
    }

    private boolean union(int[] parent, int u, int v) {
        int rootU = find(parent, u);
        int rootV = find(parent, v);

        if (rootU == rootV) {
            return false;
        }

        parent[rootV] = rootU;
        return true;
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
}
