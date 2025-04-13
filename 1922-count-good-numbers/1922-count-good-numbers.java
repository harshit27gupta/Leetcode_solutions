class Solution {
    int M = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        long result = (pow(5, even) * pow(4, odd)) % M;

        return (int) result;
    }
    private long pow(long a, long b) {
        if (b == 0) return 1;

        if (b % 2 == 0) {
            // If b is even: a^b = (a^2)^(b/2)
            return pow((a * a) % M, b / 2) % M;
        } else {
            // If b is odd: a^b = a * a^(b - 1)
            return (a * pow(a, b - 1)) % M;
        }
    }
}