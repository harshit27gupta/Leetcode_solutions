class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int total_length = n * m;
        int[] freq_arr = new int[total_length + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                freq_arr[grid[i][j]]++;
            }
        }
        int a = -1;
        int b = -1;
        for(int i = 1; i <= total_length ; i++){
            if(freq_arr[i] == 0){
                b = i;
            }
            if(freq_arr[i] > 1){
                a = i;
            }
        }
        return new int[]{a,b};
    }
}