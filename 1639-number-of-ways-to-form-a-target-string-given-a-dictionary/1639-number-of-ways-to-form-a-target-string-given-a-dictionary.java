class Solution {
    public int numWays(String[] words, String target) {
        int n = words.length;
        int m = words[0].length();
        int tLen = target.length();
        long mod = (long) 1e9 + 7;
        int[][] freq = new int[26][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                freq[words[i].charAt(j) - 'a'][j]++;
            }
        }
        long[][] dp = new long[m + 1][tLen + 1];
        for (int j = 0; j <= m; j++) {
            dp[j][tLen] = 1;
        }
        for (int j = m - 1; j >= 0; j--) {
            for (int k = tLen - 1; k >= 0; k--) {
                dp[j][k] = dp[j + 1][k] % mod;
                char c = target.charAt(k);
                if (freq[c - 'a'][j] > 0) {
                    dp[j][k] = (dp[j][k] + freq[c - 'a'][j] * dp[j + 1][k + 1]) % mod;
                }
            }
        }
        return (int) dp[0][0];
    }
}
