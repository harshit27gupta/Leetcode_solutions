class Solution {
    static int cost_calculate(int i,int n,int k,int dp[][],int cost[][]){
        if(i==n && k==0)
        return 0;
        if(i==n || k==0)
        return (int)(1e8);
        if(dp[k][i]!=-1)
        return dp[k][i];
        int ans=(int)(1e8);
        for(int j=i;j<n;j++)
        ans=Math.min(ans,cost[i][j]+cost_calculate(j+1,n,k-1,dp,cost));
        return dp[k][i]=ans;
    }
    public int minDistance(int[] houses, int k) {
        int dp[][]=new int[101][101];
        for(int rows[]:dp)
        Arrays.fill(rows,-1);
        int cost[][]=new int[101][101];
        Arrays.sort(houses);
        int n=houses.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                //cost to put mailbox b/w house i and house j
                int median=houses[(i+j)/2];
                for(int k1=i;k1<=j;k1++)
                cost[i][j]+=Math.abs(median-houses[k1]);
            }
        }
return cost_calculate(0,n,k,dp,cost);
    }
}