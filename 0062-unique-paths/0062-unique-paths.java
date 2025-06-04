class Solution {
    static int dp[][];
    static boolean isValid(int i,int j,int n,int m){
    return (i>=0 && i<m && j>=0 && j<n);
    }
    static int ways(int i,int j,int n,int m){
if(i==m-1 && j==n-1)
return 1;
if(dp[i][j]!=-1)
return dp[i][j];
int way1=0,way2=0;
if(isValid(i+1,j,n,m))
way1=ways(i+1,j,n,m);
if(isValid(i,j+1,n,m))
way2=ways(i,j+1,n,m);
return dp[i][j]=way1+way2;
    }
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int rows[]:dp)
        Arrays.fill(rows,-1);
        return ways(0,0,n,m);
    }
}