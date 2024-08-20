class Solution {
    private Map<String, Integer> dp = new HashMap<>();
    private int score(boolean alice, int i, int M, int[] piles) {
        if (i == piles.length)
            return 0;
        String key = alice + "," + i + "," + M;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int res = alice ? 0 : Integer.MAX_VALUE;
        int total = 0;

        for (int x = 1; x <= 2 * M; ++x) {
            if (i+ x > piles.length) {
                break;
            }
            total += piles[i + x - 1];

            if (alice) {
                res = Math.max(res, total + score(!alice, i + x, Math.max(M, x), piles));
            } else {
                res = Math.min(res, score(!alice, i + x, Math.max(M, x), piles));
            }
        }

        dp.put(key, res);
        return res;
    }

    public int stoneGameII(int[] piles) {
        return score(true, 0, 1, piles);
    }
}