class Solution {
    public int minDeletion(String s, int k) {
        Set<Character> st=new HashSet<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
            st.add(c);
        }
        if(st.size()<=k)
        return 0;
        int req=st.size()-k;
        PriorityQueue <Integer> pq=new PriorityQueue<>();
        for(int i:map.values())
            pq.offer(i);
            int sum=0;
            while(req-->0)
            sum+=pq.poll();
            return sum;


    }
}