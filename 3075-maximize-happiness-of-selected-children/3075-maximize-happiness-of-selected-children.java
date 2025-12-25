class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans=0;
        int check=0;
        for(int i=happiness.length-1;i>=0 && check<k;i--,check++)
            ans+=Math.max(0,(happiness[i]-check));
    
    return ans;
    }
}