class Solution {
    static long prefix[];
    static int maxN=(int)(2e5);
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        prefix=new long[maxN+1];
        for(int arr[]:fruits)
        prefix[arr[0]]=(long)arr[1];
        for(int i=1;i<=maxN;i++)
        prefix[i]+=prefix[i-1];
        long ans=0;
        for(int i=0;i<=k;i++){
               long sum=0;
            int left=Math.max(0,startPos-i);
               int right=startPos;
            if(k-2*i>0)
         right=Math.min(right+k-2*i,maxN);
            sum+=prefix[right];
            if(left>0)
            sum-=prefix[left-1];
            ans=Math.max(ans,sum);
            
        }
        return (int)(ans);
    }
}