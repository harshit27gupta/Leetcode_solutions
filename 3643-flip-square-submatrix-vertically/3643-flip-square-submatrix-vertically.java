class Solution {
    static void swap(int i,int j,int new_i,int new_j,int grid[][]){
        int tmp=grid[i][j];
        grid[i][j]=grid[new_i][new_j];
        grid[new_i][new_j]=tmp;
    }
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int new_i=x+k-1;
        int new_y=y+k-1;
        while(x<new_i){
            for(int j=y;j<=new_y;j++){
                swap(x,j,new_i,j,grid);
            }
            x++;
            new_i--;
        }
        return grid;
    }
}