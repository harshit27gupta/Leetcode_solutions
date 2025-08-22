class Solution {
    public int minimumArea(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int minRow = r, maxRow = -1, minCol = c, maxCol = -1;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    if (i < minRow) minRow = i;
                    if (i > maxRow) maxRow = i;
                    if (j < minCol) minCol = j;
                    if (j > maxCol) maxCol = j;
                }
            }
        }
        
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;
        
        return height * width;
    }
}
