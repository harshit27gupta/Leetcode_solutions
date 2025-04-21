class Solution {
    public int maximumPossibleSize(int[] nums) {
        int n = nums.length;
        int count = 1; 

        int prev = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= prev) {
                count++;
                prev = nums[i]; 
            } else {
                prev = Math.max(prev, nums[i]); 
            }
        }

        return count;
    }
}
