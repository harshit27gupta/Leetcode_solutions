class Solution {
    static long[] dfs(ArrayList<ArrayList<Integer>> tree,long se[],int node,boolean visited[]){
        visited[node]=true;
        for(int i:tree.get(node)){
            if(!visited[i]){
            dfs(tree,se,i,visited);
        se[node]+=se[i];
            }
        }
        return se;
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<ArrayList<Integer>> tree=new ArrayList<>();
        for(int i=0;i<=n;i++)
        tree.add(new ArrayList<>());
        for(int arr[]:edges){
            int s1=arr[0];
            int s2=arr[1];
            tree.get(s1).add(s2);
            tree.get(s2).add(s1);
        }
        boolean visited[]=new boolean[n];
        long sum[]=new long[n];
        for(int i=0;i<n;i++)
        sum[i]=(long)(values[i]);
        sum=dfs(tree,sum,0,visited);
        int cnt=0;
       for(long i:sum){
        if(i%k==0)
        cnt++;
               }
               return cnt;
    }
}