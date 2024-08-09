class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList();
        if(heights.length == 0 || heights[0].length == 0)
            return result;

        int rows = heights.length;
        int cols = heights[0].length;
        int dir[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        boolean [][]pac = new boolean[rows][cols];
        boolean [][]atl = new boolean[rows][cols];
        for(int col=0; col<cols; col++) {
            dfs(0, col, pac, heights[0][col], heights);                    
            dfs(rows-1, col, atl, heights[rows-1][col], heights);
        }
        for(int row=0; row<rows; row++) {
            dfs(row, 0, pac, heights[row][0], heights);           
            dfs(row, cols-1, atl, heights[row][cols-1], heights);  
        }
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(pac[r][c] && atl[r][c]) {
                    List<Integer> li = new ArrayList();
                    li.add(r);
                    li.add(c);
                    result.add(li);
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, boolean [][]visit, int preHeight, int[][] heights) {
            if(row<0 || col<0 || row==heights.length || col==heights[0].length || visit[row][col] || preHeight>heights[row][col])
                return;
            
            visit[row][col]=true;
            dfs(row+1, col, visit, heights[row][col], heights);
            dfs(row, col+1, visit, heights[row][col], heights);
            dfs(row-1, col, visit, heights[row][col], heights);
            dfs(row, col-1, visit, heights[row][col], heights);
        }
}