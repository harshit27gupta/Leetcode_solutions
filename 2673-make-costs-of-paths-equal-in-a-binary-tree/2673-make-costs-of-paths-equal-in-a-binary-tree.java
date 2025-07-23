class Solution {
  int ans = 0;

  private int dfs(int n, int[] cost, int i) {
    if (i > n) return 0;

    int l = dfs(n, cost, 2*i);
    int r = dfs(n, cost, 2*i + 1);
    ans += Math.abs(l - r);

    return cost[i-1] + Math.max(l, r);
  }

  public int minIncrements(int n, int[] cost) {
    dfs(n, cost, 1);
    return ans;
  }
}