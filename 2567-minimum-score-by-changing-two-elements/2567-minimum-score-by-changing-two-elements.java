class Solution {
    public int minimizeSum(int[] nums) {
         Arrays.sort(nums);
        int n = nums.length;

        // Calculate minimum possible scores by modifying at most two elements
        int option1 = (nums[n - 3] - nums[0]); // Change the two largest elements
        int option2 = (nums[n - 2] - nums[1]); // Change one smallest and one largest element
        int option3 = (nums[n - 1] - nums[2]); // Change the two smallest elements

        // The low score will always be minimized by the smallest consecutive difference
        return Math.min(option1, Math.min(option2, option3));
    }
}