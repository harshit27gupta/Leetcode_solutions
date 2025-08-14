import java.util.*;

class Solution {
    static int find(int max, int[] arr) {
        int l = 0, r = arr.length - 1, ans = arr.length;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= max) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            long maxVal = (long) k * min + 1;
            int idx;
            if (maxVal > nums[nums.length - 1]) {
                idx = nums.length;
            } else {
                idx = find((int) maxVal, nums);
            }
            ans = Math.min(ans, i + (nums.length - idx));
        }
        return ans;
    }
}
