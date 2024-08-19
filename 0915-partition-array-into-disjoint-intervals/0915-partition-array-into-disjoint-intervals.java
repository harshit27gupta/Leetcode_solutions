class Solution {
    public int partitionDisjoint(int[] nums) {
        int n=nums.length;
        int mini[]=new int[n];
        int maxi[]=new int[n];
        mini[n-1]=nums[n-1];
        maxi[0]=nums[0];
        for(int i=n-2;i>=0;i--)
        mini[i]=Math.min(nums[i],mini[i+1]);
        for(int i=1;i<n;i++)
        maxi[i]=Math.max(nums[i],maxi[i-1]);
        for(int i=0;i<n-1;i++){
            if(maxi[i]<=mini[i+1])
            return i+1;
        }
        return -1;
    }

}