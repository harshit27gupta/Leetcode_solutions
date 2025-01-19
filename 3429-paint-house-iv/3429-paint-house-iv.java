class Solution {
    long[][][] dp;
    public long minCost(int n, int[][] cost) {
        dp = new long[n][3][3]; 
        long res = Long.MAX_VALUE;
        int indexL = n / 2 - 1;
        //dp[i][j][k]: minCost from index i to n - 1 - i. i painted to j color, n - 1 - i painted to k color
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (j != k) {
                    dp[indexL][j][k] = cost[indexL][j] + cost[indexL + 1][k];
                }else{
                    dp[indexL][j][k] = res;
                }
            }
        }
        for(int i = indexL - 1; i >= 0; i--){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    if(k != j){
                        for(int m = 0; m < 3; m++){
                            if(m != j && m!= k){
                                //j-m .....j-k or j-k .....m-k or j-k .....j-k
                                //Make sure color of index i + 1 different from i, and color of index n - 1 - i different from n - 2 - i
                                dp[i][j][k] = dp[i + 1][m][j] + cost[i][j] + cost[n - 1 - i][k];
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i + 1][k][m] + cost[i][j] + cost[n - 1 - i][k]);
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i + 1][k][j] + cost[i][j] + cost[n - 1 - i][k]);
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i != j) res = Math.min(res, dp[0][i][j]);
            }
        }
        return res;
    }
}