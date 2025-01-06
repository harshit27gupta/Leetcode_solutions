class Solution {
     static int[] kmp(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int len = 0, i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
    public int minimumTimeToInitialState(String word, int k) {
        int n=word.length();
        int min=n/k+Math.min(n%k,1);
int lps[]=kmp(word);
int matched=lps[n-1];
int rem=n-matched;
return Math.min(rem/k+Math.min(rem%k,1),min);
    }
}