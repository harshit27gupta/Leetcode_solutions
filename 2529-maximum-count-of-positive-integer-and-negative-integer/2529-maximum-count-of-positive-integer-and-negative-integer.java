class Solution {
    static int ans[] = new int[2];

    static void negcnt(int nums[]) {
        int l = -1, r = nums.length;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < 0)
                l = mid;
            else
                r = mid;
        }
        ans[0] = l;
        ans[1] = r;
    }

    public int maximumCount(int[] nums) {
        negcnt(nums);
        int negCount = ans[0] + 1;
        int posCount = (ans[1] < nums.length && nums[ans[1]] > 0) ? (nums.length - ans[1]) : 0;

        return Math.max(negCount, posCount);
    }
}
