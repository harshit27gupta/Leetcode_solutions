public class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        long upperBound = (long) Math.pow(10, n) - 1;
        long lowerBound = (long) Math.pow(10, n - 1);

        for (long i = upperBound; i >= lowerBound; i--) {
            long palindrome = Long.parseLong(i + new StringBuilder(Long.toString(i)).reverse().toString());
            for (long j = upperBound; j * j >= palindrome; j--) {
                if (palindrome / j > upperBound) {
                    break;
                }
                if (palindrome % j == 0) {
                    return (int) (palindrome % 1337);
                }
            }
        }

        return -1;
    }
}