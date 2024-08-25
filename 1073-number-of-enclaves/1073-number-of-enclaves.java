class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i=0; i<m; i++){
            if(grid[0][i] == 1){
                helper(grid, 0, i, visited);
            }
        }
        for(int i=1; i<n; i++){
            if(grid[i][0] == 1){
                helper(grid, i, 0, visited);
            }
        }
        for(int i=1; i<n; i++){
            if(grid[i][m-1] == 1){
                helper(grid, i, m-1, visited);
            }
        }
        for(int i=1; i<m-1; i++){
            if(grid[n-1][i] == 1){
                helper(grid, n-1, i, visited);
            }
        }  
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        } 
        return count;
    }
    public void helper(int[][] grid, int i, int j, boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] == true){
            return;
        }
        if(grid[i][j] == 1) grid[i][j] = 0;
        else return;
        visited[i][j] = true;
        helper(grid, i, j+1, visited);
        helper(grid, i+1, j, visited);
        helper(grid, i, j-1, visited);
        helper(grid, i-1, j, visited);
        visited[i][j] = false;
    }
}