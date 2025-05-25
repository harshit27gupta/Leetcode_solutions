import java.util.*;

class Solution {
    public String lexicographicallySmallestString(String s) {
        int n = s.length();
        s = "#" + s; // 1-based indexing
        char[] str = s.toCharArray();

        String[][] dp = new String[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                String res = null;

                // Case 1: Try keeping character at i
                String keep = str[i] + (i + 1 <= j ? dp[i + 1][j] : "");
                res = keep;

                // Case 2: Try removing pair (i, k)
                for (int k = i + 1; k <= j; k++) {
                    if (areConsecutive(str[i], str[k]) && (k == i + 1 || dp[i + 1][k - 1].equals(""))) {
                        String removed = (k + 1 <= j ? dp[k + 1][j] : "");
                        if (res == null || removed.compareTo(res) < 0) {
                            res = removed;
                        }
                    }
                }

                dp[i][j] = res;
            }
        }

        return dp[1][n];
    }

    private boolean areConsecutive(char a, char b) {
        int diff = Math.abs(a - b);
        return diff == 1 || diff == 25;
    }
}
