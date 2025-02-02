import java.util.*;

class FenwickTree {
    private int n;
    private int[] t;
    private static final int INF = (int) 1e9;

    public FenwickTree(int _n) {
        this.n = _n;
        this.t = new int[_n + 1];
        Arrays.fill(this.t, INF);
    }

    public void update(int i, int v) {
        for (++i; i <= n; i += i & -i) {
            t[i] = Math.min(t[i], v);
        }
    }

    public int query(int i) {
        int res = INF;
        for (++i; i > 0; i -= i & -i) {
            res = Math.min(res, t[i]);
        }
        return res;
    }
}

class Solution {
    private static final int INF = (int) 1e9;

    public int maxDifference(String s, int k) {
        int n = s.length(), ans = -INF;
        
        for (int d1 = 0; d1 < 5; d1++) {
            for (int d2 = 0; d2 < 5; d2++) {
                if (d1 != d2) {
                    int[] P = new int[n + 1], Q = new int[n + 1];
                    
                    for (int i = 0; i < n; i++) {
                        P[i + 1] = P[i] + ((s.charAt(i) - '0') == d1 ? 1 : 0);
                        Q[i + 1] = Q[i] + ((s.charAt(i) - '0') == d2 ? 1 : 0);
                    }
                    
                    int[] diff = new int[n + 1], pa = new int[n + 1], pb = new int[n + 1];
                    for (int i = 0; i <= n; i++) {
                        diff[i] = P[i] - Q[i];
                        pa[i] = P[i] & 1;
                        pb[i] = Q[i] & 1;
                    }

                    FenwickTree T00 = new FenwickTree(n + 1), T01 = new FenwickTree(n + 1);
                    FenwickTree T10 = new FenwickTree(n + 1), T11 = new FenwickTree(n + 1);
                    
                    int ptr = 0, best = -INF;
                    
                    for (int j = k; j <= n; j++) {
                        while (ptr <= j - k) {
                            if (pa[ptr] == 0 && pb[ptr] == 0) T00.update(Q[ptr], diff[ptr]);
                            else if (pa[ptr] == 0 && pb[ptr] == 1) T01.update(Q[ptr], diff[ptr]);
                            else if (pa[ptr] == 1 && pb[ptr] == 0) T10.update(Q[ptr], diff[ptr]);
                            else T11.update(Q[ptr], diff[ptr]);
                            ptr++;
                        }

                        int need_pa = (pa[j] + 1) & 1, need_pb = pb[j], maxK = Q[j] - 2;
                        if (maxK < 0) continue;

                        int cand = INF;
                        if (need_pa == 0 && need_pb == 0) cand = T00.query(maxK);
                        else if (need_pa == 0 && need_pb == 1) cand = T01.query(maxK);
                        else if (need_pa == 1 && need_pb == 0) cand = T10.query(maxK);
                        else cand = T11.query(maxK);

                        if (cand != INF) best = Math.max(best, diff[j] - cand);
                    }
                    ans = Math.max(ans, best);
                }
            }
        }
        return ans;
    }
}
