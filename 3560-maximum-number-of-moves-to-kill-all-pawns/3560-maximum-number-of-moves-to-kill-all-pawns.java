class Solution {
    HashMap<Long, Integer> memo;
    HashMap<Integer, Integer> memo2;
    int n;
    public int maxMoves(int kx, int ky, int[][] positions) {
        memo = new HashMap<>();
        memo2 = new HashMap<>();
        n = positions.length;
        return dfs(kx, ky, positions, 0, 0);
    }


    public int dfs(int kx, int ky, int[][] p, int mask, int cnt) {
        long hashVal = hash(kx, ky, mask);
        if(memo.containsKey(hashVal)) return memo.get(hashVal);
        if(cnt == n) return 0;
        int ans = (cnt%2==0)?0:Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if((mask & (1<<i)) == 0) {
                int moves = 0;
                if(memo2.containsKey(kx+100*ky+10000*p[i][0]+1000000*p[i][1])) {
                    moves = memo2.get(kx+100*ky+10000*p[i][0]+1000000*p[i][1]);
                } else {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{kx, ky});
                    boolean[][] seen = new boolean[50][50];
                    seen[kx][ky] = true;
                    int[][] dir = new int[][]{new int[]{1, 2}, new int[]{1, -2}, new int[]{-1, 2}, new int[]{-1, -2}, new int[]{2, 1}, new int[]{-2, 1}, new int[]{2, -1}, new int[]{-2, -1}};
                    while(!q.isEmpty()) {
                        int size = q.size();
                        boolean found = false;
                        while(size-->0) {
                            int[] curr = q.remove();
                            if(curr[0] == p[i][0] && curr[1] == p[i][1]) {
                                found = true;
                                break;
                            }
                            for(int[] x : dir) {
                                int nx = curr[0] + x[0];
                                int ny = curr[1] + x[1];
                                if(nx >= 0 && nx < 50 && ny >= 0 && ny < 50 && !seen[nx][ny]) {
                                    q.add(new int[]{nx, ny});
                                    seen[nx][ny] = true;
                                }
                            }
                        }
                        if(found) break;
                        moves++;
                    }
                    memo2.put(kx+100*ky+10000*p[i][0]+1000000*p[i][1], moves);
                }
                if(cnt%2==0) { // alice turn
                    ans = Math.max(ans, moves+dfs(p[i][0], p[i][1], p, mask+(1<<i), cnt+1));
                } else { // bob turn
                    ans = Math.min(ans, moves+dfs(p[i][0], p[i][1], p, mask+(1<<i), cnt+1));
                }
            }
        }
        memo.put(hashVal, ans);
        return ans;
    }


    public long hash(int x, int y, int mask) {
        return x*1000000000l+y*1000000l+mask;
    }
}