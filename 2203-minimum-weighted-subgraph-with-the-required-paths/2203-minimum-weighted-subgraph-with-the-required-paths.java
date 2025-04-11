class Solution {
    class Pair {
        int node;
        long weight;

        Pair(int node, long weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<Pair>> graph = new ArrayList<>();
        List<List<Pair>> revgraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            revgraph.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int src = edge[0];
            int desti = edge[1];
            int weight = edge[2];

            graph.get(src).add(new Pair(desti, weight));
            revgraph.get(desti).add(new Pair(src, weight));
        }

        long distanceFromsrc1[] = new long[n];
        long distanceFromsrc2[] = new long[n];
        long distanceFromDest[] = new long[n];

        Arrays.fill(distanceFromsrc1, Long.MAX_VALUE);
        Arrays.fill(distanceFromsrc2, Long.MAX_VALUE);
        Arrays.fill(distanceFromDest, Long.MAX_VALUE);

        dijkshtra(graph, src1, distanceFromsrc1);
        dijkshtra(graph, src2, distanceFromsrc2);
        dijkshtra(revgraph, dest, distanceFromDest);

        System.out.println(Arrays.toString(distanceFromsrc1));
        System.out.println(Arrays.toString(distanceFromsrc2));
        System.out.println(Arrays.toString(distanceFromDest));

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (distanceFromsrc1[i] != Long.MAX_VALUE && distanceFromsrc2[i] != Long.MAX_VALUE
                    && distanceFromDest[i] != Long.MAX_VALUE) {
                long temp = distanceFromsrc1[i] + distanceFromsrc2[i] + distanceFromDest[i];
                ans = Math.min(ans, temp);
            }
        }

        return ans == Long.MAX_VALUE ? -1 : ans;
    }

    public void dijkshtra(List<List<Pair>> graph, int src, long ans[]) {
        int n = graph.size();
        int visited[] = new int[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return Long.compare(a.weight, b.weight);
        });

        visited[src] = 1;
        pq.add(new Pair(src, 0));
        ans[src] = 0;

        while (pq.size() > 0) {
            Pair pair = pq.remove();

            if (ans[pair.node] < pair.weight) {
                continue;
            }

            for (Pair neigh : graph.get(pair.node)) {

                if (ans[neigh.node] > pair.weight + neigh.weight) {
                    ans[neigh.node] = pair.weight + neigh.weight;
                    pq.add(new Pair(neigh.node, pair.weight + neigh.weight));
                }
            }
        }
    }
}