class Solution {
    static double avg(int nums[],int k,double sum,int i,int len,double dp[][][]){
        if(i==nums.length){
        if(len>0)
        return (double)sum/len;
        return 0;
        }
        if(dp[i][k][len]!=-1)
        return dp[i][k][len];
        double l=avg(nums,k,sum+nums[i],i+1,len+1,dp);
        double r=0;
        if(k>0 && len>0)
        r=(double)(sum/len)+avg(nums,k-1,nums[i],i+1,1,dp);
        return dp[i][k][len]=Math.max(l,r);
    }
    public double largestSumOfAverages(int[] nums, int k) {
        double dp[][][]=new double[nums.length][nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            for(double rows[]:dp[i])
Arrays.fill(rows,-1);
        }
       return avg(nums,k-1,0,0,0,dp);

    }
}