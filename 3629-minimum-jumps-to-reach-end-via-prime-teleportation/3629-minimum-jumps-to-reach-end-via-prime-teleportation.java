class Solution {
    private static final int MAX_RANGE = 1_000_000 + 1;
    private static final boolean[] prime = new boolean[MAX_RANGE];
    static {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i < MAX_RANGE; i++) {
            if (prime[i] == true) {
                for (int j = i * i; j < MAX_RANGE; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
    public int minJumps(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        Map<Integer, List<Integer>> val_to_index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
            val_to_index.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        Set<Integer> visited = new HashSet<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0); 
        while (!q.isEmpty()) {
            int node = q.poll();
            if (node - 1 >= 0 && dist[node - 1] == Integer.MAX_VALUE) {
                q.offer(node - 1);
                dist[node - 1] = 1 + dist[node];
            }
            if (node + 1 < n && dist[node + 1] == Integer.MAX_VALUE) {
                q.offer(node + 1);
                dist[node + 1] = 1 + dist[node];
            }
            if (!prime[nums[node]] || visited.contains(nums[node])) {
                continue;
            }
            int i = 1;
            while (true) {
                long new_node_val = (long) nums[node] * i;
                if (new_node_val > maxi) {
                    break;
                }
                int new_node = (int)new_node_val;
                if (val_to_index.containsKey(new_node)) {
                    for (int new_node_index : val_to_index.get(new_node)) {
                        if (dist[new_node_index] == Integer.MAX_VALUE) {
                            q.offer(new_node_index);
                            dist[new_node_index] = 1 + dist[node];
                        }
                    }
                }
                i++;
            }
            visited.add(nums[node]); 
            if (dist[n - 1] != Integer.MAX_VALUE) { 
                break;
            }
        } 
        return dist[n - 1];
    }
}