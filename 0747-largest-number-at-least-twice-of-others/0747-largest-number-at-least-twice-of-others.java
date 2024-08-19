class Solution {
    public int dominantIndex(int[] nums) {
       int max=-1;
       int ind=-1;
       for(int i=0;i<nums.length;i++){
        if(nums[i]>max){
            max=nums[i];
            ind=i;
        }
       }
       Arrays.sort(nums);
        return (max>=2*nums[nums.length-2]?ind:-1);
    }
}