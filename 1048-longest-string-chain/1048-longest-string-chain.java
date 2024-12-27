class Solution {
    class Pair{
        String c;
        int chain;
        public Pair(String c,int chain){
            this.c=c;
            this.chain=chain;
        }
    }
    public int longestStrChain(String[] words) {
        Set<String> word=new HashSet<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
return Integer.compare(b.c.length(),a.c.length());
        });
        for(String c:words)
        word.add(c);
        for(String s:word)
        pq.offer(new Pair(s,1));
        int ans=1;
        while(!pq.isEmpty()){
            Pair check=pq.poll();
            String str=check.c;
            int n=str.length();
            for(int i=0;i<n;i++){
                String checker=str.substring(0,i)+str.substring(i+1);
                if(word.contains(checker)){
                    pq.offer(new Pair(checker,check.chain+1));
                    ans=Math.max(ans,check.chain+1);
                }
            }
        }
        return ans;
    }
}