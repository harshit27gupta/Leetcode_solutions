class Solution {
    public long removeZeros(long n) {
        long rev=0;
        while(n>0){
            long tmp=n%10;
            if(tmp!=0)
            rev=rev*10+tmp;
            n=n/10;
        }
        long res=0;
        while(rev>0){
            long tmp=rev%10;
            res=res*10+tmp;
            rev=rev/10;
        }
        return res;
    }
}