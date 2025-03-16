class Solution {
    static boolean possible(int ranks[],int cars,long mid){
        long cc=0;
        for(int i=0;i<ranks.length;i++)
        cc+=Math.sqrt(mid/ranks[i]);
        return cc>=cars;
    }
    public long repairCars(int[] ranks, int cars) {
        long l=0;
        long r=(long)(1e14);
        long ans=0;
        while(l<=r){
            long mid=(l+r)/2;
            if(possible(ranks,cars,mid)){
                ans=mid;
                r=mid-1;
            }
            else
            l=mid+1;
        }
        return ans;
    }
}