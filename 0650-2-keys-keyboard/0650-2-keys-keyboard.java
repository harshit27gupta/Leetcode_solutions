class Solution {
    public int minSteps(int n) {
        
        if(n==1) return 0;
        return 1+helper(n,1,1);


    }

    int helper(int n,int curr,int copy){

        if(curr==n) return 0;

        int paste=2000;
        if(curr+copy<=n){
            paste = 1+helper(n,curr+copy,copy);
        }
        int copypaste=2000;
        if(curr*2<=n){
            copypaste = 2+helper(n,curr*2,curr);
        }

        return Math.min(copypaste,paste);
        
    }
}