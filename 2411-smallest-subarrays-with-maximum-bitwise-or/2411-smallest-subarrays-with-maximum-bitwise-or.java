class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] last = new int[32];     
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            for (int b = 0; b < 32; b++) {
                if (((num >> b) & 1) == 1) {
                    last[b] = i;
                }
            }       
            int maxReach = i;
            for (int b = 0; b < 32; b++) {
                maxReach = Math.max(maxReach, last[b]);
            }       
            ans[i] = maxReach - i + 1;
        }
        return ans;
    }
}
