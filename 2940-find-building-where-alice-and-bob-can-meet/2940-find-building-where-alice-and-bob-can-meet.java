class Solution {
    static class SparseTable {
        private int[][] st; // Sparse table
        private int[] log;  // Logarithm values
        private int n;      // Array size

        // Constructor: Build the Sparse Table
        public SparseTable(int[] arr) {
            this.n = arr.length;
            int maxLog = (int) (Math.log(n) / Math.log(2)) + 1;

            // Initialize Sparse Table and log array
            st = new int[n][maxLog];
            log = new int[n + 1];

            // Compute log values for fast access
            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }

            // Fill the first column of Sparse Table
            for (int i = 0; i < n; i++) {
                st[i][0] = arr[i];
            }

            // Fill the rest of the Sparse Table
            for (int j = 1; (1 << j) <= n; j++) {
                for (int i = 0; i + (1 << j) - 1 < n; i++) {
                    st[i][j] = Math.max(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        // Query the maximum in the range [L, R]
        public int query(int L, int R) {
            int j = log[R - L + 1];
            return Math.max(st[L][j], st[R - (1 << j) + 1][j]);
        }
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        SparseTable st = new SparseTable(heights);
        int[] res = new int[queries.length];
        int n = heights.length;
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l > r) {
                int temp = l;
                l = r;
                r = temp;
            }
            if (l == r) {
                res[i] = l;
                continue;
            }
            if (heights[r] > heights[l]) {
                res[i] = r;
                continue;
            }
            int maxHeight = Math.max(heights[l], heights[r]);
            int left = r + 1, right = n - 1, mid;
            int leftmostIndex = -1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                int maxInRange = st.query(left, mid);

                if (maxInRange > maxHeight) {
                    leftmostIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = leftmostIndex;
        }

        return res;
    }
}
