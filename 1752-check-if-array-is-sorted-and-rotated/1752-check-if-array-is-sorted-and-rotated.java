class Solution {
    public boolean check(int[] nums) {
        int i=0;
        int n=nums.length;
        while(i<n-1){
            if(nums[i]>nums[i+1])
            break;
            i++;
        }
        if(i==n-1)
        return true;
        i++;
        while(i<n-1){
            if(nums[i]>nums[i+1])
            return false;
            i++;
        }
if(nums[n-1]<nums[0])
return true;
return false;

    }
}