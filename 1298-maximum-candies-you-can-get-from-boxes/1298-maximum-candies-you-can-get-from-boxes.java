class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int sum=0;
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->{
            return Integer.compare(status[b],status[a]);
        });
        boolean visited[]=new boolean[status.length];
        for(int i:initialBoxes)
            queue.offer(i);
         Set<Integer> key=new HashSet<>();
        while(!queue.isEmpty()){
            int box=queue.poll();
            if(!visited[box]&& (status[box]==1 || key.contains(box))){
            sum+=candies[box];
            visited[box]=true;
            }
            for(int i:keys[box])
            key.add(i);
            for(int i:containedBoxes[box]){
if(!visited[i] && (status[i]==1 || key.contains(i))){
    status[i]=1;
sum+=candies[i];
visited[i]=true;
}
queue.offer(i);

            }
        }
        return sum;
    }
}