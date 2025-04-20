class Solution {
    public int numRabbits(int[] answers) {
        int said[]=new int[1001];
        Arrays.fill(said,0);
        for(int i:answers)
        said[i]++;
        int ans=0;
        for(int i=0;i<=999;i++){
            int val1=(said[i]/(i+1))*(i+1);
         if(said[i]%(i+1)>0)
         val1+=(i+1);
            ans+=val1;
        }
        return ans;

    }
}