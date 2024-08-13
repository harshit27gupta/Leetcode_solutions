class Solution {
    public boolean checkPerfectNumber(int num) {
        long sum=0;
        if(num==1)
        return false;
        for(int i=1;i*i<=num;i++){
            if(num%i==0){
            sum+=i;
            if(i!=1 && i!=num/i)
            sum+=(num/i);
            }
        }
        return ((int)(sum)==num);
    }
}