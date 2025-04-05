class Solution {
    // Proper ceiling division
    static int time(int x, int y) {
        return (x + y - 1) / y;
    }

    static int ways(List<Integer> strength, int k, boolean[] visited, int base) {
        boolean allVisited = true;
        for (boolean v : visited) if (!v) allVisited = false;
        if (allVisited) return 0;

        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < strength.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;

                int currTime = time(strength.get(i), base);
                int remainingTime = ways(strength, k, visited, base + k);

                minTime = Math.min(minTime, currTime + remainingTime);

                visited[i] = false;
            }
        }

        return minTime;
    }

    public int findMinimumTime(List<Integer> strength, int k) {
        boolean[] visited = new boolean[strength.size()];
        return ways(strength, k, visited, 1);
    }
}
