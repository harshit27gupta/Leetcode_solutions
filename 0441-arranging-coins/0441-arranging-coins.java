class Solution {
    static int ways(int n,int sub){
if(n<sub)
return 0;
return 1+ways(n-sub,sub+1);
    }
    public int arrangeCoins(int n) {
        if(n==1)
        return 1;
        return 1+ways(n-1,2);
    }
}