class Solution {
    public int[] constructRectangle(int area) {
      int ans[]=new int[2];
      Arrays.fill(ans,-1);
      for(int i=1;i*i<=area;i++){
        if(area%i==0){
            int poss1=area/i;
            int poss2=i;
            int len=Math.max(poss1,poss2);
            int width=Math.min(poss1,poss2);
            if(ans[0]==-1 || (len-width)<ans[0]-ans[1]){
                ans[0]=len;
                ans[1]=width;
            }
        }
      }
      return ans;  
    }
}