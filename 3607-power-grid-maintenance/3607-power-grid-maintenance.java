class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static HashMap<Integer,Integer> land;
    static HashMap<Integer,PriorityQueue<Integer>> map;
    static int region;
    static void dfs(int node,PriorityQueue<Integer> pq,boolean visited[]){
        visited[node]=true;
        pq.offer(node);
        land.put(node,region);
        for(int child:graph.get(node)){
            if(!visited[child])
            dfs(child,pq,visited);
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        graph=new ArrayList<>();
        land=new HashMap<>();
        map=new HashMap<>();
        for(int i=0;i<=c;i++)
        graph.add(new ArrayList<>());
        for(int arr[]:connections){
            int u=arr[0];
            int v=arr[1];
            u--;
            v--;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean online[]=new boolean[c];
        Arrays.fill(online,true);
        boolean visited[]=new boolean[c];
         region=1;
        for(int i=0;i<c;i++){
            if(!visited[i]){
                PriorityQueue<Integer> pq=new PriorityQueue<>();
                dfs(i,pq,visited);
                map.put(region,pq);
                region++;
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int q_type=queries[i][0];
            int station=queries[i][1]-1;
            if(q_type==2)
            online[station]=false;
            else{
                if(online[station]){
                    ans.add(station);
                    continue;
                }
int reg=land.get(station);
PriorityQueue<Integer> pq=map.get(reg);
while(!pq.isEmpty() && !online[pq.peek()])
pq.poll();
if (!pq.isEmpty())
    ans.add(pq.peek());
else
    ans.add(-1);  

            }
        }
  
int[] res = new int[ans.size()];
for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i)==-1?-1:ans.get(i)+1;
return res;

    }
}