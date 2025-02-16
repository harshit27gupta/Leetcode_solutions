class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            boolean left=(i<k?true:nums[i-k]<nums[i]?true:false);
             boolean right=(i+k>=nums.length?true:nums[i+k]<nums[i]?true:false);
             sum+=((left && right)?nums[i]:0);
        }
        return sum;
    }
}