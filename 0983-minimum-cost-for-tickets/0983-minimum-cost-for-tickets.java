class Solution {
    static int mincost(int i,int days[],int cost[],int dp[]){
        if(i>=days.length)
        return 0;
        if(dp[i]!=-1)
        return dp[i];
        int way1=cost[0]+mincost(i+1,days,cost,dp);
        int way2=0;
        int j=i+1;
        while(j<days.length && days[j]<=days[i]+6)
        j++;
        way1=Math.min(way1,cost[1]+mincost(j,days,cost,dp));
        int way3=0;
        j=i;
         while(j<days.length && days[j]<=days[i]+29)
        j++;
        way1=Math.min(way1,cost[2]+mincost(j,days,cost,dp));
        return dp[i]=way1;
    }
    public int mincostTickets(int[] days, int[] costs) {
        int dp[]=new int[days.length];
        Arrays.fill(dp,-1);
        return mincost(0,days,costs,dp);
    }
}