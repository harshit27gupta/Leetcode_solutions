class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=nums[0];
        right[n-1]=nums[n-1];
        for(int i=1;i<n;i++)
        left[i]=Math.max(left[i-1],nums[i]);
        for(int i=n-2;i>=0;i--)
        right[i]=Math.max(right[i+1],nums[i]);
        long prod=0;
        for(int j=1;j<n-1;j++){
            int i1=left[j-1];
            int j1=nums[j];
            int k1=right[j+1];
            long cc=(long)(i1-j1)*(long)(k1);
            prod=Math.max(prod,cc);
        }
    return prod;

    }
}