class Solution {
    public long splitArray(int[] nums) {
        int n=nums.length;
        long sum_left[]=new long[n];
        long sum_right[]=new long[n];
        boolean left[]=new boolean[n];
        boolean right[]=new boolean[n];
           left[0] = true;
    sum_left[0] = nums[0];
    right[n-1] = true;
    sum_right[n-1] = nums[n-1];

    for (int i = 1; i < n; i++) {
        sum_left[i] = sum_left[i-1] + nums[i];
        if (!left[i-1]) {
            left[i] = false;
        } else {
            left[i] = nums[i] > nums[i-1];
        }
    }

    for (int i = n-2; i >= 0; i--) {
        sum_right[i] = sum_right[i+1] + nums[i];
        if (!right[i+1]) {
            right[i] = false;
        } else {
            right[i] = nums[i] > nums[i+1];
        }
    }

    long min_diff = Long.MAX_VALUE;
    for (int i = 0; i < n-1; i++) {
        if (left[i] && right[i+1]) {
            min_diff = Math.min(min_diff, Math.abs(sum_right[i+1] - sum_left[i]));
        }
    }
    return min_diff == Long.MAX_VALUE ? -1 : min_diff;
    }
}