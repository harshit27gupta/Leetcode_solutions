class Solution {
    class Pair{
        int edge;
        int col;
        public Pair(int edge,int col){
            this.edge=edge;
            this.col=col;
        }
    }
    class Triplet{
        int edge;
        int col;
        int cost;
        public Triplet(int edge,int col,int cost){
            this.cost=cost;
             this.edge=edge;
            this.col=col;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<ArrayList<Pair>> ds=new ArrayList<>();
        for(int i=0;i<=n;i++)
        ds.add(new ArrayList<>());
        for(int arr[]:redEdges)
            ds.get(arr[0]).add(new Pair(arr[1],1));
             for(int arr[]:blueEdges)
            ds.get(arr[0]).add(new Pair(arr[1],-1));
          int ans[]=new int[n];
          Arrays.fill(ans,-1);
          ans[0]=0;
          PriorityQueue<Triplet> pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(a.cost,b.cost);
          });
          pq.offer(new Triplet(0,1,0));
               pq.offer(new Triplet(0,-1,0));
          while(!pq.isEmpty()){
        Triplet node=pq.poll();
            int init=node.col;
            for(Pair child:ds.get(node.edge)){
                int edge=child.edge;
                int col=child.col;
                if(col==init)
                continue;
                if(edge==node.edge)
                pq.offer(new Triplet(edge,col,node.cost+1));
                else{
            if(ans[edge]==-1 ||ans[edge]>node.cost+1){
                ans[edge]=node.cost+1;
                pq.offer(new Triplet(edge,col,ans[edge]));
            }
                }
                
            }
          }
          return ans;

    }
}