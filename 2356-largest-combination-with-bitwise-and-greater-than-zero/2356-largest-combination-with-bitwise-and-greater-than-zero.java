class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0, cur = 0;
        for (int i = 1; i < 10000000; i <<= 1) {
            cur = 0;
            for (int cand : candidates) {
                if ((cand & i) > 0)
                    cur++;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}