class Solution {
    // static int mod=(int)(1e9+7);
    // static int ways(int n,int k,int dp[][]){
    // if (n == 0)
    //         return k == 0 ? 1 : 0;
    //     if (k < 0) 
    //         return 0;
    //     if (dp[n][k] != -1) 
    //         return dp[n][k];
    //     int res = 0;
    //     for (int i = 0; i<=Math.min(k,n-1); i++) {
    //         res = (res + ways(n - 1, k - i, dp)) % mod;
    //     }
    //     dp[n][k] = res;
    //     return res;

    // }
    public int kInversePairs(int n, int k) {
       int mod = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int m = 0; m <= j; m++) {
                    if (m <= i - 1) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - m]) % mod;
                    }
                }
            }
        }
        return dp[n][k];
    }
}