class Solution {

    private int solveHelper(int[] prefix, int len1, int len2) {
        int res = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = len1 + len2; i < prefix.length; i++) {
            maxLength = Math.max(maxLength,
                    prefix[i - len2] - prefix[i - len2 - len1]);
            res = Math.max(res, maxLength + prefix[i] - prefix[i - len2]);
        }
        return res;
    }
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return Math.max(solveHelper(prefix, firstLen, secondLen),
                solveHelper(prefix, secondLen, firstLen));
    }
}