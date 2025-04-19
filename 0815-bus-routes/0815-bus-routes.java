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

    Queue<Integer> busQueue = new LinkedList<>();
    Set<Integer> visitedBuses = new HashSet<>();
    Set<Integer> visitedStops = new HashSet<>();
    for (int bus : stopToBuses.getOrDefault(source, new ArrayList<>())) {
        busQueue.offer(bus);
        visitedBuses.add(bus);
    }

    int steps = 1;
    while (!busQueue.isEmpty()) {
        int size = busQueue.size();
        for (int i = 0; i < size; i++) {
            int bus = busQueue.poll();
            for (int stop : routes[bus]) {
                if (stop == target) return steps;
                if (visitedStops.add(stop)) {
                    for (int nextBus : stopToBuses.getOrDefault(stop, new ArrayList<>())) {
                        if (visitedBuses.add(nextBus)) {
                            busQueue.offer(nextBus);
                        }
                    }
                }
            }
        }
        steps++;
    }

    return -1;
}

}
