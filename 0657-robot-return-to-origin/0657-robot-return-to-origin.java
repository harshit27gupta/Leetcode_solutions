class Solution {
    public boolean judgeCircle(String moves) {
int l1=0;
int l2=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U')
            l1++;
            else if(moves.charAt(i)=='R')
            l2++;
            else if(moves.charAt(i)=='L')
            l2--;
            else
            l1--;
        }
        return l1==0 && l2==0;
    }
}