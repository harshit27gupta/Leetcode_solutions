class Solution {
    public void nextPermutation(int[] nums) {
        int ind1=-1;
        int ind2=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind1=i;
                break;
            }
        }
        if(ind1==-1){
            Arrays.sort(nums);
        }
        else{
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[ind1]){
                ind2=i;
                break;
            }
        }
        int tmp=nums[ind1];
        nums[ind1]=nums[ind2];
        nums[ind2]=tmp;
         reverse(nums, ind1 + 1, nums.length - 1);
        }
    }
        private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}