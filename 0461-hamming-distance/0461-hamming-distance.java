class Solution {
    public int hammingDistance(int x, int y) {
    int cnt=0;
    for(int i=30;i>=0;i--){
        int bit1=(x&(1<<i));
        int bit2=(y&(1<<i));
        if(bit1!=bit2)
        cnt++;
    }
    return cnt;
    }
}