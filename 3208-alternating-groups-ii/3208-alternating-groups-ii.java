class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
         int n = colors.length;
        int[] newColors = new int[n + k];
        System.arraycopy(colors, 0, newColors, 0, n);
        System.arraycopy(colors, 0, newColors, n, k);
        n = newColors.length;
        int cnt = 0;
        Map<String, Integer> colorToIndex = new HashMap<>();
        int[] prefixSums = new int[n + 1];

        for (int i = 1; i < n; ++i) {
            prefixSums[i] = prefixSums[i - 1] + Math.abs(newColors[i] - newColors[i - 1]);
        }

        k--;
        for (int i = k + 1; i < n; ++i) {
            if (prefixSums[i] - prefixSums[i - k] == k) {
                cnt++;
            }
        }
        return cnt;
}
}
