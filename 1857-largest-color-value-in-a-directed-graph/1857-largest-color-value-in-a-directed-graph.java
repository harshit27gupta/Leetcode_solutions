class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i)
            if (indegree[i] == 0)
                queue.offer(i);

        int[][] dp = new int[n][26];
        int visited = 0, res = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;
            dp[u][colors.charAt(u) - 'a']++;
            for (int v : graph.get(u)) {
                for (int c = 0; c < 26; ++c) {
                    dp[v][c] = Math.max(dp[v][c], dp[u][c]);
                }

                if (--indegree[v] == 0)
                    queue.offer(v);
            }
            for (int c = 0; c < 26; ++c)
                res = Math.max(res, dp[u][c]);
        }

        return visited == n ? res : -1; 
    }
}
