class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; 

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 1; i <= n; i++) {
            int ch = s.charAt(i - 1) - 'a';
            dp[i] = (2 * dp[i - 1]) % MOD;

            if (last[ch] != -1) {
                dp[i] = (dp[i] - dp[last[ch]] + MOD) % MOD;
            }

            last[ch] = i - 1;
        }

        return (dp[n] - 1 + MOD) % MOD;  
    }
}
