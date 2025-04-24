class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int ans = 0;
        Set<Integer> st = new HashSet<>();
        for (int i : nums)
            st.add(i);
        int k = st.size();
        st.clear();
        int j = 0, i = 0;
        int n = nums.length;
        int freq[] = new int[2001];
        while (i < n) {
            freq[nums[i]]++;
            st.add(nums[i]);
            while (st.size() == k) {
                ans += (n - i);
                freq[nums[j]]--;
                if (freq[nums[j]] == 0)
                    st.remove(nums[j]);
                j++;
            }
            i++;
        }
        return ans;
    }
}
