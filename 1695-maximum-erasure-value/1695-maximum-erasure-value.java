class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int ans = 0, sum = 0;
        int j = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            while (st.contains(nums[i])) {
                st.remove(nums[j]);
                sum -= nums[j];
                j++;
            }
            st.add(nums[i]);
            sum += nums[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
