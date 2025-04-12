class Solution {
    public int minOperations(int[] nums, int k) {
         int m = 0;
            for (int s : nums) 
            m += s;
            return m % k;
    }
}