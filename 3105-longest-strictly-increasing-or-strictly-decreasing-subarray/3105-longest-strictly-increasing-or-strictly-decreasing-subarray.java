class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLen = 1;
        int curLen = 1;
        boolean isIncreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (!isIncreasing) {
                    curLen = 1;
                }
                curLen++;
                isIncreasing = true;
            } else if (nums[i] < nums[i - 1]) {
                if (isIncreasing) {
                    curLen = 1;
                }
                curLen++;
                isIncreasing = false;
            } else {
                curLen = 1;
            }

            maxLen = Math.max(maxLen, curLen);
        }

        return maxLen;
    }
}