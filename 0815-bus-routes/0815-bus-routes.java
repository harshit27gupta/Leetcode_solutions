class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        int n = routes.length;
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, x -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();
        int steps = 0;

        queue.offer(source);
        visitedStops.add(source);

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int s = 0; s < size; s++) {
                int stop = queue.poll();
                List<Integer> buses = stopToBuses.getOrDefault(stop, new ArrayList<>());

                for (int bus : buses) {
                    if (visitedBuses.contains(bus)) continue;
                    visitedBuses.add(bus);

                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return steps;
                        if (visitedStops.add(nextStop)) {
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
