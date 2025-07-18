class Solution {
    class SumMaintainer{
        int n;
        PriorityQueue<Integer> pq;
        long sum;
        SumMaintainer(int n,PriorityQueue<Integer> pq){
            this.n=n;
            this.pq=pq;
            this.sum=0L;
        }

        long addElem(int a){
            pq.offer(a);
            sum+=(long)a;
            while(pq.size()>n){
                int cur=pq.poll();
                sum-=(long)cur;
            }
            return sum;
        }
        long runningSum(){
            return this.sum;
        }
        
    }
    public long minimumDifference(int[] nums) {
        long[] forward=new long[nums.length];
        Arrays.fill(forward,(long)Long.MIN_VALUE);
        long[] backward=new long[nums.length];
        Arrays.fill(backward,(long)Long.MAX_VALUE);
        int n=nums.length/3;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)->(b-a));
        SumMaintainer sm=new SumMaintainer(n,minHeap);
        for(int i=0;i<nums.length;i++){
            forward[i]=sm.addElem(nums[i]);
        }
        
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->(a-b));
        SumMaintainer sm2=new SumMaintainer(n,maxHeap);
        for(int i=nums.length-1;i>=0;i--){
            backward[i]=sm2.addElem(nums[i]);
        }
        long minDif=Long.MAX_VALUE;
        for(int i=n-1;i<2*n;i++){
            long curDif=forward[i]-backward[i+1];
            minDif=Math.min(curDif,minDif);
        }
        return minDif;
    }
}