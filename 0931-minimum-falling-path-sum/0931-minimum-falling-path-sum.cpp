class Solution {
public:
    vector<vector<int>>dp;
    int solve(vector<vector<int>>& matrix , int n , int i , int j){
        if(j<0 || j>=n) return 1e9;
       
        if(i==n-1) return matrix[i][j];
        
        if(dp[i][j]!=-1) return dp[i][j];

        return dp[i][j] = matrix[i][j] + min({solve(matrix,n,i+1,j-1) , solve(matrix,n,i+1,j) , solve(matrix,n,i+1,j+1)});

    }
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int ans = 1e9;
        int n = matrix.size();
        dp.resize(n,vector<int>(n,-1));
        for(int i = 0; i<n; i++){
          ans = min(ans,solve(matrix,n,0,i));
        }
        
        return ans;
    }
};