class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int s=(rolls.length+n)*mean;
        for(int i:rolls)
        s-=i;
        int req[]=new int[n];
        if(s>6*n || s<n)
        return new int[]{};
        while(s>0){
            for(int i=0;i<n && s>0;i++,s--)
            req[i]++;
        }
        return req;
    }
}