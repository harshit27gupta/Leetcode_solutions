class Solution {
    static int MOD=(int)(1e9+7);
    public int countPaths(int[][] grid) {
int ways=0;
int n=grid.length;
int m=grid[0].length;
int dp[][]=new int[n][m];
for(int rows[]:dp)
Arrays.fill(rows,-1);
for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        ways=(ways%MOD+(solve(i,j,n,m,grid,-1,dp)%MOD))%MOD;
    }
}
return ways;
    }
    static int solve(int i,int j,int n,int m,int grid[][],int prev,int dp[][]){
if(!isValid(i,j,n,m) || ( isValid(i,j,n,m) && grid[i][j]<=prev))
return 0;
if(dp[i][j]!=-1)
return dp[i][j];
        int ans=0;
        int left=solve(i-1,j,n,m,grid,grid[i][j],dp)%MOD;
         int right=solve(i+1,j,n,m,grid,grid[i][j],dp)%MOD;
           int up=solve(i,j+1,n,m,grid,grid[i][j],dp)%MOD;
             int down=solve(i,j-1,n,m,grid,grid[i][j],dp)%MOD;
             ans+=(left+right+up+down+1)%MOD;
             return dp[i][j]=ans;
    }
    static boolean isValid(int i,int j,int n,int m){
        return (i>=0 && i<n && j>=0 && j<m);
    }
}