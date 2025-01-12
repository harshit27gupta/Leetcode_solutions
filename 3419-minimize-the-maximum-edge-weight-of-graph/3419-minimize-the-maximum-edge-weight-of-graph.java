import java.util.*;

class Solution {
    public int minMaxWeight(int nodeCount, int[][] edges, int threshold) {
        List<List<Integer>> reverseGraph = new ArrayList<>(nodeCount);
        for (int i = 0; i < nodeCount; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        Set<Integer> uniqueWeights = new HashSet<>();
        for (int[] edge : edges) {
            int fromNode = edge[0], toNode = edge[1];
            int weight = edge[2];
            reverseGraph.get(toNode).add(fromNode);
            uniqueWeights.add(weight);
        }
        if (!isFullyConnected(nodeCount, reverseGraph)) {
            return -1;
        }
        List<Integer> sortedWeights = new ArrayList<>(uniqueWeights);
        Collections.sort(sortedWeights);
        int left = 0;
        int right = sortedWeights.size() - 1;
        int resultWeight = -1;
     while (left <= right) {
            int midIndex = (left + right) / 2;
            int currentWeightLimit = sortedWeights.get(midIndex);
            List<List<Integer>> filteredGraph = new ArrayList<>(nodeCount);
            for (int i = 0; i < nodeCount; i++) {
                filteredGraph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                int fromNode = edge[0], toNode = edge[1], weight = edge[2];
                if (weight <= currentWeightLimit) {
                    filteredGraph.get(toNode).add(fromNode);
                }
            }
            if (canVisitAllNodes(nodeCount, filteredGraph)) {
                resultWeight = currentWeightLimit;
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
        }
        return resultWeight;
    }
    public boolean canVisitAllNodes(int nodeCount, List<List<Integer>> graph) {
        boolean[] visitedNodes = new boolean[nodeCount];
        visitedNodes[0] = true;
        int visitedCount = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graph.get(currentNode)) {
                if (!visitedNodes[neighbor]) {
                    visitedNodes[neighbor] = true;
                    visitedCount++;
                    queue.offer(neighbor);
                }
            }
        }
        return visitedCount == nodeCount;
    }
    public boolean isFullyConnected(int nodeCount, List<List<Integer>> graph) {
        boolean[] visitedNodes = new boolean[nodeCount];
        visitedNodes[0] = true;
        int visitedCount = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graph.get(currentNode)) {
                if (!visitedNodes[neighbor]) {
                    visitedNodes[neighbor] = true;
                    visitedCount++;
                    queue.offer(neighbor);
                }
            }
        }
        return visitedCount == nodeCount;
    }
}
