class Solution {
    public int makeStringGood(String s) {
        int n = s.length();
        int[] f = new int[26];
        for(int i = 0; i < n; i++) f[s.charAt(i)-'a']++;
        int ans = n;
        for(int m = 1; m <= n; m++){
            int res = 0;
            int dp1 = 0;
            int dp2 = 0;
            int free = 0;
            for(int i = 0; i < 26; i++){
                int ndp1, ndp2, nfree;
                if(f[i] >= m){
                    ndp1 = Math.min(dp1, dp2) + (f[i] - m);
                    ndp2 = n;
                    nfree = f[i] - m;
                }
                else{
                    ndp1 = Math.min(dp1, dp2) + f[i];
                    ndp2 = Math.min(dp1 + Math.max(0, m - f[i] - free), dp2 + m - f[i]);
                    nfree = f[i];
                }
                dp1 = ndp1;
                dp2 = ndp2;
                free = nfree;
            }
            res = Math.min(dp1, dp2);
            ans = Math.min(ans, res);
        }
        return ans;
    }
}