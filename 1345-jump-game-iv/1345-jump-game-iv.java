class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.offer(0);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int curr = q.poll();
                if (curr == n - 1) return steps;

                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    q.offer(curr - 1);
                }

                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    q.offer(curr + 1);
                }

                if (map.containsKey(arr[curr])) {
                    for (int next : map.get(arr[curr])) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            steps++;
        }

        return -1;
    }
}
