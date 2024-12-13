class Solution {
    class Pair{
        int a;
        int b;
        public Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public long findScore(int[] nums) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
if(a.a!=b.a)
return a.a-b.a;
return a.b-b.b;
        });
        for(int i=0;i<nums.length;i++)
        pq.offer(new Pair(nums[i],i));
        Set<Integer> st=new HashSet<>();
        long s=0;
        while(!pq.isEmpty()){
            Pair c=pq.poll();
            if(st.contains(c.b))
            continue;
            s+=c.a;
            st.add(c.b);
            st.add(c.b-1);
            st.add(c.b+1);
        }
        return s;
    }
}