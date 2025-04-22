class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX_N = 10000;
    static long[][] comb = new long[MAX_N + 1][15];

    public int idealArrays(int n, int maxValue) {
        computeCombinations(n);

        int maxLen = 14; 
        int[][] count = new int[maxValue + 1][maxLen + 1];

        for (int i = 1; i <= maxValue; i++) {
            count[i][1] = 1;
        }

        for (int len = 2; len <= maxLen; len++) {
            for (int i = 1; i <= maxValue; i++) {
                if (count[i][len - 1] == 0) continue;
                for (int mul = 2 * i; mul <= maxValue; mul += i) {
                    count[mul][len] = (int) ((count[mul][len] + count[i][len - 1]) % MOD);
                }
            }
        }

        long result = 0;
        for (int val = 1; val <= maxValue; val++) {
            for (int len = 1; len <= maxLen; len++) {
                if (count[val][len] > 0) {
                    long ways = (count[val][len] * comb[n - 1][len - 1]) % MOD;
                    result = (result + ways) % MOD;
                }
            }
        }

        return (int) result;
    }

    private void computeCombinations(int n) {
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 15; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
    }
}