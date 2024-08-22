class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int m=strs[0].length();
        int ans=0;
        boolean isDeleted[] =new boolean[m];
        for(int i=1;i<n;i++){
            for(int col=0;col<m;col++){
                if(isDeleted[col] || strs[i-1].charAt(col)==strs[i].charAt(col))
                    continue;
                if(strs[i-1].charAt(col)>strs[i].charAt(col)){
                        isDeleted[col]=true;
                        ans++;
                        i=0;
                }
                break;
            }
        }
        return ans;
    }
}