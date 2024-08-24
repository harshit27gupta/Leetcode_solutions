class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=1;
        for(int i:weights)
        l=Math.max(l,i);
        int r=(int)(1e9);
        int ans=r;
        while(l<=r){
            int mid=(l+r)/2;
            if(check(weights,mid,days)){
                ans=mid;
                r=mid-1;
            }
            else
            l=mid+1;
        }
        return ans;
    }
    static boolean check(int weights[],int demand,int days){
        int sum=0;
        int cnt=1;
        for(int i:weights){
            sum+=i;
            if(sum>demand){
                sum=i;
                cnt++;
                if(sum>demand){
                    sum=0;
                    cnt++;
                }
            }
        }
        return cnt<=days;
    }
}