class Solution {
    static int dx[]={-1,0,1,0};
    static int dy[]={0,1,0,-1};
    public int getMaximumGold(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0)
                continue;
                clear(visited);
                visited[i][j]=true;
ans=Math.max(ans,visit(i,j,n,m,grid,visited));
            }
        }
        return ans;
    }
    static void clear(boolean visited[][]){
        for(boolean rows[]:visited)
        Arrays.fill(rows,false);
    }
    static int visit(int i,int j,int n,int m,int grid[][],boolean visited[][]){
if(grid[i][j]==0)
return 0;
int cc=0;
for(int k=0;k<4;k++){
    int newx=i+dx[k];
    int newy=j+dy[k];
    if (isValid(newx, newy, n, m) && !visited[newx][newy] && grid[newx][newy] != 0) {
            visited[newx][newy] = true;
            cc = Math.max(cc, visit(newx, newy, n, m, grid, visited));
            visited[newx][newy] = false;
        }
}
return grid[i][j]+cc;

    }
    static boolean isValid(int i,int j,int n,int m){
        return (i>=0 && i<n && j>=0 && j<m);
    }
}