class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> list=new ArrayList<>();
        int n=A.length;
        int m=B.length;
        if(m==0 || n==0)
            return new int[0][0];
        int start=0;
        int end=0;
        int i=0,j=0;
        while(i<n && j<m){
            start=Math.max(A[i][0],B[j][0]);
            end=Math.min(A[i][1],B[j][1]);
             if(start<=end)
                list.add(new int[]{start,end});
            if(A[i][1]==end)i++;
            if(B[j][1]==end)j++;
        }     
        return list.toArray(new int[list.size()][2]);
    }
}