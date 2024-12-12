class Solution {
    public long pickGifts(int[] gifts, int k) {
        long s=0;
                PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
                    return b-a;
                });
        for(int i:gifts){
        s+=i;
        pq.offer(i);
        }
        while(k>0 && pq.size()>0){
            int num=pq.poll();
            int rem=(int)Math.sqrt(num);
            pq.offer(rem);
            s-=(num-rem);
            k--;
        }
        return s;
    }
}