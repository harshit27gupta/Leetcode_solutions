class Solution {
    int[][] dp;
    int n, k;

    int ceilDiv(int x, int y) {
        return (x + y - 1) / y;
    }

    int solve(List<Integer> strength, int mask, int base) {
        if (mask == (1 << n) - 1) return 0;
        if (dp[mask][base] != -1) return dp[mask][base];

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                int cost = ceilDiv(strength.get(i), base);
                res = Math.min(res, cost + solve(strength, mask | (1 << i), base + k));
            }
        }

        return dp[mask][base] = res;
    }

    public int findMinimumTime(List<Integer> strength, int k) {
        this.n = strength.size();
        this.k = k;
        dp = new int[1 << n][15]; 
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(strength, 0, 1);
    }
}
