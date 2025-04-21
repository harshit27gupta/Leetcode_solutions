class Solution {
    static void union(long arr[],long l,long r){
arr[0]=Math.max(arr[0],l);
arr[1]=Math.min(arr[1],r);
    }
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long ans[]=new long[2];
        ans[0]=(long)lower;
        ans[1]=(long)upper;
        long key=0;
        for(int i=0;i<differences.length;i++){
            key+=(long)differences[i];
            long l1=lower-key;
            long r1=upper-key;
            union(ans,l1,r1);
        }
        return Math.max(0,(int)(ans[1]-ans[0]+1));
    }
}