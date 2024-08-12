class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cnt=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0;
        int r=0;
        while(l<g.length && r<s.length){
            if(g[l]<=s[r]){
                l++;
                r++;
                cnt++;
            }
            else
            r++;
        }
        return cnt;
    }
}