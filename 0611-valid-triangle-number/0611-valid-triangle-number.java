class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]==0)
            continue;
        for(int j=i+1;j<nums.length-1;j++){
        int k=i+2;
        while(k<nums.length && nums[i]+nums[j]>nums[k])
        k++;
ans+=k-j-1;
        }
        }
        return ans;
    }
}