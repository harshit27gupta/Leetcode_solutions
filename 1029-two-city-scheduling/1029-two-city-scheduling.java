class Solution {
    static int cost(int costs[][],int i,int ct1,int ct2,int dp[][][]){
        if(i==costs.length)
        return 0;
        if(dp[i][ct1][ct2]!=-1)
        return dp[i][ct1][ct2];
        int l=Integer.MAX_VALUE,r=Integer.MAX_VALUE;
        if(ct1<costs.length/2)
         l=costs[i][0]+cost(costs,i+1,ct1+1,ct2,dp);
if(ct2<costs.length/2)
         r=costs[i][1]+cost(costs,i+1,ct1,ct2+1,dp);
        return dp[i][ct1][ct2]=Math.min(l,r);
    }
    public int twoCitySchedCost(int[][] costs) {
        int n=costs.length;
        int dp[][][]=new int[n][n/2+1][n/2+1];
for(int i=0;i<n;i++){
    for(int rows[]:dp[i])
    Arrays.fill(rows,-1);
}
        return cost(costs,0,0,0,dp);
    }
}