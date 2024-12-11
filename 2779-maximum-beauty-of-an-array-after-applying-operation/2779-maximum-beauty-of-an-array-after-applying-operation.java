class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int diff[] = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++)
            diff[i - 1] = nums[i] - nums[i - 1];
        int i = 0, j = 0, s = 0, ans = 0;
        while (j < diff.length) {
            s += diff[j];
            while (i<=j && s > 2 * k) {
                s -= diff[i];
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans+1;
    }
}