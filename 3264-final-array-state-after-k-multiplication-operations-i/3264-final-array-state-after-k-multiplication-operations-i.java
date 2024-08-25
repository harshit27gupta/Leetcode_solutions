class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.a==b.a)
            return Integer.compare(a.b,b.b);
               return Integer.compare(a.a,b.a);
        });
       for(int i=0;i<nums.length;i++)
       pq.offer(new Pair(nums[i],i));
        while(k>0){
            Pair num=pq.poll();
            pq.offer(new Pair(num.a*multiplier,num.b));
            k--;
        }
        while(!pq.isEmpty()){
            Pair c=pq.poll();
            nums[c.b]=c.a;
                    }
                    return nums;
    }
    static class Pair{
        int a;
        int b;
        public Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
}