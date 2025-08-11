class Solution {
    static long MOD = (long) 1e9 + 7;

    static long pow(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public int[] productQueries(int n, int[][] queries) {
        long[] powers = new long[Integer.bitCount(n)];
        int idx = 0;
        for (int j = 0; j <= 31; j++) {
            if ((n & (1 << j)) != 0) {
                powers[idx++] = 1L << j;
            }
        }
        long[] prefix = new long[powers.length];
        prefix[0] = powers[0] % MOD;
        for (int i = 1; i < powers.length; i++) {
            prefix[i] = (prefix[i - 1] * powers[i]) % MOD;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                ans[i] = (int) prefix[r];
            } else {
                long val = (prefix[r] * pow(prefix[l - 1], MOD - 2)) % MOD;
                ans[i] = (int) val;
            }
        }
        return ans;
    }
}
