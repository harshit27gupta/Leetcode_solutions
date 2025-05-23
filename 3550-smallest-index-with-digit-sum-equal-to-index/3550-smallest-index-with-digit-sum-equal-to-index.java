class Solution {
    static int su(int nums){
        int sum=0;
        while(nums>0){
            sum+=nums%10;
            nums=nums/10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int sum=su(nums[i]);
            if(sum==i)
            return i;
        }
        return -1;
    }
}