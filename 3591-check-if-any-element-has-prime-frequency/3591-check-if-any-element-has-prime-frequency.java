class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        int freq[]=new int[101];
        for(int i: nums)
        freq[i]++;
        for(int i=0;i<101;i++){
            int f=freq[i];
            boolean poss=true;
            if(f<=1)
            continue;
            if(f==2)
            return true;
            for(int j=2;j*j<=f;j++){
                if(f%j==0){
                    poss=false;
                    break;
                }
            }
            if(poss)
            return true;
        }
        return false;
    }

}