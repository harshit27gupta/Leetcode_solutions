class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        ans = Math.max(ans, countLengthOfEvenNumbers(nums));
        ans = Math.max(ans, countLengthOfOddNumbers(nums));
        ans = Math.max(ans, countLengthOfAlternatingParity(nums, 0));
        ans = Math.max(ans, countLengthOfAlternatingParity(nums, 1));

        return ans;
    }
    private int countLengthOfEvenNumbers(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                temp++;
            }
        }
        return temp;
    }
    private int countLengthOfOddNumbers(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                temp++;
            }
        }
        return temp;
    }
    private int countLengthOfAlternatingParity(int[] nums, int cmp) {
        int temp = 0;
        for (int num : nums) {
            if (num % 2 == cmp) {
                temp++;
                cmp = (cmp + 1) % 2;
            }
        }
        return temp;
    }
}
