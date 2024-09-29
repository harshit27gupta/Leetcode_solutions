class Solution {
    public long maximumTotalSum(int [] arr) {
    long ans=0;
    Arrays.sort(arr);
    int n=arr.length;
    long done=arr[n-1];
    ans+=done;
    for(int i=n-2;i>=0;i--){
        done=Math.min(done-1,arr[i]);
        if(done==0)
        return -1;
        ans+=done;
    }
    return ans;
    }
}