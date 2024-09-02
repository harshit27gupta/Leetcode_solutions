class Solution {
    public int chalkReplacer(int[] chalk, int k1) {
        long s=0;
        long k=k1;
        for(int i:chalk)
        s+=i;
        if(k%s==0 || k%s<chalk[0])
        return 0;
        k=k%s;
        s=0;
        int i=0;
        while(s+chalk[i]<=k){
            s+=chalk[i];
            i++;
        }
        return i;
        
    }
}