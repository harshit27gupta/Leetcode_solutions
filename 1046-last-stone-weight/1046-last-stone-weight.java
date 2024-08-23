class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i:stones)
        pq.offer(i);
        while(pq.size()>1){
            int st1=pq.poll();
            int st2=pq.poll();
            if(st1!=st2)
            pq.offer(st1-st2);
        }
        return pq.isEmpty()?0:pq.poll();
    }
}