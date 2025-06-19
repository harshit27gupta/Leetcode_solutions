class Solution {
     public int countPartitions(int[] A, int k) {
        int n = A.length, mod = 1_000_000_007, acc = 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        Deque<Integer> minq = new ArrayDeque<>();
        Deque<Integer> maxq = new ArrayDeque<>();
        for (int i = 0, j = 0; j < n; ++j) {
            while (!maxq.isEmpty() && A[j] > A[maxq.peekLast()])
                maxq.pollLast();
            maxq.addLast(j);

            while (!minq.isEmpty() && A[j] < A[minq.peekLast()])
                minq.pollLast();
            minq.addLast(j);

            while (A[maxq.peekFirst()] - A[minq.peekFirst()] > k) {
                acc = (acc - dp[i++] + mod) % mod;
                if (minq.peekFirst() < i)
                    minq.pollFirst();
                if (maxq.peekFirst() < i)
                    maxq.pollFirst();
            }

            dp[j + 1] = acc;
            acc = (acc + dp[j + 1]) % mod;
        }

        return dp[n];
    }
}