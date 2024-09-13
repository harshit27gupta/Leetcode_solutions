class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        int[] p=new int[n];
        p[0]=arr[0];
        for(int i=1;i<n;i++) {
            p[i]=p[i-1]^arr[i];
        }
        int[] res=new int[queries.length];
        for(int k=0;k<queries.length;k++) {
            int i=queries[k][0];
            int j=queries[k][1];
            if(i==0) {
                res[k]=p[j];
            } else {
                res[k]=p[j]^p[i-1];
            }
        }
        return res;
    }
}