class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int i:nums)
        max=Math.max(max,i);
        int freq[]=new int[max+1];
        for(int i:nums)
        freq[i]++;
        int dp[][]=new int[max+1][2];
        int ans=0;
        for(int i=1;i<=max;i++){
            //picked
            dp[i][1]=freq[i]*i+(i>=2?Math.max(dp[i-2][0],dp[i-2][1]):0);
            //not picked
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            ans=Math.max(ans,Math.max(dp[i][0],dp[i][1]));
        }
        return ans;
    }

}