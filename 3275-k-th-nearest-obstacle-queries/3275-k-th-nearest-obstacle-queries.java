class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            int dist1=Math.abs(a.f)+Math.abs(a.s);
            int dist2=Math.abs(b.f)+Math.abs(b.s);
return dist2-dist1;
        });
        int result[]=new int[queries.length];
        Arrays.fill(result,-1);
        for(int i=0;i<queries.length;i++){
               pq.offer(new Pair(queries[i][0],queries[i][1]));
               if(pq.size()>k)
               pq.poll();
               if(pq.size()==k){
                Pair cc=pq.peek();
                result[i]=Math.abs(cc.f)+Math.abs(cc.s);
               }

        }
        return result;
    }
    class Pair{
        int f;
        int s;
        public Pair(int f,int s){
            this.f=f;
            this.s=s;
        }
    }
}