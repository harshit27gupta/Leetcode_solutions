class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int min=Math.min(a,Math.min(b,c));
        int max=Math.max(a,Math.max(b,c));
        int  mid=a+b+c-(min+max);
        if(mid-min==1 && max-mid==1)
        return new int[]{0,0};
        if(mid-min==2 && max-mid==2)
        return new int[]{1,2};
        int ans[]=new int[2];
         if(mid-min==1){
         ans[0]=1;
         ans[1]=max-mid-1;
         return ans;
         }
          if(max-mid==1){
            ans[0]=1;
            ans[1]=mid-min-1;
            return ans;
         }
         if(mid-min==2){
         ans[0]=1;
         ans[1]=max-mid;
         return ans;
         }
          if(max-mid==2){
            ans[0]=1;
            ans[1]=mid-min;
            return ans;
         }
         ans[1]=mid-min-1+max-mid-1;
         ans[0]=2;
return ans;

    }
}