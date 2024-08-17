class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans=0;
        int cnt=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1])
            cnt++;
            else{
                ans=Math.max(ans,cnt);
                cnt=1;
            }
        }
        return Math.max(ans,cnt);
    }
}