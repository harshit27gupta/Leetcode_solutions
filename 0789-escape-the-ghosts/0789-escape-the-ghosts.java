class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
       int you=Math.abs(target[0])+Math.abs(target[1]);
       int ans=Integer.MAX_VALUE;
       for(int i=0;i<ghosts.length;i++){
        int x=ghosts[i][0];
        int v=ghosts[i][1];
        ans=Math.min(ans,Math.abs(x-target[0])+Math.abs(v-target[1]));
       } 
       return you<ans;
    }
}