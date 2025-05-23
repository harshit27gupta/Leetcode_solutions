class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long delta[]=new long[nums.length];
    long tot=0;
          for (int i = 0; i < nums.length; i++) {
            long xored = nums[i] ^ k;
            delta[i] = xored - nums[i];
            tot += nums[i];
        }

        Arrays.sort(delta);

        int i = delta.length - 1;
        while (i >= 1) {
            if (delta[i] + delta[i - 1] > 0) {
                tot += delta[i] + delta[i - 1];
            } else {
                break;
            }
            i -= 2;
        }

        return tot;
    }
}