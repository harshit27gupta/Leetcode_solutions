class Solution {
    private int[][] buildPrefixSum(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] pre = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = mat[i - 1][j - 1] + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
            }
        }
        return pre;
    }
    private boolean check(int mid, int[][] pre, int threshold) {
        int m = pre.length - 1, n = pre[0].length - 1;
        for (int i = mid; i <= m; ++i) {
            for (int j = mid; j <= n; ++j) {
                int total = pre[i][j] - pre[i - mid][j] - pre[i][j - mid] + pre[i - mid][j - mid];
                if (total <= threshold) return true;
            }
        }
        return false;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int[][] prefix = buildPrefixSum(mat);
        int low = 0, high = Math.min(mat.length, mat[0].length);
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid, prefix, threshold)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
