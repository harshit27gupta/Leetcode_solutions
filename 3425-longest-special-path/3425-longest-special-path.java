class Solution {
    public int[] longestSpecialPath(int[][] e, int[] n) {
        int sz = n.length;
        int maxVal = Integer.MIN_VALUE;
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < sz; i++) {
            g.add(new ArrayList<>());
            maxVal = Math.max(n[i], maxVal);
        }
        for (int[] edge : e) {
            g.get(edge[0]).add(new int[]{edge[1], edge[2]});
            g.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        int[] last = new int[maxVal + 1];
        Arrays.fill(last, -1);
        st.clear();
        s = 0;
        maxL = 0;
        minN = 1;
        dfs(0, -1, 0, g, n, last);
        return new int[]{maxL, minN};
    }

    private List<int[]> st = new ArrayList<>();
    private int s, maxL, minN;

    private void dfs(int v, int p, int d, List<List<int[]>> g, int[] n, int[] last) {
        int idx = st.size();
        int oldPos = last[n[v]];
        int oldS = s;
        if (oldPos != -1 && oldPos >= s) {
            s = oldPos + 1;
        }
        st.add(new int[]{v, (int) d});
        last[n[v]] = idx;
        if (idx >= s) {
            int len = d;
            if (s > 0) {
                len -= st.get(s)[1];
            }

            int nodes = idx - s + 1;
            if (len > maxL) {
                maxL = len;
                minN = nodes;
            } else if (len == maxL) {
                if (nodes < minN) {
                    minN = nodes;
                }
            }
        }
        for (int[] edge : g.get(v)) {
            int neigh = edge[0];
            if (neigh == p) continue;
            dfs(neigh, v, d + edge[1], g, n, last);
        }
        last[n[v]] = oldPos;
        st.remove(st.size() - 1);
        s = oldS;
    }
}