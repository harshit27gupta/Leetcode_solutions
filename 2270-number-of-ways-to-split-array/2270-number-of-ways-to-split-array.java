class Solution {
    public int waysToSplitArray(int[] nums) {
        long s=0;
        for(int i:nums)
        s+=i;
        long s1=0;
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            s1+=nums[i];
            if(s1>=(s-s1))
            ans++;
        }
        return ans;
    }
}