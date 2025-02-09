import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int row = n - 1; row >= 0; row--) {
            sortDiagonal(grid, row, 0, false);
        }
        for (int col = 1; col < n; col++) {
            sortDiagonal(grid, 0, col, true);
        }
        
        return grid;
    }
    
    private void sortDiagonal(int[][] grid, int row, int col, boolean increasing) {
        List<Integer> diagonal = new ArrayList<>();
        int r = row, c = col, n = grid.length;
        while (r < n && c < n) {
            diagonal.add(grid[r][c]);
            r++;
            c++;
        }
        
        if (increasing) {
            Collections.sort(diagonal);
        } else {
            diagonal.sort(Collections.reverseOrder());
        }
        
        r = row;
        c = col;
        for (int val : diagonal) {
            grid[r][c] = val;
            r++;
            c++;
        }
    }
}
