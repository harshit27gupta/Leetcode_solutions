class Solution {
    public int findComplement(int num) {
        int i=30;
        while((num&(1<<i))==0)
        i--;
        int ans=0;
        for(i--;i>=0;i--){
            int bit=(num&(1<<i));
            if(bit==0)
            ans|=(1<<i);
        }
        return ans;
    }
}