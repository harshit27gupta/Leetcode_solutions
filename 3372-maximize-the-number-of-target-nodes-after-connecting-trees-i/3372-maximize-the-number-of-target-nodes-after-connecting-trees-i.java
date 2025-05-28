class Solution {
    static ArrayList<ArrayList<Integer>> tree1;
    static ArrayList<ArrayList<Integer>> tree2;
    static void fill(ArrayList<ArrayList<Integer>> tree,int n){
        for(int i=0;i<=n;i++)
        tree.add(new ArrayList<>());
    }
    static void build(int edges[][],ArrayList<ArrayList<Integer>> tree){
for(int arr[]:edges){
    tree.get(arr[0]).add(arr[1]);
    tree.get(arr[1]).add(arr[0]);
}
    }
    static class Pair{
        int n;
        int par;
        int cnt;
        public Pair(int n,int par,int cnt){
            this.n=n;
            this.par=par;
            this.cnt=cnt;
        }
    }
    static int dfs(int node,ArrayList<ArrayList<Integer>> tree,int k){
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(node,-1,0));
        int cnt=0;
        while(!queue.isEmpty()){
            Pair c=queue.poll();
            if(c.cnt>k)
            continue;
            cnt++;
            int par=c.par;
            for(int i:tree.get(c.n)){
                if(i==par)
                continue;
                queue.offer(new Pair(i,c.n,c.cnt+1));
            }
        }
        return cnt;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        tree1=new ArrayList<>();
        tree2=new ArrayList<>();
        int n=edges1.length;
        int m=edges2.length;
        fill(tree1,n+1);
        fill(tree2,m+1);
        build(edges1,tree1);
        build(edges2,tree2);
        int ans=0;
    
        for(int i=0;i<=m;i++)
        ans=Math.max(ans,dfs(i,tree2,k-1));
    int answer[]=new int[n+1];
        for(int i=0;i<=n;i++)
    answer[i]=ans+dfs(i,tree1,k);
    return answer;
    }
}