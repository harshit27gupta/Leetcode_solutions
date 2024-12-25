class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }    
        return ans(values, memo, 0, n - 1);
    } 
    private int ans(int[] values, int[][] memo, int i, int j) {
        if (j - i < 2) return 0;    
        if (memo[i][j] != -1) return memo[i][j];     
        int minCost = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) { 
            int cost = values[i] * values[k] * values[j]
                + ans(values, memo, i, k)
                + ans(values, memo, k, j);
            minCost = Math.min(minCost, cost);
        }
        
        memo[i][j] = minCost; 
        return minCost;
    }
}
