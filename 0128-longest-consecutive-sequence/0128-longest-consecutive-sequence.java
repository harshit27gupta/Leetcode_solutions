class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0)
        return 0;
        int cnt=1;
        int ans=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1)
            cnt++;
            else if(nums[i]-nums[i-1]>1){
                ans=Math.max(ans,cnt);
                cnt=1;
            }
        }
        ans=Math.max(ans,cnt);
        return ans;
    }
}