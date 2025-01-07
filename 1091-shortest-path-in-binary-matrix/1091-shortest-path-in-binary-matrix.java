class Solution {
    class Triplet{
        int x;
        int y;
        int cost;
        public Triplet(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
    static int dirc[][]={{0,1},{1,1},{0,-1},{1,-1},{-1,1},{-1,-1},{-1,0},{1,0}};
    static int find(int grid[][],int i,int j,int n,int m,int cnt){
if(i==n-1 && j==m-1)
return 1;
if(cnt==n+20)
return 10000;
int ans=10000;
for(int dir[]:dirc){
    int x=dir[0];
    int y=dir[1];
    int newx=i+x;
    int newy=j+y;
    if(newx<n && newy<m && newx>=0 && newy>=0 && grid[newx][newy]==0)
    ans=Math.min(ans,1+find(grid,newx,newy,n,m,cnt+1));
}
return ans;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
      int n=grid.length;
      int m=grid[0].length;
      if(grid[0][0]==1 || grid[n-1][m-1]==1)
      return -1;
PriorityQueue<Triplet> pq=new PriorityQueue<>((a,b)->{
return Integer.compare(a.cost,b.cost);
});
pq.offer(new Triplet(0,0,1));
boolean visited[][]=new boolean[n][m];
while(!pq.isEmpty()){
    Triplet node=pq.poll();
    if(node.x==n-1 && node.y==m-1)
    return node.cost;
    if(visited[node.x][node.y])
    continue;
    visited[node.x][node.y]=true;
    for(int dir[]:dirc){
    int x=dir[0];
    int y=dir[1];
    int newx=node.x+x;
    int newy=node.y+y;
    if(newx<n && newy<m && newx>=0 && newy>=0 && grid[newx][newy]==0)
  pq.offer(new Triplet(newx,newy,node.cost+1));
}
}



     return -1;
    }
}