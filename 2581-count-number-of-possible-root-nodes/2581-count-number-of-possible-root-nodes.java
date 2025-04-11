class Solution {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    Map<Integer, Set<Integer>> guessMap = new HashMap<>();
    int k;
    int res = 0;
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new HashSet<>()).add(edge[0]);
        }
        for (int[] guess : guesses) {
            guessMap.computeIfAbsent(guess[0], x -> new HashSet<>()).add(guess[1]);
        }
        int correctGuesses = dfsCount(0, -1);
        reroot(0, -1, correctGuesses);

        return res;
    }
    private int dfsCount(int node, int parent) {
        int count = 0;
        for (int child : graph.get(node)) {
            if (child == parent) continue;
            count += dfsCount(child, node);
            if (guessMap.containsKey(node) && guessMap.get(node).contains(child)) {
                count++; 
            }
        }
        return count;
    }
    private void reroot(int node, int parent, int currentCount) {
        if (currentCount >= k) {
            res++;
        }
        for (int child : graph.get(node)) {
            if (child == parent) continue;

            int temp = currentCount;
            if (guessMap.containsKey(node) && guessMap.get(node).contains(child)) {
                temp--;
            }
            if (guessMap.containsKey(child) && guessMap.get(child).contains(node)) {
                temp++;
            }

            reroot(child, node, temp);
        }
    }
}
