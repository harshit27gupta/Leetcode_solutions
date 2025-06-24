class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][2];
        int ans=0;
        for(int i=0;i<n;i++){
            //rob this house 
            if(i==0)
            dp[i][0]=nums[i];
            else
            dp[i][0]=nums[i]+dp[i-1][1];
            if(i>=1)
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]);
            ans=Math.max(ans,Math.max(dp[i][0],dp[i][1]));
        }
        return ans;
    }
}