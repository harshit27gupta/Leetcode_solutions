class Solution {
    static long check(int n,int limit){
        long prod=Integer.MAX_VALUE;
        for(int i=1;i<=n/2;i++){
            if(i<=limit && n-i<=limit)
            prod=Math.min(prod,((long)(i)*(long)(n-i)));
        }
        return prod;
    }
    public long minCuttingCost(int n, int m, int k) {
        long cost=0;
        if(n<=k && m<=k)
        return 0;
        if(n<=k)
        return check(m,k);
        if(m<=k)
        return check(n,k);

        cost+=check(n,k);
        cost+=check(m,k);
        return cost;
    }
}