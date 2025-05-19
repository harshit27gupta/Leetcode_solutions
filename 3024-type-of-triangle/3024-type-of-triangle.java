class Solution {
    public String triangleType(int[] nums) {
        int side1=nums[0];
        int side2=nums[1];
        int side3=nums[2];
        if((side1+side2<=side3) || (side3+side2<=side1) || (side1+side3<=side2))
            return "none";
        if(nums[0]==nums[1] && nums[1]==nums[2])
            return "equilateral";
        else  if(nums[0]==nums[1] ||  nums[1]==nums[2] || nums[0]==nums[2])
            return "isosceles";
        return "scalene";
    }
}