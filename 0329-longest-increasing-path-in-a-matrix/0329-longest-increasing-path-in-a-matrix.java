class Solution {
    static boolean isvalid(int i,int j,int n,int m){
        if(i>=0 && i<n && j>=0 && j<m)
        return true;
        return false;
    }
    static int ways(int [][]matrix,int i,int j,int n,int m,int curr,int dp[][]){
        if(!isvalid(i,j,n,m))
        return 0;
        int ans=0;
        if(dp[i][j]!=-1)
        return dp[i][j];
if(isvalid(i+1,j,n,m) && matrix[i+1][j]>curr)
ans=Math.max(ans,1+ways(matrix,i+1,j,n,m,matrix[i+1][j],dp));
if(isvalid(i-1,j,n,m) && matrix[i-1][j]>curr)
ans=Math.max(ans,1+ways(matrix,i-1,j,n,m,matrix[i-1][j],dp));
if(isvalid(i,j+1,n,m) && matrix[i][j+1]>curr)
ans=Math.max(ans,1+ways(matrix,i,j+1,n,m,matrix[i][j+1],dp));
if(isvalid(i,j-1,n,m) && matrix[i][j-1]>curr)
ans=Math.max(ans,1+ways(matrix,i,j-1,n,m,matrix[i][j-1],dp));
return dp[i][j]=ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int ans=0;
        int dp[][]=new int[n][m];
        for(int rows[]:dp)
        Arrays.fill(rows,-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
ans=Math.max(ans,ways(matrix,i,j,n,m,matrix[i][j],dp));
            }
        }
        return (ans+1);
        
    }
}