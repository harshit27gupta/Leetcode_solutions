class Solution {
  public int longestArithSeqLength(int[] nums) {
    int n = nums.length, max = 0, dp[][] = new int[n][1001];
    for (int  i=1; i<n; i++) {
      for (int  j=0; j<i; j++) {
        int diff = nums[j] - nums[i] + 500;
        dp[i][diff] = dp[j][diff] + 1;
        max = Math.max(max, dp[i][diff]);
      }
    }
    return max + 1;
  }
}