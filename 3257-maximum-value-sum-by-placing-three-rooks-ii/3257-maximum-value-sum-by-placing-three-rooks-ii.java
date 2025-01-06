class Solution {
    List<int[]> arr = new ArrayList<>();
    public long maximumValueSum(int[][] board) {
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                arr.add(new int[]{board[i][j],i,j});
            }
        }
        Collections.sort(arr,(a,b)->-Integer.compare(a[0],b[0]));//For sorting the values in descending order.
        return helper(3,new boolean[board.length],new boolean[board[0].length]);
    }
    public long helper(int rem, boolean blockedRows[], boolean blockedCols[]){
        if(rem == 0){
            return 0;
        }
        long res =Long.MIN_VALUE;
        int attempts=0;
        for(int curr[]: arr){
            if(attempts == 6){
                break;
            }
            int cost = curr[0];
            int row = curr[1];
            int col = curr[2];
            if(blockedRows[row] || blockedCols[col]){
                continue;
            }
            blockedRows[row] = true;
            blockedCols[col] = true;
            res = Math.max(res,cost+helper(rem-1,blockedRows,blockedCols));
            blockedRows[row] = false;
            blockedCols[col] = false;
            attempts++;
        }
        return res;
    }
    
}