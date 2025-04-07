class Solution {
    static Boolean search(int[] nums, int i, int target, Boolean[][] dp) {
        if (target == 0) return true;
        if (i >= nums.length || target < 0) return false;
        if (dp[i][target] != null) return dp[i][target];
        boolean pick = search(nums, i + 1, target - nums[i], dp);
        boolean skip = search(nums, i + 1, target, dp);
        dp[i][target] = pick || skip;
        return dp[i][target];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return search(nums, 0, target, dp);
    }
}
