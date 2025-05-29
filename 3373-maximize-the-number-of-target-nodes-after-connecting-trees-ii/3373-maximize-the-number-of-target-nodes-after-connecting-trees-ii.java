import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> tree1;
    static ArrayList<ArrayList<Integer>> tree2;
    static void fill(ArrayList<ArrayList<Integer>> tree, int n) {
        for (int i = 0; i <= n; i++)
            tree.add(new ArrayList<>());
    }
    static void build(int[][] edges, ArrayList<ArrayList<Integer>> tree) {
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
    }
    static class Pair {
        int node;
        int parent;
        int distance;

        public Pair(int node, int parent, int distance) {
            this.node = node;
            this.parent = parent;
            this.distance = distance;
        }
    }
    static int countEvenDistanceNodes(int start, ArrayList<ArrayList<Integer>> tree) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[tree.size()];
        queue.offer(new Pair(start, -1, 0));
        int count = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (visited[current.node]) continue;
            visited[current.node] = true;

            if (current.distance % 2 == 0) {
                count++;
            }

            for (int neighbor : tree.get(current.node)) {
                if (neighbor != current.parent && !visited[neighbor]) {
                    queue.offer(new Pair(neighbor, current.node, current.distance + 1));
                }
            }
        }

        return count;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        tree1 = new ArrayList<>();
        tree2 = new ArrayList<>();
        fill(tree1, n);
        fill(tree2, m);
        build(edges1, tree1);
        build(edges2, tree2);
        int maxTree2Targets = 0;
        for (int i = 0; i < m; i++) {
            maxTree2Targets = Math.max(maxTree2Targets, countEvenDistanceNodes(i, tree2));
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = maxTree2Targets + countEvenDistanceNodes(i, tree1);
        }

        return answer;
    }
}
