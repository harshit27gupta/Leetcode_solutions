import java.util.Arrays;

class Solution {
    public static int solve(int l, int r, int count, int[] boxes, int[][][] dp) {
        if (l > r)
            return 0;
        if (dp[l][r][count] != -1)
            return dp[l][r][count];
        int i = l;
        int cnt = count;
        while (i + 1 <= r && boxes[i + 1] == boxes[l]) {
            i++;
            cnt++;
        }
        int given = (cnt + 1) * (cnt + 1) + solve(i + 1, r, 0, boxes, dp);
        int extra = 0;
        for (int m = i + 1; m <= r; m++) {
            if (boxes[m] == boxes[l]) {
                extra = Math.max(extra, solve(m, r, cnt + 1, boxes, dp) + solve(i + 1, m - 1, 0, boxes, dp));
            }
        }

        return dp[l][r][count] = Math.max(given, extra);
    }

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return solve(0, n - 1, 0, boxes, dp);
    }
}