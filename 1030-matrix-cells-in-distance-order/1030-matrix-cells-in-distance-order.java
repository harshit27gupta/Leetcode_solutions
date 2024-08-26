class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int mat[][]=new int[rows][cols];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
int dist1=Math.abs(rCenter-a[0])+Math.abs(cCenter-a[1]);
int dist2=Math.abs(rCenter-b[0])+Math.abs(cCenter-b[1]);
return dist1-dist2;
        });
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                pq.offer(new int[]{i,j});
            }
        }
        int ans[][]=new int[pq.size()][2];
        for(int i=0;i<ans.length;i++){
           int arr[]=pq.poll();
           ans[i][0]=arr[0];
           ans[i][1]=arr[1];
        }
        return ans;
    }
}