class Solution {
    public long specialPalindrome(long n) {
        int len = String.valueOf(n).length();
        long res = Long.MAX_VALUE;
        for (long x : dp.get(len)) {
            if (x > n && x < res) {
                res = x;
            }
        }
        if (res == Long.MAX_VALUE) {
            for (long x : dp.get(len + 1)) {
                if (x < res) {
                    res = x;
                }
            }
        }
        return res;
    }

    static Map<Integer, List<Long>> dp = build();

    static Map<Integer, List<Long>> build() {
        Map<Integer, List<Long>> dp = new HashMap<>();
        for (int i = 1; i <= 16; i++) {
            dp.put(i, new ArrayList<>());
        }
        int[] map = new int[10];
        for (int i = 1; i < 10; i++) {
            map[i] = i;
        }
        build(dp, 0, 0, map);
        for (int i = 1; i < 10; i++) {
            map[i]--;
            build(dp, 1, i, map);
            map[i]++;
        }
        return dp;
    }

    static void build(Map<Integer, List<Long>> dp, int len, long num, int[] map) {
        if (len > 0 && valid(map)) {
            dp.get(len).add(num);
        }
        if (len >= 15) {
            return;
        }
        long mult = (long) Math.pow(10, len + 1);
        for (int i = 2; i < map.length; i++) {
            if (map[i] == 0 || map[i] % 2 == 1) {
                continue;
            }
            map[i] -= 2;
            build(dp, len + 2, mult * i + num * 10 + i, map);
            map[i] += 2;
        }
    }

    static boolean valid(int[] map) {
        for (int i = 1; i < map.length; i++) {
            if (map[i] != i && map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}