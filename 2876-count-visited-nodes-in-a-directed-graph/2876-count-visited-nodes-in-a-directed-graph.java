class Solution {
    Set<Integer> visited = new HashSet<>();
    List<Integer> graph = new ArrayList<>();
    private int cycleLength(Set<Integer> cycleVisit, int node) {
        if (cycleVisit.contains(node)) {
            return cycleVisit.size();
        }
        cycleVisit.add(node);
        return cycleLength(cycleVisit, graph.get(node));
    }
    private void updateLength(int node, int[] ret, int len) {
        if (ret[node] > 0) return;
        ret[node] = len;
        updateLength(graph.get(node), ret, len);
    }
    private void dfs(int[] ret, int node) {
        if (ret[node] > 0) return;
        if (visited.contains(node)) {
            int cycleLength = cycleLength(new HashSet<>(), node);
            updateLength(node, ret, cycleLength);
            return;
        }
        visited.add(node);
            dfs(ret, graph.get(node));
        if (ret[node] == 0) {
            ret[node] = ret[graph.get(node)] + 1;
        }
    }
    public int[] countVisitedNodes(List<Integer> edges) {
        graph = edges;
        int n = edges.size();
        int[] ret = new int[n];

        for(int i = 0; i < n; i++) {
            if (ret[i] == 0) {
                dfs(ret, i);
            }
        }

        return ret;
    }
}