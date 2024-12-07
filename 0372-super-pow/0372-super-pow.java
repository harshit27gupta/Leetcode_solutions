class Solution {
    static int b_new(int b[],int phi){
  int currentMod = 0;
        for (int digit : b) {
            currentMod = (currentMod * 10 + digit) % phi;
        }
        return currentMod;
    }
    //mod as phi here 
    static int power(int a, int b, int mod) {
        int res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }


    public int superPow(int a, int[] b) {
        if(a==1)
        return 1;
        if((a%1337)==0)
        return 0;
        //compute ϕ(1337) for ETF(euler totient function)
        // ϕ(1337)=ϕ(7) * ϕ(191)
        //ϕ(n)=n-1 if n:prime
        //ϕ(1337)=(7-1)*(191-1)=1140
int phi=1140;
//compute b%ϕ(1337);
 int reducedExponent = b_new(b, phi);
        // If reducedExponent is 0, replace with φ(1337)
        if (reducedExponent == 0) reducedExponent = phi;
//compute (a^b)%m
return power(a,reducedExponent,1337);


    }
}