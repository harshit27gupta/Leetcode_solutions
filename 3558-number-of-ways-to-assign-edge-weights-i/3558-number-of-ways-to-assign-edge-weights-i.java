class Solution {
    static final int MOD = 1000000007;
    static int depth(ArrayList<ArrayList<Integer>> tree,int node,int par){
        if(tree.get(node).size()==1 && node!=1)
            return 1;
        int cc=0;
        for(int i:tree.get(node)){
            if(i==par)
                continue;
            cc=Math.max(cc,depth(tree,i,node));
        }
        return cc+1;
    }
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i=0;i<=n;i++)
            tree.add(new ArrayList<>());
        for(int[] e : edges){
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        int d = depth(tree,1,-1);
        d--;
        int[][] dp = new int[d+1][2];
        dp[0][0] = 1;
        for(int i=1;i<=d;i++){
            dp[i][0] = (dp[i-1][1] + dp[i-1][0]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }
        return dp[d][1];
    }
}
