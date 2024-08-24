class Solution {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'R'){
                    int k = i - 1;
                    while(k >= 0){
                        if(board[k][j] == 'B') break;
                        if(board[k][j] == 'p'){
                            count++;
                            break;
                        }
                        k--;
                    }
                    k = i + 1;
                    while(k < board.length) {
                        if(board[k][j] == 'B') break;
                        if(board[k][j] == 'p'){
                            count++;
                            break;
                        }
                        k++;
                    }

                    int t = j - 1;
                    while(t >= 0){
                        if(board[i][t] == 'B') break;
                        if(board[i][t] == 'p') {
                            count++;
                            break;
                        }
                        t--;
                    }
                    t = j + 1;
                    while(t < board[0].length){
                        if(board[i][t] == 'B') break;
                        if(board[i][t] == 'p') {
                            count++;
                            break;
                        }
                        t++;    
                    }
                    break;
                }
            }
        }
        return count;
    }
}