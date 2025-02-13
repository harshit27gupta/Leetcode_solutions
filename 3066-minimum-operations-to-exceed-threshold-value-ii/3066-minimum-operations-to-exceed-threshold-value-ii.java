class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> result= new PriorityQueue<>();
        for (int num : nums) {
            result.offer((long)num);
        }
        int op = 0;
        while (!result.isEmpty() && result.peek() < k) {
            if (result.size() < 2) {
                return -1;
            }
        long a = result.poll();
        long b = result.poll();
            result.offer(Math.min(a, b) * 2 + Math.max(a,b));
            op++;
        }
        for (long num : result) {
            if (num < k) {
                return -1;
            }
        }
        return op;
    }
}