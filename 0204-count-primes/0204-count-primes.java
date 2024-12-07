class Solution {
    public int countPrimes(int n) {
        int cnt=0;
        if(n<=2)
        return 0;
        boolean isprime[]=new boolean[(int)(5e6+10)];
        Arrays.fill(isprime,true);
        for(int i=2;i<n;i++){
            if(isprime[i]){
                cnt++;
                for(int j=2*i;j<n;j+=i)
                isprime[j]=false;
            }
        }
        return cnt;
    }
}