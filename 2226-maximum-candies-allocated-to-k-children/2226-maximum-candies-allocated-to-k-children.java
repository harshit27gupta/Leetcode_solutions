class Solution {
    static boolean check(int mid,int candies[],long k){
        long cc=0;
        for(int i:candies){
        cc+=i/mid;
        }
        return cc>=k;
    }
    public int maximumCandies(int[] candies, long k) {
       int l=1;
       int r=(int)(1e9);
       int ans=0;
       while(l<=r){
        int mid=l+(r-l)/2;
        if(check(mid,candies,k)){
            ans=mid;
        l=mid+1;
        }
        else
        r=mid-1;
        }
        return ans;
       }
}