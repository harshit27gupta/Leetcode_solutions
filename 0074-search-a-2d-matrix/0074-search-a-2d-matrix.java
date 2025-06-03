class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int r=n*m-1;
        while(l<=r){
            int mid=(l+r)/2;
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col]==target)
            return true;
            if(matrix[row][col]>target)
            r=mid-1;
            else
            l=mid+1;
        }
        return false;
    }
}