class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=1;i<n;i++)
        ans=Math.max(ans,Math.abs(nums[i]-nums[i-1]));
         ans=Math.max(ans,Math.abs(nums[n-1]-nums[0]));
         return ans;
    }
}