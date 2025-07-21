class Solution {
    public boolean checkDivisibility(int n) {
        int k=n;
       int sum=0;
       int prod=1;
       while(k>0){
        int digit=k%10;
        k=k/10;
        sum+=digit;
        prod*=digit;
       }
       return (n%(sum+prod)==0);
    }
}