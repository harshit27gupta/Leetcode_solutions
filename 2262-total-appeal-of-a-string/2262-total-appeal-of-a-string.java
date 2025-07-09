class Solution {
    public long appealSum(String s) {
        int n = s.length();
        int[] last = new int[26];
        Arrays.fill(last, -1);
        long totalAppeal = 0;
        long currentAppeal = 0;

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            currentAppeal += (i - last[ch]);
            totalAppeal += currentAppeal;
            last[ch] = i;
        }

        return totalAppeal;
    }
}
