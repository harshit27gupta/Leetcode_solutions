class Solution {
    public int minBitFlips(int start, int goal) {
        int ans=0;
        for(int i=31;i>=0;i--){
            int bit1=(start&(1<<i));
            int bit2=(goal&(1<<i));
            if(bit1!=bit2)
            ans++;
        }
        return ans;
    }
}