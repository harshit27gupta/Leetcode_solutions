class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int n=prices.length;
        int mini=prices[0];
        for(int i=1;i<n;i++){
            int sp=prices[i];
            if(sp>=mini)
            ans=Math.max(ans,sp-mini);
            mini=Math.min(mini,prices[i]);
        }
        return ans;
    }
}