class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] b = new int[n];
        int maxSum = nums[0];
        f[0] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(nums[i], f[i - 1] + nums[i]);
            maxSum = Math.max(maxSum, f[i]);
        }
        b[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            b[i] = Math.max(nums[i], b[i + 1] + nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            maxSum = Math.max(maxSum, f[i - 1] + b[i + 1]);
        }
        return maxSum;
    }
}