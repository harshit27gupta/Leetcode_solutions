class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        int m = grid.length, n = grid[0].length, i=0;
        boolean flag = true, skip = false;
        while(i < m) {
            if(flag) {
                for(int j=0; j<n; j++) {
                    if(!skip) ans.add(grid[i][j]);
                    skip = !skip;
                }
            } else {
                for(int j=n-1; j>=0; j--) {
                    if(!skip) ans.add(grid[i][j]);
                    skip = !skip;
                }
            }
            flag = !flag;
            i++;
        }
        return ans;
    }
}