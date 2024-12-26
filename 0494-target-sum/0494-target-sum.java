class Solution {
    static int ways(int nums[],int i,int target){
        if(i==nums.length)
        return (target==0?1:0);
        int l=ways(nums,i+1,target+nums[i]);
        int r=ways(nums,i+1,target-nums[i]);
        return l+r;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return ways(nums,0,-target);
    }
}