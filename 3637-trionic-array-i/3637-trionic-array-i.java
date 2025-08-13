class Solution {
    public boolean isTrionic(int[] nums) {
        int p=0;
        boolean counter1=false,counter2=false,counter3=false;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1] > nums[i]){
                p++;
                counter1=true;
            }
            else{
                break;
            }
        }

        for(int i=p;i<nums.length-1;i++){
            if(nums[i+1] < nums[i]){
                p++;
                counter2=true;
            }
            else{
                break;
            }
        }



        for(int i=p;i<nums.length-1;i++){
            if(nums[i+1] > nums[i]){
                p++;
                counter3=true;
            }
            else{
                break;
            }
        }
        if((counter1 && counter2 && counter3) && (p == nums.length-1)){
            return true;
        }
        return false;
    }
}