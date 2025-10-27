class Solution {
    public long maxAlternatingSum(int[] nums) {
 PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> {
    int cmp = Long.compare(Math.abs(b), Math.abs(a));
    if (cmp == 0) return Long.compare(b, a);
    return cmp;
});

        for(int i:nums)
        pq.offer((long)i);
        long score=0;
        int n=nums.length;
        int add=n/2+n%2;
        while(add-->0){
            long res=pq.poll();
            score+=(res*res);
        }
        while(!pq.isEmpty()){
              long res=pq.poll();
            score-=(res*res);
        }
return score;
    }
}