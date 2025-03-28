import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[] newCuts = new int[m + 2];
        newCuts[0] = 0;
        newCuts[m + 1] = n;
        System.arraycopy(cuts, 0, newCuts, 1, m);
        
        int[][] dp = new int[m + 2][m + 2];
        
        for (int len = 2; len <= m + 1; len++) {
            for (int left = 0; left + len <= m + 1; left++) {
                int right = left + len;
                dp[left][right] = Integer.MAX_VALUE;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.min(dp[left][right], newCuts[right] - newCuts[left] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][m + 1];
    }
}
