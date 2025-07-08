class Solution {
    static HashMap<Integer, HashMap<Integer, Integer>> timeMap;
    static ArrayList<ArrayList<Integer>> graph;

    static void dfs(int node, int maxtime, boolean[] visited) {
        visited[node] = true;
        for (int child : graph.get(node)) {
            if (visited[child])
                continue;
            int edgeTime = timeMap.get(node).get(child);
            if (edgeTime >maxtime)
                dfs(child, maxtime, visited);
        }
    }

    static boolean check(int maxtime, int k, int n) {
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i, maxtime, visited);
            }
        }
        return cnt >= k;
    }

    public int minTime(int n, int[][] edges, int k) {
        graph = new ArrayList<>();
        timeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            timeMap.put(i, new HashMap<>());
        }

        int r = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            r = Math.max(r, t);
            graph.get(u).add(v);
            graph.get(v).add(u);
            timeMap.get(u).put(v, t);
            timeMap.get(v).put(u, t);
        }

        int l = 0, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, k, n)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
