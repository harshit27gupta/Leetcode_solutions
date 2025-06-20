class Solution {
    static int min(char arr[],int i,int j,int dp[][]){
        if(i>=j)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(i<j && arr[i]==arr[j])
        return min(arr,i+1,j-1,dp);
        //add at i
        int way1=1+min(arr,i,j-1,dp);
        int way2=1+min(arr,i+1,j,dp);
        return dp[i][j]=Math.min(way1,way2);
    }
    public int minInsertions(String s) {
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int rows[]:dp)
        Arrays.fill(rows,-1);
        return min(s.toCharArray(),0,n-1,dp);
    }
}