class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] arr=new int[2];
        boolean xwin=false,owin=false;
        int xdiag=0,odiag=0;
        for(int i=0;i<3;i++){
            int x=0,o=0;
            for(int j=0;j<3;j++)
            {
                if(i==0){
                    if(board[i].charAt(j)=='X' && board[i+1].charAt(j)=='X' && board[i+2].charAt(j)=='X')xwin=true;
                    if(board[i].charAt(j)=='O' && board[i+1].charAt(j)=='O' && board[i+2].charAt(j)=='O')owin=true;
                }
                if(board[i].charAt(j)=='X'){
                    if(i==j)xdiag++;
                    arr[1]++;
                    x++;
                }
                else if(board[i].charAt(j)=='O'){
                    if(i==j)odiag++;
                    arr[0]++;
                    o++;
                }
            }
            if(o==3 && owin)return false;
            if(owin && xwin)return false;
            if(x==3)xwin=true;
            else if(o==3)owin=true;
        }
        if(xdiag==3)xwin=true;
        if(odiag==3)owin=true;
        if(board[0].charAt(2)=='X' && board[1].charAt(1)=='X' && board[2].charAt(0)=='X')xwin=true;
        if(board[0].charAt(2)=='O' && board[1].charAt(1)=='O' && board[2].charAt(0)=='O')owin=true;
        if(arr[0]>=arr[1] && xwin || (arr[1]>arr[0] && owin))return false;
        if(arr[0]>arr[1] || Math.abs(arr[0]-arr[1])>1)return false;
        return xwin&&owin?false:true;
    }
}