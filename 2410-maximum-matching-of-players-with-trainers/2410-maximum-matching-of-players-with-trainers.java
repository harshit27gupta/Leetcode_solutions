class Solution {
    public int matchPlayersAndTrainers(int[] g, int[] s) {
          Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        int cnt=0;
        while(i<g.length && j<s.length){
if(s[j]>=g[i]){
    j++;
    i++;
    cnt++;
}
else
j++;
        }
        return cnt;
    }
}