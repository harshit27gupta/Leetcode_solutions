class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Initial window
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        result[0] = queue.peek();

        // Slide the window
        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            map.put(out, map.get(out) - 1); // Lazy deletion

            int in = nums[i];
            queue.offer(in);
            map.put(in, map.getOrDefault(in, 0) + 1);

            // Clean up invalid max elements
            while (map.get(queue.peek()) == 0) {
                queue.poll();
            }

            result[i - k + 1] = queue.peek();
        }

        return result;
    }
}