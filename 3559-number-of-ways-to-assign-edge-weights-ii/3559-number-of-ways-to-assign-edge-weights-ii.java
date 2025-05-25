class Solution {
    static final int MOD = 1000000007;
    static final int MAX = 18; 

    int[][] up;
    int[] depth;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) tree.add(new ArrayList<>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        depth = new int[n + 1];
        up = new int[n + 1][MAX];
        dfs(tree, 1, -1);
        for (int j = 1; j < MAX; j++) {
            for (int i = 1; i <= n; i++) {
                if (up[i][j - 1] != -1)
                    up[i][j] = up[up[i][j - 1]][j - 1];
                else
                    up[i][j] = -1;
            }
        }

        int[] res = new int[queries.length];
     for (int i = 0; i < queries.length; i++) {
    int u = queries[i][0], v = queries[i][1];
    if (u == v) {
        res[i] = 0; 
    } else {
        int lca = getLCA(u, v);
        int d = depth[u] + depth[v] - 2 * depth[lca];
        res[i] = (int) pow(2, d - 1, MOD);
    }
}
        return res;
    }

    void dfs(ArrayList<ArrayList<Integer>> tree, int node, int parent) {
        up[node][0] = parent;
        for (int nei : tree.get(node)) {
            if (nei == parent) continue;
            depth[nei] = depth[node] + 1;
            dfs(tree, nei, node);
        }
    }

    int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        for (int i = MAX - 1; i >= 0; i--) {
            if (up[u][i] != -1 && depth[up[u][i]] >= depth[v])
                u = up[u][i];
        }

        if (u == v) return u;

        for (int i = MAX - 1; i >= 0; i--) {
            if (up[u][i] != -1 && up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }
        return up[u][0];
    }

    static long pow(long a, long b, int mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}
